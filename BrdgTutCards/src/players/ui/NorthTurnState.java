/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;

import cards.lib.Card;
import cards.lib.Hand;
import gameboard.GameBoard;
import java.awt.event.MouseEvent;
import players.lib.Player;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class NorthTurnState implements State {
    
    private boolean turn;
    private GameBoard context;
    private boolean has_played;
    private static State next;

    private int selectedSuit;
    private int cardVal;
    private int suitVal;
    private int numOfCardsPlayed=0;
    private Card selectedCard;
    private int trump=0;
    private boolean cardPlayed=false;
    
    public NorthTurnState() {
        has_played = false;
        next=context.getEastState();
    }
    
    public NorthTurnState(GameBoard context) {
        this.context=context;
        has_played = false;
        next=context.getEastState();
    }
    
    public NorthTurnState(int suitVal) {
        this.suitVal=suitVal;
        turn = true;
        has_played = false;
    }   
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        Hand hand = context.getNorth().getHand();
        if (context.validAction(hand, card) && has_played==false) {
            card.setBounds(700, 300, 87, 132); 
            System.out.println("NORTH: "+card+" has moved positions");
            has_played=true;
            cardPlayed=true;
            this.cardVal=card.getValue();        
            this.selectedSuit=card.getSuit();
        }
        else System.out.println("Invalid action");
    }
    

    @Override
    public void setTurn(boolean flag) {
        turn = flag;
    }
    
    @Override
    public boolean getTurn() {
        return turn;
    }

    @Override
    public void onNorthAction(MouseEvent evt, Card card) {
        userAction(evt, card);
    }

    @Override
    public void onSouthAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public void onEastAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public void onWestAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public Player getPlayer() {
        return context.getNorth();
    }
    
    @Override
    public boolean hasPlayed() {
        return has_played;
    }

    @Override
    public boolean validAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    //Ishaan's methods
    public void userActionCustomCard(java.awt.event.MouseEvent evt, Card card) {
        
        if (numOfCardsPlayed<1) {
                if (validAction()) {  
                    
                    
                        if (card.getSuit()!=suitVal) {
                            
                            JOptionPane.showMessageDialog(null, "You have to select a card that contains the suit "+card.getGivenSuitAsString(suitVal), "Incorrect Suit", JOptionPane.INFORMATION_MESSAGE);
                            
                            
                        }
                        else{
                            numOfCardsPlayed++;
                            //JOptionPane.showMessageDialog(null, "Number of cards played variable "+numOfCardsPlayed);
                            card.setBounds(700, 300, 87, 132); 
                            System.out.println("NORTH: "+card+" has moved positions");
                            
                            JOptionPane.showMessageDialog(null, "East plays a " +card.getSuitAsString()+" next", "Next to play", JOptionPane.INFORMATION_MESSAGE);
                            //extra stuff
                            cardPlayed=true;
                            has_played=true;
                            
                            this.cardVal=card.getValue();
                            this.selectedSuit=card.getSuit();
                        }
                        
                }
                else{
                    System.out.println("Invalid action");
                }
                
            
        }
        else{
            JOptionPane.showMessageDialog(null, "You cannot select anymore cards.\nIt is East turn to play.");
          
        }  
    }
    //end of hearts method
    
    
    public void userActionCustomCardTrumps(java.awt.event.MouseEvent evt, Card card) {
        
        if (numOfCardsPlayed<1) {
                if (validAction()) {  
                    
                    
                        if (card.getSuit()!=suitVal||card.getSuit()!=this.
                                trump) {
                            
                            JOptionPane.showMessageDialog(null, "You have to select a card that contains the suit "+card.getGivenSuitAsString(suitVal)+"\nOr play a card that contains trump suit "+card.getGivenSuitAsString(trump), "Incorrect Suit", JOptionPane.INFORMATION_MESSAGE);
                            
                            
                        }
                        else{
                            numOfCardsPlayed++;
                            //JOptionPane.showMessageDialog(null, "Number of cards played variable "+numOfCardsPlayed);
                            card.setBounds(700, 300, 87, 132); 
                            System.out.println("NORTH: "+card+" has moved positions");
                            
                            JOptionPane.showMessageDialog(null, "East plays a " +card.getSuitAsString()+" next", "Next to play", JOptionPane.INFORMATION_MESSAGE);
                            //extra stuff
                            cardPlayed=true;
                            has_played=true;
                            
                            this.cardVal=card.getValue();
                            this.selectedSuit=card.getSuit();
                        }
                        
                }
                else{
                    System.out.println("Invalid action");
                }
                
            
        }
        else{
            JOptionPane.showMessageDialog(null, "You cannot select anymore cards.\nIt is East turn to play.");
          
        }
  
    }
    //end of hearts method
   
    //Ihaan's own method
    
    public boolean alreadyPlayed(){
        return cardPlayed;
    }

    @Override
    public void onNorthAction(MouseEvent evt, Card card,int lessonNum) {
        //Will use lesson number to make use the required userAction method 
        if (lessonNum==6) {
            userAction(evt, card);
       }
        else if(lessonNum==8){
            userActionCustomCardTrumps(evt, card);
        }
        else{
            userActionCustomCard(evt, card);
        }

    }

    public Card getCard() {
        return selectedCard;
    }
    
    @Override
    public int getCardVal(){
        return cardVal;
        
    }
    
    @Override
    public int getSuitVal(){
        return selectedSuit;
    }
    
    @Override
    public void setTrump(int trumpVal){
        this.trump=trumpVal;
    }

    //method used in lessons
    @Override
    public void onSouthAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is North's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    //method used in lessons
    @Override
    public void onEastAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is North's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    //method used in lessons
    @Override
    public void onWestAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is North's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

}
