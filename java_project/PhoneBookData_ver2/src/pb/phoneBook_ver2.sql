
create table phoneInfo_basic (
    idx number(6),
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address VARCHAR2(20),
    fr_regdate date default sysdate,    
    constraint pb_idx_PK primary key(idx),
    constraint pb_fr_phonenumber_UK unique(fr_phonenumber)
);


create table phoneInfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default 1 not null,
    fr_ref number(6),
    constraint pu_idx_PK primary key(idx),
    constraint pu_fr_u_year_CK check (fr_u_year>0 and fr_u_year<5),
    constraint pu_fr_ref_FK foreign key(fr_ref) REFERENCES phoneInfo_basic(idx) on delete cascade    --외래키로는 부모테이블의 PK만 들어갈 수 있음.
);

create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6),
    constraint pc_idx_PK primary key(idx),
    constraint pc_fr_ref_FK foreign key(fr_ref) REFERENCES phoneInfo_basic(idx) on delete cascade
    
);


--------------------------------------------------------------------
--SEQUENCE 생성
--------------------------------------------------------------------
--1.basic 테이블 seq
create sequence pb_idx_seq
start with 0
minvalue 0
;

--2.com 테이블 seq
create sequence pc_idx_seq
start with 0
minvalue 0
;

--3.univ 테이블 seq
create sequence pu_idx_seq
start with 0
minvalue 0
;
