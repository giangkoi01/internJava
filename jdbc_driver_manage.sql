create table driver(
	id number primary key,
	name nvarchar2(30) not null,
	address nvarchar2(50) not null,
	phoneNumber nvarchar2(10) not null,
	driver_level nvarchar2(10) not null
);
create table router(
	id number primary key,
	distance number not null,
	stop_point number not null
);

create table assignment(
	driver_id number not null,
	router_id number not null,
	turn_number number not null,
	constraint assignment_PK primary key (driver_id, router_id)
);

SELECT
    *
FROM driver