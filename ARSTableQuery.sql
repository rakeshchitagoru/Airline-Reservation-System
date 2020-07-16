------------------------------Users Table--------------------------------------------------

CREATE TABLE USERS(username varchar2(20), password varchar2(20),role varchar2(10),mobile_no varchar2(10));

--------------------------------Flight------------------------------------------------------------

CREATE TABLE flight(flight_no NUMBER(5) PRIMARY KEY,airline VARCHAR2(10),source VARCHAR2(10),destination VARCHAR2(10),
arr_date DATE, dep_date DATE,arr_time TIMESTAMP,dep_time TIMESTAMP,
first_seats NUMBER(5),first_seats_left NUMBER(5),first_seats_fare NUMBER(5),
buss_seats NUMBER(5),buss_seats_left NUMBER(5),buss_seats_fare NUMBER(5));

-----------------------------BookingInformation----------------------------------------

CREATE TABLE bookinginformation(booking_id NUMBER(10) PRIMARY KEY,flight_number NUMBER(10),username VARCHAR2(20),
cust_email VARCHAR2(20),no_of_passengers VARCHAR2(20),class_type VARCHAR2(20),total_fare NUMBER(10),
seat_number_start NUMBER(10),seat_number_end NUMBER(10),creditcard_info VARCHAR2(16),src_city VARCHAR2(10),dest_city VARCHAR2(10));

----------------------------------Flight Insertion------------------------------------------------------
INSERT INTO flight VALUES(10001,'Airlines','Delhi','Chennai','13-oct-2017','12-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('20:14:00', 'HH24:MI:SS'),50,50,2000,50,50,8000);

INSERT INTO flight VALUES(10002,'Airines','Delhi','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('13:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),50,50,1500,50,50,6000);

INSERT INTO flight VALUES(10003,'Jetways','Delhi','Pune','13-oct-2017','12-oct-2017',TO_TIMESTAMP('12:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,1000,50,50,5000);

INSERT INTO flight VALUES(10004,'Kingfisher','Delhi','Mumbai','13-oct-2017','13-oct-2017',TO_TIMESTAMP('10:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),50,50,9500,50,50,12000);

INSERT INTO flight VALUES(10005,'Kingfisher','Delhi','Chennai','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:14:00', 'HH24:MI:SS'),60,60,1500,60,60,7000);

INSERT INTO flight VALUES(10006,'Jetays','Delhi','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('15:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),50,50,1200,50,50,4500);

INSERT INTO flight VALUES(10007,'Kingfisher','Delhi','Pune','13-oct-2017','12-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('20:14:00', 'HH24:MI:SS'),75,75,2000,25,25,6500);

INSERT INTO flight VALUES(10008,'Airlines','Delhi','Mumbai','13-oct-2017','13-oct-2017',TO_TIMESTAMP('12:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),60,60,8500,50,50,12500);

INSERT INTO flight VALUES(10009,'Kingfisher','Delhi','Kolkatta','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:14:00', 'HH24:MI:SS'),50,50,5000,50,50,11500);

INSERT INTO flight VALUES(10010,'Jetways','Delhi','Kolkatta','13-oct-2017','12-oct-2017',TO_TIMESTAMP('10:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('04:14:00', 'HH24:MI:SS'),65,65,6000,35,35,12500);

INSERT INTO flight VALUES(20001,'Airlines','Kolkatta','Chennai','14-oct-2017','13-oct-2017',TO_TIMESTAMP('04:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('20:14:00', 'HH24:MI:SS'),50,50,1500,50,50,7000);

INSERT INTO flight VALUES(20002,'Airines','Kolkatta','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('10:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),50,50,1200,50,50,6000);

INSERT INTO flight VALUES(20003,'Jetways','Kolkatta','Pune','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:00:00', 'HH24:MI:SS'),50,50,1000,50,50,4000);

INSERT INTO flight VALUES(20004,'Kingfisher','Kolkatta','Mumbai','13-oct-2017','13-oct-2017',TO_TIMESTAMP('16:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('12:14:00', 'HH24:MI:SS'),50,50,4000,50,50,8000);

INSERT INTO flight VALUES(20005,'Kingfisher','Kolkatta','Delhi','13-oct-2017','12-oct-2017',TO_TIMESTAMP('05:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:14:00', 'HH24:MI:SS'),60,60,2000,60,60,6500);

INSERT INTO flight VALUES(20006,'Jetways','Kolkatta','Chennai','13-oct-2017','13-oct-2017',TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('16:14:00', 'HH24:MI:SS'),50,50,1200,50,50,6000);

INSERT INTO flight VALUES(20007,'SpiceJet','Kolkatta','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('18:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('14:14:00', 'HH24:MI:SS'),50,50,1100,50,50,5500);

INSERT INTO flight VALUES(20008,'Airlines','Kolkatta','Pune','12-oct-2017','12-oct-2017',TO_TIMESTAMP('12:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('06:00:00', 'HH24:MI:SS'),50,50,2000,50,50,5000);

INSERT INTO flight VALUES(20009,'Indigo','Kolkatta','Mumbai','14-oct-2017','13-oct-2017',TO_TIMESTAMP('04:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,3000,50,50,7500);

INSERT INTO flight VALUES(20010,'Emirates','Kolkatta','Delhi','12-oct-2017','12-oct-2017',TO_TIMESTAMP('12:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('05:14:00', 'HH24:MI:SS'),60,60,3000,60,60,8000);


INSERT INTO flight VALUES(30001,'Airlines','Chennai','Hyderabad','13-oct-2017','12-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,1000,50,50,4000);

INSERT INTO flight VALUES(30002,'Airlines','Chennai','Kolkatta','12-oct-2017','12-oct-2017',TO_TIMESTAMP('09:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('05:14:00', 'HH24:MI:SS'),50,50,1500,50,50,5000);

INSERT INTO flight VALUES(30003,'Jetways','Chennai','Pune','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:00:00', 'HH24:MI:SS'),50,50,2500,50,50,5500);

INSERT INTO flight VALUES(30004,'Kingfisher','Chennai','Mumbai','13-oct-2017','13-oct-2017',TO_TIMESTAMP('12:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),50,50,3000,50,50,8000);


INSERT INTO flight VALUES(30005,'Kingfisher','Chennai','Delhi','13-oct-2017','12-oct-2017',TO_TIMESTAMP('05:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:14:00', 'HH24:MI:SS'),60,60,2000,60,60,6500);

INSERT INTO flight VALUES(30006,'Kingfisher','Chennai','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('13:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),60,60,1500,50,50,5000);

INSERT INTO flight VALUES(30007,'SpiceJet','Chennai','Kolkatta','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:14:00', 'HH24:MI:SS'),50,50,2500,50,50,6000);

INSERT INTO flight VALUES(30008,'Indigo','Chennai','Pune','12-oct-2017','12-oct-2017',TO_TIMESTAMP('12:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('07:00:00', 'HH24:MI:SS'),50,50,2000,50,50,5000);

INSERT INTO flight VALUES(30009,'Indian','Chennai','Mumbai','14-oct-2017','13-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2500,50,50,7000);


INSERT INTO flight VALUES(30010,'Emirates','Chennai','Delhi','12-oct-2017','12-oct-2017',TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('18:14:00', 'HH24:MI:SS'),60,60,2000,60,60,6500);


INSERT INTO flight VALUES(40001,'SpiceJet','Pune','Hyderabad','13-oct-2017','12-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2000,50,50,5000);

INSERT INTO flight VALUES(40002,'Airlines','Pune','Kolkatta','12-oct-2017','12-oct-2017',TO_TIMESTAMP('07:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('04:14:00', 'HH24:MI:SS'),50,50,1000,50,50,4500);

INSERT INTO flight VALUES(40003,'Jetways','Pune','Delhi','13-oct-2017','12-oct-2017',TO_TIMESTAMP('01:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:00:00', 'HH24:MI:SS'),50,50,2500,50,50,6500);

INSERT INTO flight VALUES(40004,'Kingfisher','Pune','Mumbai','13-oct-2017','13-oct-2017',TO_TIMESTAMP('10:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),50,50,3000,50,50,9000);

INSERT INTO flight VALUES(40005,'Kingfisher','Pune','Chennai','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:30:00', 'HH24:MI:SS'),60,60,2000,60,60,6500);


INSERT INTO flight VALUES(40006,'Emirates','Pune','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('20:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('16:14:00', 'HH24:MI:SS'),50,50,1500,50,50,5500);

INSERT INTO flight VALUES(40007,'Indigo','Pune','Kolkatta','13-oct-2017','12-oct-2017',TO_TIMESTAMP('02:30:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,1500,50,50,4000);

INSERT INTO flight VALUES(40008,'KingFisher','Pune','Delhi','12-oct-2017','12-oct-2017',TO_TIMESTAMP('18:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('14:00:00', 'HH24:MI:SS'),50,50,2000,50,50,5500);

INSERT INTO flight VALUES(40009,'Jetways','Pune','Mumbai','14-oct-2017','13-oct-2017',TO_TIMESTAMP('02:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2500,50,50,8000);

INSERT INTO flight VALUES(40010,'SpiceJet','Pune','Chennai','12-oct-2017','12-oct-2017',TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('05:30:00', 'HH24:MI:SS'),60,60,1500,60,60,6000);


INSERT INTO flight VALUES(50001,'SpiceJet','Mumbai','Hyderabad','13-oct-2017','12-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2000,50,50,5000);

INSERT INTO flight VALUES(50002,'Airlines','Mumbai','Kolkatta','12-oct-2017','12-oct-2017',TO_TIMESTAMP('07:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('04:14:00', 'HH24:MI:SS'),50,50,1000,50,50,4500);

INSERT INTO flight VALUES(50003,'Jetways','Mumbai','Delhi','13-oct-2017','12-oct-2017',TO_TIMESTAMP('01:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:00:00', 'HH24:MI:SS'),50,50,2500,50,50,6500);

INSERT INTO flight VALUES(50004,'Kingfisher','Mumbai','Pune','13-oct-2017','13-oct-2017',TO_TIMESTAMP('10:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),50,50,3000,50,50,9000);

INSERT INTO flight VALUES(50005,'Kingfisher','Mumbai','Chennai','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:30:00', 'HH24:MI:SS'),60,60,2000,60,60,6500);


INSERT INTO flight VALUES(50006,'Emirates','Mumbai','Hyderabad','12-oct-2017','12-oct-2017',TO_TIMESTAMP('20:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('16:14:00', 'HH24:MI:SS'),50,50,1500,50,50,5500);

INSERT INTO flight VALUES(50007,'Indigo','Mumbai','Kolkatta','13-oct-2017','12-oct-2017',TO_TIMESTAMP('02:30:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,1500,50,50,4000);

INSERT INTO flight VALUES(50008,'KingFisher','Mumbai','Delhi','12-oct-2017','12-oct-2017',TO_TIMESTAMP('18:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('14:00:00', 'HH24:MI:SS'),50,50,2000,50,50,5500);

INSERT INTO flight VALUES(50009,'Jetways','Mumbai','Pune','14-oct-2017','13-oct-2017',TO_TIMESTAMP('02:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2500,50,50,8000);

INSERT INTO flight VALUES(50010,'SpiceJet','Mumbai','Chennai','12-oct-2017','12-oct-2017',TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('05:30:00', 'HH24:MI:SS'),60,60,1500,60,60,6000);


INSERT INTO flight VALUES(60001,'SpiceJet','Hyderabad','Mumbai','13-oct-2017','12-oct-2017',TO_TIMESTAMP('06:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2000,50,50,5000);

INSERT INTO flight VALUES(60002,'Airlines','Hyderabad','Kolkatta','12-oct-2017','12-oct-2017',TO_TIMESTAMP('07:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('04:14:00', 'HH24:MI:SS'),50,50,1000,50,50,4500);

INSERT INTO flight VALUES(60003,'Jetways','Hyderabad','Delhi','13-oct-2017','12-oct-2017',TO_TIMESTAMP('01:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('22:00:00', 'HH24:MI:SS'),50,50,2500,50,50,6500);

INSERT INTO flight VALUES(60004,'Kingfisher','Hyderabad','Pune','13-oct-2017','13-oct-2017',TO_TIMESTAMP('10:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),50,50,3000,50,50,9000);

INSERT INTO flight VALUES(60005,'Kingfisher','Hyderabad','Chennai','13-oct-2017','12-oct-2017',TO_TIMESTAMP('03:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:30:00', 'HH24:MI:SS'),60,60,2000,60,60,6500);

INSERT INTO flight VALUES(60006,'Emirates','Hyderabad','Mumbai','12-oct-2017','12-oct-2017',TO_TIMESTAMP('20:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('16:14:00', 'HH24:MI:SS'),50,50,1500,50,50,5500);

INSERT INTO flight VALUES(60007,'Indigo','Hyderabad','Kolkatta','13-oct-2017','12-oct-2017',TO_TIMESTAMP('02:30:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,1500,50,50,4000);

INSERT INTO flight VALUES(60008,'KingFisher','Hyderabad','Delhi','12-oct-2017','12-oct-2017',TO_TIMESTAMP('18:00:00', 'HH24:MI:SS'),TO_TIMESTAMP('14:00:00', 'HH24:MI:SS'),50,50,2000,50,50,5500);

INSERT INTO flight VALUES(60009,'Jetways','Hyderabad','Pune','14-oct-2017','13-oct-2017',TO_TIMESTAMP('02:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('23:14:00', 'HH24:MI:SS'),50,50,2500,50,50,8000);

INSERT INTO flight VALUES(60010,'SpiceJet','Hyderabad','Chennai','12-oct-2017','12-oct-2017',TO_TIMESTAMP('08:14:00', 'HH24:MI:SS'),TO_TIMESTAMP('05:30:00', 'HH24:MI:SS'),60,60,1500,60,60,6000);

------------------------------------User Insertion-----------------------
INSERT INTO users VALUES('akhilravuri','akhilravuri','USER',9898989898);

INSERT INTO users VALUES('indusree','indusree','USER',9798989898);

INSERT INTO users VALUES('mounikas','mounikas','USER',9798989898);

INSERT INTO users VALUES('aakashjuneja','aakashjuneja','USER',9798989898);

