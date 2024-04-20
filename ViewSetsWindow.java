package teamProjectGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 * Window for the VIEW SETS section of FlashcardGUI
 * 
 * @author Brandon Fitzgerald
 */
public class ViewSetsWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int deckNum;

	private String fileFlashcards = "src/teamProjectGui/TextFiles/Flashcards.csv";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSetsWindow frame = new ViewSetsWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewSetsWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(275, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(130, 125, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel NorthPanel = new JPanel();
		contentPane.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.setLayout(new GridLayout(0, 4, 0, 0));

		JButton addSetBtn = addSetBtn();
		NorthPanel.add(addSetBtn);

		JButton deleteSetBtn = deleteSetBtn();
		NorthPanel.add(deleteSetBtn);

		JButton viewSetBtn = viewSetsBtn();
		NorthPanel.add(viewSetBtn);

		JButton homeBtn = homeBtn();
		NorthPanel.add(homeBtn);

		JPanel CenterPanel = new JPanel();
		CenterPanel.setOpaque(false);
		contentPane.add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblSetList = lblSetListLabel();
			CenterPanel.add(lblSetList, BorderLayout.NORTH);
		}
		{
			JPanel SetsPanel = new JPanel();
			SetsPanel.setOpaque(false);
			CenterPanel.add(SetsPanel, BorderLayout.CENTER);
			SetsPanel.setLayout(new GridLayout(3, 4, 0, 0));
			{
				JButton btnSet1 = btnSet1();
				SetsPanel.add(btnSet1);
			}
			{
				JButton btnSet2 = btnSet2();
				SetsPanel.add(btnSet2);
			}
			{
				JButton btnSet3 = btnSet3();
				SetsPanel.add(btnSet3);
			}
			{
				JButton btnSet4 = btnSet4();
				SetsPanel.add(btnSet4);
			}
			{
				JButton btnSet5 = btnSet5();
				SetsPanel.add(btnSet5);
			}
			{
				JButton btnSet6 = btnSet6();
				SetsPanel.add(btnSet6);
			}
			{
				JButton btnSet7 = btnSet7();
				SetsPanel.add(btnSet7);
			}
			{
				JButton btnSet8 = btnSet8();
				SetsPanel.add(btnSet8);
			}
			{
				JButton btnSet9 = btnSet9();
				SetsPanel.add(btnSet9);
			}
			{
				JButton btnSet10 = btnSet10();
				SetsPanel.add(btnSet10);
			}
			{
				JButton btnSet11 = btnSet11();
				SetsPanel.add(btnSet11);
			}
			{
				JButton btnSet12 = btnSet12();
				SetsPanel.add(btnSet12);
			}

		}
	}

	/**
	 * Resets the current flashcard when looking in view window
	 */
	public static void resetCurrentFlashcard() {
		FlashcardWindow.currentFlashcard = 0;
	}

	/**
	 * Button twelve on screen indicating twelfth set
	 */
	private JButton btnSet12() {
		JButton btnSet12 = new JButton("Empty");
		btnSet12.setOpaque(true);
		btnSet12.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet12.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet12.setBackground(new Color(169, 169, 200));
		btnSetAction(12, btnSet12);
		return btnSet12;
	}

	/**
	 * Button eleven on screen indicating eleventh set
	 */
	private JButton btnSet11() {
		JButton btnSet11 = new JButton("Empty");
		btnSet11.setOpaque(true);
		btnSet11.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet11.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet11.setBackground(new Color(169, 169, 200));
		btnSetAction(11, btnSet11);
		return btnSet11;
	}

	/**
	 * Button ten on screen indicating tenth set
	 */
	private JButton btnSet10() {
		JButton btnSet10 = new JButton("Empty");
		btnSet10.setOpaque(true);
		btnSet10.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet10.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet10.setBackground(new Color(169, 169, 200));
		btnSetAction(10, btnSet10);
		return btnSet10;
	}

	/**
	 * Button nine on screen indicating ninth set
	 */
	private JButton btnSet9() {
		JButton btnSet9 = new JButton("Empty");
		btnSet9.setOpaque(true);
		btnSet9.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet9.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet9.setBackground(new Color(169, 169, 200));
		btnSetAction(9, btnSet9);
		return btnSet9;
	}

	/**
	 * Button eight on screen indicating eigth set
	 */
	private JButton btnSet8() {
		JButton btnSet8 = new JButton("Empty");
		btnSet8.setOpaque(true);
		btnSet8.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet8.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet8.setBackground(new Color(169, 169, 200));
		btnSetAction(8, btnSet8);
		return btnSet8;
	}

	/**
	 * Button seven on screen indicating seventh set
	 */
	private JButton btnSet7() {
		JButton btnSet7 = new JButton("Empty");
		btnSet7.setOpaque(true);
		btnSet7.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet7.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet7.setBackground(new Color(169, 169, 200));
		btnSetAction(7, btnSet7);
		return btnSet7;
	}

	/**
	 * Button six on screen indicating sixth set
	 */
	private JButton btnSet6() {
		JButton btnSet6 = new JButton("Empty");
		btnSet6.setOpaque(true);
		btnSet6.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet6.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet6.setBackground(new Color(169, 169, 200));
		btnSetAction(6, btnSet6);
		return btnSet6;
	}

	/**
	 * Button five on screen indicating fifth set
	 */
	private JButton btnSet5() {
		JButton btnSet5 = new JButton("Empty");
		btnSet5.setOpaque(true);
		btnSet5.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet5.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet5.setBackground(new Color(169, 169, 200));
		btnSetAction(5, btnSet5);
		return btnSet5;
	}

	/**
	 * Button four on screen indicating fourth set
	 */
	private JButton btnSet4() {
		JButton btnSet4 = new JButton("Empty");
		btnSet4.setOpaque(true);
		btnSet4.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet4.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet4.setBackground(new Color(169, 169, 200));
		btnSetAction(4, btnSet4);
		return btnSet4;
	}

	/**
	 * Button three on screen indicating third set
	 */
	private JButton btnSet3() {
		JButton btnSet3 = new JButton("Empty");
		btnSet3.setOpaque(true);
		btnSet3.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet3.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet3.setBackground(new Color(169, 169, 200));
		btnSetAction(3, btnSet3);
		return btnSet3;
	}

	/**
	 * Button two on screen indicating second set
	 */
	private JButton btnSet2() {
		JButton btnSet2 = new JButton();

		if (getSetsFromFile(fileFlashcards) != null) {
			btnSet2.setText(getSetsFromFile(fileFlashcards).get(1));
		}

		btnSet2.setOpaque(true);
		btnSet2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet2.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet2.setBackground(new Color(169, 169, 200));
		btnSetAction(2, btnSet2);
		return btnSet2;
	}

	/**
	 * Button one on screen indicating first set
	 */
	private JButton btnSet1() {
		JButton btnSet1 = new JButton();

		if (getSetsFromFile(fileFlashcards) != null) {
			btnSet1.setText(getSetsFromFile(fileFlashcards).get(0));
		}

		btnSet1.setOpaque(true);
		btnSet1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSet1.setBorder(new MatteBorder(10, 20, 10, 20, (Color) new Color(130, 125, 150)));
		btnSet1.setBackground(new Color(169, 169, 200));
		btnSetAction(1, btnSet1);
		return btnSet1;
	}

	/**
	 * Method for all buttons to delete from deck list
	 * 
	 * @param value  - number of which button it is placed under
	 * @param button - which button value
	 */
	public void btnSetAction(int value, JButton button) {
		if (HomeWindow.currentDecks.size() >= value) {
			button.setText(HomeWindow.currentDecks.get(value - 1).getName());
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button.getText() == "Empty") {
					JOptionPane.showMessageDialog(null, "No set currently occupies this spot.");

				} else if (HomeWindow.currentDecks.get(ViewSetsWindow.deckNum).getCard(0) == null) {
					JOptionPane.showMessageDialog(null, "No flashcards are on this set!");
				} else {
					close();
					FlashcardWindow as = new FlashcardWindow();
					as.setVisible(true);
					deckNum = value - 1;

				}
			}
		});
	}

	/**
	 * Top label showing the sets
	 */
	private JLabel lblSetListLabel() {
		JLabel lblSetList = new JLabel("Sets:");
		lblSetList.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSetList.setHorizontalAlignment(SwingConstants.CENTER);
		return lblSetList;
	}

	/**
	 * Method to allow window to close when used
	 */
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	/**
	 * Add button on top of screen
	 * 
	 * @return a button to display adding sets
	 */
	private JButton addSetBtn() {
		JButton addSetBtn = new JButton("Add Set");
		addSetBtn.setOpaque(true);
		addSetBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		addSetBtn.setBackground(new Color(169, 169, 169));
		addSetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AddWindow as = new AddWindow();
				as.setVisible(true);
			}
		});
		addSetBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		return addSetBtn;
	}

	/**
	 * Delete button on top of screen
	 * 
	 * @return a button to display deleting sets
	 */
	private JButton deleteSetBtn() {
		JButton deleteSetBtn = new JButton("Delete Set");
		deleteSetBtn.setOpaque(true);
		deleteSetBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		deleteSetBtn.setBackground(new Color(169, 169, 169));
		deleteSetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				DeleteSetWindow ds = new DeleteSetWindow();
				ds.setVisible(true);
			}
		});
		deleteSetBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		return deleteSetBtn;
	}

	/**
	 * View button on top of screen
	 * 
	 * @return a button to display view sets
	 */
	private JButton viewSetsBtn() {
		JButton viewSetsBtn = new JButton("View Sets");
		viewSetsBtn.setOpaque(true);
		viewSetsBtn.setForeground(new Color(255, 255, 255));
		viewSetsBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		viewSetsBtn.setBackground(new Color(150, 150, 150));
		viewSetsBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		return viewSetsBtn;
	}

	/**
	 * Home button on top of screen
	 * 
	 * @return a button to display home
	 */
	private JButton homeBtn() {
		JButton homeBtn = new JButton("Home");
		homeBtn.setOpaque(true);
		homeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		homeBtn.setBackground(new Color(169, 169, 169));
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				HomeWindow mf = new HomeWindow();
				mf.setVisible(true);
			}
		});
		homeBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		return homeBtn;
	}

	/**
	 * Method for retrieving the all the names of the sets from the CSV file. An
	 * ArrayList was created to store all the names. That ArrayList is returned.
	 * 
	 * @param fileFlashcards The CSV file that the names are being retrieved from.
	 * @param testDeck A FlashcardDeck object is being used to call the readFromFile method.
	 * @return The ArrayList of names.
	 * 
	 * @author Diego Galvan
	 */
	private static ArrayList<String> getSetsFromFile(String fileFlashcards) {
		Map<String, List<Flashcard>> flashcardDecks = new FlashcardDeck("").readFromFile(fileFlashcards);
		ArrayList<String> namesOfSets = new ArrayList<>();

		for (String deckName : flashcardDecks.keySet()) {
			namesOfSets.add(deckName);
		}

		return namesOfSets;
	}

}
