/***********************************************************
* Create the database named ceismgr and all of its tables
************************************************************/

DROP DATABASE IF EXISTS ceismgr;

CREATE DATABASE ceismgr;

USE ceismgr;

CREATE TABLE user (
  userid VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  role VARCHAR(15) NOT NULL,
  PRIMARY KEY(UserID) 
);

INSERT INTO User 
  (userid, password, role)
VALUES 
  ('jsmith@gmail.com', 'password', 'admin');

/***********************************************************
* role_access_map table maps a role to a pre-defined access 
* levels. [FUTURE] These levels will include modifications to
* db and system configurations.
************************************************************/
                              
CREATE  TABLE role_access_map (
  role VARCHAR(25) NOT NULL ,
  type VARCHAR(25) NOT NULL ,
  PRIMARY KEY (role) 
);

INSERT INTO role_access_map 
  (role, type)
VALUES
	('admin', 'root');


