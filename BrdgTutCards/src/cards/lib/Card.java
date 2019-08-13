/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.lib;

/**
 *
 * @author kevin
 */
public class Card extends javax.swing.JPanel {

    public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;      // Codes for the non-numeric cards.
    public final static int JACK = 11;     
    public final static int QUEEN = 12;   
    public final static int KING = 13;

    private javax.swing.JLabel jLabel1;
    private static String reference="";
    /**
     * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
     * CLUBS.
     */
    private final int suit; 

    /**
     * The card's value.  For a normal card, this is one of the values
     * 1 through 13, with 1 representing ACE.  
     */
    private final int value;

    /**
     * Creates a Joker, with 1 as the associated value.  (Note that
     * "new Card()" is equivalent to "new Card(1,Card.JOKER)".)
     */
    public Card() {
        suit = HEARTS;
        value = 13;
        
        switch (value) {
            case 1:
                reference="A";
                break;
            case 11:
                reference="J";
                break;
            case 12:
                reference="Q";
                break;
            case 13:
                reference="K";
                break;
            default:
                reference=String.valueOf(value);
                break;
        }
        //reference=String.valueOf(value);
        switch(suit) {
            case JOKER:
                break;
            case SPADES:
                reference+="S";
                break;
            case DIAMONDS:
                reference+="D";
                break;
            case HEARTS:
                reference+="H";
                break;
            case CLUBS:
                reference+="C";
                break;
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cards/ui/assets/"+reference+".jpg"))); // NOI18N
        jLabel1.setText(reference);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
    }
    /**
     * Creates a card with a specified suit and value.
     * @param theValue the value of the new card.  For a regular card (non-joker),
     * the value must be in the range 1 through 13, with 1 representing an Ace.
     * You can use the constants Card.ACE, Card.JACK, Card.QUEEN, and Card.KING.  
     * For a Joker, the value can be anything.
     * @param theSuit the suit of the new card.  This must be one of the values
     * Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER.
     * @throws IllegalArgumentException if the parameter values are not in the
     * permissible ranges
     */
    public Card(int theValue, int theSuit) {
        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && 
                theSuit != CLUBS && theSuit != JOKER)
            throw new IllegalArgumentException("Illegal playing card suit");
        if (theSuit != JOKER && (theValue < 1 || theValue > 13))
            throw new IllegalArgumentException("Illegal playing card value");
        value = theValue;
        suit = theSuit;
        
        switch (value) {
            case 1:
                reference="A";
                break;
            case 11:
                reference="J";
                break;
            case 12:
                reference="Q";
                break;
            case 13:
                reference="K";
                break;
            default:
                reference=String.valueOf(value);
                break;
        }
        //reference=String.valueOf(value);
        
        switch(suit) {
            case JOKER:
                break;
            case SPADES:
                reference+="S";
                break;
            case DIAMONDS:
                reference+="D";
                break;
            case HEARTS:
                reference+="H";
                break;
            case CLUBS:
                reference+="C";
                break;
        }
        initComponents();
    }

    /**
     * Returns the suit of this card.
     * (Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER)
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns the value of this card.
     (1-13)
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a String representation of the card's suit.
     * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
     * or "Joker".
     */
    public String getSuitAsString() {
        switch ( suit ) {
        case SPADES:   return "Spades";
        case HEARTS:   return "Hearts";
        case DIAMONDS: return "Diamonds";
        case CLUBS:    return "Clubs";
        default:       return "Joker";
        }
    }

    /**
     * Returns a String representation of the card's value.
     * @return for a regular card, one of the strings "Ace", "2",
     * "3", ..., "10", "Jack", "Queen", or "King".  For a Joker, the 
     * string is always numerical.
     */
    public String getValueAsString() {
        if (suit == JOKER)
            return "" + value;
        else {
            switch ( value ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "Jack";
            case 12:  return "Queen";
            default:  return "King";
            }
        }
    }

    /**
     * Returns a string representation of this card, including both
     * its suit and its value (except that for a Joker with value 1,
     * the return value is just "Joker").  Sample return values
     * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
     * "Joker", "Joker #2"
     */
    public String toString() {
        if (suit == JOKER) {
            if (value == 1)
                return "Joker";
            else
                return "Joker #" + value;
        }
        else
            return getValueAsString() + " of " + getSuitAsString();
    }


} // end class Card
