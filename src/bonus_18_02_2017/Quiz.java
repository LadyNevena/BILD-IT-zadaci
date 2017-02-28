package bonus_18_02_2017;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quiz {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz window = new Quiz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getJTextField(){
		return textField.getText();
	}
	public JFrame getJFrame(){
		return frame;
	}

	/**
	 * Create the application.
	 */
	public Quiz() {
		initialize();
	}
	//metoda za login
	public static boolean logAs(String username, String password, String filename) {
		Path path = Paths.get(filename);
		boolean flag = false;
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] readAdmin = line.split(" ");
					if (readAdmin[0].equals(username) && readAdmin[1].equals(password)) {
						flag = true;
					}
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(600, 600, 500, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		

		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 11));

		JLabel lblNewLabel_1 = new JLabel("Korisni\u010Dko ime:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));

		JLabel lblNewLabel_2 = new JLabel("Lozinka\r\n:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "----Uloguj se kao----", "Administrator", "Korisnik" }));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("quiz.jpg"));

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		JButton btnUlogujSe = new JButton("Uloguj se");
		btnUlogujSe.setFont(new Font("Arial Black", Font.PLAIN, 11));
		// sta se desava kad kliknemo na uloguj se
		btnUlogujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// hocemo da zatvorimo tekuci prozor i otvorimo userMenu
				boolean loged = false;
				String username = textField.getText();
				String password = textField_2.getText();
				String choice = (String) comboBox.getSelectedItem();
		      //System.out.println(choice);
			  //System.out.println(password);
		      //System.out.println(username);
				if (choice.equals("Administrator")) {
					if (logAs(username, password,"admin.txt")) {
						loged = true;
						if (loged) {
							JOptionPane.showMessageDialog(null,"Upješno ste se ulogovali!");
							AdminMenu adminMenu = new AdminMenu();
							adminMenu.setVisible(true);
							ReaderWriter.writeLogged("logged.txt", username);
							adminMenu.setLabel(username);
							frame.dispose();
						}
					}
					else{
						lblNewLabel_4.setVisible(true);
						lblNewLabel_4.setText("Korisnièko ime ili lozinka su nevažeæi!");
					}
				}
				else if(choice.equals("Korisnik")){
					if(logAs(username,password,"user.txt")){
						loged = true;
						if (loged) {
							JOptionPane.showMessageDialog(null,"Uspješno ste se ulogovali!");
							UserMenu userMenu = new UserMenu();
							userMenu.setVisible(true);
							userMenu.setLabel(username);
							ReaderWriter.writeLogged("logged.txt", username);
							frame.dispose();
							}
					}
					else{
						lblNewLabel_4.setVisible(true);
						lblNewLabel_4.setText("Korisnièko ime ili lozinka su nevažeæi!");
					
					}
				}
				else{
					lblNewLabel_4.setVisible(true);
					lblNewLabel_4.setText("Molimo, ulogujte se kao Administrator ili kao korisnik!");
				
				}
			}

		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_2, 121, 121, Short.MAX_VALUE)
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField))
					.addContainerGap(97, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(lblNewLabel_3)
					.addContainerGap(303, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(177)
					.addComponent(btnUlogujSe, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(196))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addContainerGap(423, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addComponent(btnUlogujSe, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addGap(133))
		);
		frame.getContentPane().setLayout(groupLayout);

	}
}
