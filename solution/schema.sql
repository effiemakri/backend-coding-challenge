-- -----------------------------------------------------
-- User engagetechuser with password engagetech
-- -----------------------------------------------------

-- CREATE USER IF NOT EXISTS 'engagetechuser'@'localhost';
-- FLUSH PRIVILEGES;
-- GRANT ALL ON *.* TO 'engagetechuser'@'localhost';
-- GRANT ALL PRIVILEGES ON * . * TO 'engagetechuser'@'localhost';

GRANT ALL PRIVILEGES ON `engagetechdb`.* TO 'engagetechuser'@'localhost' IDENTIFIED BY 'engagetech';

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema engagetechdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `engagetechdb` DEFAULT CHARACTER SET utf8 ;
USE `engagetechdb` ;

-- -----------------------------------------------------
-- Table `engagetechdb`.`expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `engagetechdb`.`expenses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `amount` DOUBLE NOT NULL,
  `vat` DOUBLE NOT NULL,
  `reason` BLOB NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
