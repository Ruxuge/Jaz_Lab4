CREATE table profile(
    id BIGSERIAL PRIMARY KEY ,
    firstName varchar not null,
    lastName varchar not null
);

create table photo
(
    id   BIGSERIAL PRIMARY KEY ,
    photo varchar not null
);

create table parameter
(
    id  BIGSERIAL PRIMARY KEY,
    description varchar not null
);

CREATE table section
(
    id   BIGSERIAL PRIMARY KEY ,
    name varchar not null
);

CREATE table category
(
    id   BIGSERIAL PRIMARY KEY ,
    name varchar not null ,
    description varchar not null ,
    section_id BIGINT not null
);

CREATE table auction
(
    id BIGSERIAL PRIMARY KEY,
    title varchar not null ,
    description varchar not null ,
    price money not null,
    owner_id BIGINT not null,
    category_id BIGINT not null,
    FOREIGN KEY (owner_id) REFERENCES profile (id),
    foreign key (category_id) REFERENCES category (id)
);

ALTER TABLE category
    ADD CONSTRAINT dodaniekluczasekcji FOREIGN KEY (section_id) REFERENCES section (id);

create table auction_parameter
(
    id_auction  BIGINT NOT NULL ,
    id_parameter  BIGINT NOT NULL ,
    values varchar not null,
    FOREIGN KEY (id_auction) REFERENCES auction (id),
    foreign key (id_parameter) REFERENCES parameter (id)
);