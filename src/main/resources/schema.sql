CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    genero VARCHAR(50),
    fecha_nacimiento DATE,
    altura INT,
    peso DECIMAL(5,2),
    nivel_actividad TINYINT CHECK (nivel_actividad IN (0, 1, 2)),
    objetivo TINYINT CHECK (objetivo in (0, 1, 2)),
    img_path varchar(255)
);

CREATE TABLE IF NOT EXISTS historial_pesos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha VARCHAR(11),
    peso INTEGER
);