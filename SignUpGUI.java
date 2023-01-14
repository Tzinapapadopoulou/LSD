package net.codejava.sql;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class SignUpGUI extends JFrame {
	
	static UserEclipse register = new UserEclipse();
	static SQLConnector connector = new SQLConnector();
    
	private Image img_logo = new ImageIcon(SignUpGUI.class.getResource("/images/4312298.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	
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
	private final JComboBox comboBox = new JComboBox();
	private final JButton btnNewButton = new JButton("Sign up");
	private final JLabel lblNewLabel_2 = new JLabel("already have an account?");
	private final JButton btnNewButton_1 = new JButton("Login");
	private final JLabel lbl_logo = new JLabel("");
	private final JLabel lblNewLabel_4 = new JLabel("Tra");
	private final JLabel lblNewLabel_5 = new JLabel("Budz");
	private final JDateChooser dateChooser = new JDateChooser();


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
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(266, 72, 145, 29);
		textField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 612);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(289, 12, 124, 50);
		
		getContentPane().add(lblNewLabel);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(138, 65, 133, 44);
		
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(138, 108, 133, 44);
		
		getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(138, 160, 133, 44);
		
		getContentPane().add(lblNewLabel_1_2);
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1_3.setBounds(138, 215, 133, 44);
		
		getContentPane().add(lblNewLabel_1_3);
		lblNewLabel_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1_4.setBounds(138, 264, 133, 44);
		
		getContentPane().add(lblNewLabel_1_4);
		lblNewLabel_1_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1_5.setBounds(138, 307, 133, 44);
		
		getContentPane().add(lblNewLabel_1_5);
		lblNewLabel_1_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_5_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		lblNewLabel_1_5_1.setBounds(138, 362, 133, 44);
		
		getContentPane().add(lblNewLabel_1_5_1);
		
		getContentPane().add(textField);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_1.setColumns(10);
		textField_1.setBounds(266, 120, 145, 29);
		getContentPane().add(textField_1);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		textField_2.setColumns(10);
		textField_2.setBounds(266, 172, 145, 29);
		getContentPane().add(textField_2);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		textField_3.setColumns(10);
		textField_3.setBounds(266, 226, 145, 29);
		getContentPane().add(textField_3);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		textField_4.setColumns(10);
		textField_4.setBounds(266, 274, 145, 29);
		getContentPane().add(textField_4);
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"female", "male", "other"}));
		comboBox.setBounds(266, 370, 145, 29);
		getContentPane().add(comboBox);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					register.setFirstName(textField.getText());
					register.setLastName(textField_1.getText());
					register.setUserName(textField_2.getText());
					register.setPassword(textField_3.getText());
					register.setEmail(textField_4.getText());
					register.setBirthDay(dateChooser.getDate().toString());
					
					System.out.println(dateChooser.getDate().toString());
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
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton_1) {
					LoginGUI logingui = new LoginGUI();
					logingui.setVisible(true);
					dispose();
				}
			}
		});
			
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		btnNewButton.setBounds(472, 437, 216, 50);
		getContentPane().add(btnNewButton);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(531, 28, 145, 27);
		getContentPane().add(lblNewLabel_2);
		
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 13));
		btnNewButton_1.setBounds(674, 30, 101, 23);
		getContentPane().add(btnNewButton_1);
		
		
		lbl_logo.setBounds(485, 132, 145, 72);
		contentPane.add(lbl_logo);
		lbl_logo.setIcon(new ImageIcon(img_logo));
		
		lblNewLabel_4.setForeground(new Color(192, 192, 192));
		lblNewLabel_4.setFont(new Font("Bauhaus 93", Font.PLAIN, 65));
		lblNewLabel_4.setBounds(508, 138, 93, 158);
		contentPane.add(lblNewLabel_4);
		
		
		lblNewLabel_5.setForeground(new Color(255, 128, 64));
		lblNewLabel_5.setFont(new Font("Bauhaus 93", Font.PLAIN, 65));
		lblNewLabel_5.setBounds(597, 176, 157, 83);
		contentPane.add(lblNewLabel_5);
		dateChooser.setBounds(266, 321, 147, 30);
		
		contentPane.add(dateChooser);
	}
}


