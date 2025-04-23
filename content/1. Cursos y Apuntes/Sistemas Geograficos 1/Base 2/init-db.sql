-- Creación de la base de datos
--CREATE DATABASE museo;

\c escuelas;

-- Habilitar PostGIS
--CREATE EXTENSION postgis;

-- Tabla de museos
CREATE TABLE escuelas (
    id SERIAL PRIMARY KEY,
    rude VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    dependencia VARCHAR(20) NOT NULL CHECK (dependencia IN ('privado', 'fiscal', 'convenio')),
    turno VARCHAR(100),-- NOT NULL CHECK (turno IN ('mañana', 'tarde', 'noche')),
    nivel VARCHAR(100),--[] NOT NULL CHECK (nivel <@ ARRAY['inicial', 'primaria', 'secundaria']),
    telefono VARCHAR(20),
    foto_url TEXT,
    --geom GEOMETRY(Point, 4326) GENERATED ALWAYS AS (ST_SetSRID(ST_MakePoint(longitud, latitud), 4326)) STORED,
    latitud DOUBLE PRECISION NOT NULL,
    longitud DOUBLE PRECISION NOT NULL
);


CREATE TABLE matriculacion (
    id SERIAL PRIMARY KEY,
    rude VARCHAR(20) NOT NULL,
    anio INTEGER NOT NULL CHECK (anio > 2000 AND anio <= EXTRACT(YEAR FROM CURRENT_DATE)),
    matricula_total INTEGER NOT NULL CHECK (matricula_total >= 0),
    matricula_mujer INTEGER NOT NULL CHECK (matricula_mujer >= 0),
    matricula_hombre INTEGER NOT NULL CHECK (matricula_hombre >= 0),
    promovidos_total INTEGER NOT NULL CHECK (promovidos_total >= 0),
    promovidos_mujer INTEGER NOT NULL CHECK (promovidos_mujer >= 0),
    promovidos_hombre INTEGER NOT NULL CHECK (promovidos_hombre >= 0),
    reprobados_total INTEGER NOT NULL CHECK (reprobados_total >= 0),
    reprobados_mujer INTEGER NOT NULL CHECK (reprobados_mujer >= 0),
    reprobados_hombre INTEGER NOT NULL CHECK (reprobados_hombre >= 0),
    abandono_total INTEGER NOT NULL CHECK (abandono_total >= 0),
    abandono_mujer INTEGER NOT NULL CHECK (abandono_mujer >= 0),
    abandono_hombre INTEGER NOT NULL CHECK (abandono_hombre >= 0),
    FOREIGN KEY (rude) REFERENCES escuelas(rude)
)