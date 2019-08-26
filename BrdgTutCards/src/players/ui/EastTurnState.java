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
public class EastTurnState implements State{ 
    
    private boolean turn = true;
    
    public EastTurnState() {
        turn = false;
    }
    
    public void Tester(java.awt.event.MouseEvent evt, Card card) {
        if (validAction()) {
            card.setBounds(650, 300, 87, 132);
            System.out.println("EAST: "+card+" has moved positions");
        }
        else System.out.println("Invalid action");
    }
    
    public boolean validAction() {
        return turn;
    }
}
