--create table hs3_dept(
--  deptno number(2,0),
--  dname  varchar2(14),
--  loc    varchar2(13),
--  constraint pk_dept primary key (deptno),
--  dmgrid number(4)
--);

--create table hs3_emp(
--  empno    number(4,0),
--  ename    varchar2(10),
--  job      varchar2(9),
--  mgr      number(4,0),
--  hiredate date,
--  sal      number(7,2),
--  comm     number(7,2),
--  deptno   number(2,0),
--  constraint pk_hs3_emp primary key (empno),
--  constraint fk_hs3_deptno foreign key (deptno) references hs3_dept (deptno)
--);

--INSERT INTO hs3_dept (deptno, dname, loc, dmgrid) VALUES (10, 'ACCOUNTING', 'NEW YORK', 7782);
--INSERT INTO hs3_dept (deptno, dname, loc, dmgrid) VALUES (20, 'RESEARCH', 'DALLAS', 7566);
--INSERT INTO hs3_dept (deptno, dname, loc, dmgrid) VALUES (30, 'SALES', 'CHICAGO', 7698);
--INSERT INTO hs3_dept (deptno, dname, loc, dmgrid) VALUES (40, 'OPERATIONS', 'BOSTON', 7782);


--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17', 'YYYY-MM-DD'), 5000, NULL, 10);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566, 'JONES', 'MANAGER', 7839, TO_DATE('1981-04-02', 'YYYY-MM-DD'), 2975, NULL, 20);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698, 'BLAKE', 'MANAGER', 7839, TO_DATE('1981-05-01', 'YYYY-MM-DD'), 2850, NULL, 30);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782, 'CLARK', 'MANAGER', 7839, TO_DATE('1981-06-09', 'YYYY-MM-DD'), 2450, NULL, 10);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788, 'SCOTT', 'ANALYST', 7566, TO_DATE('1982-12-09', 'YYYY-MM-DD'), 3000, NULL, 20);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7902, 'FORD', 'ANALYST', 7566, TO_DATE('1981-12-09', 'YYYY-MM-DD'), 3000, NULL, 20);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7844, 'TURNER', 'SALESMAN', 7698, TO_DATE('1981-09-08', 'YYYY-MM-DD'), 1500, 0.00, 30);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499, 'ALLEN', 'SALESMAN', 7698, TO_DATE('1981-02-20', 'YYYY-MM-DD'), 1600, 300.00, 30);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7521, 'WARD', 'SALESMAN', 7698, TO_DATE('1981-02-22', 'YYYY-MM-DD'), 1250, 500.00, 30);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7654, 'MARTIN', 'SALESMAN', 7698, TO_DATE('1981-09-28', 'YYYY-MM-DD'), 1250, 1400.00, 30);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7934, 'MILLER', 'CLERK', 7782, TO_DATE('1982-01-23', 'YYYY-MM-DD'), 1300, NULL, 10);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7876, 'ADAMS', 'CLERK', 7788, TO_DATE('1983-01-12', 'YYYY-MM-DD'), 1100, NULL, 20);
--INSERT INTO hs3_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7900, 'JAMES', 'CLERK', 7698, TO_DATE('1981-12-03', 'YYYY-MM-DD'), 950, NULL, 30);

-- 1 Retrieve a list of MANAGERS.
select * from hs3_emp where job='MANAGER';
-- 2 Find out salary of both MILLER and SMITH.
select ename,sal from hs3_emp where ename='MILLER' or ename='SMITH';
-- 3 Find out the names and salaries of all employees earning more than 1000 per month.
select ename,sal from hs3_emp where sal > 1000;
-- 4 Display the names and salaries of all employees except JAMES.
select * from hs3_emp where ename!='JAMES';
-- 5 Find out the details of employees whose names begin with ‘S’
select * from hs3_emp where ename like 'S%';
-- 6 Find out the names of all employees that have ‘A’ anywhere in their name.
select * from hs3_emp where ename like '%A%';
-- 7 Find out the names of all employees that have ‘L’ as their third character in their name.
select * from hs3_emp where ename like '__L%';
-- 8 Find out the names of the employees whose name begin with ‘A’ or ‘M’.
select * from hs3_emp where ename like 'A%' or ename like 'M%';
-- 9 Compute yearly salary of SMITH.
select ename,case when comm is not null then (sal*12)+comm else (sal*12) end "YEARLY SALARY" from hs3_emp where ename='SMITH';
-- 10. Compute daily salary of JONES.
select ename,floor(sal/30) as "Daily Salary" from hs3_emp where ename='JONES';
-- 11. Calculate the total monthly salary of all employees.
select sum(sal) as "TOTAL SALARY OF ALL EMPLOYEES" from hs3_emp;
-- 12 Print the average annual salary
select avg(sal*12) as "yearly avg sal of all emp" from hs3_emp;
-- 13.Select the name, job, salary, department number of all employees except SALESMAN from department number 30
select ename,job,sal,deptno from hs3_emp where job!='SALESMAN' and deptno!=30;
-- 14. List unique departments of the EMP table
select * from hs3_dept where deptno in (select deptno from hs3_emp);
-- 15. List the name and salary of employees who can earn more than 1500 and are in department 10 or 30. Label the columns Employee and Monthly Salary respectively.
select ename as "Employee",sal as "Monthly Salary"  from hs3_emp where deptno in (10,30) and sal>1500;
-- 16. List the name and salary for all employees whose salary is not in the range of 1500 and 2850.
select * from hs3_emp where sal not between 1500 and 2850;
-- 17. Display the name and job of all employees who do not have a MANAGER.
select ename,job from hs3_emp where mgr is null;
-- 18. Display the name, job, and salary of all the employees whose job is MANAGER or ANALYST and their salary is not equal to 1000, 3000, or 5000
select ename,job,sal from hs3_emp where job in ('MANAGER','ANALYST') and sal not in (1000,3000,5000);
-- 19. Display the name, salary and commission for all employees whose commission amount is greater than their salary increased by 10%.
select ename,sal,comm from hs3_emp where comm>(sal*110/100);
-- 20. Display the name of all employees who have two Ls in their name and are in department 30 or their manager is 7782
select ename from hs3_emp where ename like '%L%L%' and (deptno=30 or mgr=7782);
-- 21. Retrieve the names of departments in ascending order and their employees in descending order.
select * from hs3_emp e,hs3_dept d where e.deptno = d.deptno order by d.dname,e.ename;
-- 22.Display the names of employees with experience of over 10 years or under 0. Count the total number of employees.
select * from hs3_emp where floor((sysdate-hiredate)/365) = 0 or floor((sysdate-hiredate)/365) > 10;
-- 23. Find out experience of MILLER.
select ename,floor((sysdate-hiredate)/365) as experience from hs3_emp where ename = 'MILLER';
-- 24. How many different departments are there in the employee table.
SELECT COUNT(DISTINCT deptno) AS "Number of Departments" FROM hs3_emp;
-- 25. Find out which employee either work in SALES or RESEARCH department.
select * from hs3_emp where deptno in (SELECT deptno from hs3_dept where dname in ('SALES','RESEARCH'));
-- 26. Print the name and average salary of each department.
select d.dname,round(avg(e.sal),2) from hs3_emp e,hs3_dept d where e.deptno = d.deptno group by d.dname;
-- 27. Select the minimum and maximum salary from employee table.
select min(sal) as "Minimum Salary",max(sal) as "Maximum Salary" from hs3_emp;
-- 28. Select the minimum and maximum salaries from each department in employee table.
select deptno,min(sal) as "Minimum Salary",max(sal) as "Maximum Salary" from hs3_emp group by deptno;
-- 29. Select the details of employees whose salary is below 1000 and job is CLERK.
select * from hs3_emp where sal<1000 and job = 'CLERK';
-- 30. Select the employees from each dept whose salary is above the average salary of their corresponding depts.
select * from hs3_emp e,(select deptno,round(avg(sal),2) as sal from hs3_emp group by deptno) t where e.sal > t.sal and e.deptno = t.deptno;




select * from hs3_emp;



