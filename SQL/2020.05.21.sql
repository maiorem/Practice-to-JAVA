--2020.05.21.
--조인

select * from emp;
select * from dept;

--cross join
select * from emp, dept;

--equi join
select ename, dname, dept.deptno
from emp, dept 
where emp.deptno=dept.deptno
;

--book, customer, orders
--cross join
select * from book;
select * from orders;
select * from customer;
select * from orders o, book b, customer c;

--equi join
select * from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
;

--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) 
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid 
and c.name='박지성'
;

--non-equi join
select * from salgrade;

select e.ename, e.sal, s.grade
from emp e, salgrade s
where sal between losal and hisal
and grade>3
;

--self join
--관리자의 이름을 알아보자.
select e.empno, e.ename, e.mgr, m.ename as mgrName 
from emp e, emp m
where e.mgr=m.empno;

select e.ename || '의 상사는 ' || m.ename ||'입니다.'
from emp e, emp m
where e.mgr=m.empno
;

--outer join
select e.ename || '의 상사는 ' || m.ename ||'입니다.'
from emp e, emp m
where e.mgr=m.empno(+)
;

select e.empno, e.ename, e.sal, e.comm, nvl(m.ename, '----') as "관리자" 
from emp e, emp m
where e.mgr=m.empno(+)
;

--ANSI join : oracle 이외의 데이터베이스 프로그램에서도 사용할 수 있는 표준 SQL
select * from emp cross join dept; --cross join

--inner join ~ on
select ename, dname
from emp e inner join dept d
on e.deptno=d.deptno
; 

--using (공통컬럼)
select ename, dname
from emp join dept
using (deptno)
;

--natural join
select ename, dname
from emp natural join dept
;

--outer join
select e.empno, e.ename, e.sal, e.comm, nvl(m.ename, '----') as "관리자" 
from emp e left outer join emp m
on e.mgr=m.empno
;