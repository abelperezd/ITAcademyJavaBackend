-- https://www.youtube.com/watch?v=w-0IWyAeZ3M  <-- database creation from UML schema
-- https://www.youtube.com/watch?v=QpdhBUYk7Kk  <-- uml relationships

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `cul_d_ampolla`;

CREATE SCHEMA IF NOT EXISTS `cul_d_ampolla` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`proveidors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(30) NOT NULL,
  `telefon` VARCHAR(9) NOT NULL,
  `fax` VARCHAR(9) NULL DEFAULT NULL,
  `NIF` VARCHAR(45) NOT NULL,
  `adreça_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`adreces` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `carrer` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(3) NOT NULL,
  `pis` VARCHAR(2) NULL DEFAULT NULL,
  `porta` VARCHAR(1) NULL DEFAULT NULL,
  `codi_postal` VARCHAR(5) NULL DEFAULT NULL,
  `pais` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`ulleres` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(20) NOT NULL,
  `graduacio_esq` DECIMAL(4,2) NOT NULL,
  `graduacio_dre` DECIMAL(4,2) NOT NULL,
  `color_montura` VARCHAR(15) NOT NULL,
  `color_esq` VARCHAR(15) NULL DEFAULT NULL,
  `color_dre` VARCHAR(15) NULL DEFAULT NULL,
  `preu` DECIMAL(6,2) NOT NULL,
  `montura_id` INT(11) NOT NULL,
  `proveidors_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`montures` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipus` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`clients` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(30) NOT NULL,
  `telefon` VARCHAR(9) NOT NULL,
  `correu` VARCHAR(40) NOT NULL,
  `data_registre` DATETIME NOT NULL,
  `client_recomanador_id` INT(11) NULL DEFAULT NULL,
  `adreces_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`venda` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data_venda` DATETIME NOT NULL,
  `clients_id` INT(11) NOT NULL,
  `empleat_id` INT(11) NOT NULL,
  `ulleres_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `clients_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `cul_d_ampolla`.`empleat` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
