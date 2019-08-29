/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.lib;

import cards.lib.Card;
import gameboard.GameBoard;

/**
 *
 * @author kevin
 */
public class SouthScore implements Score {
    
    private static Card card;
    
    public SouthScore() {
        card = new Card();
    }
    
    public SouthScore(Card card) {
        this.card = card;
    }

    @Override
    public void initTrick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initTrick(GameBoard context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void wonTrick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tallyRound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Card getCard() {
        return card;
    }
}
