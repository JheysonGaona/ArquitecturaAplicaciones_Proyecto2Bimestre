-- MySQL xammp

-- source /home/pc/socrativeBD_MySQL.sql

-- CREATE USER 'utpl'@'localhost' IDENTIFIED BY '1234';
-- GRANT ALL PRIVILEGES ON * . * TO 'utpl'@'localhost';
CREATE DATABASE DB_cuestionario DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE DB_cuestionario;
-- -----------------------------------------------------
-- Table docentes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS docentes (
  codedocentes INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los docenteses',
  nombre VARCHAR(200) NOT NULL COMMENT 'Nombre del docentes') COMMENT='docentes del cuestionario';

-- -----------------------------------------------------
-- Table quiz
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS quiz ( 
  idQuiz INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los quiz.', 
  nameQuiz VARCHAR(200) NOT NULL UNIQUE COMMENT 'nombre del cuestionario.',
  fkdocentes INT NOT NULL COMMENT 'FK a docentes',
  FOREIGN KEY (fkdocentes) REFERENCES docentes(codedocentes)) COMMENT='quiz almacenados';

-- -----------------------------------------------------
-- Table shortAnswer
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS shortAnswer (
  idQuestionShortAnswer INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para las preguntas.',
  idQuiz INT NOT NULL COMMENT 'FK a quiz',
  textQuestion VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  answer VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  FOREIGN KEY (idQuiz) REFERENCES quiz(idQuiz)) COMMENT='preguntas del cuestionario';
  
-- -----------------------------------------------------
-- Table true_false
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS true_false (
  idQuestionTrueFalse INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para las preguntas.',
  idQuiz INT NOT NULL COMMENT 'FK a quiz',
  textQuestion VARCHAR(300) NOT NULL COMMENT 'pregunta almacenada.',
  answer bit(1) NULL COMMENT 'pregunta almacenada.',
  FOREIGN KEY (idQuiz) REFERENCES quiz(idQuiz)) COMMENT='preguntas del cuestionario';

-- -----------------------------------------------------
-- Table optionmultiple
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS optionmultiple (
  idQuestionOptionMultiple INT AUTO_INCREMENT PRIMARY KEY,
  idQuiz INT NOT NULL,
  textQuestion VARCHAR(300) NOT NULL COMMENT 'pregunta almacenada.',
  FOREIGN KEY (idQuiz) REFERENCES quiz(idQuiz)) COMMENT='preguntas del cuestionario';
  
-- -----------------------------------------------------
-- Table optionmultipleoptions
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS optionmultipleoptions (
  idOption INT AUTO_INCREMENT PRIMARY KEY,
  idQuestionOptionMultiple INT NOT NULL,
  textoOption VARCHAR(300) NOT NULL COMMENT 'opcion almacenada.',
  answer tinyint(1) NOT NULL COMMENT 'respuesta entre las opciones.',
  FOREIGN KEY (idQuestionOptionMultiple) REFERENCES optionmultiple(idQuestionOptionMultiple)) COMMENT='opciones de las preguntas de tipo_opcion_multiple';

-- -----------------------------------------------------
-- Table estudiantes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudiantes (
  idestudiantes INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los estudiantes',
  nombre VARCHAR(100) NOT NULL COMMENT 'nombre del alumno.') COMMENT='estudiantes registrados';

-- -----------------------------------------------------
-- Table examenrealizados
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS examenrealizados (
  idexamen INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los examenrealizados',
  fkestudiante INT NOT NULL COMMENT 'FK a estudiantes',
  fkquiz INT NOT NULL COMMENT 'FK a quiz',
  fkopciones INT NOT NULL COMMENT 'FK a tp_preguntas_opcion_multiple',
  opcion tinyint(1) NOT NULL COMMENT 'respuesta entre las opciones.',
  fktrue_false INT NOT NULL COMMENT 'FK a tp_preguntas_true_false',
  truefalse bit(1) NULL COMMENT 'pregunta almacenada.',
  fkshortanswer INT NOT NULL COMMENT 'FK a tp_preguntas_opcion_shortAnswer',
  answer VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  FOREIGN KEY (fkestudiante) REFERENCES estudiantes(idestudiantes),
  FOREIGN KEY (fkquiz) REFERENCES quiz(idQuiz),
  FOREIGN KEY (fkopciones) REFERENCES optionmultipleoptions(idQuestionOptionMultiple),
  FOREIGN KEY (fktrue_false) REFERENCES true_false(idQuestionTrueFalse),
  FOREIGN KEY (fkshortanswer) REFERENCES shortAnswer(idQuestionShortAnswer)) COMMENT='examen realizados';

INSERT INTO `estudiantes`(`nombre`) VALUES ('Luis Benitez'), ('Rosa Pineda');
INSERT INTO `docentes`(`nombre`) VALUES ('Sara Loaiza'), ('Pablo Cabrera');
