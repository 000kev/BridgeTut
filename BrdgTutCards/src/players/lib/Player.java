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

public class Player {
    
    private Hand hand;
    public Player team;
    
    public Player() {
        hand = new Hand();
        team = null;
    }
    
    public void assignTeam(Player player) {
        team = player;
    }
    
    public void addCard(Card card) {
        hand.addCard(card);
    }
    
    public Card getCard(int index) {
        return hand.getCard(index);
    }
}
