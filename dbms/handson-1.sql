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






