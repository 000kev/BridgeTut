/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import cards.lib.Card;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class lessonFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * This is a lesson that makes use of past lessons
         * It is essentially the culmination of what the user has been taught in the past lessons
         * 
         * Cards are shuffled each time this lesson is opened.
         */
        
        //variables
        final int lessonNum=9;
        int cardSuit=0; //Can randomly generate this so that each time you open the lesson,there is a different suit to follow during the lesson
        String suit; //Will hold the string value of the suit value
        
        boolean validInput=false;//checks if the user has entered a valid difficulty input
        String difficulty=""; //Will store the selected user difficulty
        boolean bestPlayHelp=false;//User either has access to best play or not
        

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
        
        JOptionPane.showMessageDialog(null, "This lesson will make use of the previous tutorial lessons that you have completed.", "Practical Lesson", JOptionPane.INFORMATION_MESSAGE);
        
        
        //The game
        while (validInput==false) {    
                difficulty=JOptionPane.showInputDialog("Select your difficulty:\n1=New to the game\n2=I know how to play");
                difficulty=difficulty.trim();//removes white space on end
                if (difficulty.equalsIgnoreCase("1")||difficulty.equalsIgnoreCase("2")) {
                    validInput=true;
            }
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid Difficulty input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
        }//first while close
        
        
        //checking what to set the difficulty to
        if (difficulty.equalsIgnoreCase("1")) { //Help is given,user has access to Quick High card calculation for bidding and best play is given

            bestPlayHelp=true;
        }
        else if(difficulty.equalsIgnoreCase("2")){//No help for bidding,you can still view best play during the game
            bestPlayHelp=true;
            
        }
        //end

        
        //Play a round and win a trick
        JOptionPane.showMessageDialog(null, "To complete the lesson successfully,you must win a trick for anyone of the players.", "Winning Tricks Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, suit+" is the generated suit of choice for each of the 4 rounds.\nNorth plays first.", "Random Suit to Follow", JOptionPane.INFORMATION_MESSAGE);
        

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




        }//second While loop close
            
            
            JOptionPane.showMessageDialog(null, game.evalTrickWinner(), "Trick Winner", JOptionPane.INFORMATION_MESSAGE);
        
    }//main method close
}
