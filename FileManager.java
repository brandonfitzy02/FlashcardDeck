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
	public static void writeSetAndCardToFile(String filePath, String deckName, String front, String back) {

		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
			writer.printf("%s,%s,%s,%n", deckName, front, back);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * The deleteDeck method reads the entire file line by line, checking if each
	 * line belongs to the specified 'deckName'.
	 * 
	 * @param filePath The String of the file path
	 * @param deckName The name of the deck to be deleted
	 */
	public static void deleteDeck(String filePath, String deckName) {
		List<String> linesToKeep = new ArrayList<>();
		try (Scanner reader = new Scanner(new File(filePath))) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				if (!line.startsWith(deckName + ",")) { // Keep lines that do not belong to the deckName
					linesToKeep.add(line);
				}
			}
		} catch (IOException e) {
			System.err.println("Error writing to CSV file: " + e.getMessage());
		}

		// Rewrite the file with only the lines to keep
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			for (String line : linesToKeep) {
				writer.println(line);
			}
		} catch (IOException e) {
			System.err.println("Error writing to CSV file: " + e.getMessage());
		}
	}
}
