-- member table
create table member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null,
	unique key(id)
)

--SQL(CRUD), JDBC

-- insert (����)
insert into member(id, pass,name, age, email,phone) 
values('admin','ad,in','������',40,'navercorp@naver.com','010-1111-1111');

-- �˻�
select * from member;

--update(����)
update member set age=45, phone='010-1111-0000' where id='admin';

--����
delete from member where id='admin'