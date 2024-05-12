INSERT INTO Client VALUES
(1, 'Alexander Dolzhkov', 89234234234, 'aasdas@gmail.com', 'Street', 'qwerty', '12345'),
(2, 'Dmitriy Gornov', 854323452534, 'fafadsfas@gmail.com', 'Moscow', 'asdfg', '12345');

INSERT INTO Category VALUES
(1, 'Физический', ARRAY['Высота', 'Ширина', 'Длина', 'Вес']),
(2, 'Цифровой', null),
(3, 'Купон', ARRAY['Место использования', 'Получаемый контент']),
(4, 'Мобильный телефон', ARRAY['Бренд', 'Размер экрана', 'Процессор']),
(5, 'Монитор', ARRAY['Бренд', 'Размер экрана', 'Частота обновления']),
(6, 'Чайник', ARRAY['Бренд', 'Мощность', 'Объем']);
 
INSERT INTO Product VALUES
(1, 'Bosch FastBoil', 5000, 10,  'описание чайника', 5)
,(2, 'Vivo 1337', 11444, 5, 'описание телефона', 5)
,(3, 'Мегафон 150', 20000, 20, 'описание телефона 2', 5)
,(4, 'Asus ProMonitor', 30000, 10, 'описание монитора', 5)
,(5, 'BenQ SuperMonior', 35000, 20, 'описание монитора 2', 5)
,(6, 'Пополнение Steam 20$', 2000, 100, 'описание цифрового товара', 5)
,(7, 'Пополнение Steam 60$', 6000, 100, 'описание цифрового товара2', 5);

INSERT INTO ProductCategory VALUES
(1, 1, 1, ARRAY['0.1', '0.1', '0.1', '1']),
(1, 6, 1, ARRAY['Bosch', '30', '3']),
(2, 1, 1, ARRAY['0.1', '0.1', '0.1', '1']),
(2, 4, 1, ARRAY['Vivo', '4', 'Qualcom213']),
(3, 1, 1, ARRAY['0.1', '0.1', '0.1', '1']),
(3, 4, 1, ARRAY['Мегафон', '4', 'Snapdragon g12']),
(4, 1, 1, ARRAY['0.1', '0.1', '0.1', '1']),
(4, 5, 1, ARRAY['Asus', '27', '144']),
(5, 1, 1, ARRAY['0.1', '0.1', '0.1', '1']),
(5, 5, 1, ARRAY['BenQ', '24', '240']),
(6, 2, 1, null),
(6, 3, 1, ARRAY['Steam', '20$ на аккаунт']),
(7, 2, 1, null),
(7, 3, 1, ARRAY['Steam', '60$ на аккаунт']);


-- SELECT * FROM Client
-- SELECT * FROM Category
-- SELECT * FROM ProductCategory
-- SELECT * FROM Product
-- SELECT * FROM OrderTable
-- SELECT * FROM OrderProduct