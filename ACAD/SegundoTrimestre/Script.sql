-- Creación del usuario DAM2 con contraseña DAM2
CREATE USER DAM2 IDENTIFIED BY DAM2;

-- Asignación de permisos básicos (Standard en Oracle 8i)
-- CONNECT: Permite loguearse.
-- RESOURCE: Permite crear tablas, secuencias, etc.
GRANT CONNECT, RESOURCE TO DAM2;

-- (Opcional) Asignar cuota en el tablespace por defecto si es necesario
GRANT UNLIMITED TABLESPACE TO DAM2;


-- 1. Creación de la tabla DEPART (Departamento)
-- Es necesario crearla antes que EMPLE porque EMPLE depende de ella.
CREATE TABLE DEPART (
    DEPT_NO NUMBER(2) NOT NULL,
    DNOMBRE VARCHAR2(20),
    LOC     VARCHAR2(20),
    CONSTRAINT PK_DEPART PRIMARY KEY (DEPT_NO)
);

-- 2. Creación de la tabla EMPLE (Empleado)
CREATE TABLE EMPLE (
    EMP_NO    NUMBER(4) NOT NULL,
    APELLIDO  VARCHAR2(20),
    OFICIO    VARCHAR2(20),
    DIR       NUMBER(4),           -- Este es el campo del JEFE
    FECHA_ALT DATE,
    SALARIO   NUMBER(7,2),
    COMISION  NUMBER(7,2),
    DEPT_NO   NUMBER(2) NOT NULL,
    
    -- Restricción de Clave Primaria
    CONSTRAINT PK_EMPLE PRIMARY KEY (EMP_NO),

    -- Restricción Foreign Key: El empleado pertenece a un departamento
    CONSTRAINT FK_EMP_DEPART FOREIGN KEY (DEPT_NO) 
        REFERENCES DEPART(DEPT_NO),

    -- Restricción Foreign Key (Recursiva): El jefe debe ser un empleado existente
    CONSTRAINT FK_EMP_JEFE FOREIGN KEY (DIR) 
        REFERENCES EMPLE(EMP_NO),

    -- REQUISITO: Un empleado no puede ser jefe de sí mismo
    -- Esto se logra con un CHECK que valida que el número de empleado
    -- sea diferente al número del director (jefe).
    CONSTRAINT CHK_NO_AUTO_JEFE CHECK (EMP_NO <> DIR)
);

-- Insertar Departamentos
INSERT INTO DEPART VALUES (10, 'CONTABILIDAD', 'SEVILLA');
INSERT INTO DEPART VALUES (20, 'INVESTIGACION', 'MADRID');

-- Insertar un Jefe (El presidente, no tiene jefe, así que DIR es NULL)
INSERT INTO EMPLE VALUES (7839, 'REY', 'PRESIDENTE', NULL, SYSDATE, 5000, 0, 10);

-- Insertar un Empleado (Su jefe es REY - 7839)
INSERT INTO EMPLE VALUES (7566, 'JIMENEZ', 'MANAGER', 7839, SYSDATE, 2900, 100, 20);

-- Confirmar cambios
COMMIT;