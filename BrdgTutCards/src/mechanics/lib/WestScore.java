/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.lib;

import cards.lib.Card;
import gameboard.GameBoard;
import players.lib.West;

/**
 *
 * @author kevin
 */
public class WestScore implements Score {
    
    private static West player;
    private static Card played_card;
    private static GameBoard context;
    public boolean trump;
    
    public WestScore(West west) {
        played_card = new Card();
        trump = false;
        player = west;
    }

    @Override
    public void initTrick(GameBoard context) {
        this.context = context;
        trump = true;
        context.setState(context.getWestState());
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
    public boolean isTrump() {
        return trump;
    }
    
    @Override
    public void setCard(Card card) {
        played_card = card;
    }

    @Override
    public Card getCard() {
        return played_card;
    }
}
