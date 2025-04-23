-- Creación de la base de datos
--CREATE DATABASE museo;

\c museo;

-- Habilitar PostGIS
--CREATE EXTENSION postgis;

-- Tabla de museos
CREATE TABLE museos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion TEXT NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    area_m2 FLOAT CHECK (area_m2 > 0),
    geom GEOMETRY(Point, 4326) -- Coordenadas geográficas (Lat, Lon)
);

-- Tabla de exhibiciones
CREATE TABLE exhibiciones (
    id SERIAL PRIMARY KEY,
    museo_id INT REFERENCES museos(id) ON DELETE CASCADE,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    area_m2 FLOAT CHECK (area_m2 > 0),
    geom GEOMETRY(Polygon, 4326) -- Área que ocupa dentro del museo
);

-- Tabla de piezas de exhibición
CREATE TABLE piezas (
    id SERIAL PRIMARY KEY,
    exhibicion_id INT REFERENCES exhibiciones(id) ON DELETE CASCADE,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    año INT CHECK (año > 0),
    tipo VARCHAR(100), -- Ej: Pintura, Escultura, Artefacto
    estado VARCHAR(50) CHECK (estado IN ('En exhibición', 'En restauración', 'En préstamo', 'En bodega')),
    geom GEOMETRY(Point, 4326) -- Ubicación específica dentro del museo
);

-- Tabla de empleados
CREATE TABLE empleados (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    cargo VARCHAR(100) NOT NULL, -- Ej: Guía, Conservador, Seguridad
    salario DECIMAL(10,2) CHECK (salario >= 0),
    fecha_contratacion DATE NOT NULL,
    museo_id INT REFERENCES museos(id) ON DELETE CASCADE
);

-- Tabla de visitas (registro de visitantes)
CREATE TABLE visitas (
    id SERIAL PRIMARY KEY,
    museo_id INT REFERENCES museos(id) ON DELETE CASCADE,
    fecha TIMESTAMP DEFAULT NOW(),
    cantidad INT CHECK (cantidad > 0)
);

-- Tabla de ubicaciones dentro del museo (zonas o salas)
CREATE TABLE ubicaciones (
    id SERIAL PRIMARY KEY,
    museo_id INT REFERENCES museos(id) ON DELETE CASCADE,
    nombre VARCHAR(255) NOT NULL, -- Ej: Sala de arte moderno, Patio central
    descripcion TEXT,
    tipo VARCHAR(100) CHECK (tipo IN ('Exhibición', 'Tienda', 'Cafetería', 'Entrada', 'Salida')),
    geom GEOMETRY(Polygon, 4326) -- Forma del área en el mapa
);

-- Inserción de datos de ejemplo
INSERT INTO museos (nombre, direccion, ciudad, pais, area_m2, geom)
VALUES ('Museo Nacional de Arte', 'Calle Comercio 123', 'La Paz', 'Bolivia', 5000, ST_GeomFromText('POINT(-68.1193 -16.5000)', 4326));

INSERT INTO exhibiciones (museo_id, nombre, descripcion, fecha_inicio, fecha_fin, area_m2, geom)
VALUES (1, 'Arte Precolombino', 'Exhibición de arte indígena precolombino.', '2025-01-15', '2025-12-15', 400, ST_GeomFromText('POLYGON((-68.1195 -16.5001, -68.1194 -16.5001, -68.1194 -16.5000, -68.1195 -16.5000, -68.1195 -16.5001))', 4326));

INSERT INTO piezas (exhibicion_id, nombre, descripcion, año, tipo, estado, geom)
VALUES (1, 'Vasija Tiwanaku', 'Vasija ceremonial de la cultura Tiwanaku.', 800, 'Artefacto', 'En exhibición', ST_GeomFromText('POINT(-68.11945 -16.50005)', 4326));

INSERT INTO empleados (nombre, cargo, salario, fecha_contratacion, museo_id)
VALUES ('María Pérez', 'Guía', 3000.00, '2023-06-10', 1);

INSERT INTO visitas (museo_id, fecha, cantidad)
VALUES (1, NOW(), 120);

INSERT INTO ubicaciones (museo_id, nombre, descripcion, tipo, geom)
VALUES (1, 'Patio Central', 'Zona de descanso y actividades culturales.', 'Exhibición', ST_GeomFromText('POLYGON((-68.1196 -16.5002, -68.1194 -16.5002, -68.1194 -16.5001, -68.1196 -16.5001, -68.1196 -16.5002))', 4326));
