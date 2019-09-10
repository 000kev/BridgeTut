/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import gui.lessons.lessonsScreen;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class lesson2 implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }

    @Override
    public void run() {
         /*
         * Here the user will have to select the order of cards from lowest to highest to successfully complete the lesson.
         * The purpose of this lesson is to teach the user the ranking of cards
         */
        
        final int lessonNum=2;
        
        //Random gen-used to ask the user for either highest or lowest value card in a hand of cards.
        Random random=new Random();
        int val=random.nextInt(2);
        String ranking=""; //If the computer requires highest value card or lowest value card.
        String correctAns="";//used for checking if the user's answer is correct or not.
        
        //Gui setup
        GameBoard game=new GameBoard(lessonNum);
        game.setVisible(true);
        
        
        if (val==0) {
            ranking="Highest";
        }
        else if(val==1){
            ranking="Lowest";
        }
        
        
        
        
        
        //Info for the user
        JOptionPane.showMessageDialog(null, "Select the card with the "+ranking+" ranking.\nIf they are 2 suits with same value, just select one of them.", "Card Ranks", JOptionPane.INFORMATION_MESSAGE);
        game.setState(game.getSouthState());
        
        //runs the cards component of the game
        while (game.roundComplete()==false) {            
                if (game.getSouthState().hasPlayed()==true) {
                
                game.roundComplete();
                break;
                
            }
        }//while close
        
        //Evaluate the player's choice
        correctAns=game.evalCardRankings(ranking);
        String parts[]=correctAns.split(",");
        String high=parts[0];
        String low=parts[1];
        
        
        String userAns=game.getSelectedCardVal()+"";
        
        String suitVal="";
        
        if (high.equalsIgnoreCase("14")) {
            suitVal="(Ace)";
        }
        else if(high.equalsIgnoreCase("13")){
            suitVal="(King)";
        }
        else if(high.equalsIgnoreCase("12")){
            suitVal="(Queen)";
        }
        else if(high.equalsIgnoreCase("11")){
            suitVal="(Jack)";
        }
        
        
        JOptionPane.showMessageDialog(null, userAns);
        
        if (ranking.equalsIgnoreCase("highest")) {
                if (userAns.equalsIgnoreCase(high)) {
                    JOptionPane.showMessageDialog(null, "You have selected the correct card.\nWell done!", "Correct", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You did not select the "+ranking+" card.\nThe correct highest value was "+high+" "+suitVal, "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                }
        }
        else if(ranking.equalsIgnoreCase("Lowest")){
            if (userAns.equalsIgnoreCase(low)) {
                    JOptionPane.showMessageDialog(null, "You have selected the correct card.\nWell done!", "Correct", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You did not select the "+ranking+" card.\nThe correct lowest value was "+low, "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                }
        }
        
        
        
        
        
        new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose(); 
    }
    
    
    
    
}
