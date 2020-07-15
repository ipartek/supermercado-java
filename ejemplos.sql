

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


/* gruop by y subconsulta */

-- CUIDADO con COUNT(*) porque cuenta los NULL
SELECT
  c.id,
  c.nombre,
  COUNT(p.id) as 'num_productos',    
  ( SELECT nombre FROM producto WHERE id_categoria = c.id ORDER BY precio ASC LIMIT 1 ) as 'producto_mas_caro_barato',
  MIN( p.precio ) as 'producto_mas_barato',  
  ( SELECT nombre FROM producto WHERE id_categoria = c.id ORDER BY precio DESC LIMIT 1 ) as 'producto_mas_caro_nombre',
  MAX( p.precio ) as 'producto_mas_caro_precio',
  ROUND( AVG( p.precio ) , 2 ) as 'producto_media'
FROM categoria c LEFT JOIN producto p ON c.id = p.id_categoria 
GROUP BY p.id_categoria ;




