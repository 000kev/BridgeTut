/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;

import cards.lib.Card;
import gameboard.GameBoard;
import java.awt.event.MouseEvent;
import players.lib.Player;

/**
 *
 * @author kevin
 */
public class NorthTurnState implements State {
    
    private boolean turn;
    private GameBoard context;
    private boolean has_played;
    
    public NorthTurnState(GameBoard ctxt) {
        context=ctxt;
        turn = true;
        has_played = false;
    }
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        if (validAction()) {
            has_played=true;
            card.setBounds(700, 300, 87, 132); 
            System.out.println("NORTH: "+card+" has moved positions");
        }
        else System.out.println("Invalid action");
    }
    
    @Override
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
        userAction(evt, card);
        context.scoreNorth(card);
    }

    @Override
    public void onSouthAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public void onEastAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public void onWestAction(MouseEvent evt, Card card) {
        System.out.println("Locked");
    }

    @Override
    public Player getPlayer() {
        return context.getNorth();
    }
    
    @Override
    public boolean hasPlayed() {
        return has_played;
    }
}
