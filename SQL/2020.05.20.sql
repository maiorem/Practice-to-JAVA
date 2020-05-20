--2020.05.20. 함수
-- 단일함수
-- 숫자 함수

select mod(10,2)
from dual
;

select abs(comm)
from emp
;

select trunc(sal, -2)
from emp
;

select round(3.141592, 3)
from dual
;

--날짜 함수
select sysdate
from dual
;

select months_between(sysdate, hiredate)
from emp
;


--변환함수
--To_CHAR : 포맷팅 목적. 원하는 형식으로 보여주기 위해서.
--date -> varchar2
select sysdate, to_char(sysdate, 'YYYY.MM.DD.')
from dual;

select ename, to_char(hiredate, 'YYYY.MM.DD.DY') as hiredate
from emp;

select to_char(sysdate, 'YYYY.MM.DD. HH24:Mi') as 현재 from dual;

select ename, to_char(hiredate, 'YYYY.MM.DD. HH24:Mi')
from emp;

select to_char(1230000, '99,999,999')
from dual;

--to_char
--number -> varchar2
select to_char(12500, '999,999.9')
from dual;


select to_char(12500, '0,000') -- > 원본 데이터 자릿수가 더 커서 표현되지 않음
from dual;

select to_char(12500, 'L999,999')
from dual;

select to_char(3.1415, '000,000.000')
from dual;

select to_char(3.1415, '999,999.999')
from dual;

select ename, to_char(sal*1300, 'L999,999,999') as 월급, to_char(sal*1300*12+nvl(comm,0), 'L999,999,999') as 연봉
from emp
order by 연봉
;

--to_date
--to_date(원본, 패턴)
--str -> date
select to_date('19810220', 'YYYYMMDD')
from dual
;
select to_date('1981/02/20', 'YYYY/MM/DD')
from dual
;

select ename, hiredate
from emp
where hiredate=TO_DATE('1981/02/20', 'YYYY/MM/DD')
;

select sysdate, to_date('2020.12.25', 'YYYY.MM.DD.') as CristMas,
trunc(to_date('20201225' , 'YYYYMMDD')-sysdate) as remainday
from dual
;

select sysdate, trunc(sysdate-to_date('19871012', 'YYYYMMDD')) as DAYS
from dual
;


--to_number
--to_number(원본, '패턴')
--str -> number : 산술, 관계연산을 목적으로
select to_number('20,000', '9,999,999')
from dual;

select to_number('20,000','999,999')-to_number('10,000', '99,999')
from dual
;


--DECODE 함수 : if/switch 구문과 유사
select ename, deptno, 
decode(deptno,
            10, 'ACCOUNTING',
            20, 'RESEARCH',
            30, 'SALES',
            40, 'OPERATIONS')
as dname
from emp
;

select empno, ename, job, sal,
decode(job, 'ANALYST', sal+sal*0.05,
            'SALESMAN', sal+sal*0.1,
            'MANAGER', sal+sal*0.15,
            'CLERK', sal+sal*0.2,
            'PRESIDENT', sal)
as upsal
from emp
order by job
;

select ename, deptno,
case
    when deptno=10 then 'ACCOUNTING'
    WHEN DEPTNO=20 THEN 'RESEARCH'
    WHEN DEPTNO=30 THEN 'SALES'
    WHEN DEPTNO=40 THEN 'OPERATIONS'
    else 'no name'
end AS DNAME   
from emp
;
---------------------------------------------
--그룹함수(집합함수)

--sum, avg, count, max, min

--sum(컬림이름) : 해당 컬럼의 데이터들의 합 반환
--매월 지급되는 급여의 총합
select to_char(sum(sal*1300), 'L999,999,999') from emp;

select sum(comm) --null은 집합함수에서 연산의 대상이 되지 않는다.
from emp;


--avg(컬럼명) : 해당 컬럼의 데이터들의 평균값을 반환
select trunc(avg(sal)) from emp;

select avg(comm) from emp; --null이 포함된 데이터는 무시한다
select 2200/4 from dual; 





--소속부서별
--평균급여구하기
select deptno, round(avg(sal), 0)
from emp
group by deptno;

--최대급여와 최소급여 구하기
select deptno, max(sal), min(sal)
from emp
group by deptno;

--사원의 수와 커미션을 받는 사원의 수
select deptno, count(*), count(comm)
from emp
--where comm <> 0 : 이게 기준이 됨...
group by deptno;


--부서별 
--평균 급여가 2000 이상인(HAVING) 
--부서번호와 부서별 평균 급여를 출력
select deptno, round(avg(sal),0), count(*), count(comm), sum(comm)
from emp
group by deptno
having avg(sal) <=2000;

--직급별 지표 출력
select job, count(*) as "직급별 인원",
            sum(sal) as "직급별 월급 총액",
            trunc(avg(sal)) as "직급별 평균급여",
            nvl(sum(comm),0) as "직급별 수령 커미션 총액",
            max(sal) as "직급별 최고 수령액"
from emp
group by job
--having count(job)>=2 --인원이 2명 이상인 직급
having avg(sal)>=2000 and count(*)>1 --평균 급여가 2000이상인 직급
;

select deptno, job
from emp
group by deptno, job
order by job
;