SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `pizzeria`;

CREATE SCHEMA IF NOT EXISTS `pizzeria` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE IF NOT EXISTS `pizzeria`.`clients` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `cognoms` VARCHAR(45) NULL DEFAULT NULL,
  `telefon` VARCHAR(9) NULL DEFAULT NULL,
  `adreça_id` INT(11) NOT NULL,
  constraint `pk_id` PRIMARY KEY (`id`),
  FOREIGN KEY (`adreça_id`) REFERENCES `adreces`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`adreces` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `adreça` VARCHAR(45) NOT NULL,
  `codi_postal` VARCHAR(10) NOT NULL,
  `localitat` VARCHAR(30) NOT NULL,
  `provincia` VARCHAR(30) NOT NULL,
  constraint `pk_id` PRIMARY KEY (`id`)) 
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`comandes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `repartiment` VARCHAR(9) NULL DEFAULT NULL,
  `treballador_id` INT(11) NULL DEFAULT NULL,
  `client_id` INT(11) NOT NULL,
  `botiga_id` INT(11) NOT NULL,
  constraint `pk_id` PRIMARY KEY (`id`),
  FOREIGN KEY (`client_id`) REFERENCES `clients`(`id`),
  FOREIGN KEY (`botiga_id`) REFERENCES `botigues`(`id`),
  FOREIGN KEY (`treballador_id`) REFERENCES `treballadors`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`productes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(35) NOT NULL,
  `preu` FLOAT(11) NOT NULL,
  `descripcio` VARCHAR(150) NULL DEFAULT NULL,
  `imatge` JSON NULL,
  `categoria` VARCHAR(20) NOT NULL,
  `categoria_pizza_id` INT(11) NULL DEFAULT NULL,
  constraint `pk_id` PRIMARY KEY (`id`),
  FOREIGN KEY (`categoria_pizza_id`) REFERENCES `categories_pizza`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`categories_pizza` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipus` VARCHAR(20) NULL DEFAULT NULL,
  constraint `pk_id` PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`botigues` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `adreça_id` INT(11) NOT NULL,
  constraint `pk_id` PRIMARY KEY (`id`),
  FOREIGN KEY (`adreça_id`) REFERENCES `adreces`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`treballadors` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `cognoms` VARCHAR(45) NOT NULL,
  `NIF` VARCHAR(15) NULL DEFAULT NULL,
  `telefon` VARCHAR(9) NULL DEFAULT NULL,
  `posicio` VARCHAR(20) NULL DEFAULT NULL,
  `botiga_id` INT(11) NOT NULL,
  constraint `pk_id` PRIMARY KEY (`id`),
  FOREIGN KEY (`botiga_id`) REFERENCES `botigues`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `pizzeria`.`items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantitat` INT(11) NOT NULL,
  `comanda_id` INT(11) NOT NULL,
  `producte_id` INT(11) NOT NULL,
  constraint `pk_id` PRIMARY KEY (`id`),
  FOREIGN KEY (`comanda_id`) REFERENCES `comandes`(`id`),
  FOREIGN KEY (`producte_id`) REFERENCES `productes`(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
