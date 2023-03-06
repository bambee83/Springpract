DROP TABLE course IF EXISTS;

CREATE TABLE course
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255),
    instructors VARCHAR(255),
    cost        DOUBLE,
    CONSTRAINT pk_course PRIMARY KEY (id)
);