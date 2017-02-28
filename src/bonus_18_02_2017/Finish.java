package bonus_18_02_2017;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Finish extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	public JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish frame = new Finish();
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
	public Finish() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblKvizJeZavren = new JLabel("Kviz je zavr\u0161en");
		lblKvizJeZavren.setForeground(Color.RED);
		lblKvizJeZavren.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblRezultat = new JLabel("Rezultat:");
		lblRezultat.setForeground(Color.RED);
		lblRezultat.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon("back.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu usermenu = new UserMenu();
				usermenu.setLabel(ReaderWriter.readFile("logged.txt").get(0));
				usermenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setForeground(Color.RED);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.BLUE);
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblKvizJeZavren, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(lblRezultat)
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(164)
							.addComponent(btnNewButton)))
					.addGap(155))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKvizJeZavren)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRezultat)
						.addComponent(lblNewLabel))
					.addGap(53)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
