/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;
import players.ui.*;
/**
 *
 * @author kevin
 */
public class Game {
    
    
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        
        game.setVisible(true);
        //game.setState(game.getWestState());
        System.out.println(game.roundComplete());
        while (!game.roundComplete()) {
            System.out.println();
            if (game.getNorthState().hasPlayed()) {
                //System.out.println("Next player's turn.");
                game.setState(game.getSouthState());
            }
        }
        System.out.println("cleared a round");
        game.tallyRound();
    }

}
