insert into users (role, first_name, last_name, email, password, first_time_logged) values ('USER', 'Jovan', 'Jenjic', 'jovanjenjic@gmail.com', '$2a$10$67WhFHSky5EtaPlkTj1nqOIWRTHGNbWqJxtpJTUZMBQA.2am2yKqe', true);
insert into users (role, first_name, last_name, email, password, first_time_logged) values ('ADMIN', 'Stefan', 'Pejakovic', 'stefanpejakovic@gmail.com', '$2a$10$67WhFHSky5EtaPlkTj1nqOIWRTHGNbWqJxtpJTUZMBQA.2am2yKqe', true);
insert into users (role, first_name, last_name, email, password, first_time_logged) values ('USER', 'Aleksandar', 'Kosic', 'aleksandarkosic@gmail.com', '$2a$10$67WhFHSky5EtaPlkTj1nqOIWRTHGNbWqJxtpJTUZMBQA.2am2yKqe', true);

insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('BMW', 'X5', 'diesel', 'manuel', 'SUV', 220, 120000, true, 5, 0, 2200, 150, true, true, 70, 'Novi Sad');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('BMW', 'X6', 'gasoline', 'automatic', 'classic', 290, 90000, true, 6, 1, 3500, 300, true, true, 80, 'Beograd');
insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Mercedes', 'ML', 'diesel', 'manuel', 'SUV',310, 170000, false, 3, 2, 2500, 170, false, true, 60, 'Negotin');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Mercedes', 'GL', 'gasoline', 'automatic', 'SUV', 199, 300000, false, 7, 0, 2000, 110, false, false, 62, 'Nis');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Golf', '5', 'gasoline', 'manuel', 'classic', 140, 190000, false, 5, 0, 1600, 70, false, false, 50, 'Prizren');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Golf', '6', 'gasoline', 'manuel', 'classic', 175, 40000, true, 4, 1, 1200, 110, true, true, 63, 'Kula');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Audi', 'A6', 'diesel', 'automatic', 'classic', 199, 50000, true, 5, 0, 1900, 150, true, false, 55, 'Zajecar');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Audi', 'A5', 'diesel', 'automatic', 'classic', 310, 10000, false, 4, 1, 2500, 200, true, true, 66, 'Novi Sad');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('Audi', 'A4', 'gasoline', 'manuel', 'SUV', 210, 78000, false, 5, 1, 2000, 90, false, false, 59, 'Beograd');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('BMW', 'm4', 'gasoiline', 'automatic', 'SUV', 400, 60000, true, 2, 0, 3000, 300, false, true, 40, 'Beograd');
 insert into car (brand, model, fuel_type, transmission, class_car, price, mileage, cdw, capacity_seats, capacity_seats_for_kids, cubic_capacity, horse_power, usb, gps, fuel_tank_capacity, city_location)
 values ('BMW', '3', 'diesel', 'manuel', 'classic', 420, 87000, false, 4, 0, 3300, 250, true, false, 45, 'Novi Sad');

 insert into car_rental_date (start_date, end_date, car_id) values ('2020-01-01 04:09:00', '2020-02-01', 1);
 insert into car_rental_date (start_date, end_date, car_id) values ('2020-02-02 10:43:12', '2020-03-02', 2);


alter sequence users_id_seq restart with 4;
alter sequence car_id_seq restart with 12;
alter sequence car_rental_date_id_seq restart with 3;