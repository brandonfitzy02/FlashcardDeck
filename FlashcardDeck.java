package teamProjectGui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class represents a collection of flashcards. It includes an ArrayList of
 * flashcards and a constructor class for that ArrayList.
 * 
 * @author Diego Galvan
 */
public class FlashcardDeck {
	private List<Flashcard> deck;
	private String deckName;

	/**
	 * Constructor method for the flashcardDeck. Initliazes the flashcardDeck.
	 */
	public FlashcardDeck(String deckName) {
		this.deck = new ArrayList<>();
		this.deckName = deckName;
	}

	/**
	 * Getter method to get the flashcard deck
	 * 
	 * @return
	 */
	public List<Flashcard> getDeck() {
		// Returning a copy of the deck to prevent external modifications
		return new ArrayList<>(deck);
	}

	/**
	 * Method for adding a card to the deck. It takes a flashcard object as the
	 * parameter.
	 * 
	 * @param flashcard Flashcard object
	 */
	public void addCard(Flashcard flashcard) {
		deck.add(flashcard);
	}

	/**
	 * Method for removing a flashcard from the deck.
	 * 
	 * @param flashcard Flashcard object.
	 * @return The flashcard being removed.
	 */
	public boolean removeCard(Flashcard flashcard) {
		return deck.remove(flashcard);
	}

	/**
	 * Method to get name of deck
	 * 
	 * @return the name of the deck
	 */
	public String getName() {
		return deckName;
	}

	/**
	 * Method for getting the card.
	 * 
	 * @param index Index of the card in the flashcardDeck.
	 * @return The index of the flashcard or null.
	 */
	public Flashcard getCard(int index) {
		if (index >= 0 && index < deck.size()) {
			return deck.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Writes the flashcard deck to a csv file. Each card is written as:
	 * deckName,front,back
	 * 
	 * @param filePath The path to the csv file.
	 */
	public void writeCardToFile(String filePath) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
			for (Flashcard card : deck) {
				writer.printf("%s,%s,%s%n", deckName, card.getFront(), card.getBack());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * Reads flashcards from a CSV file and organizes them into decks. Each line in
	 * the CSV file should be formatted as {deckName,front,back}.
	 * 
	 * @param filePath The path to the CSV file that contains the flashcard data.
	 * @return A Map where each key is a String representing the deck name and the
	 *         value is a List of Flashcard objects belonging to that deck.
	 */
	public Map<String, List<Flashcard>> readFromFile(String filePath) {
		Map<String, List<Flashcard>> decks = new HashMap<>();

		try (Scanner reader = new Scanner(new File(filePath))) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] parts = line.split(",");

				if (parts.length == 3) {
					String deckName = parts[0];
					String front = parts[1];
					String back = parts[2];
					Flashcard card = new Flashcard(front, back);
					decks.putIfAbsent(deckName, new ArrayList<>());
					decks.get(deckName).add(card);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		return decks;
	}

	/**
	 * Method for shuffling the flaschards in a random order.
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}

	@Override
	public int hashCode() {
		return Objects.hash(deck, deckName);
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
		return Objects.equals(deck, other.deck) && Objects.equals(deckName, other.deckName);
	}
}
