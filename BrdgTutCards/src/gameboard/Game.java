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
        //System.out.println(game.roundComplete();
        boolean north_played = game.getNorthState().hasPlayed();
        while (!game.roundComplete()) {
                System.out.print("i");
            if (north_played) {
                System.out.println("Next player's turn.");
                game.setState(game.getSouthState());
            }
        } 
        System.out.println("cleared a round");
        game.tallyRound();
    }

}
