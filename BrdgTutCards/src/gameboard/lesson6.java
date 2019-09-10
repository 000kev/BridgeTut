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
public class lesson6 implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
    }

    @Override
    public void run() {
        /*
         * In this lesson the player is taught what is a trump card and when it is used.
         * They have to select a suit that they feel is the correct suit for a trump card,but the computer will evaluate 
         * if the player is correct in their decision.
         * 
         * 
         */
        
        //variables
        final int lessonNum=6;//this lesson number
        int cardSuit=0; //Can randomly generate this so that each time you open the lesson,there is a different suit to follow during the lesson
        String suit; //Will hold the string value of the suit value
        
        boolean correctTrump=false;//check if the card the player selected is the correct suit for trump
        //variables end
        
        
        
        //Making a card object
        Card c=new Card();
        //Making use of the method from the card object that converts a given int value for suit to its corresponding Suit value as a String
        
        
         //New gameboard object created
        GameBoard game=new GameBoard(lessonNum);
        game.setVisible(true); 
       
        
        //Info about this lesson is presented to player before lesson begins
        
        JOptionPane.showMessageDialog(null, "Trump cards are cards of a particular suit that has been decided upon by a team that is currently bidding.\nThese cards give the players,who have them, an advantage as they automatically win the trick for you.\nDeciding on what suit should be trumps is done before the offical gameplay begins.", "Selecting Trump Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "You play a trump card when you do not contain a card to follow the suit of cards that is currently in play.\nIf other players also end up playing trump cards then the normal rules, of who has the highest value wins the round, will stll apply.", "Selecting Trump Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Best way to select a suit that should be trump is by looking at which suit is most common in your hand.\nLook at your hand and your parnters' hand of cards.\nCount 7 or more cards of the same suit between yourself and your partner.That suit is now the suit that you set as Trump.", "Deciding Trump suit", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "To complete the lesson successfully,you must select the suit that is most common amoungst you and your partner.\nYou have 1 chance to do so.", "Selecting Trump Lesson", JOptionPane.INFORMATION_MESSAGE);
        
        
        
    
        
        JOptionPane.showMessageDialog(null, "South must select the trump card", "Play as:", JOptionPane.INFORMATION_MESSAGE);
        game.setState(game.getSouthState());
        while (game.roundComplete()==false) {            
                if (game.getSouthState().hasPlayed()==true) {
                
                game.roundComplete();
                break;
                
            }
        }
        
        
        //Evalutaes the players choice in suit for trump
        correctTrump=game.evalPlayerTrump(game.calcTrump());
       //Gets the value of the suit that should have been selected
        suit=c.getGivenSuitAsString(Integer.parseInt(game.calcTrump()));
        
        if (correctTrump==true) {
            
            JOptionPane.showMessageDialog(null, "You have selected the correct suit for trump card!\nLesson complete.", "Trump Selected", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Incorrect suit for trump card selected.\nThere was a larger number of "+suit+" between you and your partner.\nThat should have been selected as Trump.", "Incorrect Suit Selected", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        JOptionPane.showMessageDialog(null, "Don't forget to come back and replay the lesson.\nThe shuffling of the cards each time you come back to this lesson can yield some different outcomes!", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose(); 
        //JOptionPane.showMessageDialog(null,suit +" is the generated suit of choice.\nNorth plays first.", "Random Suit to Follow", JOptionPane.INFORMATION_MESSAGE);
        
        
    }
}
