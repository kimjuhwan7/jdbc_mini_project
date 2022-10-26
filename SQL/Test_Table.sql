
CREATE TABLE exploiter (
  exploiternum      NUMBER(4) PRIMARY KEY,
  id    VARCHAR2(40) NOT NULL,
  password   VARCHAR2(100) NOT NULL,
  nickname       VARCHAR2(16) NOT NULL,
  admin     INT,
  salt varchar2(20)
);

CREATE TABLE  Game (
  serialnum      NUMBER(4) PRIMARY KEY,  
  gamename        VARCHAR2(50) NOT NULL,
  discription     VARCHAR2(50) NOT NULL,
  genre       VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE RANK_INDEX INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE EXPLOITER_INDEX INCREMENT BY 1 START WITH 1;

CREATE TABLE Rank (
  rankindex NUMBER(4) PRIMARY KEY,
  exploiternum  NUMBER(4)REFERENCES exploiter(exploiternum) NOT NULL,
  serialnum  NUMBER(4) REFERENCES Game(serialnum) NOT NULL,
  score NUMBER(8) NOT NULL ,
  cleartime DATE NOT NULL
);


INSERT INTO exploiter VALUES(exploiter_index.nextval, 'Admin', 'Admin', 'GM', 1, e0a8abb8451ee39565fe);


insert into game values(1,'홀짝','알잖아','도박');
insert into game values(2,'가위바위보','설명해야되나','도박');

INSERT INTO Rank VALUES(RANK_INDEX.nextval, 3, 1, 300, '22/10/11');
