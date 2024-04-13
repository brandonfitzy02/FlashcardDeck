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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class AddWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWindow frame = new AddWindow();
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
	public AddWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(275, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(130, 125, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new GridLayout(0, 4, 0, 0));

		JButton addSetBtn = addSetBtn();
		titlePanel.add(addSetBtn);

		JButton deleteSetBtn = deleteSetBtn();
		titlePanel.add(deleteSetBtn);

		JButton viewSetBtn = viewSetsBtn();
		titlePanel.add(viewSetBtn);

		JButton homeBtn = homeBtn();
		titlePanel.add(homeBtn);

		JPanel centerPanel = new JPanel();
		centerPanel.setOpaque(false);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			JButton btnAddSet = btnAddSet();
			centerPanel.add(btnAddSet);
		}
		{
			JButton btnAddFlashcards = btnAddFlashcard();
			centerPanel.add(btnAddFlashcards);
		}
	}

	/**
	 * Button to add flashcards to an existing set
	 */
	private JButton btnAddFlashcard() {
		JButton btnAddFlashcard = new JButton("Add flashcards to an existing set");
		btnAddFlashcard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AddFlashcardWindow as = new AddFlashcardWindow();
				as.setVisible(true);
			}
		});
		btnAddFlashcard.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnAddFlashcard.setBorder(new MatteBorder(150, 20, 150, 20, (Color) new Color(130, 125, 150)));
		btnAddFlashcard.setBackground(new Color(169, 169, 200));
		return btnAddFlashcard;
	}

	/**
	 * Button to go into adding a set window
	 */
	private JButton btnAddSet() {
		JButton btnAddSet = new JButton("Create a new set");
		btnAddSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AddSetWindow as = new AddSetWindow();
				as.setVisible(true);
			}
		});
		btnAddSet.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnAddSet.setBorder(new MatteBorder(150, 20, 150, 20, (Color) new Color(130, 125, 150)));
		btnAddSet.setBackground(new Color(169, 169, 200));

		return btnAddSet;
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
		addSetBtn.setForeground(new Color(255, 255, 255));
		addSetBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addSetBtn.setBackground(new Color(150, 150, 150));
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

}
