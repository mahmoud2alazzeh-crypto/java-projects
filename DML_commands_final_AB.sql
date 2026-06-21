use htu_transport;

insert into students(firstname , lastname , email) values 
('ahmad', 'abdeen','ahmadabd@htu.edu.jo'); 

update booking 
set status = 'cancelled'
where studentID = 4 and tripID = 2; 
select*from booking;

delete from Student_PhoneNumber
where studentid = '2';
select*from Student_PhoneNumber;

select*from students
where firstname like 'a%';
