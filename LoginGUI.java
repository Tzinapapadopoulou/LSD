package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class LoginGUI extends JFrame {

	
	
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("LOGIN ");
	private final JLabel lblNewLabel_1 = new JLabel("Username:");
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel_1_1 = new JLabel("Password:");
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton btnNewButton = new JButton("Login");
	private final JLabel lblNewLabel_1_2 = new JLabel("Destination:");
	private final JLabel lblNewLabel_1_2_1 = new JLabel("Month:");
	private final JButton btnNewButton_1 = new JButton("Create an account");
	private final JLabel lblNewLabel_2 = new JLabel("New to Trabuds?");
	private final JComboBox comboBox = new JComboBox();
	private final JComboBox comboBox_1 = new JComboBox();

	/**\
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(295, 105, 121, 30);
		textField.setColumns(10);
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 11, 205, 53);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(143, 98, 115, 39);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(textField);                                         //Εισαγωγη ονοματος
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(143, 148, 122, 30);
		
		contentPane.add(lblNewLabel_1_1);
		passwordField.setBounds(295, 152, 121, 30);
		contentPane.add(passwordField);                                     //Εισαγωγη κωδικου
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		btnNewButton.setBounds(180, 319, 155, 39);
		contentPane.add(btnNewButton);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(143, 200, 122, 30);
		
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_2_1.setBounds(143, 252, 95, 30);
		
		contentPane.add(lblNewLabel_1_2_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton_1.setBounds(211, 410, 205, 30);
		
		contentPane.add(btnNewButton_1);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(70, 410, 275, 30);
		
		contentPane.add(lblNewLabel_2);
		comboBox.setEditable(true);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Athens", "Paris", "Rome", "London", "Barcelona", "Prague", "Vienna", "Amsterdam", "Budapest", "Lisbon", "Copenagen", "Instabul", "Berlin", "Stockholm", "Dublin", "Oslo", "Milan", "Bucharest", "Moscha", "Madrid", ""}));
		comboBox.setBounds(295, 204, 128, 30);
     	contentPane.add(comboBox);  //εισαγωγη του προορισμου
     	
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(295, 252, 128, 30);
		contentPane.add(comboBox_1); //εισαγωγη μηνα
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
		            String user = "LSD";
		            String passWord = "LSD123";
		            Connection conn = DriverManager.getConnection(url, user, passWord);
		            System.out.println("connected successfully to Database");
		            
		            Statement stmt = conn.createStatement();
		            String query = "UPDATE USERS SET DEST=?, MONTHY=? WHERE POSITION= ?";
		            PreparedStatement pstmt = conn.prepareStatement(query);
		            
		    		int i = 0;        //αρχικοποιηση μεταβλητης που μετατρεπει το string του πινακα σε int για να μπει στη βαση σωστα
		         	String dest = comboBox.getSelectedItem().toString(); //αποκτηση τιμης προορισμου που επιλεγει ο χρηστης και μετατροπη σε String απο object
		         	switch (dest) {
		         	case "Athens": 
		         		i = 1;
		         		break;
		         	case "Paris": 
		         		i = 2;
		         		break;
		         	case "Rome": 
		         		i = 3;
		         		break;
		         	case "London": 
		         		i = 4;
		         		break;
		         	case "Barcelona": 
		         		i = 5;
		         		break;
		         	case "Prague": 
		         		i = 6;
		         		break;
		         	case "Vienna": 
		         		i = 7;
		         		break;
		         	case "Amsterdam": 
		         		i = 8;
		         		break;
		         	case "Budapest": 
		         		i = 9;
		         		break;
		         	case "Lisbon": 
		         		i = 10;
		         		break;
		         	case "Copenagen": 
		         		i = 11;
		         		break;
		         	case "Instabul": 
		         		i = 12;
		         		break;
		         	case "Berlin": 
		         		i = 13;
		         		break;
		         	case "Stockholm": 
		         		i = 14;
		         		break;
		         	case "Dublin": 
		         		i = 15;
		         		break;
		         	case "Oslo": 
		         		i = 16;
		         		break;
		         	case "Milan": 
		         		i = 17;
		         		break;
		         	case "Bucharest": 
		         		i = 18;
		         		break;
		         	case "Moscha": 
		         		i = 19;
		         		break;
		         	case "Madrid": 
		         		i = 20;
		         		break;
		         	}
		         	final int proorismos = i; 
		         	String mhnas = comboBox_1.getSelectedItem().toString(); //αποκτηση της τιμης του μηνα που επιλεγει ο χρηστης και μεταροπη σε string απο object
		            
		            String sql = "Select * from USERS where USERNAME='"+textField.getText()+"' and PASSWORDY='"+passwordField.getText()+"'";
		            ResultSet rs = stmt.executeQuery(sql);
		            
		            if (rs.next()) {
		            	JOptionPane.showMessageDialog(null,  "login successfully");
			            int position = rs.getInt(1); //παιρνουμε τη θεση που βρισκεται ο χρηστης μας στη βαση δεδομενων
			         	
		            	pstmt.setInt(1, proorismos); //Μπαινουν τα στοιχεια στη βαση(dest, monthy) μονο σε περιπτωση που ο χρηστης υπαρχει
		                pstmt.setString(2, mhnas);
		                pstmt.setInt(3, position);
		                pstmt.executeUpdate(); //μπαινουν τα στοιχεια στη βαση 
		                Match match = new Match();
		                match.setPosition(position);
		                match.matchingUsersProfile();
		                if (match.getBoolean() == false) {
		                	dispose();
		                	JOptionPane.showMessageDialog(null, "We're sorry but there isn't any travel buddy for you. Please try again with new destination info");
		                	EventQueue.invokeLater(new Runnable() {
		            			public void run() {
		            				try {
		            					LoginGUI frame = new LoginGUI();
		            					frame.setVisible(true);
		            				} catch (Exception e) {
		            					e.printStackTrace();
		            				}
		            			}
		            		});
		                }
		            } else {
		            	JOptionPane.showMessageDialog(null,  "Incorrect user data");
		            }
		       
		            
		            conn.commit();
		            conn.close();
					
				} catch (SQLException e) {
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == btnNewButton_1 ) {
					SignUpGUI signupgui =new SignUpGUI();
					signupgui.setVisible(true);
					dispose();
				}
				
			}
	    });
	}
}
