CREATE DATABASE area;

USE area;

create table `area`
(
    id    int primary key auto_increment,
    title varchar(100) NOT NULL
);

create table `area_safety`
(
    area_id     int primary key,
    score_avg   float,
    score_theft float,
    FOREIGN KEY (area_id)
        REFERENCES area (id)
);

# DROP table school;


create table `school`
(
    id      int PRIMARY KEY AUTO_INCREMENT,
    area_id int,
    type_id int,
    title   varchar(100) NOT NULL,
    FOREIGN KEY (type_id)
        REFERENCES school_type (id),
    FOREIGN KEY (area_id)
        REFERENCES area (id)
);

create table `school_type`
(
    id    int primary key auto_increment,
    title varchar(100) NOT NULL
);


# === DATA ===

insert into school_type (title) values ('regular');
insert into school_type (title) values ('private');
insert into area (title) values ('media_city');
insert into area_safety (area_id, score_avg, score_theft) values (1, 0.9, 1.0);
insert into school (area, type_id, title) values (1, 1, 'International school 1');


# === QUERIES ===

select * from area LEFT JOIN area_safety `as` on area.id = `as`.area_id LEFT JOIN school s on `as`.area_id = s.area
WHERE `as`.score_avg > 0.5 AND s.type_id;

SELECT * FROM `area` as a LEFT JOIN `area_safety` as `as` on a.id = `as`.area_id WHERE a.id = 1;