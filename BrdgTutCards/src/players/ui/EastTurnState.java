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
public class EastTurnState implements State{ 
    
    private boolean turn = true;
    private boolean has_played;
    private static GameBoard context;
    private static State next;

    private int selectedSuit;
    private int cardVal;
    private int suitVal;
    private int trump;
    private int numOfCardsPlayed=0;
    private Card selectedCard;
    
    public EastTurnState() {
        has_played = false;
        next=context.getSouthState();
    }

    public EastTurnState(int suitVal) {
        this.suitVal=suitVal;
        turn = true;
        has_played = false;
    }
    
    public EastTurnState(GameBoard context) {
        this.context = context;
        has_played = false;
        next=context.getSouthState();
    }
    
    
    @Override
    public boolean hasPlayed() {
        return has_played;
    }
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        Hand hand = context.getEast().getHand();
        if (context.validAction(hand, card) && has_played==false) {
            card.setBounds(650, 300, 87, 132);
            System.out.println("EAST: "+card+" has moved positions");
            has_played=true;

            selectedCard=card;
            this.cardVal=card.getValue();
            this.selectedSuit=card.getSuit();   
        }
        else System.out.println("Invalid action");
    }
    
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
        userAction(evt, card);
    }

    @Override
    public void onWestAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public Player getPlayer() {
        return context.getEast();
    }

    //Ishaan's methods
    //it takes the suit input that is randomly generated in lesson
    public void userActionCustomCard(java.awt.event.MouseEvent evt, Card card) {
        
        if (numOfCardsPlayed<1) {
                if (validAction()) {
                    
                    
                        if (card.getSuit()!=suitVal) {
                        
                        JOptionPane.showMessageDialog(null, "You have to select a card that contains the suit "+card.getGivenSuitAsString(suitVal), "Incorrect Suit", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                             numOfCardsPlayed++;
                            //JOptionPane.showMessageDialog(null, "Number of cards played variable "+numOfCardsPlayed);
                            card.setBounds(650, 300, 87, 132);
                            System.out.println("EAST: "+card+" has moved positions");

                            
                            JOptionPane.showMessageDialog(null, "South plays a " +card.getSuitAsString()+" next", "Next to play", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "You cannot select anymore cards.\nIt is South turn to play.");
            //numOfCardsPlayed=2;
        }
        
        
    }
    //end of custom

    //For the lessons
    @Override
    public void onNorthAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is East's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    //For the lessons
    @Override
    public void onSouthAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
        JOptionPane.showMessageDialog(null, "It is East's turn to play ", "Who Plays?", JOptionPane.INFORMATION_MESSAGE);
    }

    //For the lessons
    @Override
    public void onWestAction(MouseEvent evt, Card card,int lessonNum) {
        System.out.println("Locked");
    }

    @Override
    public void onEastAction(MouseEvent evt, Card card,int lessonNum) {
        
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
    
    public void userActionCustomCardTrumps(java.awt.event.MouseEvent evt, Card card) {
        
        if (numOfCardsPlayed<1) {
                if (validAction()) {
                    
                    
                        if (card.getSuit()!=suitVal||card.getSuit()!=trump) {
                        
                        JOptionPane.showMessageDialog(null, "You have to select a card that contains the suit "+card.getGivenSuitAsString(suitVal)+"\nOr play a card that contains trump suit "+card.getGivenSuitAsString(trump), "Incorrect Suit", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                             numOfCardsPlayed++;
                            //JOptionPane.showMessageDialog(null, "Number of cards played variable "+numOfCardsPlayed);
                            card.setBounds(650, 300, 87, 132);
                            System.out.println("EAST: "+card+" has moved positions");

                            
                            JOptionPane.showMessageDialog(null, "South plays a " +card.getSuitAsString()+" next", "Next to play", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "You cannot select anymore cards.\nIt is South turn to play.");
            //numOfCardsPlayed=2;
        }
    }

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
