/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;
import cards.lib.*;
import players.lib.*;
import players.ui.*;
import mechanics.lib.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class GameBoard extends javax.swing.JFrame {

    
    // Variables declaration - do not modify 
    private static java.awt.Panel panel1;
    
    private static North north; private static State north_state; private static Score north_score;
    private static South south; private static State south_state; private static Score south_score;
    private static East east; private static State east_state; private static Score east_score;
    private static West west; private static State west_state; private static Score west_score;
    
    private static State current_state;
    private static ArrayList<Card> playedCards;
    // End of variables declaration 
    
    
    /**
     * Creates new form board
     */
    public GameBoard() {
        north = new North(); north_state = new NorthTurnState(this); north_score = new NorthScore();
        south = new South(); south_state = new SouthTurnState(); south_score = new SouthScore();
        east = new East(); east_state = new EastTurnState();
        west = new West(); west_state = new WestTurnState();
        
        north_score.initTrick(this);
        playedCards = new ArrayList<>();
        
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
    
    public State getNorthState() {
        return north_state;
    }
    
    public State getSouthState() {
        return south_state;
    }
    
    public State getEastState() {
        return east_state;
    }
    
    public State getWestState() {
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
    
    /* game mechanics */
    
    public Player getNorth() {
        return north;
    }
    
    public Player getSouth() {
        return south;
    }
    
    public Player getEast() {
        return east;
    }
    
    public Player getWest() {
        return west;
    }
    public void scoreNorth(Card card) {
        north_score = new NorthScore(card);
    }
    
    public void scoreSouth(Card card) {
        
    }
    
    public void scoreEast(Card card) {
        
    }
    
    public void scoreWest(Card card) {
        
    }
    
    public void tallyRound() {
        Card n = north_score.getCard();
        Card s = south_score.getCard();
        System.out.println("TALLY: "+n+", "+s);
    }
    
    public boolean roundComplete() {
        return north_state.hasPlayed() && south_state.hasPlayed();
               //& east_state.hasPlayed() && west_state.hasPlayed();
    }
}
