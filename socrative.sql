-- MySQL xammp

-- source /home/pc/socrativeBD_MySQL.sql

CREATE USER 'utpl'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON * . * TO 'utpl'@'localhost';
CREATE DATABASE socrative DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE socrative;
-- -----------------------------------------------------
-- Table docentes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS docentes (
  codedocentes INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los docenteses',
  nombre VARCHAR(200) NOT NULL UNIQUE COMMENT 'Nombre del docentes') COMMENT='docentes del cuestionario';

-- -----------------------------------------------------
-- Table cuestionarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cuestionarios ( 
  idCuestionario INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los cuestionarios.', 
  nombreCuestionario VARCHAR(200) NOT NULL UNIQUE COMMENT 'nombre del cuestionario.',
  numPreguntasCuestionario INT NOT NULL,
  fechaCreacionCuestionario DATE NOT NULL,
  fkdocentes INT NOT NULL COMMENT 'FK a docentes',
  FOREIGN KEY (fkdocentes) REFERENCES docentes(codedocentes)) COMMENT='cuestionarios almacenados';

-- -----------------------------------------------------
-- Table shortAnswer
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS shortAnswer (
  idShortAnswer INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para las preguntas.',
  textAnswer VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  idCuestionario INT NOT NULL COMMENT 'FK a cuestionarios',
  FOREIGN KEY (idCuestionario) REFERENCES cuestionarios(idCuestionario)) COMMENT='preguntas del cuestionario';
  
-- -----------------------------------------------------
-- Table true_false
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS true_false (
  idTrue_false INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para las preguntas.',
  textoPregunta VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  answer VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  idCuestionario INT NOT NULL COMMENT 'FK a cuestionarios',
  FOREIGN KEY (idCuestionario) REFERENCES cuestionarios(idCuestionario)) COMMENT='preguntas del cuestionario';

-- -----------------------------------------------------
-- Table optionmultiple
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS optionmultiple (
  idOptionMultiple INT AUTO_INCREMENT PRIMARY KEY,
  textoPregunta VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  idCuestionario INT NOT NULL,
  FOREIGN KEY (idCuestionario) REFERENCES cuestionarios(idCuestionario)) COMMENT='preguntas del cuestionario';
  
-- -----------------------------------------------------
-- Table optionmultipleoptions
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS optionmultipleoptions (
  idOptionMultipleOptions INT AUTO_INCREMENT PRIMARY KEY,
  textoOption VARCHAR(300) NULL COMMENT 'opcion almacenada.',
  answerOption VARCHAR(300) NULL COMMENT 'respuesta entre las opciones.',
  idOptionMultiple INT NOT NULL,
  FOREIGN KEY (idOptionMultiple) REFERENCES optionmultiple(idOptionMultiple)) COMMENT='opciones de las preguntas de tipo_opcion_multiple';

-- -----------------------------------------------------
-- Table estudiantes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudiantes (
  idestudiantes INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los estudiantes',
  nombre VARCHAR(100) NOT NULL COMMENT 'nombre del alumno.') COMMENT='estudiantes registrados';
/*
-- -----------------------------------------------------
-- Table examenrealizados
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS examenrealizados (
  codexamenrealizados INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los examenrealizados',
  fkestudiante INT NOT NULL COMMENT 'FK a estudiantes',
  fkopciones INT NOT NULL COMMENT 'FK a tp_preguntas_opcion_multiple',
  fkopciones INT NOT NULL COMMENT 'FK a tp_preguntas_true_false',
  fkopciones INT NOT NULL COMMENT 'FK a tp_preguntas_opcion_shortAnswer',
  FOREIGN KEY (fkestudiante) REFERENCES estudiantes(idestudiantes),
  FOREIGN KEY (fkpregunta) REFERENCES cuestionarios(idCuestionario),
  FOREIGN KEY (fkopciones) REFERENCES opciones(codopciones)) COMMENT='examen realizados';
*/