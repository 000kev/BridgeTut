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
public class WestTurnState implements State{
    
    private boolean turn = true;
    private boolean has_played;
    private static GameBoard context;
    private int cardVal;
    private int suitVal;
    private int trump;
    private int selectedSuit; //This is going to hold the value of the suit from a card that the user selects
    private Card selectedCard;
    private int numOfCardsPlayed=0;
    
    public WestTurnState() {
        has_played=false;
    }
    public WestTurnState(GameBoard context) {
        this.context = context;
        has_played=false;
    }

    public WestTurnState(int suitVal) {
        this.suitVal=suitVal;
        turn = true;
        has_played = false;
    }
    
    @Override
    public boolean hasPlayed() {
        return has_played;
    }
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        Hand hand = context.getWest().getHand();
        if (context.validAction(hand, card) && has_played==false) {
            card.setBounds(550, 300, 87, 132);
            System.out.println("WEST: "+card+" has moved positions");
            has_played=true;
            has_played=true;
            selectedCard=card;
            this.cardVal=card.getValue();
            this.selectedSuit=card.getSuit();
        }
        else System.out.println("Invalid action");
    }
    
    @Override
    public boolean validAction() {
        return turn;
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
        System.out.println("Locked");
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
        userAction(evt, card);
    }

    @Override
    public Player getPlayer() {
        return context.getWest();
    }

    //Ishaan's methods
    //used in lessons
    public void userActionCustomCard(java.awt.event.MouseEvent evt, Card card) {
        
        if (numOfCardsPlayed<1) {
            
            if (validAction()) {
                
                if (card.getSuit()!=suitVal) {
                    JOptionPane.showMessageDialog(null, "You have to select a card that contains the suit "+card.getGivenSuitAsString(suitVal), "Incorrect Suit", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    numOfCardsPlayed++;
                        //JOptionPane.showMessageDialog(null, "Number of cards played variable "+numOfCardsPlayed);
                        card.setBounds(550, 300, 87, 132);
                        System.out.println("WEST: "+card+" has moved positions");
                        JOptionPane.showMessageDialog(null, "West has played the final suit of " +card.getSuitAsString(), "Last to play", JOptionPane.INFORMATION_MESSAGE);
                        //JOptionPane.showMessageDialog(null, "Last player has played a" +card.getSuitAsString(), "Done playing", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "You cannot select anymore cards.");
            //numOfCardsPlayed=2;
        }
        
        
    }
    
    public void userActionCustomCardTrumps(java.awt.event.MouseEvent evt, Card card) { //method used during trumps
        
        if (numOfCardsPlayed<1) {
            
            if (validAction()) {
                
                if (card.getSuit()!=suitVal||card.getSuit()!=trump) {
                    JOptionPane.showMessageDialog(null, "You have to select a card that contains the suit "+card.getGivenSuitAsString(suitVal)+"\nOr play a card that contains trump suit "+card.getGivenSuitAsString(trump), "Incorrect Suit", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    numOfCardsPlayed++;
                        //JOptionPane.showMessageDialog(null, "Number of cards played variable "+numOfCardsPlayed);
                        card.setBounds(550, 300, 87, 132);
                        System.out.println("WEST: "+card+" has moved positions");
                        JOptionPane.showMessageDialog(null, "West has played the final suit of " +card.getSuitAsString(), "Last to play", JOptionPane.INFORMATION_MESSAGE);
                        //JOptionPane.showMessageDialog(null, "Last player has played a" +card.getSuitAsString(), "Done playing", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "You cannot select anymore cards.");
            //numOfCardsPlayed=2;
        }   
    }

    //For the lessons
    @Override
    public void onNorthAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is West's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    //For the lessons
    @Override
    public void onSouthAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is West's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    //For the lessons
    @Override
    public void onEastAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is West's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void onWestAction(MouseEvent evt, Card card,int lessonNum) {
        
        if (lessonNum==6) {
                userAction(evt, card);
           }
        else if(lessonNum==8){
            userActionCustomCardTrumps(evt, card);
        }
        else {
                userActionCustomCard(evt, card);
            }
    }

    //get the selected Card object
    @Override
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
}
