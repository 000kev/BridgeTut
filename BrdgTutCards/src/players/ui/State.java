/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;
import cards.lib.Card;
import players.lib.*;

/**
 *
 * @author kevin
 */
public interface State {
    
    public void userAction(java.awt.event.MouseEvent evt, cards.lib.Card card);
    
    public boolean validAction();
    
    public boolean getTurn();
    
    public void setTurn(boolean turn);
    
    public void onNorthAction(java.awt.event.MouseEvent evt, cards.lib.Card card);
    
    public void onSouthAction(java.awt.event.MouseEvent evt, cards.lib.Card card);
    
    public void onEastAction(java.awt.event.MouseEvent evt, cards.lib.Card card);
    
    public void onWestAction(java.awt.event.MouseEvent evt, cards.lib.Card card);
    
    public Player getPlayer();
    
    public boolean hasPlayed();

    /* Ishaan's section */
    
    public Card getCard();
    
    public int getCardVal(); //returns the a value of the card that has been selected by player
    
    public int getSuitVal(); //returns the a value of the suit of the  card that has been selected by player
    
    public void setTrump(int trumpVal); //set the trump value

    public void onWestAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum); //Method used during the lessons 

    public void onEastAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum);

    public void onSouthAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum);

    public void onNorthAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum);
    
}
