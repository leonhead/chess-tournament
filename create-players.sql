use `chess_tournament`;

INSERT INTO `tournament` VALUES
	(1, '2019 Washington Challengers Cup', 'SWISS','CLASSIC', 40, 'Main Street 2', 'Seattle', 'USA', '2020-07-03' ,'2020-07-11'),
    (2, '2019 Saint Louis Invitational - IM Norm', 'ROUND','CLASSIC', 10, 'Second Street 3', 'Saint Louis', 'USA', '2020-07-03' ,'2020-07-11'),
    (3, 'October 26 LACC Saturday Blitz', 'SWISS', 'BLITZ', 20, 'Beach Street 88', 'Log Angeles', 'USA', '2020-08-15', '2020-08-15');
    
INSERT INTO `team` VALUES 
	(1, 'Chess Club Sant Louis'),
	(2, 'New Yorker Chessplayers');
    

INSERT INTO `player` VALUES   
(1, 'Selina', 'Erickson', 0 ,1),
(2, 'Jasmin',  'Colon', 1302, 1),
(3, 'Hajra',  'Mcneill', 1809, 2),
(4, 'Toyah',  'Holding', 2087, 2),
(5, 'Aydin',  'Hume', 1788, 1),
(6, 'Ayva',  'Crossley', 1572, 2),
(7, 'Louisa',  'Snider', 1405, 1),
(8, 'Parker',  'Cope', 1438, 1),
(9, 'Marek',  'Mcconnell', 1752, 1),
(10, 'Hal',  'Stephenson', 1731, 2),
(11, 'Jasmine',  'Norton', 1190, 1),
(12, 'Siena',  'Kendall', 2089, 2),
(13, 'Findlay',  'Broadhurst', 1656, 1),
(14, 'Teigan',  'Britton', 1389, 1),
(15, 'Aleisha',  'Macdonald', 2192, 1),
(16, 'Catherine',  'Spencer', 2087, 2),
(17, 'Taliyah',  'Willis', 1978, 1),
(18, 'Tasmin',  'Macias', 1492, 2),
(19, 'Tobias',  'Haas', 1578, 2),
(20, 'Libbi',  'Bassett', 2101, 1);
  
   
    
INSERT INTO `tournament_player` VALUES 
	(1, 1),
	(1, 2),
	(2, 3),
	(1, 3),
    (2, 4),
	(2, 5),
    (3, 6),
    (3, 7),
    (2, 8),
    (1, 9),
    (1, 10),
    (1, 11),
    (1, 12),
    (1, 13),
    (1, 14),
    (2, 15),
    (2, 16),
    (2, 17),
    (1, 18),
    (1, 19),
    (2, 19),
    (2, 20),
    (3, 20);
    
    


    

    

    

    
       
