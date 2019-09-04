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
    private static int trump_suit;
    // End of variables declaration 
    
    
    /**
     * Creates new form board
     */
    public GameBoard() {
        north = new North(); north_state = new NorthTurnState(this,east_state); north_score = new NorthScore(north);
        south = new South(); south_state = new SouthTurnState(this,west_state); south_score = new SouthScore(south);
        east = new East(); east_state = new EastTurnState(this,south_state); east_score = new EastScore(east);
        west = new West(); west_state = new WestTurnState(this,north_state); west_score = new WestScore(west);
        
        playedCards = new ArrayList<>();
        north_score.initTrick(this);
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
                            if (north_score.isTrump()) 
                                trump_suit = card.getSuit();
                            onNorthAction(evt, card);
                        }
                    });
                    break;
                case "class players.lib.South":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //south_state.userAction(evt, card);
                            if (south_score.isTrump()) 
                                trump_suit = card.getSuit();
                            onSouthAction(evt, card);
                        }
                    });
                    break;
                case "class players.lib.East":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //east_state.userAction(evt, card);
                            if (east_score.isTrump()) 
                                trump_suit = card.getSuit();
                            onEastAction(evt, card);
                        }
                    });
                    break;
                case "class players.lib.West":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //west_state.userAction(evt, card);
                            if (west_score.isTrump()) 
                                trump_suit = card.getSuit();
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
    public static void setState(State state) {
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
        north_score.setCard(card);
        if (north_score.isTrump()) 
                trump_suit = card.getSuit();
    }
    
    private void onSouthAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        
        current_state.onSouthAction(evt, card);
        south_score.setCard(card);
        if (south_score.isTrump()) 
                trump_suit = card.getSuit();
    }
    
    private void onEastAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        
        current_state.onEastAction(evt, card);
        east_score.setCard(card);
        if (east_score.isTrump()) 
                trump_suit = card.getSuit();
    }
    
    private void onWestAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        
        current_state.onWestAction(evt, card);
        west_score.setCard(card);
        if (west_score.isTrump()) 
                trump_suit = card.getSuit();
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

    // method uses if's to control the flow of play
    public void play() {
            
            if (current_state==north_state) {
                
                if (current_state.hasPlayed()) {
                    setState(east_state);
                }
            }
            else if (current_state==south_state) {
                
                if (current_state.hasPlayed()) {
                    setState(west_state);
                }
            }
            else if (current_state==east_state) {
                
                if (current_state.hasPlayed()) {
                    setState(south_state);
                }
            }
            else if (current_state==west_state) {
                
                if (current_state.hasPlayed()) {
                    setState(north_state);
                }
            }
    }
    
    
    public void tallyRound() {
        int n = north_score.getCard().getValue();
        int s = south_score.getCard().getValue();
        int e = east_score.getCard().getValue();
        int w = west_score.getCard().getValue();
        
        System.out.println("N: "+n);
        System.out.println("E: "+e);
        System.out.println("S: "+s);
        System.out.println("W: "+w);
        
        if (n==1) {
            System.out.println("North wins the trick");
            north.wonRound();
            newRound();
            north_score.initTrick(this);
            current_state=north_state;
        }
        else if (s==1) {
            System.out.println("South wins the trick");
            south.wonRound();
            newRound();
            south_score.initTrick(this);
            current_state=south_state;
        }
        else if (e==1) {
            System.out.println("East wins the trick");
            east.wonRound();
            newRound();
            east_score.initTrick(this);
            current_state=east_state;
        }
        else if (w==1){
            System.out.println("West wins the trick");
            west.wonRound();
            newRound();
            west_score.initTrick(this);
            current_state=west_state;
        }
        else {
            if (n>s && n>e && n>w) {
                System.out.println("North wins the trick");
                north.wonRound();
                newRound();
                north_score.initTrick(this);
                current_state=north_state;
            }
            else if (s>n && s>e && s>w) {
                System.out.println("South wins the trick");
                south.wonRound();
                newRound();
                south_score.initTrick(this);
                current_state=south_state;
            }
            else if (e>n && e>s && e>w) {
                System.out.println("East wins the trick");
                east.wonRound();
                newRound();
                east_score.initTrick(this);
                current_state=east_state;
            }
            else if (w>n && w>s && w>e) {
                System.out.println("West wins the trick");
                west.wonRound();
                newRound();
                west_score.initTrick(this);
                current_state=west_state;
            }
        }
    }
    
    public boolean validAction(Hand hand, Card card) {
        if (card.getSuit()==trump_suit) return true;
        else for (int i=0; i<hand.getCardCount(); i++) {
            if (hand.getCard(i).getSuit()==trump_suit) return false;
        }
        return true;
    }
    
    public boolean roundComplete() {
        return north_state.hasPlayed() && south_state.hasPlayed()
               && east_state.hasPlayed() && west_state.hasPlayed();
    }
    
    public boolean gameOver() {
        if (current_state.getPlayer().getHand().getCardCount()==0) {
            System.out.println("GAME OVER");
            return true;
        }
        else return false;
    }
    
    
    private void newRound() {
        System.out.println("Next round");
        
        Card n = north_score.getCard(); n.setVisible(false);
        Card s = south_score.getCard(); s.setVisible(false);
        Card e = east_score.getCard(); e.setVisible(false);
        Card w = west_score.getCard(); w.setVisible(false);
        
        playedCards.add(n); north.removeCard(n);
        playedCards.add(s); south.removeCard(s);
        playedCards.add(e); east.removeCard(e); 
        playedCards.add(w); west.removeCard(w); 
           
        north_score = new NorthScore(north);
        south_score = new SouthScore(south);
        east_score = new EastScore(east);
        west_score = new WestScore(west);
        
        north_state = new NorthTurnState(this);
        south_state = new SouthTurnState(this);
        east_state = new EastTurnState(this);
        west_state = new WestTurnState(this);
        
    }
}
