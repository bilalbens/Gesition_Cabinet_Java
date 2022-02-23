import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;



public class patient_information extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextfield;
	private JTextField textFieldPrenom;
	private JTextField textField_nom;
	private JTextField textFieldBirthday;
	private JTextField textFieldCin;
	private JTextField textFieldMobile;
	private JTextField textFieldemail;
	private JTextField textadress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_information frame = new patient_information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	Gestion_Patient gst_patient = new Gestion_Patient();
	private JTextField textField;
	private JTextField textField_metier;
	private JTextField textField_gender;

	
	Connection connection = null;
	Connection connection1 = null;
	private JLabel ID_Label;
	
	/**
	 * Create the frame.
	 */
	public patient_information() {
		connection = sqliteConnection.dbConnector();
		connection1 = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel IbID = new JLabel("ID:");
		IbID.setFont(new Font("Tahoma", Font.BOLD, 16));
		IbID.setBounds(30, 139, 80, 30);
		getContentPane().add(IbID);
	
		
		JLabel Prenomaff = new JLabel("Prenom:");
		Prenomaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		Prenomaff.setBounds(30, 179, 80, 30);
		getContentPane().add(Prenomaff);
		
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNom.setBounds(30, 219, 80, 30);
		getContentPane().add(lblNom);
		
		
		JLabel Datedenaissib = new JLabel("Date de naissance:");
		Datedenaissib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Datedenaissib.setBounds(30, 259, 192, 30);
		getContentPane().add(Datedenaissib);
		
		
		JLabel CINib = new JLabel("N\u00B0 CIN:");
		CINib.setFont(new Font("Tahoma", Font.BOLD, 16));
		CINib.setBounds(30, 299, 80, 30);
		getContentPane().add(CINib);
		
		
		JLabel Mobileiiib = new JLabel("Mobile:");
		Mobileiiib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Mobileiiib.setBounds(30, 339, 80, 30);
		getContentPane().add(Mobileiiib);

		
		JLabel emailip = new JLabel("E-mail:");
		emailip.setFont(new Font("Tahoma", Font.BOLD, 16));
		emailip.setBounds(30, 379, 80, 30);
		getContentPane().add(emailip);
		
		
		JLabel adresseib = new JLabel("Adresse:");
		adresseib.setFont(new Font("Tahoma", Font.BOLD, 16));
		adresseib.setBounds(30, 419, 80, 30);
		getContentPane().add(adresseib);
		
		
		JLabel Metierib = new JLabel("M\u00E9tier:");
		Metierib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Metierib.setBounds(30, 459, 80, 30);
		getContentPane().add(Metierib);
		
		
		JLabel Genderriib = new JLabel("Gender:");
		Genderriib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Genderriib.setBounds(30, 499, 80, 30);
		getContentPane().add(Genderriib);
		
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(297, 181, 150, 30);
		contentPane.add(textFieldPrenom);
		
		
		textField_nom = new JTextField();
		textField_nom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_nom.setColumns(10);
		textField_nom.setBounds(297, 221, 150, 30);
		contentPane.add(textField_nom);
		
		
		textFieldBirthday = new JTextField();
		textFieldBirthday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(297, 261, 150, 30);
		contentPane.add(textFieldBirthday);
		
		
		textFieldCin = new JTextField();
		textFieldCin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCin.setColumns(10);
		textFieldCin.setBounds(297, 301, 150, 30);
		contentPane.add(textFieldCin);
		
		
		textFieldMobile = new JTextField();
		textFieldMobile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMobile.setColumns(10);
		textFieldMobile.setBounds(297, 341, 150, 30);
		contentPane.add(textFieldMobile);
		
		
		textFieldemail = new JTextField();
		textFieldemail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldemail.setColumns(10);
		textFieldemail.setBounds(297, 381, 150, 30);
		contentPane.add(textFieldemail);
		
		
		textadress = new JTextField();
		textadress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textadress.setColumns(10);
		textadress.setBounds(297, 421, 150, 30);
		contentPane.add(textadress);
		
		textField_metier = new JTextField();
		textField_metier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_metier.setColumns(10);
		textField_metier.setBounds(297, 461, 150, 30);
		contentPane.add(textField_metier);
		
		textField_gender = new JTextField();
		textField_gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_gender.setColumns(10);
		textField_gender.setBounds(297, 501, 150, 30);
		contentPane.add(textField_gender);
		
		System.out.println(Gestion_Patient.seaarch_value);
		
		
		try {
			String query = "select pat_id, pat_name,pat_prenom,pat_birthday,pat_cin,pat_mobile,pat_email,pat_adress,pat_metier,pat_gender from patients where pat_cin = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, Gestion_Patient.seaarch_value);
			ResultSet rs = pst.executeQuery();
			
			

			textFieldPrenom.setText(rs.getString("pat_name"));	
			textField_nom.setText(rs.getString("pat_prenom"));
			textFieldBirthday.setText(rs.getString("pat_birthday"));
			textFieldCin.setText(rs.getString("pat_cin"));
			textFieldMobile.setText(rs.getString("pat_mobile"));
			textFieldemail.setText(rs.getString("pat_email"));
			textadress.setText(rs.getString("pat_adress"));
			textField_metier.setText(rs.getString("pat_metier"));
			textField_gender.setText(rs.getString("pat_gender"));
			
			ID_Label = new JLabel(rs.getString("pat_id"));
			ID_Label.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 14));
			ID_Label.setBounds(297, 141, 150, 30);
			contentPane.add(ID_Label);
			
			rs.close();
			pst.close();
			connection.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 25, 447, 93);
		contentPane.add(panel);
		panel.setLayout(null);
	
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqLite2\\cabinet.db");
					String queryUpd = "DELETE FROM  patients  where pat_id = ? "; 
					PreparedStatement pstUpd;
					pstUpd = conn.prepareStatement(queryUpd);
					pstUpd.setString(1, ID_Label.getText());
					
					pstUpd.executeUpdate();
					
					JOptionPane.showInternalMessageDialog(null, "Patient DELETED");
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteButton.setBounds(146, 10, 79, 60);
		panel.add(deleteButton);
		
		JButton deleteButton_1 = new JButton("Delete");
		deleteButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteButton_1.setBounds(248, 10, 79, 60);
		panel.add(deleteButton_1);
		
		JLabel imagelbl = new JLabel("");
		imagelbl.setIcon(new ImageIcon("D:\\GSEII\\GSEII_2\\Java\\Projects\\Cabinet_Project\\resources\\patinfo.png"));
		imagelbl.setBounds(502, 116, 311, 413);
		contentPane.add(imagelbl);
		
		
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String pat_id=null ;
				String pat_name= null;
				String pat_adress= null;
				String pat_prenom= null;
				String pat_email= null;
				String pat_mobile= null;
				String pat_cin= null;
				String pat_birthday= null;
				String pat_gender= null;
				String pat_metier= null;
				
				
				
				pat_id = ID_Label.getText();
				pat_name = textField_nom.getText();
				pat_prenom= textFieldPrenom.getText();
				pat_adress= textadress.getText();
				pat_email= textFieldemail.getText();
				pat_mobile= textFieldMobile.getText();
				pat_cin= textFieldCin.getText();
				pat_birthday= textFieldBirthday.getText();
				pat_gender= textField_gender.getText();
				pat_metier= textField_metier.getText();
				
				
			
				
				
				try {
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqLite2\\cabinet.db");
					String queryUpd = "UPDATE patients  SET pat_name=?,pat_prenom=?,pat_birthday=?,pat_cin=?,pat_mobile=?,pat_email=?,pat_adress=?,pat_metier=?,pat_gender=? where pat_id = ? "; 
					PreparedStatement pstUpd;
					pstUpd = conn.prepareStatement(queryUpd);
					pstUpd.setString(10, pat_id);
					pstUpd.setString(1, pat_prenom );
					pstUpd.setString(2, pat_name);
					pstUpd.setString(3, pat_birthday);
					pstUpd.setString(4, pat_cin);
					pstUpd.setString(5, pat_mobile);
					pstUpd.setString(6, pat_email);
					pstUpd.setString(7, pat_adress);
					pstUpd.setString(8, pat_metier);
					pstUpd.setString(9, pat_gender);
					pstUpd.executeUpdate();
					
					JOptionPane.showInternalMessageDialog(null, "INFORMATION SAVED");
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					setVisible(false);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		saveButton.setBounds(57, 10, 80, 60);
		panel.add(saveButton);
		
		
		
		
		
		
		

	}
}
