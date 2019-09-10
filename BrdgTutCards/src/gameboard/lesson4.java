/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import gui.lessons.lessonsScreen;
import cards.lib.Card;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class lesson4 implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    }

    @Override
    public void run() {
       /* In this lesson,the user is taught how tricks work.
         * N,E,S,W is allowed to win the trick.
         * Cards are shuffled each time this lesson is opened.
        */
        
        //variables
        final int lessonNum=4;
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
        JOptionPane.showMessageDialog(null, "We are now learning:\nHow to Win a Trick.\n\nThe player that plays the highest value of the suit that is currently in play\nwins the trick for themself and their partner.", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your partner is the person that is seated across you in the game.\nNorth and South are partners.\nWest and East are partners.", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(null, "To complete the lesson successfully,you must win a trick for anyone of the players.", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, suit+" is the generated suit of choice for each of the 4 rounds.\nNorth plays first.", "Random Suit to Follow", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
        /*The user has to win a trick for each player,i.e North,east,south,west
         * 
        */
        
        
        
        
        
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
        
        
        //Check the arraylist for player with highest card value of same suit played
        
        
        JOptionPane.showMessageDialog(null, game.evalTrickWinner(), "Trick Winner", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "A trick has been won.\nLesson Complete!", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        //Take player back to lesson menu
        JOptionPane.showMessageDialog(null, "Don't forget to come back and replay the lesson.\nThe shuffling of the cards each time you come back to this lesson can yield some different outcomes!", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose(); 
    }
}
