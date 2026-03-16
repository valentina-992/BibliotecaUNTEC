-- Script de datos iniciales para BibliotecaUNTEC
-- Incluye libros y usuarios de prueba


USE biblioteca;

-- ELIMINACIÓN DE REGISTROS ANTERIORES
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE detalle_prestamo;
TRUNCATE TABLE prestamos;
TRUNCATE TABLE usuarios;
TRUNCATE TABLE libros;

SET FOREIGN_KEY_CHECKS = 1;

-- LIBROS DE EJEMPLO

INSERT INTO libros (titulo, autor) VALUES
('Crimen y Castigo', 'Fiódor Dostoyevski'),
('Siddhartha', 'Hermann Hesse'),
('El cuento de la criada', 'Margaret Atwood'),
('El hombre que calculaba', 'Malba Tahan'),
('La tregua', 'Mario Benedetti');

-- USUARIOS DE PRUEBA

INSERT INTO usuarios (nombre, email, password, tipo_usuario) VALUES
('Profesor', 'profesor@untec.com', '1234', 'TRABAJADOR'),
('Estudiante', 'estudiante@untec.com', '1234', 'ESTUDIANTE');
