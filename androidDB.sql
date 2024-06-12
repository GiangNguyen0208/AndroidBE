create database androiddb;
use androiddb;

CREATE TABLE users (
                       id int auto_increment,
                       username varchar(50),
                       firstname varchar(100),
                       lastname varchar(100),
                       gender bit,
                       phone int,
                       email varchar(100),
                       birthDay timestamp,
                       role_id int,
                       role int(11),
                       status bit(1) ,
                       password varchar(100) ,
                       address varchar(255),
                       birth_day datetime(6),
                       primary key (id)
);
CREATE TABLE roles (
                       id int auto_increment,
                       name nvarchar(100),
                       date_create timestamp,

                       primary key (id)
);
CREATE TABLE cards (
                       id int auto_increment,
                       card_number nvarchar(100),
                       card_name varchar(100),
                       expiry_date timestamp,
                       fullname varchar(100),
                       user_id int,

                       primary key (id)
);
CREATE TABLE license_vehicles (
                                  id int auto_increment,
                                  number_code nvarchar(100),
                                  imgLicense nvarchar(1000),
                                  fullname varchar(100),
                                  birthDay date,
                                  rank_license varchar(100),
                                  user_id int,

                                  primary key (id)
);
CREATE TABLE anounces (
                          id int auto_increment,
                          title varchar(100),
                          content varchar(100),
                          send_at timestamp,
                          user_id varchar (100),

                          primary key (id)
);
CREATE TABLE anouces_users (
                               anounce_id int auto_increment,
                               user_id varchar (100),

                               primary key (anounce_id, user_id)
);
CREATE TABLE vehicles (
                          id int auto_increment,
                          type enum("car","motor","bike"),
                          status bit,
                          price double,
                          discount_id int,
                          color_id int,
                          brand_id int,
                          model_id int,
                          image_id int,

                          primary key (id)
);
CREATE TABLE models (
                        id int auto_increment,
                        name nvarchar(100),

                        primary key (id)
);
CREATE TABLE brands (
                        id int auto_increment,
                        name nvarchar(100),

                        primary key (id)
);
CREATE TABLE rates (
                       id int auto_increment,
                       rateComment varchar(100),
                       rateScore int,
                       user_id int,
                       vehicle_id int,
                       date_create timestamp,

                       primary key (id)
);

CREATE TABLE discounts (
                           id int auto_increment,
                           value double,

                           primary key (id)
);

CREATE TABLE colors (
                        id int auto_increment,
                        codeColor varchar(100),
                        nameColor varchar(100),

                        primary key (id)
);

CREATE TABLE images (
                        id int auto_increment,
                        imgLink nvarchar(1000),

                        primary key (id)
);
CREATE TABLE orders (
                        id int auto_increment,
                        rental_id int,
                        date_create timestamp,
                        user_id int,
                        payment_id int,

                        primary key (id)
);

CREATE TABLE rentals (
                         id int auto_increment,
                         vehicle_id int,
                         rental_date timestamp DEFAULT CURRENT_TIMESTAMP,
                         return_date TIMESTAMP NULL DEFAULT NULL,

                         primary key (id)
);



CREATE TABLE payments (
                          id int auto_increment,
                          user_id int,
                          card_id int,
                          amount double,
                          date_create timestamp,

                          primary key (id)
);

CREATE TABLE messages (
                          id int auto_increment,
                          from_user_id int,
                          to_user_id int,
                          content nvarchar(512),
                          date_create timestamp,
                          primary key (id)
);

-- USERS
alter table users ADD FOREIGN KEY (role_id) REFERENCES roles (id);
-- LICENSEVEHICLES
alter table license_vehicles ADD FOREIGN KEY (user_id) REFERENCES users (id);
-- CARDS
alter table cards ADD FOREIGN KEY (user_id) REFERENCES users (id);
-- VEHICLES
alter table vehicles ADD FOREIGN KEY (discount_id) REFERENCES discounts (id);
alter table vehicles ADD FOREIGN KEY (color_id) REFERENCES colors (id);
alter table vehicles ADD FOREIGN KEY (brand_id) REFERENCES brands (id);
alter table vehicles ADD FOREIGN KEY (model_id) REFERENCES models (id);
alter table vehicles ADD FOREIGN KEY (image_id) REFERENCES images (id);
-- RATES
alter table rates ADD FOREIGN KEY (user_id) REFERENCES users (id);
alter table rates ADD FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);
-- ORDERS
alter table orders ADD FOREIGN KEY (rental_id) REFERENCES rentals (id);
alter table orders ADD FOREIGN KEY (user_id) REFERENCES users (id);
alter table orders ADD FOREIGN KEY (payment_id) REFERENCES payments (id);
-- RENTALS
alter table rentals ADD FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);
-- PAYMENTS
alter table payments ADD FOREIGN KEY (user_id) REFERENCES users (id);
alter table payments ADD FOREIGN KEY (card_id) REFERENCES cards (id);
-- MESSAGES
alter table messages ADD FOREIGN KEY (from_user_id) REFERENCES users (id);
alter table messages ADD FOREIGN KEY (to_user_id) REFERENCES users (id);



INSERT INTO roles (name, date_create) VALUES ('user', CURRENT_TIMESTAMP);
INSERT INTO roles (name, date_create) VALUES ('admin', CURRENT_TIMESTAMP);

INSERT INTO users (username, firstname, lastname, gender, phone, email, birthDay, status, password, role_id) VALUES ('giang456','Giang', 'Nguyen', 1, '0948188712', 'truongnguyenhuonggiang02082003@gmail.com', '2003-08-02', 1, 'user123', 1);
INSERT INTO users (username, firstname, lastname, gender, phone, email, birthDay, status, password, role_id) VALUES ('giang123','Giang', 'Nguyen', 1, '0948188712', 'giangtruongnguyen02082003@gmail.com', '2003-08-02', 1, 'admin123', 2);
INSERT INTO users (username, firstname, lastname, gender, phone, email, birthDay, status, password, role_id) VALUES ('admin','Admin', 'Test', 1, '123123123', 'admin123@gmail.com', '2003-08-01', 1, 'admin123', 2);
INSERT INTO users (username, firstname, lastname, gender, phone, email, birthDay, status, password, role_id) VALUES ('user','User', 'Test', 1, '3213212321', 'user123@gmail.com', '2003-03-02', 1, 'user123', 1);

select * from users;
  
  
  
  