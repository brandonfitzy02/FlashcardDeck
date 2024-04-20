package teamProjectGui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class serves as a file manager for reading from and writing to files.
 * 
 * @author Diego Galvan
 */
public class FileManager {
	private static List<Flashcard> deck;
	private static String deckName;

	/**
	 * Reads content from a specified file using scanner.
	 * 
	 * @return filePath The path to the file that needs to be read.
	 */
	public static List<Flashcard> readFromFile(String filePath) {
		List<Flashcard> flashcards = new ArrayList<>();

		try (Scanner reader = new Scanner(new File(filePath))) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				Flashcard flashcard = getCard(line);
//				FlashcardDeck deck = getDeck(line);

				if (line != null) {
					flashcards.add(flashcard);
				}
			}
			flashcards.forEach(c -> {
				System.out.println("Front: " + c.getFront());
				System.out.println("Back: " + c.getBack() + "\n");
			});

			return flashcards;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return null;
		}
	}

	/**
	 * Creates a flashcard object based on the data record passed as an argument.
	 * 
	 * @param line A line from the csv file that includes data about the card.
	 * @return The flashcard object.
	 */
	public static Flashcard getCard(String line) {
		String[] parts = line.split(",");

		try {
			String front = parts[1];
			String back = parts[2];

			return new Flashcard(front, back);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error: " + line);
			return null;
		}
	}
	
	/**
	 * Writes the flashcard deck to a csv file. Each card is written as:
	 * deckName,front,back
	 * 
	 * @param filePath The path to the csv file.
	 */
	public static void writeCardToFile(String filePath, String deckName, String front, String back) {
		
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
//			deck.add(new Flashcard(front, back));
//			for (Flashcard card : deck) {
//				writer.printf("%s,%s,%s%n", deckName, card.getFront(), card.getBack());
//			}
			writer.printf("%s,%s,%s,%n", deckName, front, back);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void writeNewSetToFile(String filePath, String deckName) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
			writer.printf("%s,%n", deckName);
			System.out.println("New set: " + deckName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves the whole flashcard deck.
	 * 
	 * @param line A line from the csv file that includes data about the card.
	 * @return The flashcard deck
	 */
//	public static FlashcardDeck getDeck(String line) {
//		String[] parts = line.split(",");
////		String placeholder;
//
//		try {
//			String nameOfDeck = parts[0];
//
////			if (line.startsWith("name of set")) {
////				placeholder = nameOfDeck;
////				System.out.println(nameOfDeck);
////			}
//
//			return new FlashcardDeck(nameOfDeck);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.err.println("Error: " + line);
//			return null;
//		}
//	}
}
