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
public class SouthTurnState implements State {
    
    public void Tester(java.awt.event.MouseEvent evt, Card card) {
        card.setBounds(600, 300, 87, 132);
        System.out.println("SOUTH: "+card+" has moved positions");
    }
}
