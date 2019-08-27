/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;

import cards.lib.Card;
import java.awt.event.MouseEvent;

/**
 *
 * @author kevin
 */
public class EastTurnState implements State{ 
    
    private boolean turn = true;
    
    public EastTurnState() {
        turn = true;
    }
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        if (validAction()) {
            card.setBounds(650, 300, 87, 132);
            System.out.println("EAST: "+card+" has moved positions");
        }
        else System.out.println("Invalid action");
    }
    
    public boolean validAction() {
        return turn;
    }

    @Override
    public void setTurn(boolean flag) {
        turn = flag;
    }
    
    @Override
    public boolean getTurn() {
        return turn;
    }
    
    @Override
    public void onNorthAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public void onSouthAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public void onEastAction(MouseEvent evt, Card card) {
        userAction(evt, card);
    }

    @Override
    public void onWestAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }
}
