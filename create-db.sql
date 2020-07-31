create database if not exists `chess_tournament`;
use `chess_tournament`;


drop table if exists `tournament_player`;
drop table if exists `game_player`;
drop table if exists `game`;
drop table if exists `round`;
drop table if exists `tournament`;
drop table if exists `player`;
drop table if exists `team`;


create table `tournament`(
`id` int(11) not null auto_increment,
`name` varchar(125) not null,
`system` varchar(45) not null,
`type` varchar(45) not null,
`number_of_players` int(11),
`street` varchar(45),
`city` varchar(45),
`country` varchar(45),
`start_date` TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
`end_date` TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,

primary key(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



create table `round`(
`id` int(11) not null auto_increment,
`number` int(11) not null,
`tournament_id` int(11) default null,

primary key(`id`),

KEY `FK_TOURNAMENT_idx` (`tournament_id`),
CONSTRAINT `FK_TOURNAMET` FOREIGN KEY (`tournament_id`) 
REFERENCES `tournament` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


create table `team`(
`id` int(11) not null auto_increment,
`name` varchar(45) default null,

primary key (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



create table `player`(
`id` int(11) not null auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`elo` int(5) default null ,
`team_id` int(11) default null,
primary key(`id`),

KEY `FK_TEAM_idx` (`team_id`),
CONSTRAINT `FK_TEAM` FOREIGN KEY (`team_id`) 
REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE `tournament_player` (
  `tournament_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  
  PRIMARY KEY (`tournament_id`,`player_id`),
  
  KEY `FK_TOURNAMENT_idx` (`tournament_id`),
  
  CONSTRAINT `FK_TOURNAMENT` FOREIGN KEY (`tournament_id`) 
  REFERENCES `tournament` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_PLAYER` FOREIGN KEY (`player_id`) 
  REFERENCES `player` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


create table `game`(
`id` int(11) not null auto_increment,
`round_id` int(11) default null,

primary key(`id`),

KEY `FK_ROUND_idx` (`round_id`),
CONSTRAINT `FK_ROUND` FOREIGN KEY (`round_id`) 
REFERENCES `round` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `game_player` (
  `game_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `score` double(2,1) NOT NULL,
  
  PRIMARY KEY (`game_id`,`player_id`),
  
  KEY `FK_GAME_idx` (`game_id`),
  
  CONSTRAINT `FK_GAME` FOREIGN KEY (`game_id`) 
  REFERENCES `game` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_PLAYER_GAME` FOREIGN KEY (`player_id`) 
  REFERENCES `player` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

