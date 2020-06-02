
drop table phoneinfoall;


create table phoneInfoAll (
    idx number(6),
    type varchar2(10) not null,
    name varchar2(20) not null,
    phonenumber varchar2(20) not null,
    email varchar2(20),
    address VARCHAR2(20),
    
    major varchar2(20),
    grade varchar2(20),
    
    dept varchar2(20),
    job varchar2(20),
      
    constraint pba_idx_PK primary key(idx),
    constraint pba_type_CK check (type in ('UNIV','COM'))
);

create sequence pba_idx_seq
start with 0
minvalue 0
;


select * from phoneinfoall;
select * from phoneInfoAll where name like '%홍%';

delete from phoneinfoall where name='