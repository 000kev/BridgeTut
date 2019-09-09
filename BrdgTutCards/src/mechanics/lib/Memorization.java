/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.lib;

import java.util.ArrayList;
import cards.lib.*;

/**
 *
 * @author kevin
 */
public class Memorization {
    
    private static ArrayList<Card> played;
    private static ArrayList<Card> hearts;
    private static ArrayList<Card> spades;
    private static ArrayList<Card> clubs;
    private static ArrayList<Card> diamonds;
    
    public Memorization(ArrayList<Card> played_cards) {
        played = played_cards;
        hearts = new ArrayList();
        spades = new ArrayList();
        clubs = new ArrayList();
        diamonds = new ArrayList();
    }
    
    public void sortByHearts() {
        for (Card card: played) {
            if (card.getSuit()==Card.HEARTS) {
                hearts.add(card);
            }
        }
    }
    
    public ArrayList<Card> getHearts() {
        sortByHearts();
        return hearts;
    }
    
    public void sortByClubs() {
        for (Card card: played) {
            if (card.getSuit()==Card.CLUBS) {
                clubs.add(card);
            }
        }
    }
    
    public ArrayList<Card> getClubs() {
        sortByClubs();
        return clubs;
    }
    
    public void sortByDiamonds() {
        for (Card card: played) {
            if (card.getSuit()==Card.DIAMONDS) {
                diamonds.add(card);
            }
        }
    }
    
    public ArrayList<Card> getDiamonds() {
        sortByDiamonds();
        return diamonds;
    }
    
    public void sortBySpades() {
        for (Card card: played) {
            if (card.getSuit()==Card.SPADES) {
                spades.add(card);
            }
        }
    }
    
    public ArrayList<Card> getSpades() {
        sortBySpades();
        return spades;
    }
    
    public int getPlayedSize() {
        return played.size();
    }
    
   
}
