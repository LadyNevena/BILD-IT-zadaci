package bonus_18_02_2017;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class EditQuestions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JLabel lblNewLabel_3 = null;
	JLabel lblNewLabel_4 = null;
	JLabel lblNewLabel_5 = null;
	JLabel lblNewLabel_6 = null;
	JLabel lblNewLabel_7 = null;
	JLabel lblNewLabel_8 = null;
	JLabel lblNewLabel_9 = null;
	JLabel lblNewLabel_2 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditQuestions frame = new EditQuestions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static boolean validInput(String s) {
		if (isNumber(s)) {
			if (Integer.parseInt(s) > 0 && Integer.parseInt(s) <= ReaderWriter.numberOfQuestions("kviz.txt")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit((s.charAt(i)))) {
				return false;
			}
		}
		return true;
	}


	
	/**
	 * Create the frame.
	 */
	public EditQuestions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Ukupno pitanja:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setText(ReaderWriter.numberOfQuestions("kviz.txt") + "");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JLabel lblBrojPitanja = new JLabel("Broj pitanja:");
		lblBrojPitanja.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblBrojPitanja.setForeground(Color.RED);

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Obri\u0161i");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Popunite polje broj pitanja!");
				} else if (!isNumber(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Molimo unesite broj!");
				} else if (!validInput(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Pitanje br. " + textField.getText() + " ne postoji!");
				} else {
					ReaderWriter.deleteQuestion("kviz.txt", textField.getText());
					ReaderWriter.deleteQuestion("odgovori.txt", textField.getText());
					ReaderWriter.deleteQuestion("rjesenja.txt", textField.getText());
					textField.setText("");
					lblNewLabel_1.setText("" + ReaderWriter.numberOfQuestions("kviz.txt"));
					lblNewLabel_2.setText("");
				}
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JButton btnNewButton_1 = new JButton("Izmijeni");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Popunite polje broj pitanja!");
				} else if (!isNumber(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Molimo unesite broj!");
				} else if (!validInput(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Pitanje br. " + textField.getText() + " ne postoji!");
				} else {
					setBounds(100, 100, 450, 650);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
					textField_3.setVisible(true);
					textField_4.setVisible(true);
					textField_5.setVisible(true);
					textField_6.setVisible(true);
					lblNewLabel_3.setVisible(true);
					lblNewLabel_4.setVisible(true);
					lblNewLabel_5.setVisible(true);
					lblNewLabel_6.setVisible(true);
					lblNewLabel_7.setVisible(true);
					lblNewLabel_8.setVisible(true);
					lblNewLabel_9.setVisible(true);
				}

			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 13));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.RED);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setVisible(false);

		lblNewLabel_3 = new JLabel("Unesite pitanje:");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_3.setVisible(false);
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorderPainted(false);
		//kad kliknemo na ok poslije izmjenej pitanja u editu
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("") || textField_1.getText().equals("")
						|| textField_2.getText().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("") || textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Popunite sva polja!");
				} else if (!(textField_6.getText().equals("A") || textField_6.getText().equals("B")
						|| textField_6.getText().equals("C") || textField_6.getText().equals("D"))
						|| textField_6.getText().length() != 1) {
					JOptionPane.showMessageDialog(null, "U polje taènog odgovora unesite A, B, C ili D!");
				} else {
					ReaderWriter.replaceQuestion("kviz.txt", Integer.parseInt(textField.getText()), textField_1.getText());
					ReaderWriter.replaceQuestion("odgovori.txt", Integer.parseInt(textField.getText()), textField_2.getText()
							+ "#" + textField_3.getText() + "#" + textField_4.getText() + "#" + textField_5.getText());
					ReaderWriter.replaceQuestion("rjesenja.txt", Integer.parseInt(textField.getText()), textField_6.getText());
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					JOptionPane.showMessageDialog(null, "Uspješno saèuvano!");
					lblNewLabel_1.setText("" + ReaderWriter.numberOfQuestions("kviz.txt"));
					lblNewLabel_2.setText("");
				}
			}
		});

		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("ok.png"));

		JButton btnNewButton_3 = new JButton("Pretraga");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Popunite polje broj pitanja!");
				} else if (!isNumber(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Molimo unesite broj!");
				} else if (!validInput(textField.getText())) {
					JOptionPane.showMessageDialog(null, "Pitanje br. " + textField.getText() + " ne postoji!");
				} else {
					lblNewLabel_2.setText(ReaderWriter.readQuestion("kviz.txt", textField.getText()));
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);
				}
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 13));

		lblNewLabel_4 = new JLabel("Unesite odgovore:");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_4.setVisible(false);

		lblNewLabel_5 = new JLabel("A");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_5.setVisible(false);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setVisible(false);

		lblNewLabel_6 = new JLabel("B");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_6.setVisible(false);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setVisible(false);

		lblNewLabel_7 = new JLabel("C");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_7.setVisible(false);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setVisible(false);

		lblNewLabel_8 = new JLabel("D");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setFont(new Font("Arial Black", Font.PLAIN, 13));

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setVisible(false);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.setVisible(true);
				adminMenu.setLabel(ReaderWriter.readLogged("logged.txt"));
				dispose();
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon("back.jpg"));

		lblNewLabel_9 = new JLabel("Unesite ta\u010Dan odgovor:");
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setForeground(Color.BLUE);
		lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 13));

		textField_6 = new JTextField();
		textField_6.setVisible(false);
		textField_6.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup().addContainerGap(83, Short.MAX_VALUE).addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
												.addGap(18).addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 47,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblBrojPitanja)
												.addGap(18).addComponent(textField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(15).addComponent(btnNewButton_3).addGap(50))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_2)
						.addContainerGap(424, Short.MAX_VALUE))
				.addGroup(
						gl_contentPane.createSequentialGroup().addGap(105)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 86,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 89,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(
						gl_contentPane.createSequentialGroup().addContainerGap(123, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95,
										GroupLayout.PREFERRED_SIZE)
								.addGap(118))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_4)
						.addContainerGap(292, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(
										lblNewLabel_3)
								.addContainerGap(310, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
																.createSequentialGroup().addComponent(lblNewLabel_7)
																.addGap(18)
																.addComponent(textField_4, GroupLayout.DEFAULT_SIZE,
																		132, Short.MAX_VALUE)
																.addGap(100).addComponent(lblNewLabel_8,
																		GroupLayout.PREFERRED_SIZE, 10,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel_5).addGap(18)
																.addComponent(textField_2, GroupLayout.DEFAULT_SIZE,
																		132, Short.MAX_VALUE)
																.addGap(100).addComponent(lblNewLabel_6)))
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_9)
												.addGap(105)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING,
												gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 140,
																Short.MAX_VALUE)
														.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 140,
																Short.MAX_VALUE)))
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblBrojPitanja)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3))
						.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_2).addGap(140))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 52,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18)))
						.addComponent(lblNewLabel_3).addGap(18)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(
								lblNewLabel_4)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_5)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6).addComponent(textField_3,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(30).addComponent(lblNewLabel_7))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_8).addComponent(textField_5,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_9)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
