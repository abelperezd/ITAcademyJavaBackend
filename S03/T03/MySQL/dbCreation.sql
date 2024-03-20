-- MySQL Script generated by MySQL Workbench
-- Sun May  7 17:47:06 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema floristeria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `floristeria` ;
USE `floristeria` ;

-- -----------------------------------------------------
-- Table `floristeria`.`floristeria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floristeria`.`floristeria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `guanys` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `floristeria`.`tiquet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floristeria`.`tiquet` (
  `id` INT NOT NULL,
  `floristeria_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `floristeria`.`arbre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floristeria`.`arbre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `preu` INT NULL DEFAULT 0,
  `alcada` INT NULL DEFAULT 0,
  `floristeria_id` INT NULL DEFAULT NULL,
  `tiquet_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `floristeria`.`flor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floristeria`.`flor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `preu` INT NULL DEFAULT 0,
  `color` VARCHAR(45) NULL,
  `floristeria_id` INT NULL DEFAULT NULL,
  `tiquet_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `floristeria`.`decoracio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floristeria`.`decoracio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `preu` INT NULL DEFAULT 0,
  `material` ENUM("fusta", "plastic") NULL,
  `floristeria_id` INT NULL DEFAULT NULL,
  `tiquet_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;