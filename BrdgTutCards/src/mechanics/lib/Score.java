/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.lib;

import cards.lib.Card;

/**
 *
 * @author kevin
 */
public interface Score {
    
    public void initTrick();
    
    public void initTrick(gameboard.GameBoard context);
    
    public void wonTrick();
    
    public void calcScore();
    
    public int tallyRound();
    
    public Card getCard();
}
