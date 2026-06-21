use htu_transport; 

drop view if exists vw_StudentBookings;
create view vw_StudentBookings
as 
select s.studentID , s.firstname , s.lastname , t.routefrom , t.routeto , b.status , b.bookingID
from students s 
join booking b 
on s.studentID = b.studentID
join Trip t
on b.tripID = t.tripID;

select*from vw_StudentBookings;

drop view if exists vw_BusSchedules;
create view vw_BusSchedules
as 
select bu.busID , bu.capacity , bu.brand , t.routefrom , t.routeto , t.starttime , t.endtime
from Bus bu
join Trip t
on bu.busID = t.busID;

drop view if exists vw_ActiveRegistrations;
create view vw_ActiveRegistrations 
as
select b.busid, b.model, r.licenseplate, r.expirydate
from Bus b
join Registration r 
on b.busid = r.busid
where r.expirydate > CURDATE();

drop view if exists vw_TripPassengerCount;
create view vw_TripPassengerCount 
as
select t.tripid, t.routefrom, t.routeto, t.tripdate, COUNT(b.bookingid) as TotalPassengers -- alias
from Trip t
left join Booking b 
on t.tripid = b.tripid AND b.status = 'Confirmed'
group by t.tripid, t.routefrom, t.routeto, t.tripdate;


DELIMITER $$
-- Procedure 1: Add a new Student safely
CREATE PROCEDURE sp_AddStudent(
    IN p_fname VARCHAR(50), 
    IN p_lname VARCHAR(50), 
    IN p_email VARCHAR(100)
)
BEGIN
    INSERT INTO Students (firstname, lastname, email) 
    VALUES (p_fname, p_lname, p_email);
END $$

-- Procedure 2: Cancel a Booking
CREATE PROCEDURE sp_CancelBooking(IN p_bookingid INT)
BEGIN
    UPDATE Booking 
    SET status = 'Cancelled' 
    WHERE bookingid = p_bookingid;
END $$

-- Procedure 3: Update Bus Capacity
CREATE PROCEDURE sp_UpdateBusCapacity(IN p_busid INT, IN p_newcapacity INT)
BEGIN
    UPDATE Bus 
    SET capacity = p_newcapacity 
    WHERE busid = p_busid;
END $$

-- Procedure 4: Delete an Old Registration
CREATE PROCEDURE sp_DeleteRegistration(IN p_regid INT)
BEGIN
    DELETE FROM Registration 
    WHERE regid = p_regid;
END $$
DELIMITER ;

call sp_AddStudent('mahmoud','azzeh','mahmoud2azzeh@gmail.com');
select *from students;

CALL sp_UpdateBusCapacity(1, 30);
select *from bus;

CALL sp_DeleteRegistration(2);
select *from Registration;