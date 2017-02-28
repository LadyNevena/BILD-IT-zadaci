package bonus_18_02_2017;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblNewLabel;
	public void setLabel(String message){
		this.lblNewLabel.setText(message);
		this.lblNewLabel.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//opet ovaj ulogovani
	public static void writeUser(String filename,String username) {
		Path path = Paths.get(filename);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path); 
			try {
				writer.write(username);
				
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
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JButton btnDodajNovogKorisnika = new JButton("Dodaj novo pitanje");
		btnDodajNovogKorisnika.setForeground(Color.RED);
		btnDodajNovogKorisnika.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnDodajNovogKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQuestions addQuestion = new AddQuestions();
				addQuestion.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Edituj pitanje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditQuestions editQuestion = new EditQuestions();
				editQuestion.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		JButton btnObriiKorisnika = new JButton("Edituj korisnika");
		btnObriiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditUser editUser = new EditUser();
				editUser.setVisible(true);
				dispose();
			}
		});
		btnObriiKorisnika.setForeground(Color.MAGENTA);
		btnObriiKorisnika.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Administrator:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.RED);
		
		JButton btnNewButton_1 = new JButton("Odjava");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeUser("logged.txt", "");
				Quiz quiz = new Quiz();
				quiz.getJFrame().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_1.setForeground(Color.PINK);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addContainerGap(112, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(127)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
						.addComponent(btnObriiKorisnika, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
						.addComponent(btnDodajNovogKorisnika, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(140))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(34)
					.addComponent(btnDodajNovogKorisnika, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnObriiKorisnika, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
