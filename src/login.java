import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class login {

	private JFrame login;
	private JTextField usernameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	
	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new JFrame("Login");
		login.setBounds(100, 100, 575, 517);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		login.setResizable(false);
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		usernameLabel.setBounds(84, 99, 148, 47);
		login.getContentPane().add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(240, 96, 200, 50);
		login.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password: ");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		PasswordLabel.setBounds(84, 165, 148, 47);
		login.getContentPane().add(PasswordLabel);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from doctors where username = ? and password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameTextField.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs = pst.executeQuery();
					
					int count =  0;
					while(rs.next()) {
						count = count+1;
						
					}
					
					if(count==1) {
						JOptionPane.showInternalMessageDialog(null, "Usernamand Password are correct");
						login.dispose();
						Gestion_Patient GestionPatient = new Gestion_Patient();
						GestionPatient.setVisible(true);
						
					}
					else if(count > 1){
						JOptionPane.showInternalMessageDialog(null, "Dublicate Usernamand Password");
					}
					else{
						JOptionPane.showInternalMessageDialog(null, "Usernamand Password are not correct Try Again...");
					}
					
					rs.close();
					pst.close();
						
				}catch(Exception k)
				{
					JOptionPane.showInternalMessageDialog(null, k);
					
				}
				
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginButton.setBounds(169, 347, 211, 50);
		login.getContentPane().add(loginButton);
		
		JLabel enterInforamtionsLabel = new JLabel("Please Enter You Innfomations to Sign in");
		enterInforamtionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		enterInforamtionsLabel.setBounds(20, 48, 266, 13);
		login.getContentPane().add(enterInforamtionsLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Doctor");
		rdbtnNewRadioButton.setBackground(UIManager.getColor("Button.background"));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton.setBounds(240, 245, 200, 21);
		login.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Secretary");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_1.setBounds(240, 278, 200, 21);
		login.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategory.setBounds(84, 232, 148, 47);
		login.getContentPane().add(lblCategory);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(240, 167, 200, 50);
		login.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\GSEII\\GSEII_2\\Java\\Projects\\Cabinet_Project\\resources\\Cabinet-m\u00E9dical.jpg"));
		lblNewLabel.setBounds(0, -31, 575, 564);
		login.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(65, 323, 43, 13);
		login.getContentPane().add(label);
	}
}
