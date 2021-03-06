-- MySQL Script generated by MySQL Workbench
-- Tue May 17 16:59:45 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MYSHOP22
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MYSHOP22
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MYSHOP22` DEFAULT CHARACTER SET utf8 ;
USE `MYSHOP22` ;

-- -----------------------------------------------------
-- Table `MYSHOP22`.`credentials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`credentials` (
  `idcredentials` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `passwd` VARCHAR(45) NOT NULL,
  `Role` VARCHAR(45) NOT NULL,
  `PuntoVendita` VARCHAR(45) NULL,
  PRIMARY KEY (`idcredentials`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `passwd` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Surname` VARCHAR(45) NOT NULL,
  `Age` INT NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `telephone` INT NOT NULL,
  `occupation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Manager` (
  `idmanager` INT NOT NULL AUTO_INCREMENT,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idmanager`),
  INDEX `fk_Manager_user1_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_Manager_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `MYSHOP22`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Point_shop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Point_shop` (
  `idPoint_shop` INT NOT NULL AUTO_INCREMENT,
  `Shopname` VARCHAR(45) NOT NULL DEFAULT 'none',
  `city` VARCHAR(45) NOT NULL DEFAULT 'none',
  `article_type` VARCHAR(45) NOT NULL DEFAULT 'none',
  `Manager_idmanager` INT NOT NULL,
  PRIMARY KEY (`idPoint_shop`),
  INDEX `fk_Point_shop_Manager1_idx` (`Manager_idmanager` ASC) VISIBLE,
  CONSTRAINT `fk_Point_shop_Manager1`
    FOREIGN KEY (`Manager_idmanager`)
    REFERENCES `MYSHOP22`.`Manager` (`idmanager`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_Cliente_user1_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `MYSHOP22`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Shop_List`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Shop_List` (
  `idShop_List` INT NOT NULL AUTO_INCREMENT,
  `Stato` VARCHAR(45) NOT NULL,
  `total_price` FLOAT NOT NULL,
  `Date` VARCHAR(45) NOT NULL,
  `Point_shop_idPoint_shop` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idShop_List`),
  INDEX `fk_BUY_List_Point_shop1_idx` (`Point_shop_idPoint_shop` ASC) VISIBLE,
  INDEX `fk_BUY_List_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_BUY_List_Point_shop1`
    FOREIGN KEY (`Point_shop_idPoint_shop`)
    REFERENCES `MYSHOP22`.`Point_shop` (`idPoint_shop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BUY_List_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `MYSHOP22`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`articolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`articolo` (
  `idarticolo` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `costo` FLOAT NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `Point_shop_idPoint_shop` INT NULL,
  `catalogue_idcatalogue` INT NULL,
  `Shop_List_idShop_List` INT NULL,
  PRIMARY KEY (`idarticolo`),
  INDEX `fk_articolo_Point_shop1_idx` (`Point_shop_idPoint_shop` ASC) VISIBLE,
  INDEX `fk_articolo_Shop_List1_idx` (`Shop_List_idShop_List` ASC) VISIBLE,
  CONSTRAINT `fk_articolo_Point_shop1`
    FOREIGN KEY (`Point_shop_idPoint_shop`)
    REFERENCES `MYSHOP22`.`Point_shop` (`idPoint_shop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_articolo_Shop_List1`
    FOREIGN KEY (`Shop_List_idShop_List`)
    REFERENCES `MYSHOP22`.`Shop_List` (`idShop_List`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Produttore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Produttore` (
  `idProduttore` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL DEFAULT 'none',
  `Website` VARCHAR(45) NOT NULL DEFAULT 'none',
  `Nazione` VARCHAR(45) NOT NULL DEFAULT 'none',
  `citta` VARCHAR(45) NOT NULL DEFAULT 'none',
  PRIMARY KEY (`idProduttore`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT,
  `subcategory` VARCHAR(45) NOT NULL DEFAULT 'none',
  `corsia` INT NULL,
  `scaffale` INT NULL,
  `articolo_idarticolo` INT NOT NULL,
  `Produttore_idProduttore` INT NOT NULL,
  PRIMARY KEY (`idproduct`),
  INDEX `fk_product_articolo1_idx` (`articolo_idarticolo` ASC) VISIBLE,
  INDEX `fk_product_Produttore1_idx` (`Produttore_idProduttore` ASC) VISIBLE,
  CONSTRAINT `fk_product_articolo1`
    FOREIGN KEY (`articolo_idarticolo`)
    REFERENCES `MYSHOP22`.`articolo` (`idarticolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_Produttore1`
    FOREIGN KEY (`Produttore_idProduttore`)
    REFERENCES `MYSHOP22`.`Produttore` (`idProduttore`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Fornitore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Fornitore` (
  `idFornitore` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL DEFAULT 'none',
  `Website` VARCHAR(45) NOT NULL DEFAULT 'none',
  `Nazione` VARCHAR(45) NOT NULL DEFAULT 'none',
  `citta` VARCHAR(45) NOT NULL DEFAULT 'none',
  PRIMARY KEY (`idFornitore`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`service` (
  `idservice` INT NOT NULL AUTO_INCREMENT,
  `articolo_idarticolo` INT NOT NULL,
  `Fornitore_idFornitore` INT NOT NULL,
  PRIMARY KEY (`idservice`),
  INDEX `fk_service_articolo1_idx` (`articolo_idarticolo` ASC) VISIBLE,
  INDEX `fk_service_Fornitore1_idx` (`Fornitore_idFornitore` ASC) VISIBLE,
  CONSTRAINT `fk_service_articolo1`
    FOREIGN KEY (`articolo_idarticolo`)
    REFERENCES `MYSHOP22`.`articolo` (`idarticolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_Fornitore1`
    FOREIGN KEY (`Fornitore_idFornitore`)
    REFERENCES `MYSHOP22`.`Fornitore` (`idFornitore`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`admin` (
  `idadmin` INT NOT NULL AUTO_INCREMENT,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idadmin`),
  INDEX `user_iduser_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `user_iduser`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `MYSHOP22`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`comments` (
  `idcomments` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(150) NOT NULL DEFAULT 'none',
  `feedback` INT NOT NULL DEFAULT 0,
  `user_iduser` INT NOT NULL,
  `articolo_idarticolo` INT NOT NULL,
  PRIMARY KEY (`idcomments`),
  INDEX `fk_comments_user1_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_comments_articolo1_idx` (`articolo_idarticolo` ASC) VISIBLE,
  CONSTRAINT `fk_comments_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `MYSHOP22`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_articolo1`
    FOREIGN KEY (`articolo_idarticolo`)
    REFERENCES `MYSHOP22`.`articolo` (`idarticolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Subproduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Subproduct` (
  `idSubproduct` INT NOT NULL,
  `product_idproduct` INT NOT NULL,
  `articolo_idarticolo` INT NOT NULL,
  PRIMARY KEY (`idSubproduct`),
  INDEX `fk_Subproduct_product1_idx` (`product_idproduct` ASC) VISIBLE,
  INDEX `fk_Subproduct_articolo1_idx` (`articolo_idarticolo` ASC) VISIBLE,
  CONSTRAINT `fk_Subproduct_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `MYSHOP22`.`product` (`idproduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subproduct_articolo1`
    FOREIGN KEY (`articolo_idarticolo`)
    REFERENCES `MYSHOP22`.`articolo` (`idarticolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`Point_shop_has_Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`Point_shop_has_Cliente` (
  `Point_shop_idPoint_shop` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  INDEX `fk_Point_shop_has_Cliente_Point_shop1_idx` (`Point_shop_idPoint_shop` ASC) VISIBLE,
  INDEX `fk_Point_shop_has_Cliente_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Point_shop_has_Cliente_Point_shop1`
    FOREIGN KEY (`Point_shop_idPoint_shop`)
    REFERENCES `MYSHOP22`.`Point_shop` (`idPoint_shop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Point_shop_has_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `MYSHOP22`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MYSHOP22`.`articolo_photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MYSHOP22`.`articolo_photo` (
  `idarticolo_photo` INT NOT NULL AUTO_INCREMENT,
  `Image_descr` BLOB NULL,
  `articolo_idarticolo` INT NOT NULL,
  PRIMARY KEY (`idarticolo_photo`),
  INDEX `fk_articolo_photo_articolo1_idx` (`articolo_idarticolo` ASC) VISIBLE,
  CONSTRAINT `fk_articolo_photo_articolo1`
    FOREIGN KEY (`articolo_idarticolo`)
    REFERENCES `MYSHOP22`.`articolo` (`idarticolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
