/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.lib;
import cards.lib.*;

/**
 *
 * @author kevin
 */
public interface Player {
    
    public void setBounds();
    
    public void addCards();
    
    public void dealHand(Card card);
    
    public Player assignTeam();
    
    public Card getCard(int index);
    
    public Hand getHand();
}
