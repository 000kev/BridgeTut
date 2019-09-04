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
public class North implements Player {

    private static Hand hand;
    private static boolean has_played;
    private static int trick;

    
    public North() {
        trick = 0;
        hand = new Hand();
        has_played = false;
    }
    
    @Override
    public void setBounds() {
        int i = 850;
        for (int j=0; j<13; j++) {
            hand.getCard(j).setBounds(i, 50, 87, 132);
            i-=40;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCards() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dealHand(Card card) {
        hand.addCard(card);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player assignTeam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Card getCard(int index) {
        return hand.getCard(index);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    @Override
    public Hand getHand() {
        return hand;
    }
    
    @Override
    public void wonRound() {
        trick++;
    }

    @Override
    public void removeCard(Card card) {
        hand.removeCard(card);
    }
    
}
