--2020.05.19.

--특정 데이터를 추출하기 : where절을 이용
--select 컬럼명 from 테이블이름 where 조건(true/false);

--전체 사원 중에 월급여가 3000이상인 사원의 리스트 출력
select ename, job, sal
from emp
where sal >= 3000
;

--전체 사원 중 10번 부서의 소속 사원 이름과 직급
select ename, job
from emp
where deptno = 10
;


--컬럼의 값과 일치 여부 확인 : =
select *
from emp
where deptno=10
;
--문자열 표현 : '' 작은 따옴표로 묶는다.
select *
from emp
where job='MANAGER'
;

select *
from emp
where ename='SCOTT'
;

select *
from emp
where hiredate='80-12-17' --날짜를 비교할 때 -> '' 작은 따옴표 이용
;

--논리연산자 : and
--10번 부서 소속인 사원들 '중에서' => AND
--직급이 manager인 사람을 검색하여
--사원명, 부서번호, 직급을 출력

--조건 1 : 10번 부서 소속 -> deptno=10
--조건 2 : job='MANAGER'

select ename, deptno, job
from emp
where deptno=10 and job='MANAGER'
;

--논리연산자 : or
--10번 부서에 소속된 사원'이거나' => OR
--직급이 MANAGER인 사람을 검색하여
--사원명, 부서번호, 직급을 출력

--조건 1 : 10번 부서 소속 -> deptno=10
--조건 2 : job='MANAGER'

select ename, deptno, job
from emp
where deptno=10 or job='MANAGER'
;

--논리연산자 : not
--부서번호가 10번이 아닌 사원의 
--사원이름, 부서번호, 직급을 출력

select ename, deptno, job
from emp
-- where deptno != 10 
--where deptno <> 10 
where not deptno = 10 
;

--범위 연산 : 논리연산의 사용 and
--2000에서 3000 사이의 급여를 받는 사원의 정보를 출력
select *
from emp
where sal>=2000 and sal<=3000
;

-- 범위연산자 사용 : where 컬럼명 between A and B -> A 이상 B 이하
--2000에서 3000 사이의 급여를 받는 사원의 정보를 출력
select *
from emp
where sal between 2000 and 3000
;

--2000 초과 3000 미만의 급여를 받는 사원 출력
--sal>2000 and sal<3000
--between sal 2001 and 2999
select *
from emp
where sal>2000 and sal<3000
;

-- 1987년 입사자 리스트를 출력
select *
from emp
--where hiredate>='1987-01-01' -- 1987년 이후
--where hiredate >= '1981-01-01' and hiredate<='1981-12-31' --1981년 입사자
--where hiredate between '1981-01-01' and '1981-12-31'
where hiredate not between '1981-01-01' and '1981-12-31'
;

-- or 연산을 간소화시키는 IN 연산자
-- 컬럼이름 IN (데이터1, 데이터2, 데이터3, ...) => 데이터에는 서브쿼리로 다른 테이블의 데이터가 들어가기도 함
-- 컬럼=데이터1 or 컬럼=데이터2 or 컬럼=데이터3 ...

--커미션이 300 이거나 500 이거나 1400 인 사원
select *
from emp
--where comm=300 or comm=500 or comm=1400
--where comm in (300,500,1400)
where comm not in (300,500,1400) --null값은 true인지 false인지 알 수 없음
;


-- 패턴검색 : like 연산자
-- 컬럼이름 like 패턴
-- 패턴 : % , _
-- % -> 0개 이상의 문자열이 가능하다
-- 'S%' : S로 시작하는 문자열
-- '%S' : S로 끝나는 문자열
-- '%S%' : S를 포함하는 문자열
-- '%노트북%'

--이름이 S로 시작 하는 사원의 리스트
select *
from emp
--where ename like 'S%'
--where ename like '%IN'
where ename like '%AR%'
;

-- _ -> 1개의 자릿수에 어떠한 문자가 와도 가능하다
select *
from emp
--where ename like '_A%'
--where ename like '__A%'
--where ename like '%E_'
where ename not like '%A%'
;

--null값 확인을 위한 연산자 : is null, is not null
--컬럼명 is null : 해당 컬럼의 값이 null인 경우 true
--컬럼명 is not null : 해당 컬럼의 값이 null이 아닌 경우 true
select ename, comm
from emp
--where comm is null
where comm is not null
;

-- row의 정렬 
-- 오름차순 : asc (기본값이므로 생략 가능)
-- 내림차순 : desc (명시적 사용)
select ename, sal, hiredate, comm
from emp
--where empno>0
--order by ename -- 문자의 오름차순, asc 생략
--order by ename desc -- 문자의 내림차순
--order by sal -- 숫자의 오름차순
--order by sal desc --숫자의 내림차순
--order by hiredate asc --날짜의 오름차순
--order by hiredate desc --날짜의 내림차순
--order by comm --null값의 오름차순 확인
order by comm desc --null값의 내림차순
;


select ename, sal
from emp
where hiredate between '1981-01-01' and '1981-12-31'
order by sal desc, ename asc
;

select ename, deptno
from emp
order by deptno, ename
;

select *
from tab;

desc book;
desc customer;
desc orders;

select * from book;
select * from customer;
select * from orders;

select * from dept;