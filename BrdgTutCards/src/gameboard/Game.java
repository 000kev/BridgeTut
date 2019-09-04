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
        
        for (int i=1; i<=13; i++) {
            while (!game.roundComplete()) {
            
            System.out.print("");
            game.play();
            }
       
            System.out.println("cleared round "+i);
            game.tallyRound();
        }
        /*
        while (!game.roundComplete()) {
            
            System.out.print("");
            game.play();
            
        }
       
        System.out.println("cleared round 1");
        game.tallyRound();
        
        while (!game.roundComplete()) {
            
            System.out.print("");
            game.play();
        }
        System.out.println("cleared round 2");
        game.tallyRound(); 
       */
        
    }
    
}
