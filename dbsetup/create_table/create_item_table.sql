CREATE TABLE item (
    category varchar(255),
    name varchar(255),
    price integer,
    PRIMARY KEY(category, name)
)