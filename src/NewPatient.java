import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class NewPatient extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextfield;
	private JTextField PrenomtextField;
	private JTextField NomtextField;
	private JTextField DatdenaiitextField;
	private JTextField NCINtextField;
	private JTextField MobiletextField;
	private JTextField EmailtextField;
	private JTextField textFieldAdresse;
	private JTextField MetiertextField;
	
	private String IDvalue;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPatient frame = new NewPatient();
					frame.setTitle("Ajouter Un Patient");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection connection = null;

	
	/**
	 * Create the frame.
	 */
	public NewPatient() {
		final ButtonGroup MaleFemale = new ButtonGroup();
		
		connection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 923, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(44, 35, 538, 449);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel IbID = new JLabel("ID:");
		IbID.setFont(new Font("Tahoma", Font.BOLD, 16));
		IbID.setBounds(20, 10, 80, 30);
		panel_1.add(IbID);
		
		JLabel Prenomaff = new JLabel("Prenom:");
		Prenomaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		Prenomaff.setBounds(20, 50, 80, 30);
		panel_1.add(Prenomaff);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNom.setBounds(20, 90, 80, 30);
		panel_1.add(lblNom);
		
		JLabel Datedenaissib = new JLabel("Date de naissance:");
		Datedenaissib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Datedenaissib.setBounds(18, 130, 192, 30);
		panel_1.add(Datedenaissib);
		
		JLabel CINib = new JLabel("N\u00B0 CIN:");
		CINib.setFont(new Font("Tahoma", Font.BOLD, 16));
		CINib.setBounds(20, 170, 80, 30);
		panel_1.add(CINib);
		
		JLabel Mobileiiib = new JLabel("Mobile:");
		Mobileiiib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Mobileiiib.setBounds(20, 210, 80, 30);
		panel_1.add(Mobileiiib);
		
		JLabel emailip = new JLabel("E-mail:");
		emailip.setFont(new Font("Tahoma", Font.BOLD, 16));
		emailip.setBounds(20, 250, 80, 30);
		panel_1.add(emailip);
		
		JLabel adresseib = new JLabel("Adresse:");
		adresseib.setFont(new Font("Tahoma", Font.BOLD, 16));
		adresseib.setBounds(20, 290, 80, 30);
		panel_1.add(adresseib);
		
		JLabel Metierib = new JLabel("M\u00E9tier:");
		Metierib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Metierib.setBounds(20, 330, 80, 30);
		panel_1.add(Metierib);
		
		JLabel Genderriib = new JLabel("Gender:");
		Genderriib.setFont(new Font("Tahoma", Font.BOLD, 16));
		Genderriib.setBounds(20, 370, 80, 30);
		panel_1.add(Genderriib);
		
		
		
		
		
		
		
		PrenomtextField = new JTextField();
		PrenomtextField.setColumns(10);
		PrenomtextField.setBounds(300, 53, 150, 30);
		panel_1.add(PrenomtextField);
		
		NomtextField = new JTextField();
		NomtextField.setColumns(10);
		NomtextField.setBounds(300, 93, 150, 30);
		panel_1.add(NomtextField);
		
		DatdenaiitextField = new JTextField();
		DatdenaiitextField.setColumns(10);
		DatdenaiitextField.setBounds(300, 133, 150, 30);
		panel_1.add(DatdenaiitextField);
		
		NCINtextField = new JTextField();
		NCINtextField.setColumns(10);
		NCINtextField.setBounds(300, 173, 150, 30);
		panel_1.add(NCINtextField);
		
		MobiletextField = new JTextField();
		MobiletextField.setColumns(10);
		MobiletextField.setBounds(300, 213, 150, 30);
		panel_1.add(MobiletextField);
		
		EmailtextField = new JTextField();
		EmailtextField.setColumns(10);
		EmailtextField.setBounds(300, 253, 150, 30);
		panel_1.add(EmailtextField);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(300, 293, 150, 30);
		panel_1.add(textFieldAdresse);
		
		MetiertextField = new JTextField();
		MetiertextField.setColumns(10);
		MetiertextField.setBounds(300, 333, 150, 30);
		panel_1.add(MetiertextField);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Homme");
		MaleFemale.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setActionCommand("Homme");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(300, 380, 99, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemme = new JRadioButton("Femme");
		MaleFemale.add(rdbtnFemme);
		rdbtnFemme.setActionCommand("Homme");
		rdbtnFemme.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemme.setBounds(300, 410, 99, 21);
		panel_1.add(rdbtnFemme);
		
		
		 
		 
		
		
		
		try {
			String queryid = " SELECT pat_id FROM    patients WHERE   pat_id = (SELECT MAX(pat_id)  FROM patients)";
			PreparedStatement pstid;
			pstid = connection.prepareStatement(queryid);
			ResultSet rsid = pstid.executeQuery();
			  
			
			IDvalue = Integer.toString(Integer.parseInt(rsid.getString("pat_id"))+1);
			
			connection.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel patID_lbl = new JLabel(IDvalue);
		patID_lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		patID_lbl.setBounds(300, 10, 150, 30);
		panel_1.add(patID_lbl);
		
		
		
		
		JButton add_patient_btn = new JButton("Ajouter");
		add_patient_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		add_patient_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
			
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
					
					
					
					pat_id = IDvalue;
					pat_name = NomtextField.getText();
					pat_prenom= PrenomtextField.getText();
					pat_adress= textFieldAdresse.getText();
					pat_email= EmailtextField.getText();
					pat_mobile= MobiletextField.getText();
					pat_cin= NCINtextField.getText();
					pat_birthday= DatdenaiitextField.getText();
					pat_gender= MaleFemale.getSelection().getActionCommand();
					pat_metier= MetiertextField.getText();
					
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqLite2\\cabinet.db");
					
					String query = "INSERT INTO patients (pat_id, pat_name,pat_prenom,pat_birthday,pat_cin,pat_mobile,pat_email,pat_adress,pat_metier,pat_gender) VALUES (?,?,?,?,?,?,?,?,?,?) "; 
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, pat_id);
					pst.setString(2, pat_prenom );
					pst.setString(3, pat_name);
					pst.setString(4, pat_birthday);
					pst.setString(5, pat_cin);
					pst.setString(6, pat_mobile);
					pst.setString(7, pat_email);
					pst.setString(8, pat_adress);
					pst.setString(9, pat_metier);
					pst.setString(10, pat_gender);
					pst.executeUpdate();
					
					JOptionPane.showInternalMessageDialog(null, "Patient is added");
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					setVisible(false);
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
			
		});
		add_patient_btn.setBounds(44, 535, 225, 59);
		contentPane.add(add_patient_btn);
		
		JButton annuler_btn = new JButton("Annuler");
		annuler_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, "Vous Voullez Annuler");
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		annuler_btn.setFont(new Font("Tahoma", Font.BOLD, 18));
		annuler_btn.setBounds(357, 535, 225, 59);
		contentPane.add(annuler_btn);
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setIcon(new ImageIcon("D:\\GSEII\\GSEII_2\\Java\\Projects\\Cabinet_Project\\resources\\patient.jpg"));
		imgLabel.setBounds(614, 45, 287, 324);
		contentPane.add(imgLabel);
	}
}
