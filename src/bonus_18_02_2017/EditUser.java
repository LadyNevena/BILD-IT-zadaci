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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class EditUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUser frame = new EditUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static boolean validUsernamePassword(String data) {
		if (data.length() != 8) {
			return false;
		}
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public EditUser() {
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setVisible(false);
		btnNewButton_2.setBorderPainted(false);
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setVisible(false);
		btnNewButton_4.setBorderPainted(false);
		JButton btnNewButton_1 = new JButton("Dodaj korisnika");
		JButton btnNewButton = new JButton("Obriši korisnika");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Unesite korisnicko ime:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("Unesite lozinku:");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));

		textField = new JTextField();
		textField.setVisible(false);
		textField.setColumns(10);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(ReaderWriter.alreadyExist("user.txt", textField.getText(), 0));
				if(!textField.getText().isEmpty()){
					if(ReaderWriter.alreadyExist("user.txt", textField.getText(), 0)){
						ReaderWriter.deleteUser("user.txt", textField.getText());
						ReaderWriter.deleteUser("sacuvaniRezultati.txt", textField.getText());
						btnNewButton_1.setEnabled(true);
						textField.setVisible(false);
						lblNewLabel.setVisible(false);
						btnNewButton_4.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Korisnièko ime ne postoji!");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Popunite sva polja!");
				}
				textField.setText("");

				
			}
		
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				btnNewButton_2.setVisible(true);
				btnNewButton.setEnabled(false);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(false);
				textField.setVisible(true);
				textField_1.setVisible(false);
				btnNewButton_4.setVisible(true);
				btnNewButton_2.setVisible(false);
				btnNewButton_1.setEnabled(false);
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));

		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Popunite sva polja!");
				} else if (!validUsernamePassword(textField.getText())) {
					JOptionPane.showMessageDialog(null,
							"" + "Korisnicko ime mora sadržavati 8 karaktera, bez znaka razmaka!");
				} else if (ReaderWriter.alreadyExist("user.txt", textField.getText(), 0)) {
					JOptionPane.showMessageDialog(null, "Korisnicko ime vec postoji!");
				} else if (!validUsernamePassword(textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "Lozinka nije validna!");
				} else if (ReaderWriter.alreadyExist("user.txt", textField.getText(), 1)) {
					JOptionPane.showMessageDialog(null, "Lozinka vec postoji!");
				} else {
					ReaderWriter.write("user.txt", textField.getText()+" "+textField_1.getText());
					lblNewLabel.setVisible(false);
					textField.setVisible(false);
					textField.setText("");
					textField_1.setVisible(false);
					textField_1.setText("");
					lblNewLabel_1.setVisible(false);
					btnNewButton_1.setVisible(true);
					btnNewButton.setVisible(true);
					btnNewButton.setEnabled(true);
					btnNewButton_4.setVisible(false);
					btnNewButton_2.setVisible(false);
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("ok.png"));



		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon("ok.png"));
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu adminMenu = new AdminMenu();
				adminMenu.setVisible(true);
				adminMenu.setLabel(ReaderWriter.readLogged("logged.txt"));
				dispose();
				
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setIcon(new ImageIcon("back.jpg"));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(126)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addGap(116))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
