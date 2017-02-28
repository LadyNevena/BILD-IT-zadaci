package bonus_18_02_2017;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Questions extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int k = 4;
	int p = 1;
	int j = 0;
	int correct = 0;
	public JLabel lblNewLabel;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questions frame = new Questions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static java.util.ArrayList<String> readQuestions(String filename, java.util.ArrayList<Integer> questNumber) {
		java.util.ArrayList<String> list = new java.util.ArrayList<>();
		for (int i = 0; i < questNumber.size(); i++) {
			list.add(ReaderWriter.readQuestion(filename, ""+questNumber.get(i)));
		}

		return list;
	}



	public static java.util.ArrayList<String> readAnswers(String filename, java.util.ArrayList<Integer> answerNumber) {
		java.util.ArrayList<String> list = new java.util.ArrayList<>();

		for (int i = 0; i < answerNumber.size(); i++) {
			String line = ReaderWriter.readQuestion(filename, ""+answerNumber.get(i));
			String[] answers = line.split("#");
			//stem.out.println("PPPPP "+answers.length);
			for (int j = 0; j <answers.length; j++) {
				list.add(answers[j]);
			}
		}
		return list;
	}

	// generise n manjih od m nasumicnih brojeva i smjesta u listu i to ce biti
	// odabrana pitanja u kvizu
	public static java.util.ArrayList<Integer> listGenNum(int n, int size) {
		java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
		int num = 0;
		while (list.size() < n) {
			num = (int) (Math.random() * size + 1);
			while (list.contains(num)) {
				num = (int) (Math.random() * size + 1);
			}
			list.add(num);
		}
		return list;
	}

	
	/**
	 * Create the frame.
	 */
	public Questions() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 320);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));

		JLabel lblPitanjeBroj = new JLabel("");
		lblPitanjeBroj.setBackground(Color.WHITE);
		lblPitanjeBroj.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblPitanjeBroj.setForeground(Color.BLUE);

		btnNewButton = new JButton("New button");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));

		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 15));

		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 15));

		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 15));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.GREEN);
		java.util.ArrayList<Integer> list = listGenNum(25, ReaderWriter.numberOfQuestions("kviz.txt"));
		java.util.ArrayList<String> questions = readQuestions("kviz.txt", list);
		java.util.ArrayList<String> answers = readAnswers("odgovori.txt", list);
		java.util.ArrayList<String> correctAnswers = readQuestions("rjesenja.txt", list);
		lblNewLabel.setText(questions.get(0));
		btnNewButton.setText(answers.get(0));
		btnNewButton_1.setText(answers.get(1));
		btnNewButton_2.setText(answers.get(2));
		btnNewButton_3.setText(answers.get(3));
       /*
         for (int i = 0; i < readAnswers("odgovori.txt", list).size(); i++) {
			System.out.println(readAnswers("odgovori.txt", list).get(i));
		}
		
		*/
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (k >= answers.size() || p >= questions.size()) {
					Finish finish = new Finish();
					finish.setVisible(true);
					finish.lblNewLabel.setText("" + ((double) correct / 25 * 100) + "%");
					ReaderWriter.write("sacuvaniRezultati.txt", ReaderWriter.readFile("logged.txt").get(0)+" "+
							Double.toString((double) correct / 25 * 100));
					dispose();
				} else {
					lblNewLabel.setText(questions.get(p));
					btnNewButton.setText(answers.get(k));
					btnNewButton_1.setText(answers.get(k + 1));
					btnNewButton_2.setText(answers.get(k + 2));
					btnNewButton_3.setText(answers.get(k + 3));
					String answer = correctAnswers.get(j++);
					if (answer.equals("A")) {
						correct++;
						lblPitanjeBroj.setIcon(new ImageIcon("correct.jpg"));
					} else {
						lblPitanjeBroj.setIcon(new ImageIcon("uncorrect.jpg"));
					}
					lblNewLabel_1.setText("" + correct + "/25");
					k += 4;
					p++;

				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (k >= answers.size() || p >= questions.size()) {
					Finish finish = new Finish();
					finish.setVisible(true);
					finish.lblNewLabel.setText("" + ((double) correct / 25 * 100) + "%");
					ReaderWriter.write("sacuvaniRezultati.txt", ReaderWriter.readFile("logged.txt").get(0)+" "+
							Double.toString((double) correct / 25 * 100));
					dispose();
				} else {

					lblNewLabel.setText(questions.get(p));
					btnNewButton.setText(answers.get(k));
					btnNewButton_1.setText(answers.get(k + 1));
					btnNewButton_2.setText(answers.get(k + 2));
					btnNewButton_3.setText(answers.get(k + 3));
					String answer = correctAnswers.get(j++);

					if (answer.equals("B")) {
						lblPitanjeBroj.setIcon(new ImageIcon("correct.jpg"));
						correct++;
					} else {
						lblPitanjeBroj.setIcon(new ImageIcon("uncorrect.jpg"));
					}
					lblNewLabel_1.setText("" + correct + "/25");
					k += 4;
					p++;

				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (k >= answers.size() || p >= questions.size()) {
					Finish finish = new Finish();
					finish.setVisible(true);
					finish.lblNewLabel.setText("" + ((double) correct / 25 * 100) + "%");
					ReaderWriter.write("sacuvaniRezultati.txt", ReaderWriter.readFile("logged.txt").get(0)+" "+
							Double.toString((double) correct / 25 * 100));

					dispose();
				} else {
					lblNewLabel.setText(questions.get(p));
					btnNewButton.setText(answers.get(k));
					btnNewButton_1.setText(answers.get(k + 1));
					btnNewButton_2.setText(answers.get(k + 2));
					btnNewButton_3.setText(answers.get(k + 3));
					String answer = correctAnswers.get(j++);

					if (answer.equals("C")) {
						lblPitanjeBroj.setIcon(new ImageIcon("correct.jpg"));
						correct++;
					} else {
						lblPitanjeBroj.setIcon(new ImageIcon("uncorrect.jpg"));
					}
					lblNewLabel_1.setText("" + correct + "/25");
					k += 4;
					p++;

				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (k >= answers.size() || p >= questions.size()) {
					Finish finish = new Finish();
					finish.setVisible(true);
					finish.lblNewLabel.setText("" + ((double) correct / 25 * 100) + "%");
					ReaderWriter.write("sacuvaniRezultati.txt", ReaderWriter.readFile("logged.txt").get(0)+" "+
							Double.toString((double) correct / 25 * 100));
					dispose();
				} else {
					lblNewLabel.setText(questions.get(p));
					btnNewButton.setText(answers.get(k));
					btnNewButton_1.setText(answers.get(k + 1));
					btnNewButton_2.setText(answers.get(k + 2));
					btnNewButton_3.setText(answers.get(k + 3));
					String answer = correctAnswers.get(j++);
					if (answer.equals("D")) {
						lblPitanjeBroj.setIcon(new ImageIcon("correct.jpg"));
						correct++;
					} else {
						lblPitanjeBroj.setIcon(new ImageIcon("uncorrect.jpg"));
					}
					lblNewLabel_1.setText("" + correct + "/25");
					k += 4;
					p++;

				}
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(21).addGroup(gl_contentPane.createParallelGroup(
						Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
								.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
										.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
								.addContainerGap())
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addComponent(lblPitanjeBroj)
												.addPreferredGap(ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
												.addComponent(lblNewLabel_1).addGap(22))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(lblPitanjeBroj))
						.addGap(16).addComponent(lblNewLabel).addGap(18).addComponent(btnNewButton)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_1).addGap(18)
						.addComponent(btnNewButton_2).addGap(18).addComponent(btnNewButton_3).addGap(24)));
		contentPane.setLayout(gl_contentPane);
	}
}
