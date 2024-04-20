package teamProjectGui;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class serves for testing purposes. The testing done below was from
 * testing the FileManager class.
 * 
 * @author Diego Galvan
 */
public class TestClient {

	/**
	 * Main method for testing purposes.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		String filePath = "flashcards.csv";
		String nameOfDeck;
		String fileFlashcards = "src/teamProjectGui/TextFiles/Flashcards.csv";
		FlashcardDeck testDeck = new FlashcardDeck("Capitals");
		
//		System.out.println("What's the name of the deck you want to view: ");
//		nameOfDeck = scnr.nextLine();
//		
//		FileManager.getCard(nameOfDeck);
		
//		FlashcardDeck testDeck = new FlashcardDeck("Capitals");
//		testDeck.addCard(new Flashcard("Capital of France", "Paris"));
		
		// Retrieve the deck using the getter
		List<Flashcard> flashcards = testDeck.getDeck();
		
		for (Flashcard card: flashcards) {
			System.out.println("Question: " + card.getFront() + " - Answer: " + card.getBack());
		}
		
//		testDeck.addCard(new Flashcard("England", "London"));
//		testDeck.addCard(new Flashcard("Nevada", "Carson City"));
//		testDeck.addCard(new Flashcard("Ohio", "Columbus"));
//		testDeck.addCard(new Flashcard("Texas", "Austin"));
//		testDeck.addCard(new Flashcard("South Dakota", "Pierre"));
		
		// Write to file
//		FileManager.writeCardToFile(fileFlashcards, "Capitals", "Norway", "Oslo");
		FileManager.writeNewSetToFile(fileFlashcards, "Test");
		
		// Read from file
//		getSetsFromFile(fileFlashcards, testDeck);

//		System.out.println("FLASHCARDS:");
//		System.out.println("-----------");
//		FileManager.readFromFile(filePath);	
	}

	private static void getSetsFromFile(String fileFlashcards, FlashcardDeck testDeck) {
		Map<String, List<Flashcard>> flashcardDecks = testDeck.readFromFile(fileFlashcards);
		for (String deckName : flashcardDecks.keySet()) {
			System.out.println("Deck: " + deckName);
			System.out.println("=============================");
			for (Flashcard card : flashcardDecks.get(deckName)) {
				System.out.printf("Front: %s, Back: %s\n", card.getFront(), card.getBack());
			}
		}
	}
}
