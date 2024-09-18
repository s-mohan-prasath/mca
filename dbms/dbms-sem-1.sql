--create table employees(
--emp_no int primary key  not null,
--fname varchar(50) not null,
--lname varchar(50) not null,
--job varchar(100),
--mgr_no int,
--foreign key (mgr_no) references employees(emp_no),
--dob date,
--hiredata date,
--salary int,
--commission int
--);

--INSERT INTO employees VALUES (7839,'Mohan','Prasath','President',null,'30/04/2024','28/08/2024',100000,25000);
select * from employees;
commit;

