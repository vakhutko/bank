create table if not exists transaction
(
    id            uuid           not null primary key default gen_random_uuid(),
    payer_account varchar(20)    not null,
    payee_account varchar(20)    not null,
    amount        numeric(10, 2) not null,
    currency      varchar(3)     not null,
    created_at    timestamp      not null
);