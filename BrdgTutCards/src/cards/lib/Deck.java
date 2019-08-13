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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> cards = new LinkedList<Card>();
	
	public Deck() {
            int[] array = new int[4];
            array[0]=0; //SPADES
            array[1]=1; //HEARTS
            array[2]=2; //DIAMONDS
            array[3]=3; //CLUBS
            for (int suit: array) {
                for (int value=1; value<=13; value++) {
                    this.putBottom(new Card(value, suit));
                }
            }
	}
	
	public Deck(Deck deck) {
		this.cards.addAll(deck.cards);
	}
	
	private void putTop(Card card) {
		this.cards.add(0, card);
	}
	
	private void putBottom(Card card) {
		this.cards.add(card);
	}
	
	public Card removeTop() {
		return this.cards.remove(0);
	}
	
	public Card peekTop() {
		return this.cards.get(0);
	}
	
	/*public void fill() {
		this.fill(FullCardProvider.instance);
	}
	
	public void fill(CardProvider cardProvider) {
		this.empty();
		this.cards.addAll(cardProvider.getCards());
	} */
	
	public void shuffle(Random random) {
		Collections.shuffle(this.cards, random);
	}
	
	public int getRemaining() {
		return this.cards.size();
	}
	
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
	
	public void empty() {
		this.cards.clear();
	}
	
	public Deck split() {
		Deck deck = new Deck();
		this.split(deck);
		return deck;
	}
	
	public void split(Deck... decks) {
		int piece = this.cards.size() / (decks.length + 1);
		for(int i = 0; i < decks.length; i++) {
			for(int j = 0; j < piece; j++) {
				decks[i].putTop(this.removeTop());
			}
		}
	}
	
	public void dealTop(Deck... decks) {
		while(!this.cards.isEmpty()) {
			for(Deck deck : decks) {
				Card card = this.removeTop();
				if(card == null) {
					break;
				}
				deck.putTop(card);
			}
		}
	}
	
	public void dealBottom(Deck... decks) {
		while(!this.cards.isEmpty()) {
			for(Deck deck : decks) {
				Card card = this.removeTop();
				if(card == null) {
					break;
				}
				deck.putBottom(card);
			}
		}
	}
	
	public Deck clone() {
		return new Deck(this);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(Card card : this.cards) {
			if(first) {
				first = false;
			} else {
				builder.append(", ");
			}
			builder.append(card.toString());
		}
		return builder.toString();
	}
	
}
