package teamProjectGui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * This class represents a collection of flashcards. It includes an ArrayList of
 * flashcards and a constructor class for that ArrayList.
 * 
 * @author Diego Galvan
 */
public class FlashcardDeck {
	private ArrayList<Flashcard> flashcardDeck;
	private String name;

	/**
	 * Constructor method for the flashcardDeck. Initliazes the flashcardDeck.
	 */
	public FlashcardDeck(String name) {
		this.flashcardDeck = new ArrayList<>();
		this.name = name;
	}

	/**
	 * Method for adding a card to the deck. It takes two strings as parameters, one
	 * string for the front side, second string for the back side. Example: front:
	 * {Sweden capital city} back: {Stockholm}
	 * 
	 * @param front String for the front side.
	 * @param back  String for the back side.
	 */
	public void addCard(String front, String back) {
		Flashcard newCard = new Flashcard(front, back);
		flashcardDeck.add(newCard);
	}

	/**
	 * Method for removing a flashcard from the deck.
	 * 
	 * @param flashcard Flashcard object.
	 * @return The flashcard being removed.
	 */
	public boolean removeCard(Flashcard flashcard) {
		return flashcardDeck.remove(flashcard);
	}

	/**
	 * Method to get name of deck
	 * 
	 * @return the name of the deck
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method for getting the card.
	 * 
	 * @param index Index of the card in the flashcardDeck.
	 * @return The index of the flashcard or null.
	 */
	public Flashcard getCard(int index) {
		if (index >= 0 && index < flashcardDeck.size()) {
			return flashcardDeck.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Method for shuffling the flaschards in a random order.
	 */
	public void shuffle() {
		Collections.shuffle(flashcardDeck);
	}

	@Override
	public int hashCode() {
		return Objects.hash(flashcardDeck, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlashcardDeck other = (FlashcardDeck) obj;
		return Objects.equals(flashcardDeck, other.flashcardDeck) && Objects.equals(name, other.name);
	}
	
	
	
}
