

-- Comandos de CRUD

-- READ

SELECT id, nombre FROM producto;
SELECT id, nombre FROM producto WHERE id = 12;
SELECT id, nombre FROM producto WHERE nombre LIKE '%galle%';



-- Create

INSERT INTO producto ( nombre, id_usuario ) VALUES ('Iphone 7 Pkus', 1);

-- UPDATE
UPDATE producto SET nombre = 'Iphone 7 Plus' WHERE id = 30;

-- DELETE
DELETE FROM producto WHERE id = 19;




