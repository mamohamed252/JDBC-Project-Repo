/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

import com.mycompany.bullscow.DAO.RoundDaoDB.RoundMapper;
import com.mycompany.bullscow.entity.Game;
import com.mycompany.bullscow.entity.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mohamed
 */
@Repository
public class GameDaoDB implements GameDao {

    private final JdbcTemplate jdbc;

    @Autowired
    public GameDaoDB(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        final String INSERT_GAME = "INSERT INTO game(GameId, CorrectAnswerKey, GameStatus) VALUES(?, ?, ?)";
                jdbc.update(INSERT_GAME,
                        game.getGameId(),
                        game.getCorrectAnswerKey(),
                        game.getGameStatus());
                int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
                game.setGameId(newId);
                return game;
    }

    @Override
    public Game getGameById(int gameId) {
        try {
            final String SELECT_GAME_BY_ID = "SELECT * FROM Game WHERE gameId = ?";
            Game game = jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), gameId);
            game.setRound(getRoundsForGame(game));
            return game;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private Round getRoundsForGame(Game game) {
        final String SELECT_ROUNDS_FOR_GAME = "SELECT r.* FROM Round r "
                + "Join Game g ON r.gameId = g.gameId WHERE g.GameId = ?";
        return jdbc.queryForObject(SELECT_ROUNDS_FOR_GAME, new RoundMapper(),
                game.getGameId());
    }

    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_GAMES = "SELECT * FROM game";
        List<Game> games = jdbc.query(SELECT_ALL_GAMES, new GameMapper());
        addRoundToGame(games);
        return games;
    }

    private void addRoundToGame(List<Game> games) {
        for(Game game : games){
        game.setRound(getRoundsForGame(game));     
        }
    }

    @Override
    public Game updateStatus(Game game) {
        game.setGameStatus(false);
        return game;
    }
    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameId(rs.getInt("GameId"));
            game.setCorrectAnswerKey(rs.getInt("CorrectAnswerKey"));
            game.setGameStatus(rs.getBoolean("GameStatus"));
            return game;
        }

    }
}
