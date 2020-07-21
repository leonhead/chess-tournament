use `chess_tournament`;

INSERT INTO `tournament` VALUES
	(1, 'Deutsche Schach-Pokalmeisterschaft 2020 (Daehne-Pokal)', 'KO','CLASSIC', 32, 'Otto-von-Guericke-Straße 87', 'Magdeburg', 'GER', ' 2020-07-03' ,'2020-07-11', 1),
    (2, '17. Kaiseropen Bad Ems 2020 Open', 'SWISS','CLASSIC', 100, 'Römerstr. 1', 'Bad Ems', 'GER', '2020-07-03' ,'2020-07-11', 1),
    (3, 'Deutsche Blitz-Einzelmeisterschaft der Frauen 2020', 'ROUND', 'BLITZ', 30, 'Otto-von-Guericke-Straße 87', 'Magdeburg', 'GER', '2020-08-15', '2020-08-15', 1);
    
INSERT INTO `team` VALUES 
	(1, 'Tigers'),
	(2, 'Crocodils');
    

INSERT INTO `player` VALUES 
	(1,'Leslie','Andrews', 1920, 1),
	(2,'Emma','Baumgarten', 1580, 1),
	(3,'Avani','Gupta', 2030, 2),
	(4,'Yuri','Petrov', 1802, 2),
	(5,'Juan','Vega', 1742, 1);
    
    
INSERT INTO `tournament_player` VALUES 
	(1, 1),
	(1, 2),
	(2, 3),
	(1, 3),
    (2, 4),
	(2, 5);


    

    

    

    
       
