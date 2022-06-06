create user 'ar5y-kn'@'%' identified by 'bitc5600';
grant all privileges on *.* to 'ar5y-kn'@'%';
create database percussion;
use percussion;

create table testDomain (
	testNo int primary key auto_increment,
    testStr varchar(100)
);

insert into testDomain (
    testStr
) values (
	'testSuccess'
);