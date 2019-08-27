/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;
import cards.lib.*;
import java.util.ArrayList;
import players.lib.*;
import java.util.Random;
import players.ui.*;

/**
 *
 * @author kevin
 */
public class GameBoard extends javax.swing.JFrame {

    
    // Variables declaration - do not modify 
    private static java.awt.Panel panel1;
    private static North north; private static State north_state;
    private static South south; private static State south_state;
    private static East east; private static State east_state;
    private static West west; private static State west_state;
    
    private static State current_state;
    // End of variables declaration 
    
    /**
     * Creates new form board
     */
    public GameBoard() {
        north = new North(); north_state = new NorthTurnState();
        south = new South(); south_state = new SouthTurnState();
        east = new East(); east_state = new EastTurnState();
        west = new West(); west_state = new WestTurnState();
        current_state = north_state;
        
        initDeck();
        initComponents();
    }
    
    private void addHand(Player player) {
        Hand hand = player.getHand();
        for (int i=0; i<13; i++) {
            panel1.add(hand.getCard(i));
            addMouseListener(player, hand.getCard(i));
        }
    }
    
    private void addMouseListener(Player player, Card card) {
        switch (player.getClass().toString()) {
                case "class players.lib.North":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //north_state.userAction(evt, card);
                            onNorthAction(evt, card);
                        }
                    });
                    break;
                case "class players.lib.South":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //south_state.userAction(evt, card);
                            onSouthAction(evt, card);
                        }
                    });
                    break;
                case "class players.lib.East":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //east_state.userAction(evt, card);
                            onEastAction(evt, card);
                        }
                    });
                    break;
                case "class players.lib.West":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //west_state.userAction(evt, card);
                            onWestAction(evt, card);
                        }
                    });
            }
    }

    private void initDeck() {
         /* Shuffle the deck and deal the cards */
        Deck deck = new Deck();
        deck.shuffle(new Random());
      
        /* Deal hand to each of the players (N,S,E,W) */
   
        while (!deck.isEmpty()) {
            north.dealHand(deck.removeTop());
            south.dealHand(deck.removeTop());
            east.dealHand(deck.removeTop());
            west.dealHand(deck.removeTop());
        }
    }
    
    private void initComponents() {
        
        panel1 = new java.awt.Panel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(44, 107, 16));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.gray);
        setPreferredSize(new java.awt.Dimension(6000, 4500));
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(47, 144, 27));
        panel1.setLayout(null);
        
        addHand(north); north.setBounds();
        
        addHand(south); south.setBounds();
        
        addHand(east); east.setBounds();
        
        addHand(west); west.setBounds();
        
        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1300, 710);

        pack();
    }// </editor-fold>   
    
    
    /* state tools */
    public void setState(State state) {
        current_state = state;
    }
    
    public State getNorth() {
        return north_state;
    }
    
    public State getSouth() {
        return south_state;
    }
    
    public State getEast() {
        return east_state;
    }
    
    public State getWest() {
        return west_state;
    }
    
    private void onNorthAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        current_state.onNorthAction(evt, card);
    }
    
    private void onSouthAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        current_state.onSouthAction(evt, card);
    }
    
    private void onEastAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        current_state.onEastAction(evt, card);
    }
    
    private void onWestAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        current_state.onWestAction(evt, card);
    }
}
