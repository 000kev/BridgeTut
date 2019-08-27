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
public class South implements Player {
    
   
    private static Hand hand;
    
    public South() {
        hand = new Hand();
    }
    
    @Override
    public void setBounds() {
        int j = 850;
        for (int i=0; i<13; i++) {
            hand.getCard(i).setBounds(j, 550, 87, 132);
            j-=40;
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
}
