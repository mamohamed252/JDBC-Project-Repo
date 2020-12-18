/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bullscow.DAO;

import com.mycompany.bullscow.entity.Round;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public interface RoundDao {
    List<Round> getRoundsById(int gameId);
    Round addRound(Round round, int gameId);
}