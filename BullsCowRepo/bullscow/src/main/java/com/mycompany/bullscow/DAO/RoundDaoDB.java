/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

import com.mycompany.bullscow.entity.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohamed
 */
@Repository
public class RoundDaoDB implements RoundDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Round> getRoundsById(int gameId) {
        try {
            final String GET_ROUND_BY_GAME_ID = "SELECT * FROM round r "
                    + "JOIN GAME g ON r.GameId = g.GameId "
                    + "Where r.GameId = ?";
            return jdbc.query(GET_ROUND_BY_GAME_ID, new RoundMapper(), gameId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Round addRound(Round round, int gameId) {
        
        final String INSERT_ROUND = "INSERT INTO ROUND(Time, GuessResultExact, GuessResultPartial, UserGuessKey, GameId) VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_ROUND,
                Timestamp.valueOf(round.getTime()),
                round.getGuessResultExact(),
                round.getGuessResultPartial(),
                round.getUserGuessKey(),
                gameId);
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundId(newId);
        return round;
    }

    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("RoundId"));
            round.setTime(rs.getTimestamp("Time").toLocalDateTime());
            round.setGuessResultExact(rs.getString("GuessResultExact"));
            round.setGuessResultPartial(rs.getString("GuessResultPartial"));
            round.setUserGuessKey(rs.getString("UserGuessKey"));

            return round;
        }
    }
}
