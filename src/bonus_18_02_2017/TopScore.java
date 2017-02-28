package bonus_18_02_2017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TopScore extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopScore frame = new TopScore();
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
	public TopScore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel_1 = new JLabel("Rezultati:       ");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1, BorderLayout.WEST);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("TOP 100");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2, BorderLayout.NORTH);
	}

}
