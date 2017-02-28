package bonus_18_02_2017;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import javax.swing.JLabel;
import java.awt.Color;

public class UserMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;

	public void setLabel(String message) {
		this.lblNewLabel.setText(message);
		this.lblNewLabel.setVisible(true);
	}

	public String getLabel() {
		return lblNewLabel.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu frame = new UserMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// cita rezultate
	public static String readScores(String filename, String username) {
		FileInputStream input;
		String score = "";
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] lines = line.split(" ");
					if (lines[0].equals(username)) {
						score += lines[1] + "%" + "\n";
					}
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return score;
	}

	// sortira listu sa rezultatima
	public static void sortList(java.util.ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				if (Double.parseDouble((list.get(j).split(" ")[1])) < Double
						.parseDouble(list.get(j + 1).split(" ")[1])) {
					String temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}

	// ovo vraca rezultate tj. treba top 100, ali ja ih sve iscitam sortirane
	public static String readTopScores(String filename) {
		FileInputStream input;
		java.util.ArrayList<String> scores = new java.util.ArrayList<>();
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					scores.add(line);

				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sortList(scores);
		for (int i = 0; i < scores.size(); i++) {
			System.out.println(scores.get(i));
		}
		String results = "";
		int topSize = 0;
		if (scores.size() < 100) {
			topSize = scores.size();
		} else {
			topSize = 100;
		}
		for (int i = 0; i < topSize; i++) {
			results += (i + 1) + ". " + scores.get(i).split(" ")[0] + "\t\t" + scores.get(i).split(" ")[1] + "%" + "\n";
			System.out.println(results);
		}

		return results;
	}

	public static java.util.ArrayList<String> readQuestions(String filename, java.util.ArrayList<Integer> questNumber) {
		java.util.ArrayList<String> list = new java.util.ArrayList<>();
		for (int i = 0; i < questNumber.size(); i++) {
			list.add(ReaderWriter.readQuestion(filename, "" + questNumber.get(i)));
		}

		return list;
	}

	/**
	 * Create the frame.
	 */
	public UserMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 500, 450, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JButton btnNewButton = new JButton("Igraj\r\n");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questions questions = new Questions();
				questions.setVisible(true);
				dispose();

			}
		});

		JButton btnNewButton_1 = new JButton("Prethodni rezultati\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Score scores = new Score();
				scores.setVisible(true);
				scores.lblNewLabel.setText("Korisnicko ime: "+ReaderWriter.readFile("logged.txt").get(0));
				scores.textArea
						.setText((readScores("sacuvaniRezultati.txt", ReaderWriter.readFile("logged.txt").get(0))));
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 15));

		JButton btnNewButton_2 = new JButton("Top 100");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TopScore topScores = new TopScore();
				topScores.setVisible(true);
				topScores.textArea.setText(readTopScores("sacuvaniRezultati.txt"));
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 15));

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Korisnik:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.RED);

		JButton btnNewButton_3 = new JButton("Odjava");
		btnNewButton_3.setForeground(Color.MAGENTA);
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReaderWriter.writeLogged("logged.txt", "");
				Quiz quiz = new Quiz();
				quiz.getJFrame().setVisible(true);
				dispose();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblNewLabel_1).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(12)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 236,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
										.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblNewLabel))
				.addGap(92)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_1).addComponent(lblNewLabel))
												.addGap(29)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 73,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 78,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 76,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(40, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
