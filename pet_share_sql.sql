drop table diary;

create table diary(
no number(5) primary key,
title varchar2(200) not null,
writer varchar2(100) not null,
content varchar2(2000) not null,
write_date date default sysdate 
);

drop sequence seq_diary;

create sequence seq_diary start with 1 increment by 1;

insert into diary(no, title, writer, content) values (seq_diary.nextval, '다이어트 시작!', '뚱땡이', 
'너무 살이 쪄서 다이어트를 하기 시작했다. 과연 성공 할 수 있을까?'); 
insert into diary(no, title, writer, content)
values(seq_diary.nextval, '다이어트 진행 즁', '뚱땡이', '요즘 매일 저녁에 샐러드와 버팔로 윙을 먹고 있다.
빨리 다이어트를 성공해서 편하게 매콤차슈씨를 먹고싶다.');
insert into diary(no, title, writer, content)
values(seq_diary.nextval, '다이어트 실패...', '뚱땡이', '자꾸 경민님과 기승님이 맛있는 걸 먹자고 해서 오늘은 치킨에 맥주까지 질러버렸다...
다이어트는 성공하지 못할 것 같다...');

commit

select * from diary;