
CREATE TABLE exploiter (
  exploiternum      NUMBER(4) PRIMARY KEY,
  id    VARCHAR2(40) NOT NULL,
  password   VARCHAR2(100) NOT NULL,
  nickname       VARCHAR2(16) NOT NULL,
  admin     INT,
  salt VARCHAR2(20)
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


INSERT INTO exploiter VALUES(1, 'Admin', '891affec2ff4176343738f93dd8950b2dbdc115587d0a6ac8e2eb8137a5cfec8', 'GM', 1, 'e0a8abb8451ee39565fe');

delete from exploiter where password = 'Admin';


insert into game values(1,'NumberGuessing','Guess Correct Number in 5 time','Puzzle');
insert into game values(2,'Hi99','Solve Multiplication Table in 30 Sec','Math');
insert into game values(3,'TicTacToe','Check one line first','Puzzle');

INSERT INTO Rank VALUES(RANK_INDEX.nextval, 3, 1, 300, '22/10/11');
drop table rank;
drop table exploiter;
commit;