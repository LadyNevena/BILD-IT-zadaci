package bonus_18_02_2017;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Score extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextArea textArea;
	public JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
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
	public Score() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		JLabel lblRezultati = new JLabel("Rezultati:      ");
		lblRezultati.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblRezultati.setForeground(Color.RED);
		contentPane.add(lblRezultati, BorderLayout.WEST);

		textArea = new JTextArea();
		textArea.setForeground(Color.RED);
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 13));
		contentPane.add(textArea, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		getContentPane().add(scrollPane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(500, 377);
		textArea.setSize(200, 200);
		textArea.setLocation(110, 228);
		textArea.setLineWrap(true);
		textArea.setEditable(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("back.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserMenu userMenu = new UserMenu();
				userMenu.setVisible(true);
				userMenu.setLabel(ReaderWriter.readFile("logged.txt").get(0));
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

	}

}
