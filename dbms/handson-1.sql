create table employee(
    emp_no number,
    fname varchar(15) not null,
    lname varchar(15) not null,
    job varchar(15) not null,
    mgr number(4) default null,
    dob date not null,
    hiredate date not null,
    salary number(7,2) not null,
    comm number default null,
    constraint pk_emp primary key (emp_no),
    constraint fk_mgr foreign key(emp_no) references employee(emp_no),
    constraint chk_emp_dob_range check (extract(year from dob)<=1975),
    constraint chk_emp_salary_range check (salary >20000 and salary < 100000)
);

INSERT INTO EMPLOYEE VALUES(7839, 'Robert', 'James', 'President', NULL, TO_DATE('11/09/1972', 'DD/MM/YYYY'), TO_DATE('11/01/2003', 'DD/MM/YYYY'), 65000.00, NULL);
INSERT INTO EMPLOYEE VALUES(7698, 'Ram', 'Raman', 'Manager', 7839, TO_DATE('05/01/1972', 'DD/MM/YYYY'), TO_DATE('25/01/2007', 'DD/MM/YYYY'), 42850.00, NULL);
INSERT INTO EMPLOYEE VALUES(7782, 'Ramana', 'Samy', 'Manager', 7839, TO_DATE('06/09/1973', 'DD/MM/YYYY'), TO_DATE('16/09/2008', 'DD/MM/YYYY'), 42450.00, 23230.00);
INSERT INTO EMPLOYEE VALUES(7566, 'Palani', 'Velappan', 'Manager', 7839, TO_DATE('04/02/1972', 'DD/MM/YYYY'), TO_DATE('14/02/2006', 'DD/MM/YYYY'), 42975.00, 19455.00);
INSERT INTO EMPLOYEE VALUES(7654, 'Senthil', 'Pandian', 'Salesman', 7698, TO_DATE('09/08/1969', 'DD/MM/YYYY'), TO_DATE('19/08/2007', 'DD/MM/YYYY'), 21250.00, 13400.00);
INSERT INTO EMPLOYEE VALUES(7499, 'Sampandam', 'Ramanathan', 'Salesman', 7698, TO_DATE('02/02/1970', 'DD/MM/YYYY'), TO_DATE('22/02/2006', 'DD/MM/YYYY'), 21600.00, 13300.00);
INSERT INTO EMPLOYEE VALUES(7844, 'Kannan', 'Kumar', 'Salesman', 7698, TO_DATE('09/08/1971', 'DD/MM/YYYY'), TO_DATE('29/08/2005', 'DD/MM/YYYY'), 26000.00, 17500.00);
INSERT INTO EMPLOYEE VALUES(7900, 'Sumathi', 'Manian', 'Clerk', 7698, TO_DATE('12/03/1965', 'DD/MM/YYYY'), TO_DATE('22/03/2003', 'DD/MM/YYYY'), 20950.00, NULL);
INSERT INTO EMPLOYEE VALUES(7521, 'Mohanraj', 'Ramkumar', 'Salesman', 7698, TO_DATE('02/02/1974', 'DD/MM/YYYY'), TO_DATE('12/02/2004', 'DD/MM/YYYY'), 21250.00, 15000.00);
INSERT INTO EMPLOYEE VALUES(7902, 'Kumaran', 'Saravanan', 'Analyst Manager', 7566, TO_DATE('12/03/1969', 'DD/MM/YYYY'), TO_DATE('22/03/2008', 'DD/MM/YYYY'), 33000.00, NULL);
INSERT INTO EMPLOYEE VALUES(7369, 'Shuruthi', 'Muthu', 'Clerk', 7902, TO_DATE('12/07/1968', 'DD/MM/YYYY'), TO_DATE('12/07/2008', 'DD/MM/YYYY'), 21800.00, NULL);
INSERT INTO EMPLOYEE VALUES(7788, 'Rajan', 'Nadarajan', 'Analyst Manager', 7566, TO_DATE('12/09/1968', 'DD/MM/YYYY'), TO_DATE('02/09/2005', 'DD/MM/YYYY'), 33000.00, NULL);
INSERT INTO EMPLOYEE VALUES(7876, 'Aravind', 'Ram', 'Clerk', 7788, TO_DATE('07/10/1971', 'DD/MM/YYYY'), TO_DATE('17/03/2004', 'DD/MM/YYYY'), 21100.00, NULL);
INSERT INTO EMPLOYEE VALUES(7934, 'Ganesh', 'Ramanathan', 'Clerk', 7782, TO_DATE('01/03/1975', 'DD/MM/YYYY'), TO_DATE('11/02/2006', 'DD/MM/YYYY'), 21300.00, NULL);
INSERT INTO EMPLOYEE VALUES(9015, 'Annamalai', 'Ganesh', 'Salesman', 7698, TO_DATE('12/12/1975', 'DD/MM/YYYY'), TO_DATE('18/10/2005', 'DD/MM/YYYY'), 22900.00, 14000.00);

----------------------------------SELECT QUERIES--------------------------------
--1
SELECT * FROM EMPLOYEE;
--2
SELECT * FROM EMPLOYEE WHERE salary > 30000 AND extract(year from dob) BETWEEN 1965 AND 1975;
--3
SELECT fname,lname from EMPLOYEE where (sysdate-dob)/365 < 30;
--4
select fname,lname from employee where job in ('Analyst Manager','Manager');
--5
select * from employee where lname like '%an%';
--6
select fname from employee where fname like 'K%' or fname like 'S%';
--7
select fname,lname,job,salary,floor((sysdate-dob)/365) as age from employee where floor((sysdate-dob)/365) = (select max(floor((sysdate-dob)/365)) from employee);
--8
select emp_no,fname,lname,job,salary from employee where salary >= 30000 and job in ('Analyst Manager','Manager');
--9
select emp_no,fname,lname,job,salary from employee where comm >= 4000 and job in ('Salesman','Manager');
--10
select fname,lname,job,salary from employee where job like 'Sales%';
--11
select emp_no,lname,salary from employee where lname in ('Kumar','Manian','Muthu','Ram');
--12
select emp_no,floor((sysdate-dob)/365) as age,lname,salary from employee where floor((sysdate-dob)/365) between 30 and 50;
--13
select * from employee where mgr in (select emp_no from employee where lname in ('Raman','Nadarajan','Saravanan'));
--14
select * from employee where job not in ('Analyst Manager','Manager');
--15
select * from employee where floor((sysdate-dob)/365) = (select min(floor((sysdate-dob)/365)) from employee where comm is not null);
--16
select job,count(*) from employee group by job;
--17
select job,sum(salary) from employee group by job;
--18
select job,sal from (select job,sum(salary)as sal from employee  group by job) where sal>100000;
--19
select e.fname,e.lname,tmp.job,tmp.maxsalary from (select job,max(salary) as maxsalary from employee group by job) tmp,employee e where tmp.job = e.job and tmp.maxsalary = e.salary;
--20
select fname,lname,job,to_char(dob,'MONTH') as birth_month from employee where to_char(dob,'MON') in ('JAN','MAR','AUG'); 
--21
select count(emp_no) from employee group by to_char(dob,'YEAR');
--22
select fname as "Employee Name",lname as "Father Name",job as "Designation" from employee;
--23
select 'Dear '||fname||', you were born on '|| extract(day from dob) || ', ' || to_char(dob,'Day') || '-' || to_char(dob,'Month') || '-' || extract(year from dob) as message from employee;
--24
select fname||lname as Name, salary, comm,case when comm is null then salary else salary + comm end as remuneration from employee;
--25
select fname||lname as Name, salary,case when comm is null then 0 else comm end as commision,case when comm is null then salary else salary + comm end as remuneration from employee;
--26
select fname||', '||job||' earns $'||salary||' with $'||comm||' as commision' as message from employee where comm is not null;
--27
select fname,lname,job,hiredate from employee where (sysdate-hiredate,job) in (select max(sysdate - hiredate),job as maxdays from employee group by job);
--28
select upper(fname)||', '||upper(job)||' EARNS $'||salary||' with $'||comm||' as COMMISSION' as message from employee where comm is not null;
--29
select * from employee where job like '%Manager%' and salary > 40000 and extract(year from dob) <= 1972;
--30
select * from employee where comm is null and salary between 20000 and 35000;
------------------------------------UPDATE QUERIES--------------------------
--31
UPDATE employee set lname = 'Hari' where fname = 'Sumathi';
--32
UPDATE employee set salary = salary * 105 / 100, comm = comm * 105/100 where comm is not null and extract(month from sysdate) = extract(month from dob);
--33
UPDATE employee set job = 'Administrative Assistant' where job = 'Clerk';
--34
UPDATE employee set salary = salary + 3500 where salary < 30000;
--35
UPDATE employee set salary = salary + 4500 where salary > 33500;
--36
UPDATE employee set job = 'Sales Executives' where job = 'Salesman';
--37
DELETE employee where salary > 45000 and job not in ('President','Manager');
--38
DELETE employee where (sysdate-hiredate) = (select min(sysdate-hiredate) from employee);
--39
select * from employee where extract(month from dob) = extract(month from hiredate);
--40
ALTER TABLE employee add age number;
ALTER TABLE employee add constraint chk_valid_age check (age<100);
UPDATE employee set age = floor((sysdate-dob)/365);
--41
select fname,lname,hiredate from employee;
--42
select fname,lname,hiredate from employee where extract(year from hiredate) in (1981,1982);
--43
select fname||' '||lname as "Name", hiredate as "Start Date" from employee;
--44
select fname||' '||lname as "Name", hiredate from employee order by hiredate;
--45
select fname||' '||lname||' working as '||job||' earned commision $'||comm as "Message" from employee where comm is not null order by salary desc;
--46
select job,sum(salary),sum(comm) from employee group by job;
--47
select job,sum(salary) from employee where job in (select job from employee group by job having count(job) >= 4) group by job;


select * from employee;

rollback;
commit;



--1.	Display all columns for everyone in your employee table. 
--2.	Display all columns for everyone with a salary over 3000 and born in between 1965 to 1975. 
--3.	Display first and last names for everyone that's less than 30 years old. 
--4.	Display first name, last name, and salary for anyone with "Analyst Manager" or �Manager� as job title. 
--5.	Display all columns for everyone whose last name contains "an". 
--6.	Display the first name for everyone whose first name starts with �K� or �S�. 
--7.	Display all columns for everyone who is very old.  
--8.	Display the employeeid, firstname, lastname, title, and salary from the employee table where the salary is greater than or equal to 30000.00 and the job title is equal to 'Analyst' or �Manager�.
--9.	Display the employeeid, firstname, lastname, title, and salary from the employee table where the salary with commission is greater than or equal to 40000.00 and the job title is equal to 'Salesman' or �Manager�.
--10.	Display the firstname, lastname, title, and salary from the employee_info table where the title is either equal to 'Sales' OR the title is equal to 'Programmer'.
--11.	Display the employeeid, lastname, salary from the employee table where the lastname is equal to either: �Kumar�, �Manian�, �Muthu�, �Ram�.
--12.	Display the employee id, age, last name, and salary from the employee table where the age is between 30 and 40 (including 30 and 40).
--13.	Find out the entire employees who all are managed by �Raman� or �Saravanan� or �Nadarajan�.
--14.	List out the entire employees who all are not manager and analyst. 
--15.	Find out the employee who is youngest earning commission.
--16.	Display the total number of employees in each job title. Display the result with Job Title and Count.  
--17.	Display the department with total salary with in each job title. 
--18.	Display the department with total salary with in each job which is greater than 1,00,000.
--19.	Display the employees who are all getting maximum salary in each job title. 
--20.	Display the employees with their salary where employees born in either January or March or August. 
--21.	Find out the total number of employees joined in every year. 
--22.	Display all the employees with their fname, lname and job as titled as follows: 
-- 	�Employee Name�, �Father Name�, �Designation�.
--23.  Display all the employees with their dob and doj as follows:
--	Ex. Dear �Robert�, you were born on �11, Monday � September � 1972�.
--	( Also use CAST date function to display the same details)
--24.  Display the name, salary, commission and total remuneration for all the employees.
--25.  Display the name, salary, commission and total remuneration for all the employees and fill 
--       the column with 0 where it contains NULL.
--26.  Concatenate the name, salary, and department number and give the entire results as follows:
--	�Kannan, Salesman earns Rs. 26,000 with Rs. 17,500 as Commission�
--27.  Display all the employees having maximum year�s job experience in each job title.
--28.  Concatenate the name, salary, and department number and give the entire results as follows:
--	�KANNAN, SALESMAN EARNS Rs. 26,000 with Rs. 17,500 as COMMISSION�
--29.  Display all the managers getting salary greater than 40000 and born before 1972.
--30.  Display the entire employees who are not getting any commission but getting salary between 
--       20000 and 35000. 
--After each update, issue a select statement to verify your changes.
--31.  Sumathi just got married to Hari. She has requested that her last name to be updated to 
--       Hari. 
--32.  Update commission in Addison with 5% increased on salary where employees birthday             
--       falls in this current month. 
--33.  All clerks are now called "Administrative Assistant". Update all titles accordingly. 
--34.  Everyone that's making less than Rs. 30000 is to receive a 3500 a year raise. 
--35.  Everyone that's making over 33500 is to receive a 4500 a year raise.
--36.  All "Salesman" titles are now promoted to "Sales Executives". 
--37.  It's time for budget cuts. Remove all employees who are making over 45000 except             
--       President and Manager. 
--38.  Remove employee who is having minimum experience.
--39.  Find all the employees who were born and joined month are same.
--40.  Add new data field called AGE, update it with relevant data for all existing employees.
--41.  Display only the hire date and employee name for each employee.
--42.  Display the names and hire dates of all employees hired in 1981 or 1982
--43.  Display the names and dates of employees with the column headers �Name� and �Start Date�
--44.   Display the names and hire dates of all employees in the order they were hired.
--45.   Display �ename working as job earned commission $� for each salesman in reverse salary   
--        order.
--46.   Display the Job title, total salary payout and total commission payout for each Job category.
--47.   Display the Job title and total salary of employees in each Job title that employs four or 
--        more people.









