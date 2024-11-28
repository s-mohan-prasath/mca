CREATE TABLE HS4_EMP(
    Empcode varchar(5),
    Empname varchar(15),
    Address varchar(25),
    Age number(2),
    Dept_code varchar(5),
    constraint pk_emp_id PRIMARY KEY (Empcode),
    constraint chk_age_range CHECK (Age>=0 and Age<=100)
);
CREATE TABLE HS4_PAYSLIP(
    Empcode varchar(5),
    Basic NUMBER,
    HRA NUMBER,
    DA NUMBER,
    CONSTRAINT fk_emp_payslip FOREIGN KEY (Empcode) references HS4_EMP(Empcode)
);
CREATE TABLE HS4_DEPT(
    dept_code varchar(5),
    Deptname varchar(15),
    constraint pk_dept_id PRIMARY KEY (dept_code)
);

-- INSERT DATA INTO THE TABLES

--INSERT INTO hs4_emp VALUES 
--('E101', 'Anjaly', 'Anjaly Nivas, Thiruvalla', 25, 'D301'),
--('E102', 'Bobby', 'Alapuzha', 28, 'D305'),
--('E103', 'Aravind', 'Chennai', 31, 'D305'),
--('E104', 'Lakshmi', 'Mannar', 55, 'D707'),
--('E105', 'Daisy', 'Chaithram, Angamaly', 35, 'D707'),
--('E106', 'Esha', 'Mumbai', 23, 'D707'),
--('E107', 'Georgy', 'Pala', 45, 'D909'),
--('E108', 'Prakash', 'Vennikulam', 36, 'D110'),
--('E109', 'Madhavan', 'Mynakum, Kottayam', 46, 'D202'),
--('E110', 'Anugraha', 'Aparna, Angamaly', 47, 'D301'),
--('E111', 'Deva', 'Trichy', 38, 'D301'),
--('E112', 'Saju', 'Dhanya, Ernakulam', 27, 'D202'),
--('E113', 'Priyesh', 'Priya Nivas, Kottayam', 26, 'D302');

--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E101', 4000, 1900, 1500);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E102', 4500, 2200, 2000);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E103', 5000, 2800, 2200);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E104', 7000, 3000, 2700);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E105', 3000, 1500, 1200);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E106', 5700, 3000, 2900);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E107', 6200, 3300, 3000);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E108', 5700, 3700, 3000);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E109', 7500, 4660, 545);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E110', 5000, 300, 100);
--INSERT INTO hs4_payslip (Empcode, Basic, HRA, DA) VALUES ('E111', 6000, 200, 120);

--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D301', 'Sales');
--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D302', 'Account');
--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D707', 'Research');
--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D909', 'Advertising');
--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D202', 'Stock');
--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D110', 'Computer');
--INSERT INTO hs4_dept (dept_code, DEPTNAME) VALUES ('D305', 'Marketing');


-- 1 Update table EMPLY, add 15 years of age to employee with EMPCODE 'E107'.
UPDATE hs4_emp set age = age+15 where empcode = 'E107';
-- 2 Create a view which shows details of employees whose age is between 35 and 45.
CREATE VIEW vu_emp_age_35_to_45 as SELECT * from hs4_emp where age between 35 and 45;
-- 3 Retrieve empcode, empname, address, Netpay from EMPLY and PAYSLIP. Display in ascending order of empcode.
SELECT emp.empcode,emp.empname,emp.address,(sal.basic+sal.hra+sal.da) as salary from hs4_emp emp,hs4_payslip sal WHERE emp.empcode = sal.empcode;
-- 4 Create an English like sentence to display the following output from payslip table. "Employees with empcode E101 draws a basic salary 4000".
SELECT 'Employees with empcode '||emp.empcode||' draws a basic salary '||(sal.basic+sal.hra+sal.da) as message from hs4_emp emp,hs4_payslip sal WHERE emp.empcode = sal.empcode;
-- 5 List the names and address of employees drawing a basic salary between 5000 and 7000.
SELECT emp.empname,emp.address from hs4_emp emp,hs4_payslip sal WHERE emp.empcode = sal.empcode and (sal.basic+sal.hra+sal.da) between 5000 and 7000;
-- 6 Add new column Total_Sal in the PAYSLIP table and display all details including total salary for Employees with Empcode > E107.
ALTER TABLE hs4_payslip ADD Total_Sal number;
UPDATE hs4_payslip set total_sal = (basic+hra+da);
-- 7 Display records from EMPY1 table for employees whose age is between 25 and 45.
SELECT * from hs4_emp where age between 25 and 45;
-- 8 Retrieve the dept_code and total no of employees in each department.
select dept_code,count(empcode) from hs4_emp group by dept_code;
-- 9 Retrieve empcode, empname, address, dept_code for all employees in "account" and "stock" departments.
select empcode,empname,address,dept_code from hs4_emp where dept_code in (select dept_code from hs4_dept where deptname in ('Account','Stock'));
-- 10 Display average, maximum and minimum age of employees.
select floor(avg(age)) as "Average Age",max(age) as "Maximum Age",min(age) as "Minimum Age" from hs4_emp;
-- 11 Delete all records belonging to research department in the EMPY1 table.
DELETE hs4_emp where dept_code in (select dept_code from hs4_dept where deptname='Research');
-- 12 List details of employee with empcode 'E105'.
select * from hs4_emp where empcode = 'E105';
-- 13 Count the number of employees whose age is less than 45.
select count(*) from hs4_emp where age<45;
-- 14 Compute NET SALARY (Netsal = Basic + HRA +DA) for employees in the Payslip table.
select (basic+hra+da) as "Net Salary" from hs4_payslip;
-- 15 Give the employee with empcode 'E110' a bonus of 15% of Basic and update the value held in column Netsal.
UPDATE hs4_payslip set basic = floor((basic)*115/100), TOTAL_SAL = floor((basic)*115/100)+hra+da where empcode='E110';
--16 Display Name, Address, Empcode, Net salary, & age from EMPLY and PAYSLIP tables respectively.
SELECT e.empname,e.address,e.empcode,e.age,s.TOTAL_SAL FROM hs4_emp e,hs4_payslip s;
-- 17 Retrieve all information from EMPLY table for employees whose Basic Salary is more than 6000.
select * from hs4_emp emp, hs4_payslip sal where emp.empcode = sal.empcode and sal.basic > 6000;


select * from hs4_emp;
select address from vu_emp_age_35_to_45;

rollback;
commit;




