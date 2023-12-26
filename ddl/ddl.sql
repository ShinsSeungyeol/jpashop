create table category (
                          category_id bigint not null,
                          parent_id bigint,
                          name varchar(255),
                          primary key (category_id)
)

create table category_item (
                               category_id bigint not null,
                               item_id bigint not null
)

create table delivery (
                          delivery_id bigint not null,
                          city varchar(255),
                          stats varchar(255) check (stats in ('READY','COMP')),
                          street varchar(255),
                          zipcode varchar(255),
                          primary key (delivery_id)
)

create table item (
                      price integer not null,
                      stock_quantity integer not null,
                      item_id bigint not null,
                      dtype varchar(31) not null,
                      actor varchar(255),
                      artist varchar(255),
                      author varchar(255),
                      director varchar(255),
                      etc varchar(255),
                      is_bn varchar(255),
                      name varchar(255),
                      primary key (item_id)
)

create table member (
                        member_id bigint not null,
                        city varchar(255),
                        name varchar(255),
                        street varchar(255),
                        zipcode varchar(255),
                        primary key (member_id)
)


create table order_item (
                            count integer not null,
                            order_price integer not null,
                            item_id bigint,
                            order_id bigint,
                            order_item_id bigint not null,
                            primary key (order_item_id)
)

create table orders (
                        delivery_id bigint unique,
                        member_id bigint,
                        order_date timestamp(6),
                        order_id bigint not null,
                        status varchar(255) check (status in ('ORDER','CANCEL')),
                        primary key (order_id)
)