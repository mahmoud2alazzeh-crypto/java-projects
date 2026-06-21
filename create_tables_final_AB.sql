create database if not exists HTU_TRANSPORT;
use HTU_TRANSPORT;

drop table if exists students;
create table if not exists students(
studentID INT AUTO_INCREMENT PRIMARY KEY, 
firstname varchar(50) not null,
lastname varchar(50) not null,
email varchar(200) unique not null,
nationality varchar(50) default 'Jordanian', 
address varchar(200),
parent_contact varchar(50) 
);

drop table if exists Student_PhoneNumber;
create table if not exists Student_PhoneNumber(
studentID INT,
student_mobileNumber varchar(15),
primary key(studentID , student_mobileNumber),
constraint student_mobile_fk foreign key (studentID) references students (studentID) on delete cascade on update cascade
);

drop table if exists Bus;
create table if not exists Bus(
busID INT auto_increment primary key,
capacity INT not null check (capacity > 0),
model varchar(50),
brand varchar(50),
color varchar(50)
);

drop table if exists registration;
create table if not exists registration(
regID INT auto_increment primary key,
licenseplate varchar(20) unique not null,
expirydate date not null,
busID INT unique NOT null,
foreign key (busID) references bus (busID) on delete cascade  on update cascade
); 

drop table if exists Trip;
create table if not exists Trip(
tripID INT auto_increment primary key,
routefrom varchar(100) not null,
routeto varchar(100) not null,
tripdate date not null,
starttime time not null,
endtime time not null,
busID INT not null,
foreign key (busID) references bus (busID) on delete cascade on update cascade
);

drop table if exists Booking;
create table if not exists Booking(
bookingID INT auto_increment primary key,
bookingDate datetime default current_timestamp,
status varchar(50) check( status in ('confirmed','cancelled','pending')),
studentID INT not null,
tripID INT not null,
foreign key (studentID) references students (studentID) on delete cascade on update cascade,
foreign key (tripID) references Trip (tripID) on delete cascade on update cascade
);

-- 1. Create a temporary table that strictly restricts deleting a Bus
CREATE TABLE Restrict_Test (
    testid INT PRIMARY KEY,
    busid INT,
    FOREIGN KEY (busid) REFERENCES Bus(busid) ON DELETE RESTRICT 
);
-- 2. Insert a dummy record connecting to Bus #1
INSERT INTO Restrict_Test (testid, busid) VALUES (999, 2);
select * from bus;
-- 3. THE TEST: Attempt to delete Bus #1 
-- (TAKE YOUR SCREENSHOT OF THIS ERROR!)
DELETE FROM Bus WHERE busid = 1;
-- 4. Clean up: Delete the temporary table so your database is back to normal
DROP TABLE Restrict_Test;
