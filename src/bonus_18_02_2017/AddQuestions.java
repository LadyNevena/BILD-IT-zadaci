package bonus_18_02_2017;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.awt.event.ActionEvent;

public class AddQuestions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestions frame = new AddQuestions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//vraca ukupno pitanja iz fajla
	public static int numberOfQuestions(String filename) {
		FileInputStream input;
		int counter = 0;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				while ((reader.readLine()) != null) {
					counter++;
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}
	
	public static void writeQuestion(String filename, String question) {
		try {
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter writer = new BufferedWriter(fw);
			try {
				writer.write(question);
			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String readLogged(String filename) {
		FileInputStream input;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line=null;
				while ((line = reader.readLine()) != null) {
					return line;
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//ova je uduplana metoda, ne treba, prepravi samo jednu za write u fajl
	//i ubaci ti liniju pa onda upise u fajl. popravi!!!!
	public static void writeAnswers(String filename, String answer) {
		try {
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter writer = new BufferedWriter(fw);
			try {
				writer.write(answer);

			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public AddQuestions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Ukupno pitanja:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("Broj pitanja");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setText("" + numberOfQuestions("kviz.txt"));

		JLabel lblNewLabel_2 = new JLabel("Unesite novo pitanje :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.BLUE);

		JLabel lblNewLabel_3 = new JLabel("C");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("")
						|| textField_2.getText().equals("") || textField_3.getText().equals("")
						|| textField_4.getText().equals("") || textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Popunite sva polja!");
				}else if (!(textField_5.getText().equals("A") || textField_5.getText().equals("B")
						|| textField_5.getText().equals("C") || textField_5.getText().equals("D"))
						|| textField_5.getText().length() != 1) {
					JOptionPane.showMessageDialog(null, "U polje taènog odgovora unesite A, B, C ili D!");
				} else {
					ReaderWriter.write("kviz.txt", textField.getText());
					String answer = textField_1.getText() + "#" + textField_2.getText() + "#"
							+ textField_3.getText() + "#" + textField_4.getText();
					ReaderWriter.write("odgovori.txt", answer);
					ReaderWriter.write("rjesenja.txt", textField_5.getText());
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					JOptionPane.showMessageDialog(null, "Uspješno saèuvano!");
					lblNewLabel_1.setText("" + numberOfQuestions("kviz.txt"));
				}

			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("ok.png"));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.MAGENTA);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.setVisible(true);
				adminMenu.setLabel(readLogged("logged.txt"));
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("back.jpg"));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 15));

		JLabel lblNewLabel_4 = new JLabel("Unesite odgovore:");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.BLUE);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Unesite ta\u010Dan odgovor:");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 13));

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("A");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JLabel lblNewLabel_7 = new JLabel("B");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JLabel lblD = new JLabel("D");
		lblD.setForeground(Color.RED);
		lblD.setFont(new Font("Arial Black", Font.PLAIN, 13));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(18)
										.addComponent(lblNewLabel_1))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane
												.createParallelGroup(
														Alignment.LEADING)
												.addComponent(lblNewLabel_4).addComponent(lblNewLabel_2)
												.addComponent(lblNewLabel_5))
										.addGap(25)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textField)
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(8)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(textField_5,
																				GroupLayout.DEFAULT_SIZE, 218,
																				Short.MAX_VALUE)
																		.addGroup(gl_contentPane.createSequentialGroup()
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(lblNewLabel_3)
																						.addComponent(lblNewLabel_6))
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addGroup(gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(textField_3,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								204, Short.MAX_VALUE)
																						.addComponent(textField_1,
																								GroupLayout.DEFAULT_SIZE,
																								166, Short.MAX_VALUE))))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblD, GroupLayout.PREFERRED_SIZE,
																				10, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblNewLabel_7)))
														.addGroup(gl_contentPane.createSequentialGroup().addGap(78)
																.addComponent(btnNewButton_1,
																		GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(textField_4)
																.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
																		197, GroupLayout.PREFERRED_SIZE)
																.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
																		80, GroupLayout.PREFERRED_SIZE))))))
						.addContainerGap(39, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_7)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6).addComponent(textField_1,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19,
										GroupLayout.PREFERRED_SIZE))
						.addGap(44)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(46)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_5)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(21).addGroup(
								gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE))));
		contentPane.setLayout(gl_contentPane);
	}
}
