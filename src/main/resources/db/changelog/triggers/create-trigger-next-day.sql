-- liquibase formatted sql
-- changeset pcoates33:trigger-1 splitStatements:false

-- delimiter $$


CREATE TRIGGER  next_day
    BEFORE INSERT
    ON upcoming_tournament_data FOR EACH ROW
BEGIN
    IF NEW.reg_ends <= (CURRENT_DATE + INTERVAL 1 DAY) THEN
        SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'An error occurred';

    END IF;
END-- $$
-- delimiter ;

--DROP TRIGGER IF EXISTS next_day;

