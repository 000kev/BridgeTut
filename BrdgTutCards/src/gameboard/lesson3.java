/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import gui.lessons.lessonsScreen;
import cards.lib.Card;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class lesson3 implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }

    @Override
    public void run() {
         /*
         * The user has to follow the suit set by the computer to successfully complete the lesson
         */
        
        
        //variables
        final int lessonNum=3;
        int cardSuit=1;//we want the user to follow this specific suit 
        String suit; //Will hold the string value of the suit value
        //variables end
        
        
        //Making a card object
        Card c=new Card();
        //Making use of the method from the card object that converts a given int value for suit to its corresponding Suit value as a String
        suit=c.getGivenSuitAsString(cardSuit);
       
        
        GameBoard game=new GameBoard(lessonNum,cardSuit);
        game.setVisible(true);
        
        
        JOptionPane.showMessageDialog(null, "To complete this lesson,you must follow the suit that is being played", "Follow Suit Lesson", JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null, "Do not worry about value of the card you select.\nOnly the suit needs to match", "Follow Suit Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, suit+" is the generated suit of choice.\nNorth plays first.", "Random Suit to Follow", JOptionPane.INFORMATION_MESSAGE);
        
        
        while (game.roundComplete()==false) { //While a round has not finished
            game.setState(game.getNorthState());
            
            if (game.getNorthState().hasPlayed()==true) {
                game.setState(game.getEastState());
                
                if (game.getEastState().hasPlayed()==true) {
                    game.setState(game.getSouthState());
                    
                    
                        if (game.getSouthState().hasPlayed()==true) {
                            game.setState(game.getWestState());
                            
                            
                                if (game.getWestState().hasPlayed()==true) {
                                   
                                    game.roundComplete();
                                    //break;
                                }
                            
                        }
                    
                }
            }
            
        
        
        
    }
        
        
        JOptionPane.showMessageDialog(null, "You have matched the suits successfully.\nLesson Complete!", "Match Suit of Hearts Lesson", JOptionPane.INFORMATION_MESSAGE);
        new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose(); 
    }
}
