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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * Window for viewing the flashcard set when clicked on in view section
 * 
 * @author Brandon Fitzgerald
 */
public class FlashcardWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlashcardWindow frame = new FlashcardWindow();
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
	public FlashcardWindow() {
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

		JLabel Flashcardlbl = lblFlashcard();
		contentPane.add(Flashcardlbl, BorderLayout.CENTER);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EmptyBorder(0, 10, 10, 10));
			panel_1.setOpaque(false);
			contentPane.add(panel_1, BorderLayout.SOUTH);
			panel_1.setLayout(new GridLayout(0, 4, 0, 0));
			{
				JButton btnPrevious = btnPrevious();
				panel_1.add(btnPrevious);
			}
			{
				JLabel lblGap1 = new JLabel("");
				panel_1.add(lblGap1);
			}
			{
				JLabel lblGap2 = new JLabel("");
				panel_1.add(lblGap2);
			}
			{
				JButton btnNext = btnNext();
				panel_1.add(btnNext);
			}
		}
	}

	/**
	 * Next button to move onto next flashcard
	 */
	private JButton btnNext() {
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNext.setBackground(new Color(169, 169, 200));
		return btnNext;
	}

	/**
	 * Previous button to go back a flashcard
	 */
	private JButton btnPrevious() {
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnPrevious.setBackground(new Color(169, 169, 200));
		return btnPrevious;
	}

	/**
	 * Label in center showing front and back sides of a flashcard
	 */
	private JLabel lblFlashcard() {
		JLabel Flashcardlbl = new JLabel("fdName");
		Flashcardlbl.setBorder(new MatteBorder(75, 100, 75, 100, (Color) new Color(130, 125, 150)));
		Flashcardlbl.setOpaque(true);
		Flashcardlbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		Flashcardlbl.setHorizontalAlignment(SwingConstants.CENTER);
		return Flashcardlbl;
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
		viewSetsBtn.setForeground(new Color(255, 255, 255));
		viewSetsBtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		viewSetsBtn.setBackground(new Color(150, 150, 150));
		viewSetsBtn.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		viewSetsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				ViewSetsWindow vs = new ViewSetsWindow();
				vs.setVisible(true);
			}
		});
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
