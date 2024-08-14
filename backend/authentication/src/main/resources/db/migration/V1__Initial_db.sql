create table if not exists usr
(
    id         bigserial primary key,
    username   varchar(64)   not null unique,
    password   varchar(2048) not null,
    enabled    boolean       not null default false,
    created_at timestamp,
    updated_at timestamp
);

create table if not exists role
(
    id   bigserial primary key,
    role varchar(32) not null unique
);

create table if not exists usr_role
(
    id      bigserial primary key,
    usr_id  bigint references usr,
    role_id bigint references role
);

create table if not exists address
(
    id        bigserial primary key,
    country   varchar(64) not null,
    state     varchar(64) not null,
    city      varchar(64) not null,
    street    varchar(64) not null,
    house     int         not null,
    apartment int,
    zip       int         not null
);

create table if not exists account
(
    id          bigserial primary key,
    type        varchar(20)    not null,
    number      varchar(20)    not null unique,
    balance     decimal(17, 2) not null,
    date_opened date           not null,
    date_closed date,
    status      varchar(20)
);

create table if not exists person
(
    id            bigserial primary key,
    last_name     varchar(100) not null,
    first_name    varchar(100) not null,
    middle_name   varchar(100),
    date_of_birth date         not null,
    phone         varchar(20)  not null unique,
    email         varchar(100) not null unique,
    active        boolean      not null,
    created_at    timestamp,
    updated_at    timestamp,
    user_id       bigint references usr,
    address_id    bigint references address,
    account_id    bigint references account
);

create table if not exists card
(
    id              bigserial primary key,
    number          varchar(16) not null unique,
    expiration_date date        not null,
    security_code   varchar(3)  not null,
    pin             varchar(4)  not null,
    type            varchar(10) not null, -- 1 - VISA, 2 - MASTERCARD, 3 - AMEX, 4 - DISCOVER, 5 - JCB, 6 - MAESTRO, 7 - МИР
    status          varchar(8)  not null, -- 1 - active, 2 - inactive, 3 - blocked, 4 - expired
    created_at      timestamp,
    updated_at      timestamp,
    account_id      bigint references account
);

create table if not exists transaction
(
    id         uuid           not null primary key default gen_random_uuid(),
    payer_card varchar(16) references card (number),
    payee_card varchar(16) references card (number),
    amount     numeric(17, 2) not null,
    currency   varchar(3)     not null,
    created_at timestamp      not null
);

insert into usr (username, password, enabled)
VALUES ('ADMIN', '/H0drjOsg3/D/RShl3dLq1FMrzUocL5H62V3Z28EADg=', true); -- 123456

insert into role (id, role)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_MANAGER'),
       (3, 'ROLE_ADMIN');

insert into usr_role (usr_id, role_id)
values (1, 3);