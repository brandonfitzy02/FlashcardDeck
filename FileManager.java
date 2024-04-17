package teamProjectGui;

import java.io.File;
import java.io.FileNotFoundException;
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

				if (line != null) {
					flashcards.add(flashcard);
				}
			}
			flashcards.forEach(c -> {
				System.out.println("Front: " + c.front);
				System.out.println("Back: " + c.back + "\n");
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
			String front = parts[0];
			String back = parts[1];

			return new Flashcard(front, back);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error: " + line);
			return null;
		}
	}
}
