/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;

import cards.lib.Card;

/**
 *
 * @author kevin
 */
public class NorthTurnState implements State {
    
    private boolean turn;
    
    public NorthTurnState() {
        turn = true;
    }
    
    public void Tester(java.awt.event.MouseEvent evt, Card card) {
        if (validAction()) {
            card.setBounds(700, 300, 87, 132); 
            System.out.println("NORTH: "+card+" has moved positions");
        }
    }
    
    public boolean validAction() {
        return turn;
    }
    
}
