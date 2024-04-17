package teamProjectGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

/**
 * Window for the HOME section of FlashcardGUI
 * 
 * @author Brandon Fitzgerald
 */
public class HomeWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static List<FlashcardDeck> currentDecks = new ArrayList<>(12);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeWindow frame = new HomeWindow();
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
	public HomeWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(275, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(130, 125, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));

		JButton addSetBtn = addSetBtn();
		panel.add(addSetBtn);

		JButton deleteSetBtn = deleteSetBtn();
		panel.add(deleteSetBtn);

		JButton viewSetBtn = viewSetsBtn();
		panel.add(viewSetBtn);

		JButton homeBtn = homeBtn();
		panel.add(homeBtn);

		JLabel lblNewLabel = centerText();
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		JLabel lblNewLabel_1 = bottomTextLabel();
		contentPane.add(lblNewLabel_1, BorderLayout.SOUTH);
		{
			JPanel WestPanel = new JPanel();
			WestPanel.setOpaque(false);
			contentPane.add(WestPanel, BorderLayout.WEST);
			WestPanel.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel lblLastOpened = lblLastOpened();
				WestPanel.add(lblLastOpened);
			}
			{
				JButton btnLastOpened = btnLastOpened();
				WestPanel.add(btnLastOpened);
			}
		}

	}

	public static void readingFile(List<FlashcardDeck> list) {

	}

	/**
	 * A button to press the last opened deck
	 */
	private JButton btnLastOpened() {
		JButton btnLastOpened = new JButton("This is a test");
		if (currentDecks.isEmpty() || currentDecks.size() == 0) {
			btnLastOpened.setVisible(false);
		}
		btnLastOpened.setBorder(new MatteBorder(10, 10, 70, 10, (Color) new Color(130, 125, 150)));
		return btnLastOpened;
	}

	/**
	 * Shows a label of the last opened deck
	 */
	private JLabel lblLastOpened() {
		JLabel lblLastOpened = new JLabel("TBD");
		if (currentDecks.isEmpty() || currentDecks.size() == 0) {
			lblLastOpened.setVisible(false);
		}
		lblLastOpened.setBorder(new EmptyBorder(50, 0, 10, 0));
		lblLastOpened.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastOpened.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		return lblLastOpened;
	}

	/**
	 * Bottom text for welcome window to explain where to begin
	 * 
	 * @return label stating how to start
	 */
	private JLabel bottomTextLabel() {
		JLabel lblBottomTxt = new JLabel("To access your current sets, press \"View Sets\" on the top.");
		if (currentDecks.isEmpty() || currentDecks.size() == 0) {
			lblBottomTxt.setText("To begin, create a new set by pressing \"Add\" in the top left corner.");
		}
		lblBottomTxt.setBorder(new EmptyBorder(5, 0, 15, 15));
		lblBottomTxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblBottomTxt.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		return lblBottomTxt;
	}

	/**
	 * Center text for welcome window to introduce program
	 * 
	 * @return label stating welcome
	 */
	private JLabel centerText() {
		JLabel lblWelcomeTxt = new JLabel("Welcome Back!");
		if (currentDecks.isEmpty() || currentDecks.size() == 0) {
			lblWelcomeTxt.setText("Welcome");
		}
		lblWelcomeTxt.setBorder(new EmptyBorder(0, 0, 100, 90));
		lblWelcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeTxt.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		return lblWelcomeTxt;
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
		viewSetsBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		viewSetsBtn.setBackground(new Color(169, 169, 169));
		viewSetsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				ViewSetsWindow vs = new ViewSetsWindow();
				vs.setVisible(true);
			}
		});
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
		homeBtn.setForeground(new Color(255, 255, 255));
		homeBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		homeBtn.setBackground(new Color(150, 150, 150));
		homeBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		return homeBtn;
	}

}
