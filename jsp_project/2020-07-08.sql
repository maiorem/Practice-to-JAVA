-- 방명록 테이블

create table guestbook_message(
    message_id number(4) not null primary key,
    guest_name varchar2(50) not null,
    password varchar2(10) not null,
    message varchar2(2000) not null
);

create sequence message_id_seq increment by 1 start with 1;

insert into guestbook_message values (message_id_seq.nextVal, '테스터10', '1111', '테스트 글쓰기');

delete from guestbook_message;

select rownum, message_id, guest_name, password, message
from (select * from guestbook_message order by message_id desc);

--2페이지 : 4~6

select rownum rnum, message_id, guest_name, password, message
from (select * from guestbook_message order by guestbook_message.message_id desc)
where rownum<=6;

select message_id, guest_name, password, message
from (
    select rownum rnum, message_id, guest_name, password, message
    from (
        select * from guestbook_message order by guestbook_message.message_id desc
        ) where rownum<=6
)
where rnum >= 4
;




select rownum, message_id, message 
from (select * from guestbook_message order by message_id);

commit;

ROLLBACK;


select * from guestbook_message where message_id=40;



--op 데이터 베이스

create table op_guestbook_message(
    message_id number(4) not null primary key,
    guest_name varchar2(50) not null,
    password varchar2(10) not null,
    message varchar2(2000) not null
);

select * from op_guestbook_message;

create sequence op_mid_seq increment by 1 start with 1;


select message_id, guest_name, password, message
from (
    select rownum rnum, message_id, guest_name, password, message
    from (
        select * from op_guestbook_message order by op_guestbook_message.message_id desc
        ) where rownum<=6
)
where rnum >= 4
;



--op 회원 데이터

drop table memberInfo;

create table memberInfo(
    member_idx number(4) not null primary key,
    member_id varchar(20) not null,
    member_pw varchar(50) not null,
    member_name varchar2(50) not null,
    member_photo varchar2(200)
);

create sequence memberInfo_idx_seq increment by 1 start with 1;

select * from memberInfo;

select * from memberInfo where member_id='tttt';

--op 회원게시판