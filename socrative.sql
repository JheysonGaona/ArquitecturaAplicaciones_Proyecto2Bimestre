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
  codigo INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los cuestionarios.', 
  title VARCHAR(200) NOT NULL UNIQUE COMMENT 'nombre del cuestionario.',
  fkdocentes INT NOT NULL COMMENT 'FK a docentes',
  FOREIGN KEY (fkdocentes) REFERENCES docentes(codedocentes)) COMMENT='cuestionarios almacenados';

-- -----------------------------------------------------
-- Table preguntas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS preguntas (
  codpregunta INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para las preguntas.',
  pregunta VARCHAR(300) NULL COMMENT 'pregunta almacenada.',
  fkcuestionarios INT NOT NULL COMMENT 'FK a cuestionarios',
  FOREIGN KEY (fkcuestionarios) REFERENCES cuestionarios(codigo)) COMMENT='preguntas del cuestionario';

-- -----------------------------------------------------
-- Table opciones
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS opciones (
  codopciones INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los opciones.',
  opcion VARCHAR(300) NOT NULL COMMENT 'opciones de la pregunta.',
  respuesta INT NOT NULL COMMENT 'Guarda el ID de la opcion correcta (respuesta).',
  fkpreguntas INT NOT NULL COMMENT 'FK a areas',
  FOREIGN KEY (fkpreguntas) REFERENCES preguntas(codpregunta)) COMMENT='preguntas del cuestionario';

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
  codexamenrealizados INT AUTO_INCREMENT PRIMARY KEY COMMENT 'PK codigo autoincrementable para los examenrealizados',
  fkestudiante INT NOT NULL COMMENT 'FK a estudiantes',
  fkpregunta INT NOT NULL COMMENT 'FK a cuestionarios',
  fkopciones INT NOT NULL COMMENT 'FK a cuestionarios',
  nota double NOT NULL COMMENT 'Nota del estudiante',
  FOREIGN KEY (fkestudiante) REFERENCES estudiantes(idestudiantes),
  FOREIGN KEY (fkpregunta) REFERENCES preguntas(codpregunta),
  FOREIGN KEY (fkopciones) REFERENCES opciones(codopciones)) COMMENT='examen realizados';


