CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `rezultati_simplified`
AS
select
	`rezultat`.`Vozac_IdVozaca` AS `IdVozaca`,
	`rezultat`.`Trkacki vikend_IdTrkackogVikenda` AS `IdTrke`,
	`vozac`.`Ime` AS `Ime`,
	`vozac`.`Prezime` AS `Prezime`,
	`konstruktor`.`Naziv` AS `Ekipa`,
	`trkacki_vikend`.`NazivVelikeNagrade` AS `Trka`,
	`rezultat`.`KrajnjaPozicija` AS `KrajnjaPozicija`,
	`rezultat`.`Poeni` AS `Poeni`
from (((`rezultat`
	join `vozac` on((`rezultat`.`Vozac_IdVozaca` = `vozac`.`IdVozaca`)))
	join `trkacki_vikend` on((`rezultat`.`Trkacki vikend_IdTrkackogVikenda` = `trkacki_vikend`.`IdTrkackogVikenda`)))
	join `konstruktor` on((`rezultat`.`Konstruktor_IdKonstruktora` = `konstruktor`.`IdKonstruktora`))) 
order by
	`rezultat`.`Trkacki vikend_IdTrkackogVikenda`
	`rezultat`.`KrajnjaPozicija`;







DELIMITER $$

CREATE TRIGGER trg_rezultat_insert
AFTER INSERT ON rezultat
FOR EACH ROW
BEGIN
    DECLARE existingCount INT;
    
    SELECT COUNT(*) INTO existingCount
    FROM poredak_u_konkurenciji_vozaca
    WHERE Vozac_IdVozaca = NEW.Vozac_IdVozaca
        AND Sezona_IdSezone = (
            SELECT Sezona_IdSezone
            FROM trkacki_vikend
            WHERE IdTrkackogVikenda = NEW.`Trkacki vikend_IdTrkackogVikenda`
        );
    
    IF existingCount = 0 THEN
        INSERT INTO poredak_u_konkurenciji_vozaca (Vozac_IdVozaca, Sezona_IdSezone, BrojPoena)
        VALUES (NEW.Vozac_IdVozaca, (
            SELECT Sezona_IdSezone
            FROM trkacki_vikend
            WHERE IdTrkackogVikenda = NEW.`Trkacki vikend_IdTrkackogVikenda`
        ), NEW.Poeni);
    ELSE
        UPDATE poredak_u_konkurenciji_vozaca
        SET BrojPoena = (
            SELECT SUM(Poeni)
            FROM rezultat
            WHERE Vozac_IdVozaca = NEW.Vozac_IdVozaca
                AND `Trkacki vikend_IdTrkackogVikenda` IN (
                    SELECT IdTrkackogVikenda
                    FROM trkacki_vikend
                    WHERE Sezona_IdSezone = (
                        SELECT Sezona_IdSezone
                        FROM trkacki_vikend
                        WHERE IdTrkackogVikenda = NEW.`Trkacki vikend_IdTrkackogVikenda`
                    )
                )
        )
        WHERE Vozac_IdVozaca = NEW.Vozac_IdVozaca
            AND Sezona_IdSezone = (
                SELECT Sezona_IdSezone
                FROM trkacki_vikend
                WHERE IdTrkackogVikenda = NEW.`Trkacki vikend_IdTrkackogVikenda`
            );
    END IF;
END $$

DELIMITER ;


DELIMITER $$
CREATE TRIGGER rezultat_delete_trigger
AFTER DELETE ON rezultat
FOR EACH ROW
BEGIN
    DECLARE existing_row_count INT;
    
    SELECT COUNT(*) INTO existing_row_count
    FROM rezultat
    WHERE Vozac_IdVozaca = OLD.Vozac_IdVozaca;
    
    IF existing_row_count = 0 THEN
        DELETE FROM poredak_u_konkurenciji_vozaca
        WHERE Vozac_IdVozaca = OLD.Vozac_IdVozaca;
    ELSE
        UPDATE poredak_u_konkurenciji_vozaca
        SET BrojPoena = BrojPoena - OLD.Poeni
        WHERE Vozac_IdVozaca = OLD.Vozac_IdVozaca;
    END IF;
END $$
DELIMITER ;



DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CalculateAverageStartnaPozicija`()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE vozacId INT;
    DECLARE avgStartnaPozicija DECIMAL(10, 2);
    
    DECLARE cur CURSOR FOR SELECT IdVozaca FROM vozac;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS temp_avg_startna_pozicija (
        Vozac_IdVozaca INT,
        AvgStartnaPozicija DECIMAL(10, 2)
    );
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO vozacId;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        SET avgStartnaPozicija = (
            SELECT AVG(StartnaPozicija)
            FROM rezultat
            WHERE Vozac_IdVozaca = vozacId
        );
        
        IF avgStartnaPozicija IS NOT NULL THEN
            INSERT INTO temp_avg_startna_pozicija (Vozac_IdVozaca, AvgStartnaPozicija)
            VALUES (vozacId, avgStartnaPozicija);
        END IF;
    END LOOP;
    
    CLOSE cur;
    
    SELECT vozac.IdVozaca, vozac.Ime, vozac.Prezime, temp_avg_startna_pozicija.AvgStartnaPozicija
    FROM vozac
    INNER JOIN temp_avg_startna_pozicija
    ON vozac.IdVozaca = temp_avg_startna_pozicija.Vozac_IdVozaca;
    
    DROP TABLE IF EXISTS temp_avg_startna_pozicija;
END ;;
DELIMITER ;


DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CalculateAverageKrajnjaPozicija`()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE vozacId INT;
    DECLARE avgKrajnjaPozicija DECIMAL(10, 2);
    
    DECLARE cur CURSOR FOR SELECT IdVozaca FROM vozac;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS temp_avg_krajnja_pozicija (
        Vozac_IdVozaca INT,
        AvgKrajnjaPozicija DECIMAL(10, 2)
    );
    
    OPEN cur;
    
    read_loop: LOOP
        FETCH cur INTO vozacId;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        SET avgKrajnjaPozicija = (
            SELECT AVG(KrajnjaPozicija)
            FROM rezultat
            WHERE Vozac_IdVozaca = vozacId
        );
        
        IF avgKrajnjaPozicija IS NOT NULL THEN
            INSERT INTO temp_avg_krajnja_pozicija (Vozac_IdVozaca, AvgKrajnjaPozicija)
            VALUES (vozacId, avgKrajnjaPozicija);
        END IF;
    END LOOP;
    
    CLOSE cur;
    
    SELECT vozac.IdVozaca, vozac.Ime, vozac.Prezime, temp_avg_krajnja_pozicija.AvgKrajnjaPozicija
    FROM vozac
    INNER JOIN temp_avg_krajnja_pozicija
    ON vozac.IdVozaca = temp_avg_krajnja_pozicija.Vozac_IdVozaca;
    
    DROP TABLE IF EXISTS temp_avg_krajnja_pozicija;
END ;;
DELIMITER ;
