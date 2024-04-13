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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * Window for the ADD SET section of FlashcardGUI
 * 
 * @author Brandon Fitzgerald
 */
public class AddSetWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameOfSetTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSetWindow frame = new AddSetWindow();
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
	public AddSetWindow() {
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
		centerPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JLabel lblNameSet = lblNameSet();
			centerPanel.add(lblNameSet);
		}
		{
			nameTxt();
			centerPanel.add(nameOfSetTxt);
			nameOfSetTxt.setColumns(10);
		}

		JButton btnAdd = btnAdd();
		contentPane.add(btnAdd, BorderLayout.SOUTH);

	}

	/**
	 * Button to add a new set
	 */
	private JButton btnAdd() {
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (HomeWindow.currentDecks.size() < 12) {
					String name = nameOfSetTxt.getText();

					FlashcardDeck fd = new FlashcardDeck(name);

					HomeWindow.currentDecks.add(fd);
				} else {
					JOptionPane.showMessageDialog(null, "Maximum value reached");
				}
				nameOfSetTxt.setText("");
			}
		});

		btnAdd.setBorder(new MatteBorder(1, 100, 1, 100, (Color) new Color(130, 125, 150)));
		btnAdd.setBackground(new Color(169, 169, 200));
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		return btnAdd;
	}

	/**
	 * Text field to save name of flashcard set to files
	 */
	private void nameTxt() {
		nameOfSetTxt = new JTextField();
		nameOfSetTxt.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		nameOfSetTxt.setBorder(new MatteBorder(100, 1, 100, 80, (Color) new Color(130, 125, 150)));
	}

	/**
	 * Title for the name of the set entry box
	 */
	private JLabel lblNameSet() {
		JLabel lblNameSet = new JLabel("Name Of Set:");
		lblNameSet.setBorder(new EmptyBorder(0, 0, 0, 45));
		lblNameSet.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNameSet.setHorizontalAlignment(SwingConstants.TRAILING);
		return lblNameSet;
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
		addSetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				AddWindow as = new AddWindow();
				as.setVisible(true);
			}
		});
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
