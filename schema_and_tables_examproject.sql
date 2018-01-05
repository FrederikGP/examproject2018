DROP SCHEMA IF EXISTS examproject;
CREATE SCHEMA IF NOT EXISTS examproject;
USE examproject;


DROP TABLE IF EXISTS content;
CREATE TABLE IF NOT EXISTS content(
id int(8) NOT NULL AUTO_INCREMENT,
title varchar(50) NOT NULL DEFAULT '',
description varchar(400) NOT NULL DEFAULT '',
published varchar(50) NOT NULL DEFAULT '',
amount varchar(200) NOT NULL DEFAULT '',
localCurrency varchar(3) NOT NULL DEFAULT '',
foreignCurrency varchar(3) NOT NULL DEFAULT '',
price varchar(200) NOT NULL DEFAULT '',
storeType varchar(100) NOT NULL DEFAULT '',
publishedInMill varchar(200) NOT NULL DEFAULT'',
PRIMARY KEY(id)
);