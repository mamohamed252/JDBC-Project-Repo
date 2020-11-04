/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

import com.mycompany.bullscow.entity.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Round getRoundById(int roundId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Round addRound(Round round) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      public static final class RoundMapper implements RowMapper<Round>{
        
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException{
            Round round = new Round();
            round.setRoundId(rs.getInt("RoundId"));
            round.setTime(rs.getTimestamp("Time").toLocalDateTime());
            round.setGuessResultExact(rs.getString("GuessResultExact"));
            round.setGuessResultPartial(rs.getString("GuessResultExactPartial"));
            round.setUserGuessKey(rs.getInt("UserGuessKey"));
            
            return round;
        }
      }   
}
