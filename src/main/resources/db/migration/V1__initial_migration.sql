CREATE TABLE PERSON (
    ID bigint NOT NULL AUTO_INCREMENT,
    SSN varchar(255) NOT NULL UNIQUE ,
    FirstName varchar(255) NOT NULL,
    LastName varchar(255) NOT NULL,
    Gender varchar(255) NULL,
    PRIMARY KEY (ID)
);