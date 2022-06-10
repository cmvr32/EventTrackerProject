-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema flighttrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `flighttrackerdb` ;

-- -----------------------------------------------------
-- Schema flighttrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flighttrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `flighttrackerdb` ;

-- -----------------------------------------------------
-- Table `crew_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `crew_member` ;

CREATE TABLE IF NOT EXISTS `crew_member` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `rank` VARCHAR(45) NULL,
  `flight_crew_position` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flight`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flight` ;

CREATE TABLE IF NOT EXISTS `flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(45) NOT NULL,
  `date` DATETIME NULL,
  `duration_in_hours` DECIMAL(2) NULL,
  `mission` VARCHAR(45) NULL,
  `pc_crew_member_id` INT NOT NULL,
  `pi_crew_member_id` INT NOT NULL,
  `ce_crew_member_id` INT NOT NULL,
  `me_crew_member_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_flight_crew_member1_idx` (`pc_crew_member_id` ASC),
  INDEX `fk_flight_crew_member2_idx` (`pi_crew_member_id` ASC),
  INDEX `fk_flight_crew_member3_idx` (`ce_crew_member_id` ASC),
  INDEX `fk_flight_crew_member4_idx` (`me_crew_member_id` ASC),
  CONSTRAINT `fk_flight_crew_member1`
    FOREIGN KEY (`pc_crew_member_id`)
    REFERENCES `crew_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_crew_member2`
    FOREIGN KEY (`pi_crew_member_id`)
    REFERENCES `crew_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_crew_member3`
    FOREIGN KEY (`ce_crew_member_id`)
    REFERENCES `crew_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_crew_member4`
    FOREIGN KEY (`me_crew_member_id`)
    REFERENCES `crew_member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS flightcrew;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'flightcrew' IDENTIFIED BY 'flightcrew';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'flightcrew';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `crew_member`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (1, 'Briana', 'Dahm', 'O2', 'PI');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (2, 'Paule', 'Pupelyte', 'CW2', 'PI');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (3, 'Chad', 'Beyers', 'CW2', 'PC');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (4, 'Justin', 'Hsia', 'CW2', 'PC');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (5, 'Charli', 'Verderame', 'E4', 'CE');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (6, 'John', 'Patton', 'E5', 'CE');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (7, 'Andrew', 'Vaughn', 'E5', 'ME');
INSERT INTO `crew_member` (`id`, `first_name`, `last_name`, `rank`, `flight_crew_position`) VALUES (8, 'Chancellor', 'Bluehorse', 'E5', 'ME');

COMMIT;


-- -----------------------------------------------------
-- Data for table `flight`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `flight` (`id`, `location`, `date`, `duration_in_hours`, `mission`, `pc_crew_member_id`, `pi_crew_member_id`, `ce_crew_member_id`, `me_crew_member_id`) VALUES (1, 'Denver', '2022-01-01', 1.5, 'Training', 3, 1, 5, 7);
INSERT INTO `flight` (`id`, `location`, `date`, `duration_in_hours`, `mission`, `pc_crew_member_id`, `pi_crew_member_id`, `ce_crew_member_id`, `me_crew_member_id`) VALUES (2, 'MTA\'s', '2022-02-02', 3, 'MEDEVAC', 4, 2, 6, 8);

COMMIT;

