use htu_transport;

CREATE USER 'Admin_User'@'localhost' IDENTIFIED BY 'AdminPass123';

-- Granting complete control over the entire database architecture
GRANT ALL PRIVILEGES ON HTU_Transport.* TO 'Admin_User'@'localhost';

-- 2. Create the Standard Student User
CREATE USER 'Student_User'@'localhost' IDENTIFIED BY 'StudentPass456';

GRANT SELECT ON HTU_Transport.vw_StudentBookings TO 'Student_User'@'localhost';
GRANT SELECT ON HTU_Transport.vw_BusSchedules TO 'Student_User'@'localhost';
revoke select on htu_transport.vw_BusSchedules from 'Student_User'@'localhost';
revoke select on htu_transport.bus from 'Student_User'@'localhost';
-- *Note: Replace 'BusSchedule' with the actual name of your base table if it is different.*
GRANT SELECT, INSERT, UPDATE ON HTU_Transport.Booking TO 'Student_User'@'localhost';
grant select on htu_transport.trip to 'Student_User'@'localhost';
FLUSH PRIVILEGES;

show grants for 'Student_User'@'localhost';
show grants for 'Admin_User'@'localhost';

SELECT * FROM vw_BusSchedules;

update HTU_Transport.Booking
set status = "cancelled"
where studentID =3;
select * from booking;

insert into bus(busID,capacity,model,brand,color)
values (1,25,'Coaster', 'Toyota', 'White');

update bus set busID = NULL
where busID=2;

INSERT INTO Booking (bookingdate, status, studentid, tripid)
VALUES ('2026-06-01', 'Confirmed', 9999, 1);

delete from students 
where studentID = 4 ;
select*from students;

delete from trip 
where tripID = 1;
select *from trip;

INSERT INTO Students (firstname, lastname, email)
VALUES ('Omar', 'Salem', 'mahmoud.smith@htu.edu.jo');

INSERT INTO Students (firstname, lastname, email) 
VALUES ('Ahmad', 'Omar', 'ahmad.o@htu.edu.jo');

-- 3. Take your screenshot of this result showing 'Jordanian' was added automatically!
SELECT * FROM Students WHERE email = 'ahmad.o@htu.edu.jo';

INSERT INTO Students (lastname, email)
VALUES ('Kamel', 'kamel.99@htu.edu.jo');

INSERT INTO Booking (bookingdate, status, studentid, tripid) 
VALUES ('2026-06-15 08:00:00', 'Lost', 1, 1);


SELECT * FROM vw_studentbookings 
where studentID = 2 ;
select * from students;
select * from booking;
insert into booking (bookingdate, status, studentid, tripid) 
VALUES ('2026-05-18 09:15:00', 'Confirmed',2, 2);

INSERT INTO Bus (capacity, model, brand, color) 
VALUES (30, 'Coaster', 'Toyota', 'White');
select * from bus;

UPDATE Booking SET status = 'Confirmed' 
WHERE bookingid = 5;
select * from booking;
INSERT INTO Booking (bookingID,bookingdate, status, studentid, tripid) 
VALUES (6,'2026-05-18 10:05:00', 'Pending', 3,3);

DELETE FROM Booking 
WHERE bookingid = 6;
select * from booking;
select *from bus ;
select*from trip;

insert into booking (bookingdate, status, studentid, tripid)
values ('2026-05-20','confirmed',5,2);

insert into students(firstname, lastname, email, address, parent_contact)
values ('mahmoud','alazzeh','mahmoud222alazzeh@gmail.com','sportcity','0797585065');
select *from students;
delete from students 
where studentID = 14 ;

SELECT tripid, COUNT(studentid) AS Total_Passengers 
FROM Booking 
WHERE status = 'Confirmed' 
GROUP BY tripid;

select * from vw_StudentBookings;