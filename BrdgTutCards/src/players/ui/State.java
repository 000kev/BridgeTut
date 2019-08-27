/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;


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
}
