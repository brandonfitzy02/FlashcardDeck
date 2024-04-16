package teamProjectGui;

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
	 */
	public static void main(String[] args) {
		String filePath = "flashcards.csv";

		System.out.println("FLASHCARDS:");
		System.out.println("-----------");
		FileManager.readFromFile(filePath);
	}
}
