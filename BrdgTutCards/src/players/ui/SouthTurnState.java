/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players.ui;

import cards.lib.Card;
import cards.lib.Hand;
import gameboard.GameBoard;
import java.awt.event.MouseEvent;
import players.lib.Player;

/**
 *
 * @author kevin
 */
public class SouthTurnState implements State {
    
    private boolean turn;
    private boolean has_played;
    private static GameBoard context;
    private static State next;
    
    public SouthTurnState() {
        has_played = false;
        next = context.getWestState();
    }
    public SouthTurnState(GameBoard cxt) {
        has_played = false;
        context = cxt;
        next = context.getWestState();
    }
    public SouthTurnState(GameBoard cxt, State next) {
        has_played = false;
        context = cxt;
        this.next = next;
    }
    
    @Override
    public boolean hasPlayed() {
        return has_played;
    }
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        Hand hand = context.getSouth().getHand();
        if(context.validAction(hand, card) && has_played==false) {
            card.setBounds(600, 300, 87, 132);
            System.out.println("SOUTH: "+card+" has moved positions");
            has_played=true;
        }
        else System.out.println("Invalid action");
    }
    
    @Override
    public boolean validAction() {
        //context.getNorthState(
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
        userAction(evt, card);
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
        return context.getSouth();
    }

    @Override
    public State getNext() {
        return next;
    }
}
