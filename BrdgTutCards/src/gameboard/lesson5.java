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
public class lesson5 implements Runnable{

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        
        
        
    }

    @Override
    public void run() {
        /*
         * The player is assigned south playing position.
         * To complete the lesson successfully,the player must win a trick for themself.
         */
        
        
        
         //variables
        final int lessonNum=5;//this lesson number
        int cardSuit=0; //Can randomly generate this so that each time you open the lesson,there is a different suit to follow during the lesson
        String suit; //Will hold the string value of the suit value
        //variables end
        
        //generating a random number that corresponds to a suit value.This number will represent the suit to follow throughout the round.
        Random random=new Random();
        cardSuit=random.nextInt(4);
        
        //Making a card object
        Card c=new Card();
        //Making use of the method from the card object that converts a given int value for suit to its corresponding Suit value as a String
        suit=c.getGivenSuitAsString(cardSuit);
       
        
        //New gameboard object created
        GameBoard game=new GameBoard(lessonNum,cardSuit);
        game.setVisible(true);
        
        //Info about this lesson is presented to player before lesson begins
        
        JOptionPane.showMessageDialog(null, "As we learnt in the previous lesson:\nThe player that plays the highest value of the suit that is currently in play\nwins the trick for themself and their partner. ", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "To complete the lesson successfully,you must win a trick for your team.", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,suit +" is the generated suit of choice.\nNorth plays first.", "Random Suit to Follow", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        //This will run the lesson
        
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
            
        
        
        
    }//While round not finished closing bracket
        
        
        
        //Output the player sees once the lesson is completed
          
        if (game.evalTrickWinnerVal()==0||game.evalTrickWinnerVal()==2) {
            
            JOptionPane.showMessageDialog(null, "Well Done.\nYou have won the trick!\nLesson Completed successfully!", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Do you think that you could have won that round differently?\nWere you ever in the danger zone?\nAsk yourself what would have been the best to win that round.", "Some Thoughts", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, game.evalTrickWinner(), "Lost Trick", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "You did not win the trick.\nLesson Not completed successfully.", "Lost Trick", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "What should you have done differently to ensure that you would have won that round?\nCould you have sacrificed your play to guarantee a win via your partner?\nWhat should you have been done differently?", "Improvement", JOptionPane.INFORMATION_MESSAGE);
        }
  
          
        
        JOptionPane.showMessageDialog(null, "Don't forget to come back and replay the lesson.\nThe shuffling of the cards each time you come back to this lesson can yield some different outcomes!", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        //Take player back to lesson menu
        new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose(); 
        
    }
}
