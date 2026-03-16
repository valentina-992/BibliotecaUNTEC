-- Usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    tipo_usuario VARCHAR(20)
);

-- Libros
CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(200),
    disponible BOOLEAN DEFAULT TRUE
);

-- Préstamos
CREATE TABLE prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Detalles de cada préstamo
CREATE TABLE detalle_prestamo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prestamo_id INT,
    libro_id INT,
    FOREIGN KEY (prestamo_id) REFERENCES prestamos(id),
    FOREIGN KEY (libro_id) REFERENCES libros(id)
);
