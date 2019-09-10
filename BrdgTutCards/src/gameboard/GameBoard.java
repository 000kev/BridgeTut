/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;
import cards.lib.*;
import java.awt.Color;
import players.lib.*;
import players.ui.*;
import mechanics.lib.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class GameBoard extends javax.swing.JFrame {

    
    // Variables declaration - do not modify 
    private static java.awt.Panel panel1;
    private static javax.swing.JPanel pane;
    
    private static North north; private static State north_state; private static Score north_score;
    private static South south; private static State south_state; private static Score south_score;
    private static East east; private static State east_state; private static Score east_score;
    private static West west; private static State west_state; private static Score west_score;
    
    private static State current_state;
    private static ArrayList<Card> playedCards;
    private static int trump_suit;
    private static Memorization memory;
    private static javax.swing.JButton jButton2;
    
    private static javax.swing.JLabel north_tag;
    private static javax.swing.JLabel south_tag;
    // End of variables declaration 

    // Ishaan's variables
    private int lessonNum;
    private int cardSuit;
    private int trump;
    private int cardValue;

    private  int highCardPtsWest=0;
    private int highCardPtsEast=0;
    private int highCardPtsSouth=0;
    private int highCardPtsNorth=0;
    
    
    /**
     * Creates new form board
     */
    public GameBoard() {
        north = new North(); north_state = new NorthTurnState(this); north_score = new NorthScore(north);
        south = new South(); south_state = new SouthTurnState(this); south_score = new SouthScore(south);
        east = new East(); east_state = new EastTurnState(this); east_score = new EastScore(east);
        west = new West(); west_state = new WestTurnState(this); west_score = new WestScore(west);
        
        playedCards = new ArrayList<>();
        north_score.initTrick(this);
        current_state = north_state;
        memory = new Memorization(playedCards);
        
        north_tag = new javax.swing.JLabel(); 
        south_tag = new javax.swing.JLabel();
        
        initDeck();
        initComponents();
        initTags();
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
    
    private void initTags() {
        
        north_tag.setFont(new java.awt.Font("FreeSerif", 1, 24));
        south_tag.setFont(new java.awt.Font("FreeSerif", 1, 24));
        
        north_tag.setForeground(new java.awt.Color(254, 254, 254));
        south_tag.setForeground(new java.awt.Color(254, 254, 254));
        
        north_tag.setText("We: 0");
        south_tag.setText("They: 0");
        
        panel1.add(north_tag);
        panel1.add(south_tag);
    
        north_tag.setBounds(0, 30, 120, 140);
        south_tag.setBounds(0, 60, 120, 140);           
    }
    
    private void initComponents() {
        
        panel1 = new java.awt.Panel();
        pane = new javax.swing.JPanel();
        memory = new Memorization(playedCards);
        panel1.add(pane);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(44, 107, 16));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.gray);
        setPreferredSize(new java.awt.Dimension(6000, 4500));
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(47, 144, 27));
        panel1.setLayout(null);
        
        // Player Hands
        addHand(north); north.setBounds();
        addHand(south); south.setBounds();
        addHand(east); east.setBounds();       
        addHand(west); west.setBounds();
        
        //Hint Pane
        jButton2 = new javax.swing.JButton();
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageAssets/icon.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfoBox(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HidePane(evt);
            }
        });
        jButton2.setBounds(1210, 10, 75, 75);
        
        pane.setBounds(150, 300, 1050, 132);
        pane.setLayout(new javax.swing.BoxLayout(pane, javax.swing.BoxLayout.LINE_AXIS));
        pane.setOpaque(false);
        
        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1300, 710);

        
        panel1.add(jButton2);
        
        pane.setBackground(Color.white);
        pane.setVisible(false);
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
        //playedCards.add(card);
        north_score.setCard(card);
        if (north_score.isTrump()) 
                trump_suit = card.getSuit();
    }
    
    private void onSouthAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        
        current_state.onSouthAction(evt, card);
        //playedCards.add(card);
        south_score.setCard(card);
        if (south_score.isTrump()) 
                trump_suit = card.getSuit();
    }
    
    private void onEastAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        
        current_state.onEastAction(evt, card);
        //playedCards.add(card);
        east_score.setCard(card);
        if (east_score.isTrump()) 
                trump_suit = card.getSuit();
    }
    
    private void onWestAction(java.awt.event.MouseEvent evt, cards.lib.Card card) {
        
        current_state.onWestAction(evt, card);
        //playedCards.add(card);
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
        
        
        if (n==1 && north_score.getCard().getSuit()==trump_suit) {
            System.out.println("North wins the trick");
            JOptionPane.showMessageDialog(panel1, "North wins the trick\nNorth starts next round");
            north.wonRound();
            newRound();
            north_score.initTrick(this);
            current_state=north_state;
        }
        else if (s==1 && south_score.getCard().getSuit()==trump_suit) {
            System.out.println("South wins the trick");
            JOptionPane.showMessageDialog(panel1, "South wins the trick\nSouth starts next round");
            south.wonRound();
            newRound();
            south_score.initTrick(this);
            current_state=south_state;
        }
        else if (e==1 && east_score.getCard().getSuit()==trump_suit) {
            System.out.println("East wins the trick");
            JOptionPane.showMessageDialog(panel1, "East wins the trick\nEast starts next round");
            east.wonRound();
            newRound();
            east_score.initTrick(this);
            current_state=east_state;
        }
        else if (w==1 && west_score.getCard().getSuit()==trump_suit){
            System.out.println("West wins the trick");
            JOptionPane.showMessageDialog(panel1, "West wins the trick\nWest starts next round");
            west.wonRound();
            newRound();
            west_score.initTrick(this);
            current_state=west_state;
        }
        else {
            if ((n>s && n>e && n>w) && north_score.getCard().getSuit()==trump_suit) {
                System.out.println("North wins the trick"); 
                JOptionPane.showMessageDialog(panel1, "North wins the trick\nNorth starts next round");
                north.wonRound();
                newRound();
                north_score.initTrick(this);
                current_state=north_state;
            }
            else if ((s>n && s>e && s>w) && south_score.getCard().getSuit()==trump_suit) {
                System.out.println("South wins the trick");
                JOptionPane.showMessageDialog(panel1, "South wins the trick\nSouth starts next round");
                south.wonRound();
                newRound();
                south_score.initTrick(this);
                current_state=south_state;
            }
            else if ((e>n && e>s && e>w) && east_score.getCard().getSuit()==trump_suit) {
                System.out.println("East wins the trick");
                JOptionPane.showMessageDialog(panel1, "East wins the trick\nEast starts next round");
                east.wonRound();
                newRound();
                east_score.initTrick(this);
                current_state=east_state;
            }
            else if ((w>n && w>s && w>e) && west_score.getCard().getSuit()==trump_suit) {
                System.out.println("West wins the trick");
                JOptionPane.showMessageDialog(panel1, "West wins the trick\nWest starts next round");
                west.wonRound();
                newRound();
                west_score.initTrick(this);
                current_state=west_state;
            }
        }
        int team1 = North.trick+South.trick;
        int team2 = East.trick+West.trick;
        
        north_tag.setText("We: "+ team1);
        south_tag.setText("They: "+ team2);
    }
    
    public boolean validAction(Hand hand, Card card) {
        if (card.getSuit()==trump_suit) return true;
        else for (int i=0; i<hand.getCardCount(); i++) {
            if (hand.getCard(i).getSuit()==trump_suit) {
                JOptionPane.showMessageDialog(panel1, "You must choose a card of the same suit!");
                return false;
            }
        }
        return true;
    }
    
    public boolean roundComplete() {
        return north_state.hasPlayed() && south_state.hasPlayed()
               && east_state.hasPlayed() && west_state.hasPlayed();
    }
    
    public void gameOver() {
        int n = North.trick;
        int s = South.trick;
        int e = East.trick;
        int w = West.trick;
        
        if ((n+s)>(e+w)) {
            JOptionPane.showMessageDialog(panel1, "North & South win the game!");
        }
        else if ((e+w)>(n+s)) {
            JOptionPane.showMessageDialog(panel1, "East & West win the game!");
        }
        else if ((n+s)==(e+w)) {
            JOptionPane.showMessageDialog(panel1, "Draw!");
        }
    }
    
    
    private void newRound() {
        System.out.println("Next round");
        
        Card n = north_score.getCard(); 
        Card s = south_score.getCard(); 
        Card e = east_score.getCard(); 
        Card w = west_score.getCard(); 
        
        playedCards.add(n); north.removeCard(n);
        playedCards.add(s); south.removeCard(s);
        playedCards.add(e); east.removeCard(e); 
        playedCards.add(w); west.removeCard(w); 
        
        ///memory = new Memorization(playedCards);
        
        n.setVisible(false); s.setVisible(false);
        e.setVisible(false); w.setVisible(false);
           
        north_score = new NorthScore(north);
        south_score = new SouthScore(south);
        east_score = new EastScore(east);
        west_score = new WestScore(west);
        
        north_state = new NorthTurnState(this);
        south_state = new SouthTurnState(this);
        east_state = new EastTurnState(this);
        west_state = new WestTurnState(this);
        
    }
    
    /* Card Memorization */
    
    private void InfoBox(java.awt.event.MouseEvent evt) {                         
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Spades", "Diamonds", "Clubs", "Hearts" };
        String initialSelection = "Spades";
        Object selection = JOptionPane.showInputDialog(null, "Which played cards would you like to remember?\n(Press enter once finished)" ,
        "Card Memorization", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        ArrayList<Card> test;
        
        if (selection=="Spades") {
            test=memory.getSpades();
            for (int i=0; i<test.size(); i++) {
            pane.add(test.get(i));
            test.get(i).setVisible(true);
            pane.setVisible(true);
            }
        
        }
        else if (selection=="Diamonds") {
            test=memory.getDiamonds();
            for (int i=0; i<test.size(); i++) {
                pane.add(test.get(i));
                test.get(i).setVisible(true);
                pane.setVisible(true);
            }
        }
        else if (selection=="Hearts") {
            test=memory.getHearts();
            for (int i=0; i<test.size(); i++) {
                pane.add(test.get(i));
                test.get(i).setVisible(true);
                pane.setVisible(true);
            }
        }
        else if (selection=="Clubs") {
            test=memory.getClubs();
            for (int i=0; i<test.size(); i++) {
                pane.add(test.get(i));
                test.get(i).setVisible(true);
                pane.setVisible(true);
            }
        }
    }
    
    private void HidePane(java.awt.event.KeyEvent evt) {                          
        pane.removeAll();
        pane.setVisible(false);
    }
    
    // Ishaan's Lesson's sections
    // LESSONS METHODS
    public GameBoard(int lessonNum) {
         
        this.lessonNum=lessonNum;
        north = new North(); north_state = new NorthTurnState(cardSuit); north_score = new NorthScore(north);
        south = new South(); south_state = new SouthTurnState(cardSuit); south_score = new SouthScore(south);
        east = new East(); east_state = new EastTurnState(cardSuit);
        west = new West(); west_state = new WestTurnState(cardSuit);
        
        north_score.initTrick(this);
        playedCards = new ArrayList<>();
        
     //unshuffled cards passed out
        if (lessonNum==1 || lessonNum==4||lessonNum==5||lessonNum==7||lessonNum==8) {
            initDeck(); //Initialise the card Deck
            initComponents(); //Initialise the game table GUI
            initCardsOnGameBoard();//Set up the required cards on table GUI
        }
        //single cards passed out only
        else if (lessonNum==2) {
            initSinglePlayerCardsDeck(); //shuffle cards and give cards to one player only
            initComponents(); //Setup the Main GUI
            initCardsOnGameBoardLesson2(); //Cards presented to 1 player only GUI
        }
        //shuffled cards passed out
        else if (lessonNum==3 ) {
            initDeckUnshuffled(); //Give unshuffled cards
            initComponents(); //Setup the Main GUI
            initCardsOnGameBoard(); //GUI for the 4 hands of cards on gameboard
        }
        else if (lessonNum==6) {
            initDeck(); //Give shuffled cards
            initComponents(); //Setup the Main GUI
            initCardsOnGameBoardLesson6(); //GUI for the 4 hands of cards on gameboard
        } 
    }
    
    //A constructor that will initialise the gameboard specifically to a specified lesson
    public GameBoard(int lessonNum,int cardSuit){
        
        this.cardSuit=cardSuit; //The randomly generated suit to follow in the lesson
        
        north = new North(); north_state = new NorthTurnState(cardSuit); north_score = new NorthScore(north);
        south = new South(); south_state = new SouthTurnState(cardSuit); south_score = new SouthScore(south);
        east = new East(); east_state = new EastTurnState(cardSuit);
        west = new West(); west_state = new WestTurnState(cardSuit);
        
        north_score.initTrick(this);
        playedCards = new ArrayList<>();
        
        this.lessonNum=lessonNum;
        
        //unshuffled cards passed out
        if (lessonNum==1 || lessonNum==4||lessonNum==5||lessonNum==7||lessonNum==8) {
            initDeck(); //Initialise the card Deck
            initComponents(); //Initialise the game table GUI
            initCardsOnGameBoard();//Set up the required cards on table GUI
        }
        //single cards passed out only
        else if (lessonNum==2) {
            initSinglePlayerCardsDeck(); //shuffle cards and give cards to one player only
            initComponents(); //Setup the Main GUI
            initCardsOnGameBoardLesson2(); //Cards presented to 1 player only GUI
        }
        //shuffled cards passed out
        else if (lessonNum==3 ) {
            initDeckUnshuffled(); //Give unshuffled cards
            initComponents(); //Setup the Main GUI
            initCardsOnGameBoard(); //GUI for the 4 hands of cards on gameboard
        }
        else if (lessonNum==6) {
            initDeck(); //Give shuffled cards
            initComponents(); //Setup the Main GUI
            initCardsOnGameBoardLesson6(); //GUI for the 4 hands of cards on gameboard
        }
    }

    //This is used when lesson number is given as parameter
    private void addMouseListener(Player player,final Card card,final int lessonNum) {
        switch (player.getClass().toString()) {
                case "class players.lib.North":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //north_state.userAction(evt, card);
                            onNorthAction(evt, card,lessonNum);
                        }
                    });
                    break;
                case "class players.lib.South":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //south_state.userAction(evt, card);
                            onSouthAction(evt, card,lessonNum);
                        }
                    });
                    break;
                case "class players.lib.East":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //east_state.userAction(evt, card);
                            onEastAction(evt, card,lessonNum);
                        }
                    });
                    break;
                case "class players.lib.West":
                    card.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            //west_state.userAction(evt, card);
                            onWestAction(evt, card,lessonNum);
                        }
                    });
            }
    }

    private void initDeckUnshuffled() {
         /* deal the cards */
        Deck deck = new Deck();
        //deck.shuffle(new Random());
      
        /* Deal hand to each of the players (N,S,E,W) */
   
        while (!deck.isEmpty()) {
            north.dealHand(deck.removeTop());
            south.dealHand(deck.removeTop());
            east.dealHand(deck.removeTop());
            west.dealHand(deck.removeTop());
        }
    }

    //This is for all shuffling and dealing cards to 1 player
    private void initSinglePlayerCardsDeck(){
        /* Shuffle the deck and deal the cards */
        Deck deck = new Deck();
        deck.shuffle(new Random());
      
        /* Deal hand to South Player only */
   
        while (!deck.isEmpty()) {
            
            south.dealHand(deck.removeTop());
            
        }
    }
    
    //Set the required cards on the board GUI
    private void initCardsOnGameBoard(){
        addHand(north); north.setBounds();
        
        addHand(south); south.setBounds();
        
        addHand(east); east.setBounds();
        
        addHand(west); west.setBounds();
        
        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1300, 710);

        pack();
    }

    //Set the required cards for lesson 6
    private void initCardsOnGameBoardLesson6(){
        
        addHand(north); north.setBounds();
        addHand(south); south.setBounds();
        
        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1300, 710);

        pack();
    }
    
    //Set the required cards for lesson 6
    private void initCardsOnGameBoardLesson2(){
        
     
        addHand(south); south.setBounds();
        
        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 1300, 710);

        pack();
    }

    //New method Ishaan added
    public State getCurrentState(){
        return current_state;
    }

    //method used when a lesson parameter is given
    private void onNorthAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum) {
        current_state.onNorthAction(evt, card,lessonNum);
    }

    //method used when a lesson parameter is given
    private void onSouthAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum) {
        current_state.onSouthAction(evt, card,lessonNum);
    }

    //method used when a lesson parameter is given
    private void onEastAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum) {
        current_state.onEastAction(evt, card,lessonNum);
    }

    //method used when a lesson parameter is given
    private void onWestAction(java.awt.event.MouseEvent evt, cards.lib.Card card,int lessonNum) {
        current_state.onWestAction(evt, card,lessonNum);
    }

    //Additional card methods 
    public Card getNorthCardObj(){ 
        return north_state.getCard();
    }
    
    public Card getEastCardObj(){
        return east_state.getCard();       
    }
    
    
    public Card getSouthCardObj(){
        return south_state.getCard();            
    }
    
    public Card getWestCardObj(){
        return west_state.getCard();          
    }

    public String evalTrickWinner(){ //Returns a String that tells you which player/team won the trick.No Trumps
        
        int arrLVals[]={north_state.getCardVal(),east_state.getCardVal(),south_state.getCardVal(),west_state.getCardVal()};//Hold all the values of the cards selected by N,E,S,W
        
        //Output
        
        
        String trickWinner="";
        
        int high=0;
        int indexHigh=0;//index of the highest card
        
        
        if (north_state.getCardVal()==1) { //CardVal is 1 when ace is selected
            indexHigh=0;
        }
        else{
            for (int i = 0; i < 4; i++) {
                if (arrLVals[i]>high) {
                    high=arrLVals[i];
                    indexHigh=i;
                }
            }
        }
        
        
        
        if (indexHigh==0) {
            trickWinner="Team North and South have won the trick";
        }
        else if(indexHigh==1){
            trickWinner="Team East and West have won the trick";
        }
        else if(indexHigh==2){
            trickWinner="Team South and North have won the trick";
        }
        else if(indexHigh==3){
            trickWinner="Team West and East have won the trick";
        }
        
        return trickWinner;
    }
    
    
    public int evalTrickWinnerVal(){ //Returns a String that tells you which player/team won the trick.No Trumps
        
        int arrLVals[]={north_state.getCardVal(),east_state.getCardVal(),south_state.getCardVal(),west_state.getCardVal()};//Hold all the values of the cards selected by N,E,S,W
        
        //Output
        
        
        String trickWinner="";
        
        int high=0;
        int indexHigh=0;//index of the highest card
        
        
        if (north_state.getCardVal()==1) { //CardVal is 1 when ace is selected
            indexHigh=0;
        }
        else{
            for (int i = 0; i < 4; i++) {
                if (arrLVals[i]>high) {
                    high=arrLVals[i];
                    indexHigh=i;
                }
            }
        }
        
        
        
        return indexHigh;//returns the value of highest 
    }
    
    
    //method that will setTrumps
    public void setTrumpStates(int trumpval){
        //set the trump value for each state
        north_state.setTrump(trumpval);
        south_state.setTrump(trumpval);
        east_state.setTrump(trumpval);
        west_state.setTrump(trumpval);
    }
    
    public String evalTrickWinner(int trumpval){ //Returns a String that tells you which player/team won the trick.This takes into account trump
        
     
        int trump=trumpval; 
        int arrLVals[]={north_state.getCardVal(),east_state.getCardVal(),south_state.getCardVal(),west_state.getCardVal()};//Hold all the values of the cards selected by N,E,S,W
        int arrSuitVals[]={north_state.getSuitVal(),east_state.getSuitVal(),south_state.getSuitVal(),west_state.getSuitVal()};//hold the int values of suits
        //Output
        
        
        String trickWinner="";
        
        int high=0;
        int indexHigh=0;//index of the highest card
        
        
        if (north_state.getCardVal()==1) { //CardVal is 1 when ace is selected
            indexHigh=0;
        }
        else{
            for (int i = 0; i < 4; i++) {
                
                if(arrSuitVals[i]==trump){ //If the selected card suit value is trump suit
                    indexHigh=i;
                }
                
                else if (arrLVals[i]>high) {
                    high=arrLVals[i];
                    indexHigh=i;
                }
            }
        }
        
        
        
        if (indexHigh==0) {
            trickWinner="North Player has won the trick.\nTeam North and South have won the trick";
        }
        else if(indexHigh==1){
            trickWinner="East Player has won the trick.\nTeam East and West have won the trick";
        }
        else if(indexHigh==2){
            trickWinner="South Player has won the trick.\nTeam South and North have won the trick";
        }
        else if(indexHigh==3){
            trickWinner="West Player has won the trick.\nTeam West and East have won the trick";
        }
        
        return trickWinner;
    }
    
    //Setting Trump
    /*Will check the suit of the card selected and see if that suit is found in player's hand and parnters hand,and if there 
     * is 7 cards of that suit in total amoungst both the player's hand and partners hand.
    */
 
    
    
    //get hand of cards for north and then evaluate which suit is most common in hand.This is used for finding trump suit
    public String calcTrump(){
        
        //variables
        String trumpCard="";//will hold index of array at which the largest value is found.This index position corresponds to a suit from Card class.
        int high=0; //used in finding highest value in array
        //array will be as follows [Spades,Hearts,Diamonds,Clubs]
        int arrNumSuitsN[]=new int[4]; //will hold the total number of each suits found in the north hand
        int arrNumSuitsS[]=new int[4];
        
        int arrTotalSuits[]=new int[4];//Will hold the sum of arrNumSuitsN and arrNumSuitsS for each suit found at each index position of the array.
        
        
        Hand handNorth =north.getHand();
        Hand handSouth=south.getHand();
        
        
        
        //initialise array
        for (int i = 0; i < 4; i++) {
            arrNumSuitsN[i]=0;
            arrNumSuitsS[i]=0;
            arrTotalSuits[i]=0;
        }
        
        
            for (int i=0; i<13; i++) {

                Card cardNorth=handNorth.getCard(i);
                Card cardSouth=handSouth.getCard(i);


                //Checking the suits in north hand 
                if (cardNorth.getSuit()==0) { //if card is Spades
                    arrNumSuitsN[0]=arrNumSuitsN[0]+1;
                }
                else if (cardNorth.getSuit()==1) { //if card is Hearts
                    arrNumSuitsN[1]=arrNumSuitsN[1]+1;
                }
                else if (cardNorth.getSuit()==2) {//if card is Diamonds
                    arrNumSuitsN[2]=arrNumSuitsN[2]+1;
                }
                else if (cardNorth.getSuit()==3) { //If card is Clubs
                    arrNumSuitsN[3]=arrNumSuitsN[3]+1;
                }
                
                
                //Checking the suits in South hand 
                if (cardSouth.getSuit()==0) { //if card is Spades
                    arrNumSuitsS[0]=arrNumSuitsS[0]+1;
                }
                else if (cardSouth.getSuit()==1) { //if card is Hearts
                    arrNumSuitsS[1]=arrNumSuitsS[1]+1;
                }
                else if (cardSouth.getSuit()==2) {//if card is Diamonds
                    arrNumSuitsS[2]=arrNumSuitsS[2]+1;
                }
                else if (cardSouth.getSuit()==3) { //If card is Clubs
                    arrNumSuitsS[3]=arrNumSuitsS[3]+1;
                }
                

            }//forloop close
            
            
            for (int i = 0; i < 4; i++) {
                arrTotalSuits[i]=arrNumSuitsN[i]+arrNumSuitsS[i];
                //JOptionPane.showMessageDialog(null, arrTotalSuits[i]+"");
            }
            
            //checking which index in array holds largest number for a suit
            String alternateTrump="";//will hold index position of a possible alternate trump 
            
            for (int i = 0; i < 4; i++) {
                if (arrTotalSuits[i]>high) {  //
                    high=arrTotalSuits[i];
                    trumpCard=i+"";
                }
                else if(arrTotalSuits[i]==high){   //This says that if there are two suits in the player and partner's hand that equal to the same value
                    alternateTrump=i+"";               //Either suit is eligble to be selected as trump 
                }
            }
            
            //trumpCard=trumpCard+","+alternateTrump;
            
            //return index of arrTotalSuits to say which suit should be selected as trump card
            return trumpCard;
            
        }
    
    
    
    
    //Method going to check if the suit the player selected as trump matches the calculated suit for trump card
    public boolean evalPlayerTrump(String suitValue){
       
        boolean correctTrump=false; 
        int suitVal1=0;//Will hold the converted value 
        int suitVal2=0;
        
        ArrayList<Integer>  arrAltTrumps=new ArrayList<>();
        
        
            //Split the String on comma
            if (suitValue.contains(",")) {

                String parts[]=suitValue.split(",");
                suitVal1=Integer.parseInt(parts[0]);
                suitVal2=Integer.parseInt(parts[1]);

                    if (south_state.getSuitVal()==suitVal1||south_state.getSuitVal()==suitVal2) { //checking the value of the suit of the card selected by the player
                            correctTrump=true;
                    }   
                    else{
                        correctTrump=false;
                    }   
            }
            else{
                        suitVal1=Integer.parseInt(suitValue);
                    if (south_state.getSuitVal()==suitVal1) { //checking the value of the suit of the card selected by the player
                    correctTrump=true;
                    }
                    else{
                        correctTrump=false;
                    }
            }
            return correctTrump;
        }
    
    
    //Methods for used during the bidding process.
    
    //This method will check if the high card score of a hand is equal to or greater than 13
    public void calcHighCardValues(){
        //variables
        
        Hand handNorth=north.getHand();
        Hand handEast=east.getHand();
        Hand handSouth=south.getHand();
        Hand handWest=west.getHand();
        
        Card cardNorth;
        Card cardSouth;
        Card cardEast;
        Card cardWest;
        
        this.highCardPtsEast=0;
        this.highCardPtsNorth=0;
        this.highCardPtsWest=0;
        this.highCardPtsSouth=0;
        //variables end
        
        
        
        
        for (int i = 0; i < 13; i++) {
            //Calculating high card points for West hand
            cardWest=handWest.getCard(i);//Holding the card object found at index  i
            
            //Calculate the highcard score for west
            if (cardWest.getValue()==1) { //If card is Ace
                highCardPtsWest+=4;
            }
            else if(cardWest.getValue()==13){
                highCardPtsWest+=3;
            }
            else if(cardWest.getValue()==12){
                highCardPtsWest+=2;
            }
            else if(cardWest.getValue()==11){
                highCardPtsWest+=1;
            }
            
            
            //Calculating high card points for North hand
            cardNorth=handNorth.getCard(i);//Holding the card object found at index  i
            
            //Calculate the highcard score for west
            if (cardNorth.getValue()==1) { //If card is Ace
                highCardPtsNorth+=4;
            }
            else if(cardNorth.getValue()==13){
                highCardPtsNorth+=3;
            }
            else if(cardNorth.getValue()==12){
                highCardPtsNorth+=2;
            }
            else if(cardNorth.getValue()==11){
                highCardPtsNorth+=1;
            }
            
            //Calculating high card points for East hand
            cardEast=handEast.getCard(i);//Holding the card object found at index  i
            
            //Calculate the highcard score for west
            if (cardEast.getValue()==1) { //If card is Ace
                highCardPtsEast+=4;
            }
            else if(cardEast.getValue()==13){
                highCardPtsEast+=3;
            }
            else if(cardEast.getValue()==12){
                highCardPtsEast+=2;
            }
            else if(cardEast.getValue()==11){
                highCardPtsEast+=1;
            }
            
            
            //Calculating high card points for South hand
            cardSouth=handSouth.getCard(i);//Holding the card object found at index  i
            
            //Calculate the highcard score for west
            if (cardSouth.getValue()==1) { //If card is Ace
                highCardPtsSouth+=4;
            }
            else if(cardSouth.getValue()==13){
                highCardPtsSouth+=3;
            }
            else if(cardSouth.getValue()==12){
                highCardPtsSouth+=2;
            }
            else if(cardSouth.getValue()==11){
                highCardPtsSouth+=1;
            } 
        }
    }

    //Will return each high score hand of the users as a String
        public String getHighCardValues(){
            String scores="West high card value= "+highCardPtsWest+"\nNorth high card value= "+highCardPtsNorth+"\nEast high card value= "+highCardPtsEast+"\nSouth high card value= "+highCardPtsSouth;
            return scores;
        }
    
        
        public int getHighCardValN(){ //returns the highcard value for North
            return highCardPtsNorth;
        }
        
        public int getHighCardValS(){ //returns the highcard value for South
            return highCardPtsSouth;
        }
        
        public int getHighCardValW(){ //returns the highcard value for West
            return highCardPtsWest;
        }
        
        public int getHighCardValE(){ //returns the highcard value for East
            return highCardPtsEast;
        }
        
        
        //method that will see which is the best bid for a hand by checking which suit is most common in a player's hand
        public String correctBid(String playerPosition,String inputBid){
            //variables
            String correctBid=""; //This is the suit to be bidded
            String altBid=""; //This is the alternate suit that can be bidded
            String playerPos=playerPosition; //Which player is bidding
            String playersBid=inputBid; //The value that the player has input as the bid
           
            
            int arrNumSuits[]=new int[4]; //will hold the total number of each suit found in a hand of cards [Spades,Hearts,Diamonds,Clubs]
            String arrSuits[]={"S","H","D","C"};
            int high=0;//Will be used when checking which suit is found the most
            
            Hand handNorth =north.getHand();
            Hand handSouth=south.getHand();
            Hand handWest =west.getHand();
            Hand handEast=east.getHand();
            
            //variables end
            
            
            //initialise each positon in array to zero
            for (int i = 0; i < 4; i++) {
                arrNumSuits[i]=0;
                
            }
            if (playerPos.equals("West")) {
                 //calculate how many of each suit is found in each player's hand
                for (int i=0; i<13; i++) {

                       Card cardWest=handWest.getCard(i); //gets the card object at index i


                       //Checking the suits in west hand 
                       if (cardWest.getSuit()==0) { //if card is Spades
                           arrNumSuits[0]=arrNumSuits[0]+1;
                       }
                       else if (cardWest.getSuit()==1) { //if card is Hearts
                           arrNumSuits[1]=arrNumSuits[1]+1;
                       }
                       else if (cardWest.getSuit()==2) {//if card is Diamonds
                           arrNumSuits[2]=arrNumSuits[2]+1;
                       }
                       else if (cardWest.getSuit()==3) { //If card is Clubs
                           arrNumSuits[3]=arrNumSuits[3]+1;
                       }

                    }//forloop close
            
                //See which suit(s) is most common and needs to be used in bidding
                    for (int i = 0; i < 4; i++) {
                            if (arrNumSuits[i]>high) {
                                high=arrNumSuits[i];
                                correctBid="1"+arrSuits[i];
                        }
                            else if(arrNumSuits[i]==high){
                                altBid="1"+arrSuits[i];
                            }
                    }   
            }
            else if(playerPos.equals("North")){
                for (int i=0; i<13; i++) {

                    Card cardNorth=handNorth.getCard(i); //gets the card object at index i

                    
                    //Checking the suits in west hand 
                    if (cardNorth.getSuit()==0) { //if card is Spades
                        arrNumSuits[0]=arrNumSuits[0]+1;
                    }
                    else if (cardNorth.getSuit()==1) { //if card is Hearts
                        arrNumSuits[1]=arrNumSuits[1]+1;
                    }
                    else if (cardNorth.getSuit()==2) {//if card is Diamonds
                        arrNumSuits[2]=arrNumSuits[2]+1;
                    }
                    else if (cardNorth.getSuit()==3) { //If card is Clubs
                        arrNumSuits[3]=arrNumSuits[3]+1;
                    }
                    
                }//forloop close
            
                //See which suit is most common and needs to be used in bidding
                //See which suit(s) is most common and needs to be used in bidding
                    for (int i = 0; i < 4; i++) {
                            if (arrNumSuits[i]>high) {
                                high=arrNumSuits[i];
                                correctBid="1"+arrSuits[i];
                        }
                            else if(arrNumSuits[i]==high){
                                altBid="1"+arrSuits[i];
                            }
                    }
                
                
            }
            else if(playerPos.equals("East")){
                for (int i=0; i<13; i++) {

                    Card cardEast=handEast.getCard(i); //gets the card object at index i

                    
                    //Checking the suits in west hand 
                    if (cardEast.getSuit()==0) { //if card is Spades
                        arrNumSuits[0]=arrNumSuits[0]+1;
                    }
                    else if (cardEast.getSuit()==1) { //if card is Hearts
                        arrNumSuits[1]=arrNumSuits[1]+1;
                    }
                    else if (cardEast.getSuit()==2) {//if card is Diamonds
                        arrNumSuits[2]=arrNumSuits[2]+1;
                    }
                    else if (cardEast.getSuit()==3) { //If card is Clubs
                        arrNumSuits[3]=arrNumSuits[3]+1;
                    }
                    
                }//forloop close
            
                //See which suit is most common and needs to be used in bidding
                //See which suit(s) is most common and needs to be used in bidding
                    for (int i = 0; i < 4; i++) {
                            if (arrNumSuits[i]>high) {
                                high=arrNumSuits[i];
                                correctBid="1"+arrSuits[i];
                        }
                            else if(arrNumSuits[i]==high){
                                altBid="1"+arrSuits[i];
                            }
                    }
            }
            else if(playerPos.equals("South")){
                for (int i=0; i<13; i++) {

                    Card cardSouth=handSouth.getCard(i); //gets the card object at index i

                    
                    //Checking the suits in west hand 
                    if (cardSouth.getSuit()==0) { //if card is Spades
                        arrNumSuits[0]=arrNumSuits[0]+1;
                    }
                    else if (cardSouth.getSuit()==1) { //if card is Hearts
                        arrNumSuits[1]=arrNumSuits[1]+1;
                    }
                    else if (cardSouth.getSuit()==2) {//if card is Diamonds
                        arrNumSuits[2]=arrNumSuits[2]+1;
                    }
                    else if (cardSouth.getSuit()==3) { //If card is Clubs
                        arrNumSuits[3]=arrNumSuits[3]+1;
                    }
                    
                }//forloop close
            
                //See which suit is most common and needs to be used in bidding
                //See which suit(s) is most common and needs to be used in bidding
                    for (int i = 0; i < 4; i++) {
                            if (arrNumSuits[i]>high) {
                                high=arrNumSuits[i];
                                correctBid="1"+arrSuits[i];
                        }
                            else if(arrNumSuits[i]==high){
                                altBid="1"+arrSuits[i];
                            }
                    }
            }
            
            String totalCorrectBid=correctBid+","+altBid;
            return totalCorrectBid ;
        }      
        
        public String evalCardRankings(String val){ //used in lesson 2
            
            String correct="";
            int cardVal=south_state.getCardVal();
            Hand handSouth=south.getHand();
            Card card;
            int high=0;
            int low=15;
            
            if (cardVal==1) {
                cardVal=14;
            }
            
            this.cardValue=cardVal;
            
             for (int i=0; i<13; i++) {

                card=handSouth.getCard(i);

                //Checking for highest
                if (card.getValue()==1) { //if card is Spades
                    high=14;
                    
                }
                else if (card.getValue()>high) { //if card is Hearts
                    high=card.getValue();
                
                }
                
                //Checking  for lowest
                if (card.getValue()==1) { //if card is Spades
                    low=14;
                    
                }
                else if (card.getValue()<low) { //if card is Hearts
                    low=card.getValue();
                }     
            }//forloop close
            return correct=high+","+low;
        }  
        
        public int getSelectedCardVal(){
            return this.cardValue;
        }

}
