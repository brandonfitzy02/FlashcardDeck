package teamProjectGui;

/**
* This class represents the flashcard. The back and front sides. If the
* flashcard is flipped over to the back side, isVisible = true.
*
* @author Diego Galvan
*/
public class Flashcard {
	private String front;
	private String back;
	private boolean isVisible; // True if the back is visible; false if front is visible
 
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
	 * @return the front
	 */
	public String getFront() {
		return front;
	}

	/**
	 * @return the back
	 */
	public String getBack() {
		return back;
	}

	/**
	 * @return the isVisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * Method for flipping the card over. If isVisible = false, front side is
	 * displayed. If isVisible = true, back side is displayed.
	 */
		public void flip() {
			isVisible = !isVisible;
		}
}
