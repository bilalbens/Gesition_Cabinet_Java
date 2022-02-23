import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.border.LineBorder;
import java.awt.Button;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gestion_Patient extends JFrame {

	private JPanel contentPane;
	private JTextField searchtextField;
	public static String seaarch_value;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Patient gestionPatient = new Gestion_Patient();
					gestionPatient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	Connection connection = null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	

	/**
	 * Create the frame.
	 */
	public Gestion_Patient() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400 , 700);
		setTitle("Gestion Patient");
		
		////////////////////////////////////////////////////////////////
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		menuBar.setBackground(new Color(210, 105, 30));
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu doctorMenu = new JMenu("Fichier");
		menuBar.add(doctorMenu);
		
		JMenuItem openMenuItem = new JMenuItem("Open file");
		doctorMenu.add(openMenuItem);
		
		JMenuItem closeMenuItem = new JMenuItem("Close");
		doctorMenu.add(closeMenuItem);
		
		JMenuItem SaveMenuItem = new JMenuItem("Save");
		doctorMenu.add(SaveMenuItem);
		
		JMenuItem SavasMenuItem = new JMenuItem("Save as");
		doctorMenu.add(SavasMenuItem);
		
		JSeparator separator = new JSeparator();
		doctorMenu.add(separator);
		
		JMenuItem ExitMenuItem = new JMenuItem("Exit");
		ExitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		doctorMenu.add(ExitMenuItem);
		
		JMenu aproposMen = new JMenu("Edition");
		menuBar.add(aproposMen);
		
		JMenu GestionMenu = new JMenu("Gestion");
		menuBar.add(GestionMenu);
		
		JMenu GpatientsMenu_1 = new JMenu("Gestion des patients");
		GestionMenu.add(GpatientsMenu_1);
		
		JMenuItem AjoutMenuItem = new JMenuItem("Ajouter un patient");
		AjoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				NewPatient new_Patient = new NewPatient();
				new_Patient.setVisible(true);
				
			
			}
		});
		AjoutMenuItem.setIcon(new ImageIcon("C:\\Users\\ikram\\OneDrive\\Bureau\\icons java\\aj.jfif"));
		GpatientsMenu_1.add(AjoutMenuItem);
		
		JMenuItem ModifierMenuItem = new JMenuItem("Modifier ");
		ModifierMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				patient_information patient_information = new patient_information();
				patient_information.setVisible(true);
			}
		});
		ModifierMenuItem.setIcon(new ImageIcon("C:\\Users\\ikram\\Downloads\\icons8-modifier-le-rapport-de-graphique-16.png"));
		GpatientsMenu_1.add(ModifierMenuItem);
		
		JMenuItem GRendezMenuItem = new JMenuItem("Gestion des rendez-vous");
		GestionMenu.add(GRendezMenuItem);
		
		JMenu OutilsMenu = new JMenu("Outils");
		menuBar.add(OutilsMenu);
		
		JMenu ActualiserMenu = new JMenu("Actualiser");
		menuBar.add(ActualiserMenu);
		
		JMenu mnNewMenu = new JMenu("Aide ?");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		/////////////////////////////////////////////////////////////////
		JPanel panel_info = new JPanel();
		panel_info.setBackground(new Color(224, 255, 255));
		panel_info.setBounds(22, 237, 421, 339);
		Border panel_info_border = BorderFactory.createLineBorder(Color.black);
		panel_info.setBorder(panel_info_border);
		contentPane.add(panel_info);
		panel_info.setLayout(null);
		
		JLabel idLbl = new JLabel("ID: ");
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		idLbl.setBounds(30, 20, 160, 30);
		panel_info.add(idLbl);
		
		JLabel nomLbl = new JLabel("Nom: ");
		nomLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		nomLbl.setBounds(30, 50, 160, 30);
		panel_info.add(nomLbl);
		
		JLabel prenomLbl = new JLabel("Prenom: ");
		prenomLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		prenomLbl.setBounds(30, 80, 160, 30);
		panel_info.add(prenomLbl);
		
		JLabel lblDateDeNaissance = new JLabel("Date De Naissance: ");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateDeNaissance.setBounds(30, 110, 182, 30);
		panel_info.add(lblDateDeNaissance);
		
		JLabel cinLbl = new JLabel("N\u00B0  Cin: ");
		cinLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		cinLbl.setBounds(30, 140, 160, 30);
		panel_info.add(cinLbl);
		
		JLabel mobileLbl = new JLabel("Mobile: ");
		mobileLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		mobileLbl.setBounds(30, 170, 161, 30);
		panel_info.add(mobileLbl);
		
		JLabel EmailLbl = new JLabel("E-mail: ");
		EmailLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		EmailLbl.setBounds(30, 200, 161, 30);
		panel_info.add(EmailLbl);
		
		JLabel AdresseLbl = new JLabel("Adresse: ");
		AdresseLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		AdresseLbl.setBounds(30, 230, 161, 30);
		panel_info.add(AdresseLbl);
		
		JLabel mitierLbl = new JLabel("M\u00E9tier: ");
		mitierLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		mitierLbl.setBounds(30, 260, 161, 30);
		panel_info.add(mitierLbl);
		
		JLabel genderLbl = new JLabel("Gender: ");
		genderLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		genderLbl.setBounds(30, 290, 161, 30);
		panel_info.add(genderLbl);
		
		final JLabel idAffichage = new JLabel();
		idAffichage.setFont(new Font("Tahoma", Font.BOLD, 16));
		idAffichage.setBounds(217, 20, 160, 30);
		panel_info.add(idAffichage);
		
		final JLabel Nomaffi = new JLabel();
		Nomaffi.setFont(new Font("Tahoma", Font.BOLD, 16));
		Nomaffi.setBounds(217, 50, 160, 30);
		panel_info.add(Nomaffi);
		
		final JLabel prenaff = new JLabel();
		prenaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		prenaff.setBounds(217, 80, 160, 30);
		panel_info.add(prenaff);
		
		final JLabel datedeAffichage = new JLabel();
		datedeAffichage.setFont(new Font("Tahoma", Font.BOLD, 16));
		datedeAffichage.setBounds(217, 110, 160, 30);
		panel_info.add(datedeAffichage);
		
		final JLabel Cinaff = new JLabel();
		Cinaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		Cinaff.setBounds(217, 140, 160, 30);
		panel_info.add(Cinaff);
		
		final JLabel mobileaff = new JLabel();
		mobileaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		mobileaff.setBounds(217, 170, 160, 30);
		panel_info.add(mobileaff);
		
		final JLabel emailaff = new JLabel();
		emailaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		emailaff.setBounds(217, 200, 182, 30);
		panel_info.add(emailaff);
		
		final JLabel adreeaff = new JLabel();
		adreeaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		adreeaff.setBounds(217, 230, 160, 30);
		panel_info.add(adreeaff);
		
		final JLabel metiaff = new JLabel();
		metiaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		metiaff.setBounds(217, 260, 160, 30);
		panel_info.add(metiaff);
		
		final JLabel genderaff = new JLabel();
		genderaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		genderaff.setBounds(217, 290, 160, 30);
		panel_info.add(genderaff);
		
		JButton newPtientBtn = new JButton("New Patient");
		newPtientBtn.setBackground(new Color(255, 255, 255));
		newPtientBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		newPtientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewPatient new_Patient = new NewPatient();
				new_Patient.setVisible(true);
			}
		});
		newPtientBtn.setBounds(22, 154, 421, 54);
		contentPane.add(newPtientBtn);
		
		JButton ptientInfoBtn = new JButton("Patient Information");
		ptientInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				patient_information patient_information = new patient_information();
				patient_information.setVisible(true);
				idAffichage.setText("");
				Nomaffi.setText("");	
				prenaff.setText("");
				datedeAffichage.setText("");
				Cinaff.setText("");
				mobileaff.setText("");
				emailaff.setText("");
				adreeaff.setText("");
				metiaff.setText("");
				genderaff.setText("");
			}
		});
		ptientInfoBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		ptientInfoBtn.setBounds(22, 586, 421, 54);
		contentPane.add(ptientInfoBtn);
		
		JPanel panel_rdv = new JPanel();
		Border panel_rdv_border = BorderFactory.createLineBorder(Color.black);
		panel_rdv.setBorder(panel_rdv_border);
		panel_rdv.setBounds(471, 154, 878, 486);
		contentPane.add(panel_rdv);
		panel_rdv.setLayout(null);
		
		JPanel panel_rdv_modif = new JPanel();
		Border panel_rdv_modif_border = BorderFactory.createLineBorder(Color.black);
		panel_rdv_modif.setBorder(panel_rdv_modif_border);
		panel_rdv_modif.setBounds(8, 10, 862, 43);
		panel_rdv.add(panel_rdv_modif);
		
		//////////////////////////////////////////////////
		
		JButton AjRDVButton = new JButton("Ajout RDV");
		AjRDVButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		AjRDVButton.setBounds(191, 6, 130, 30);
		AjRDVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewRDV new_RDV = new NewRDV();
				new_RDV.setVisible(true);
				
			}
		});
		panel_rdv_modif.setLayout(null);
		AjRDVButton.setIcon(new ImageIcon("C:\\Users\\ikram\\Downloads\\icons8-modifier-le-calendrier-16.png"));
		panel_rdv_modif.add(AjRDVButton);
		
		JButton ModifRDVButton = new JButton("Modifier ");
		ModifRDVButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ModifRDVButton.setBounds(364, 6, 130, 30);
		ModifRDVButton.setIcon(new ImageIcon("C:\\Users\\ikram\\Downloads\\icons8-note-16.png"));
		panel_rdv_modif.add(ModifRDVButton);
		
		JButton SupprimerRDVButton = new JButton("Supprimer");
		SupprimerRDVButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		SupprimerRDVButton.setBounds(521, 7, 130, 30);
		SupprimerRDVButton.setIcon(new ImageIcon("C:\\Users\\ikram\\Downloads\\icons8-effacer-16.png"));
		panel_rdv_modif.add(SupprimerRDVButton);
//		
//		table = new JTable();
//		table.setBounds(113, 190, 140, -69);
//		panel_rdv.add(table);
//		
//		table_1 = new JTable();
//		table_1.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Client_ID", "Date_Present", "Heure_Present", "Date_RDV", "Heure_RDV", "Prix", "Remarque"},
//				{"", "", "", "", "", "", "Trouble digestif"},
//				{null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
//			}
//		));
//		table_1.setBounds(30, 82, 818, 90);
//		panel_rdv.add(table_1);
//		
		JTextPane remarque_Field = new JTextPane();
		remarque_Field.setBounds(30, 262, 818, 161);
		panel_rdv.add(remarque_Field);
		
		Label Rqlabel = new Label("Remarques");
		Rqlabel.setFont(new Font("Cooper Black", Font.BOLD | Font.ITALIC, 14));
		Rqlabel.setBackground(new Color(255, 69, 0));
		Rqlabel.setAlignment(Label.CENTER);
		Rqlabel.setBounds(30, 216, 126, 40);
		panel_rdv.add(Rqlabel);
		
		JScrollPane show_info_tables = new JScrollPane();
		show_info_tables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
//					int i = jTablAppr
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		show_info_tables.setBounds(31, 68, 818, 142);
		panel_rdv.add(show_info_tables);
		
		table_2 = new JTable();
		show_info_tables.setViewportView(table_2);
		
		
		
		
		
		///////////////////////////////////////////////////////
		
		
		
		JPanel panel_search = new JPanel();
		Border panel_search_border = BorderFactory.createLineBorder(Color.black);
		panel_search.setBorder(panel_search_border);
		panel_search.setBounds(36, 49, 1313, 82);
		contentPane.add(panel_search);
		panel_search.setLayout(null);
		
		searchtextField = new JTextField();
		searchtextField.setBounds(1008, 21, 234, 39);
		panel_search.add(searchtextField);
		searchtextField.setColumns(10);
		
		JButton searchButton = new JButton("search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connection = sqliteConnection.dbConnector();
				
				try {
					String query = "select pat_id, pat_name,pat_prenom,pat_birthday,pat_cin,pat_mobile,pat_email,pat_adress,pat_metier,pat_gender from patients where pat_cin = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, searchtextField.getText());
					ResultSet rs = pst.executeQuery();
					
					
					
					idAffichage.setText(rs.getString("pat_id"));
					Nomaffi.setText(rs.getString("pat_name"));	
					prenaff.setText(rs.getString("pat_prenom"));
					datedeAffichage.setText(rs.getString("pat_birthday"));
					Cinaff.setText(rs.getString("pat_cin"));
					mobileaff.setText(rs.getString("pat_mobile"));
					emailaff.setText(rs.getString("pat_email"));
					adreeaff.setText(rs.getString("pat_adress"));
					metiaff.setText(rs.getString("pat_metier"));
					genderaff.setText(rs.getString("pat_gender"));
					
					seaarch_value = searchtextField.getText();
					
					connection.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showInternalMessageDialog(null, "Patient Not Found");
				}
				
				
				
				
		////////////////////////  show in table
				
				try {
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqLite2\\cabinet.db");
					String queryUpd = "select *  from rndezvous where client_cin=?"; 
					PreparedStatement pstUpd=conn.prepareStatement(queryUpd);
					pstUpd.setString(1, searchtextField.getText());
					ResultSet rs = pstUpd.executeQuery();
					
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
	 ////////////////////////////////////////////
				
				
				
				
				
				
		
				
				
				
			
				
			}
		});
		searchButton.setBounds(898, 30, 83, 21);
		panel_search.add(searchButton);
		
		
		
		
	}
}
