# chess-tournament

This project was generated with Spring.

## Development server

Run the Java application on a dev server. Navigate to http://localhost:8080/chessplan/api/tournaments

## Endpoints
/chessplan/api/tournaments  
/chessplan/api/tournaments/{id}  
/chessplan/api/tournaments/{id}/rounds  
/chessplan/api/tournaments/{id}/player  


/chessplan/api/rounds  
/chessplan/api/rounds/{id}  
/chessplan/api/rounds/{id}/games  


/chessplan/api/teams  
/chessplan/api/teams/{id}  
/chessplan/api/teams/search/findByNameContaining?name={keyword}  


/chessplan/api/players  
/chessplan/api/players/{id}  
/chessplan/api/players/{id}/team  
/chessplan/api/players/search/findByNameContaining?name={keyword}  
/chessplan/api/players/search/findByTournamentId?id={id}  


/chessplan/api/games  
/chessplan/api/games/{id}

## Architecture
![architecture](https://github.com/leonhead/chess-tournament/blob/master/architecture.png)
