/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import players.ui.*;
/**
 *
 * @author kevin
 */
public class Game {
    
    
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        
        game.setVisible(true);
        JOptionPane optionPane = new JOptionPane(new JLabel("North starts the game",JLabel.CENTER));
        JDialog dialog = optionPane.createDialog("Game Start");
        dialog.setModal(true);
        dialog.setVisible(true);
        
        for (int i=1; i<=13; i++) {
            while (!game.roundComplete()) {
            
            System.out.print("");
            game.play();
            }
       
            System.out.println("cleared round "+i);
            game.tallyRound();
        }
        
        game.gameOver();
        
    }
    
}
