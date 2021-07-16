create table ManagerInfo(
	id int(10) primary key auto_increment,
	managername varchar(32) not null unique,
	password varchar(32) not null,
	email VARCHAR(32) not null
);

CREATE TABLE employees (
    emp_no      INT             NOT NULL auto_increment,
    birth_date  DATE            NOT NULL,
    name   			VARCHAR(16)     NOT NULL,
    gender      ENUM ('M','F')  NOT NULL,    
    hire_date   DATE            NOT NULL,
    PRIMARY KEY (emp_no)
);