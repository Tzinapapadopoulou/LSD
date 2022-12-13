package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("LOGIN PAGE");
	private final JLabel lblNewLabel_1 = new JLabel("Username:");
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel_1_1 = new JLabel("Password:");
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton btnNewButton = new JButton("Login");

	/**
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
		textField.setBounds(153, 102, 121, 30);
		textField.setColumns(10);
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 25, 205, 50);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(48, 101, 95, 30);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(textField);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(48, 161, 95, 30);
		
		contentPane.add(lblNewLabel_1_1);
		passwordField.setBounds(153, 161, 121, 30);
		contentPane.add(passwordField);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
		            String user = "LSD";
		            String passWord = "LSD123";
		            Connection conn = DriverManager.getConnection(url, user, passWord);
		            System.out.println("conected successfully to Database");
		            Statement stmt = conn.createStatement();
		            String sql = "Select * from USERS where USERNAME='"+textField.getText()+"' and PASSWORDY='"+passwordField.getText()+"'";
		            ResultSet rs = stmt.executeQuery(sql);
		            if (rs.next())
		            	JOptionPane.showMessageDialog(null,  "login successfully");
		            else 
		            	JOptionPane.showMessageDialog(null,  "Incorrect user data");
		            
		            conn.close();
		   
				
					
				} catch (SQLException e) {
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					
				}
			}
		});
		
		
		
	
		btnNewButton.setBounds(286, 222, 102, 30);
		contentPane.add(btnNewButton);
	}
}
