package net.codejava.sql;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SignUpGUI extends JFrame {
	
	static UserEclipse register = new UserEclipse();
	static SQLConnector connector = new SQLConnector();

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("SIGN UP");
	private final JLabel lblNewLabel_1 = new JLabel("Firstname:");
	private final JLabel lblNewLabel_1_1 = new JLabel("Lastname:");
	private final JLabel lblNewLabel_1_2 = new JLabel("Username:");
	private final JLabel lblNewLabel_1_3 = new JLabel("Password:");
	private final JLabel lblNewLabel_1_4 = new JLabel("Email:");
	private final JLabel lblNewLabel_1_5 = new JLabel("Birthday:");
	private final JLabel lblNewLabel_1_5_1 = new JLabel("Sex:");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JComboBox comboBox = new JComboBox();
	private final JButton btnNewButton = new JButton("Sign up");
	private final JLabel lblNewLabel_2 = new JLabel("already have an account?");
	private final JButton btnNewButton_1 = new JButton("Login");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpGUI frame = new SignUpGUI();
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
	public SignUpGUI() {
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(266, 72, 145, 29);
		textField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(287, 11, 124, 50);
		
		getContentPane().add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(138, 65, 133, 44);
		
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(138, 108, 133, 44);
		
		getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(138, 160, 133, 44);
		
		getContentPane().add(lblNewLabel_1_2);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_3.setBounds(138, 215, 133, 44);
		
		getContentPane().add(lblNewLabel_1_3);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_4.setBounds(138, 264, 133, 44);
		
		getContentPane().add(lblNewLabel_1_4);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_5.setBounds(138, 307, 133, 44);
		
		getContentPane().add(lblNewLabel_1_5);
		lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_5_1.setBounds(138, 362, 133, 44);
		
		getContentPane().add(lblNewLabel_1_5_1);
		
		getContentPane().add(textField);

		textField_1.setColumns(10);
		textField_1.setBounds(266, 120, 145, 29);
		getContentPane().add(textField_1);
		
		
		textField_2.setColumns(10);
		textField_2.setBounds(266, 172, 145, 29);
		getContentPane().add(textField_2);
		
		
		textField_3.setColumns(10);
		textField_3.setBounds(266, 226, 145, 29);
		getContentPane().add(textField_3);
		
		
		textField_4.setColumns(10);
		textField_4.setBounds(266, 274, 145, 29);
		getContentPane().add(textField_4);
		
		
		textField_5.setColumns(10);
		textField_5.setBounds(266, 319, 145, 29);
		getContentPane().add(textField_5);
		
		
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"female", "male", "other"}));
		comboBox.setBounds(266, 370, 145, 29);
		getContentPane().add(comboBox);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					register.setFirstName(textField.getText());
					register.setLastName(textField_1.getText());
					register.setUserName(textField_2.getText());
					register.setPassword(textField_3.getText());
					register.setEmail(textField_4.getText());
					register.setBirthDay(textField_5.getText());
					int i = 0;
					String s = comboBox.getSelectedItem().toString();
					
					switch (s) {
					case "female":
						i = 1;
						break;
					case "male":
						i = 2;
						break;
					case "other":
						i = 3;
						break;
					}
					register.setSex(i);
					connector.addUser(register);
					LoginGUI logingui = new LoginGUI();
					if (arg0.getSource() == btnNewButton) {
						logingui.setVisible(true);
						dispose();
					} 
					
				} catch (SQLException e) {
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton_1) {
					LoginGUI logingui = new LoginGUI();
					logingui.setVisible(true);
					dispose();
				}
			}
		});
			
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(460, 416, 155, 50);
		getContentPane().add(btnNewButton);
		
		
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(486, 28, 145, 27);
		getContentPane().add(lblNewLabel_2);
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1.setBounds(623, 30, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		
		
	}

	


}


