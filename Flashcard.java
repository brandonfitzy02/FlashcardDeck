package teamProjectGui;

/**
* This class represents the flashcard. The back and front sides. If the
* flashcard is flipped over to the back side, isVisible = true.
*
* @author Diego Galvan
*/
public class Flashcard {
	public String front;
	public String back;
	public boolean isVisible; // True if the back is visible; false if front is visible
 
	/**
	 * Constructor method for initializing the Flashcard object.
	 *
	 * @param front Front side of the card.
	 * @param back  Back side of the card.
	 */
	public Flashcard(String front, String back) {
		this.front = front;
		this.back = back;
		this.isVisible = false; // Initially, the back of the card is not visible
	}
 
	/**
	 * Method for flipping the card over. If isVisible = false, front side is
	 * displayed. If isVisible = true, back side is displayed.
	 */
		public void flip() {
			isVisible = !isVisible;
		}
}


