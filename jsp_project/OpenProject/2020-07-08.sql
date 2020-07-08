-- 방명록 테이블

create table guestbook_message(
    message_id number(4) not null primary key,
    guest_name varchar2(50) not null,
    password varchar2(10) not null,
    message varchar2(2000) not null
);

create sequence message_id_seq increment by 1 start with 1;

insert into guestbook_message values (message_id_seq.nextVal, '테스터', '1111', '테스트 글쓰기');

select * from guestbook_message;

ROLLBACK;


create table memberInfo(
    member_idx number(4) not null primary key,
    member_id varchar(20) not null,
    member_pw varchar(50) not null,
    member_name varchar2(50) not null,
    member_photo varchar2(50)
);

create sequence memberInfo_idx_seq increment by 1 start with 1;