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
public class WestTurnState implements State{
    
    private boolean turn = true;
    private boolean has_played;
    private static GameBoard context;
    private static State next;
    
    public WestTurnState() {
        has_played=false;
        next=context.getNorthState();
    }
    public WestTurnState(GameBoard context) {
        this.context = context;
        has_played=false;
        next=context.getNorthState();
    }
    public WestTurnState(GameBoard context, State next) {
        this.context = context;
        has_played=false;
        this.next=next;
    }
    
    @Override
    public boolean hasPlayed() {
        return has_played;
    }
    
    @Override
    public void userAction(java.awt.event.MouseEvent evt, Card card) {
        Hand hand = context.getWest().getHand();
        if (context.validAction(hand, card) && has_played==false) {
            card.setBounds(550, 300, 87, 132);
            System.out.println("WEST: "+card+" has moved positions");
            has_played=true;
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
        System.out.println("Locked");
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
        userAction(evt, card);
    }

    @Override
    public Player getPlayer() {
        return context.getWest();
    }

    @Override
    public State getNext() {
        return next;
    }
}
