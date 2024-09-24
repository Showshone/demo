insert into contact (name, zip_code, city, number)
values
    ('John Doe', '7415ED', 'Deventer', '1234567890'),
    ('Jane Doe', '1012NC', 'Amsterdam', '4567891230'),
    ('Jan Jansen', '1113JC', 'Diemen', '7891234560');

insert into production_installation (name, contact_id, output_power)
values
    ('Solar Panel 1', (select id from contact where name = 'John Doe'), 1),
    ('Solar Panel 2', (select id from contact where name = 'Jane Doe'), 5000),
    ('Solar Panel 3', (select id from contact where name = 'Jan Jansen'), 60000);
