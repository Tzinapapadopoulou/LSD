package net.codejava.sql; 

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.*;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;

public class Match extends JFrame {

		private JPanel contentPane;
	    public static int position;
	    
	    public void setPosition(int a){
			position = a;
	    }
	   
	    public boolean flag = false;
	    public String liker;
	    public static boolean thereIsAtLeastABuddy;
	    private JTextField textField_1 = new JTextField();
	    private final JButton btnNewButton = new JButton("Like");
	    private final JLabel lblNewLabel = new JLabel("Like your possible travel buddy");
	    DefaultListModel model = new DefaultListModel();
	    private final JButton btnNewButton_1 = new JButton("load matches");
	    private JList list = new JList(model);
	    private void initGUI() {
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 524, 380);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
			contentPane.setForeground(new Color(0, 128, 128));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			//DefaultListModel model = new DefaultListModel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
			lblNewLabel.setBounds(138, 11, 257, 35);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
			contentPane.add(lblNewLabel);
			list.setBounds(161, 46, 191, 253);
			list.setBackground(new Color(248, 248, 248));
			contentPane.add(list);
	        list.addListSelectionListener(new ListSelectionListener() {
	    		@Override
	    		public void valueChanged(ListSelectionEvent e) {
	    		String liked = list.getSelectedValue().toString();
	    		System.out.println(liked);
	    		if (!e.getValueIsAdjusting()) {
	    		try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
		            String user = "LSD";
		            String passWord = "LSD123";
		            Connection conn = DriverManager.getConnection(url, user, passWord);
		            System.out.println("connected successfully to Database");
		            Statement stmt3 = conn.createStatement();
		            ResultSet rs3= null;
		            String sqlforlike = "select USERNAME from USERS where POSITION=" + String.valueOf(position);
		           
		            rs3 = stmt3.executeQuery(sqlforlike);
		            rs3.next();
			        liker = rs3.getString("USERNAME");
	    		} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		Like like = new Like();
	    		System.out.println(liked + liker);
	    		like.whoLikedWho(liked, liker);
	    		}
	    		}
			});
		}
	    
	    public ArrayList<Integer> matchingUsersProfile() throws ClassNotFoundException {
	    	thereIsAtLeastABuddy = false;
	        List<Integer> allowlike = new ArrayList<Integer>();
	        
	        try{
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
	            String user = "LSD";
	            String passWord = "LSD123";
	            Connection conn = DriverManager.getConnection(url, user, passWord);
	            System.out.println("connected successfully to Database");
	            Statement stmt1 = conn.createStatement();
	            Statement stmt2 = conn.createStatement();
	            Statement stmt = conn.createStatement();
	            ResultSet rs1= null;
	            ResultSet rs2 = null;
	            ResultSet rs = null;
	        
	            String sql2 = "SELECT COUNT(*) FROM USERS" ; //αριθμος σειρων βασης
	            rs = stmt.executeQuery(sql2);
	            rs.next();
	            int x = rs.getInt(1);
	            
	            try {
	                String sqlfortheuser = "select DEST, MONTHY, USERNAME from USERS where POSITION=" + String.valueOf(position);
	                rs1 = stmt1.executeQuery(sqlfortheuser);
	                while(rs1.next()) {
	                	for(int i = 1;i<=x; i++) {        
	                		try {
	                        	String sql = "select DEST, MONTHY, USERNAME from USERS where POSITION=" + String.valueOf(i);
	                        	rs2 = stmt2.executeQuery(sql);
	                        	while (rs2.next()) {
	                                if (rs1.getInt("DEST") == rs2.getInt("DEST") && i != position && rs1.getString("MONTHY").equals(rs2.getString("MONTHY"))) { 
	                                		if (thereIsAtLeastABuddy == false) {
	                                			System.out.println("Your possible travel Buddies are :");
	                                			thereIsAtLeastABuddy = true;
	                                		}
	                                		System.out.println(rs2.getString("USERNAME"));
	                                		model.addElement(rs2.getString("USERNAME"));
	                                		allowlike.add(i);
	                                		
	                                }
	                        	}
	                        } catch (SQLException e) {
	                            System.out.println(e);
	                        }
	                       
	                    }
	                    
	                }
	               
	            } catch (SQLException e) {
	                System.out.println(e);
	            }
	            conn.close();
	        }catch (SQLException e){
	            System.out.println("SQLException :");
	        }
	        if (thereIsAtLeastABuddy == false) {
	            System.out.println("We're sorry but there isn't any travel buddy for you. Please try again with new destination info");
	            return (ArrayList<Integer>) allowlike;
	        }else {
	            return (ArrayList<Integer>) allowlike;
	        }
	        
	    }
	    
	    public boolean getBoolean() {
	    	return thereIsAtLeastABuddy;
	    }
	    


	/**
	 * Launch the application.
	 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Match frame = new Match();
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
		public Match() {
			initGUI();
		}
		
}
