package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		this.setDeckName(deckName);
		this.setCardsInDeck();
	}
	
	public void setDeckName(String deckName) {
		if (deckName.isBlank()) {
			this.deckName = "Untitled Deck";
		} else {
			this.deckName = deckName;
		}
	}
	
	public String getDeckName() {
		return this.deckName;
	}
	
	public void setCardsInDeck() {
		this.cardsInDeck = new ArrayList<CardCounter>();
	}
	
	public ArrayList<CardCounter> getCardsInDeck(){
		return this.cardsInDeck;
	}
	
	public void addCard(UnitCard newCard, int count) {
		boolean exist = false;
		if (count <= 0) {
			return;
		}
		for (CardCounter i : this.cardsInDeck) {
			if (i.getCard() == newCard) {
				int temp = i.getCount();
				i.setCount(temp + count);
				exist = true;
			}
		}
		if (!exist) {
			CardCounter cardcounter = new CardCounter(newCard,count);
			this.cardsInDeck.add(cardcounter);
		}
	}
	
	
	public void removeCard(UnitCard toRemove, int count) {
		boolean lessthanzero = false;
		CardCounter removed = null;
		if (count <= 0) {
			return;
		}
		for (CardCounter i : this.cardsInDeck) {
			if (i.getCard() == toRemove) {
				int temp = i.getCount();
				i.setCount(temp - count);
				if (i.getCount() <= 0) {
					lessthanzero = true;
					removed = i;
				}
			}
		}
		if (lessthanzero) {
			this.cardsInDeck.remove(removed);
		}
	}
	
	public int cardCount() {
		int sum = 0;
		for (CardCounter i : this.cardsInDeck) {
			sum += i.getCount();
		}
		return sum;
	}
	
	public boolean existsInDeck(UnitCard card) {
		for (CardCounter i : this.cardsInDeck) {
			if (i.getCount() >= 1 && i.getCard() == card) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		return this.deckName.equals(other.deckName);
	}
	
}
