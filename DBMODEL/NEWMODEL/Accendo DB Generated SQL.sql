-- MySQL Script generated by MySQL Workbench
-- Sun Feb 13 15:38:48 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema accendoDBNEW
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema accendoDBNEW
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `accendoDBNEW` DEFAULT CHARACTER SET utf8 ;
USE `accendoDBNEW` ;

-- -----------------------------------------------------
-- Table `accendoDBNEW`.`pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`pessoa` (
  `idPessoa` VARCHAR(50) NOT NULL,
  `tipoPessoa` VARCHAR(45) NULL,
  `passwordPessoa` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NULL,
  `sexo` VARCHAR(1) NULL,
  `idade` INT NULL,
  `rg` VARCHAR(9) NULL,
  `cpf` VARCHAR(11) NULL,
  `flag` TINYINT NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accendoDBNEW`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`turma` (
  `idTurma` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `ano` YEAR(4) NULL,
  PRIMARY KEY (`idTurma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accendoDBNEW`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`aluno` (
  `idAluno` INT NOT NULL AUTO_INCREMENT,
  `pessoa_idPessoa` VARCHAR(50) NOT NULL,
  `etapa` VARCHAR(45) NULL,
  `serie` INT NULL,
  `turma_idTurma` INT NOT NULL,
  PRIMARY KEY (`idAluno`, `pessoa_idPessoa`, `turma_idTurma`),
  INDEX `fk_aluno_pessoa1_idx` (`pessoa_idPessoa` ASC) VISIBLE,
  INDEX `fk_aluno_turma1_idx` (`turma_idTurma` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_pessoa1`
    FOREIGN KEY (`pessoa_idPessoa`)
    REFERENCES `accendoDBNEW`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_turma1`
    FOREIGN KEY (`turma_idTurma`)
    REFERENCES `accendoDBNEW`.`turma` (`idTurma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accendoDBNEW`.`materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`materia` (
  `idMateria` INT NOT NULL AUTO_INCREMENT,
  `nomeMateria` VARCHAR(45) NULL,
  PRIMARY KEY (`idMateria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accendoDBNEW`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`nota` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
  `valor` FLOAT NULL,
  `ta` INT NULL,
  `materia_idMateria` INT NOT NULL,
  `aluno_idAluno` INT NOT NULL,
  `pessoa_idPessoa` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idNota`, `materia_idMateria`, `aluno_idAluno`, `pessoa_idPessoa`),
  INDEX `fk_nota_materia_idx` (`materia_idMateria` ASC) VISIBLE,
  INDEX `fk_nota_aluno1_idx` (`aluno_idAluno` ASC, `pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_nota_materia`
    FOREIGN KEY (`materia_idMateria`)
    REFERENCES `accendoDBNEW`.`materia` (`idMateria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_aluno1`
    FOREIGN KEY (`aluno_idAluno` , `pessoa_idPessoa`)
    REFERENCES `accendoDBNEW`.`aluno` (`idAluno` , `pessoa_idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accendoDBNEW`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`professor` (
  `idProfessor` INT NOT NULL AUTO_INCREMENT,
  `pessoa_idPessoa` VARCHAR(50) NOT NULL,
  `graduacao` VARCHAR(45) NULL,
  PRIMARY KEY (`idProfessor`, `pessoa_idPessoa`),
  INDEX `fk_professor_pessoa1_idx` (`pessoa_idPessoa` ASC) VISIBLE,
  CONSTRAINT `fk_professor_pessoa1`
    FOREIGN KEY (`pessoa_idPessoa`)
    REFERENCES `accendoDBNEW`.`pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accendoDBNEW`.`professor_has_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accendoDBNEW`.`professor_has_turma` (
  `professor_idProfessor` INT NOT NULL,
  `professor_pessoa_idPessoa` VARCHAR(50) NOT NULL,
  `turma_idTurma` INT NOT NULL,
  PRIMARY KEY (`professor_idProfessor`, `professor_pessoa_idPessoa`, `turma_idTurma`),
  INDEX `fk_professor_has_turma_professor1_idx` (`professor_idProfessor` ASC, `professor_pessoa_idPessoa` ASC) VISIBLE,
  INDEX `fk_professor_has_turma_turma1_idx` (`turma_idTurma` ASC) VISIBLE,
  CONSTRAINT `fk_professor_has_turma_professor1`
    FOREIGN KEY (`professor_idProfessor` , `professor_pessoa_idPessoa`)
    REFERENCES `accendoDBNEW`.`professor` (`idProfessor` , `pessoa_idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_professor_has_turma_turma1`
    FOREIGN KEY (`turma_idTurma`)
    REFERENCES `accendoDBNEW`.`turma` (`idTurma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;