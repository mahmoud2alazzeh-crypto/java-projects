USE HTU_Transport;

INSERT INTO Bus (capacity, model, brand, color) VALUES 
(25, 'Coaster', 'Toyota', 'White'),
(50, 'Coach', 'Mercedes-Benz', 'Yellow'),
(30, 'County', 'Hyundai', 'White');

-- Notice the busid matches exactly 1-to-1 with the buses above
INSERT INTO registration (licenseplate, expirydate, busid) VALUES 
('50-12345', '2027-01-15', 1),
('25-98765', '2026-11-30', 2),
('30-55555', '2027-06-20', 3);

-- Adding realistic HTU student profiles
INSERT INTO Students (firstname, lastname, email, nationality, address, parent_contact) VALUES 
('Ahmad', 'Al-Masri', 'ahmad.masri@htu.edu.jo', 'Jordanian', 'Amman, 7th Circle', '0790001111'),
('Sara', 'Omar', 'sara.omar@htu.edu.jo', 'Jordanian', 'Zarqa, New Zarqa', NULL),
('John', 'Smith', 'mahmoud.smith@htu.edu.jo', 'American', 'Amman, Abdoun', '0781112222'),
('Laila', 'Hassan', 'laila.hassan@htu.edu.jo', 'Jordanian', 'Irbid, University St', '0773334444');

-- Ahmad (Student 1) has two phone numbers, the rest have one.(multi valued)
INSERT INTO Student_PhoneNumber (studentid, student_mobilenumber) VALUES 
(1, '0791234567'),
(1, '0787654321'),
(2, '0775556666'),
(3, '0799998888'),
(4, '0780009999');

-- Bus 1 is doing both Trip 1 (7 am) and Trip 3 (4 pm) -> 1:M ralationship
INSERT INTO Trip (routefrom, routeto, tripdate, starttime, endtime, busid) VALUES 
('Amman 7th Circle', 'HTU Campus', '2026-05-20', '07:00:00', '08:00:00', 1),
('Zarqa Complex', 'HTU Campus', '2026-05-20', '06:30:00', '08:00:00', 2),
('HTU Campus', 'Amman 7th Circle', '2026-05-20', '16:00:00', '17:00:00', 1),
('HTU Campus', 'Zarqa Complex', '2026-05-21', '16:15:00', '17:45:00', 2);

-- Student 1 books multiple trips. Trip 1 is booked by multiple students -> M:N realtionship
INSERT INTO Booking (bookingdate, status, studentid, tripid) VALUES 
('2026-05-18 09:15:00', 'Confirmed', 1, 1),
('2026-05-18 09:20:00', 'Confirmed', 2, 1),
('2026-05-18 10:05:00', 'Pending', 3, 1),
('2026-05-19 14:30:00', 'Confirmed', 1, 3),
('2026-05-19 15:00:00', 'Confirmed', 4, 2);


