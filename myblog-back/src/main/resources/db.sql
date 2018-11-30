DROP database if EXISTS myblog;
CREATE database myblog DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
use myblog;


CREATE TABLE article(
id INTEGER PRIMARY KEY auto_increment,
title VARCHAR (128),
summary TEXT,
content TEXT,
category VARCHAR(32),
create_date datetime,
modify_date datetime)DEFAULT CHARACTER SET=utf8;
INSERT INTO article VALUES('1','过零丁洋','辛苦遭逢起一经，干戈寥落四周星...','辛苦遭逢起一经，干戈寥落四周星。山河破碎风飘絮，身世浮沉雨打萍。惶恐滩头说惶恐，零丁洋里叹零丁。人生自古谁无死，留取丹心照汗青。','默认','2018-04-30 23:52:12','2018-04-30 23:52:12');
INSERT INTO article VALUES('2','赋得古原草送别','离离原上草，一岁一枯荣...','离离原上草，一岁一枯荣。野火烧不尽，春风吹又生。远芳侵古道，晴翠接荒城。又送王孙去，萋萋满别情。','默认','2018-04-30 23:52:12','2018-04-30 23:52:12');
INSERT INTO article VALUES('3','行路难','金樽清酒斗十千，玉盘珍羞直万钱...','金樽清酒斗十千，玉盘珍羞直万钱。停杯投箸不能食，拔剑四顾心茫然。欲渡黄河冰塞川，将登太行雪满山。闲来垂钓碧溪上，忽复乘舟梦日边。行路难！行路难！多歧路，今安在？长风破浪会有时，直挂云帆济沧海。','默认','2018-04-30 23:52:12','2018-04-30 23:52:12');
INSERT INTO article VALUES('4','春望','国破山河在，城春草木深...','国破山河在，城春草木深。感时花溅泪，恨别鸟惊心。烽火连三月，家书抵万金。白头搔更短，浑欲不胜簪。','默认','2018-04-30 23:52:12','2018-04-30 23:52:12');


CREATE TABLE role(
id INTEGER PRIMARY KEY auto_increment,
role VARCHAR(128),
permissions TEXT
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;
INSERT INTO role VALUES('1','admin','comment:add;comment:delete');
INSERT INTO role VALUES('2','user','comment:add');


CREATE TABLE users(
id INTEGER PRIMARY KEY auto_increment,
user_name VARCHAR(128),
user_password VARCHAR(128),
salt VARCHAR(128),
role_id INTEGER,
FOREIGN KEY(role_id) REFERENCES role(id)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;
INSERT INTO users VALUES('1','admin','f215b4c576dc0b775f71507b478f4fa1','9TAYiq1R2Z','1');
INSERT INTO users VALUES('2','user','abda85ff4768a19f6825f9cd36da1745','g7ycGhgFeX','2');


CREATE TABLE comment(
id INTEGER PRIMARY KEY auto_increment,
comment_detail TEXT,
article_id INTEGER,
user_id INTEGER,
create_date datetime,
FOREIGN KEY(article_id) REFERENCES article(id),
FOREIGN KEY(user_id) REFERENCES users(id)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8;
INSERT INTO comment VALUES('1','实例评论1','1','1','2018-05-16 17:16:12');
INSERT INTO comment VALUES('2','实例评论2','1','2','2018-05-16 17:16:12');
INSERT INTO comment VALUES('3','实例评论3','2','1','2018-05-16 17:16:12');
INSERT INTO comment VALUES('4','实例评论4','2','2','2018-05-16 17:16:12');
INSERT INTO comment VALUES('5','实例评论5','3','2','2018-05-16 17:16:12');
INSERT INTO comment VALUES('6','实例评论6','3','1','2018-05-16 17:16:12');
INSERT INTO comment VALUES('7','实例评论7','4','2','2018-05-16 17:16:12');
INSERT INTO comment VALUES('8','实例评论8','4','1','2018-05-16 17:16:12');



