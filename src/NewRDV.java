import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewRDV extends JFrame {

	private JPanel contentPane;
	private JLabel lblDateDePresent;
	private JLabel lblHeureDePresent;
	private JTextField remarque_textField;
	private JTextField prix_textField;
	private JLabel heure_textField ;
	private JLabel date_textField;
 
	private JTextField date__textField;
	private JTextField heure__textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRDV frame = new NewRDV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Datedepreesent() 
	{
		
		Calendar cal = new GregorianCalendar ();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		date_textField.setText(+day+"/"+month+"/"+year);
	}
	
	public void Heuredepreesent() 
	{
		
		Calendar cal = new GregorianCalendar ();
		int second=cal.get(Calendar.SECOND);
		int minute=cal.get(Calendar.MINUTE);
		int hour=cal.get(Calendar.HOUR);
		heure_textField.setText("0"+hour+":0"+minute+":0"+second);
	}

	/**
	 * Create the frame.
	 */
	public NewRDV() {
		
		final ButtonGroup positifNegatif = new ButtonGroup();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ikram\\Downloads\\icons8-st\u00E9thoscope-16.png"));
		setForeground(new Color(0, 0, 255));
		setTitle("Ajouter RDV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel ClientIdLabel = new JLabel("Client_ID:");
		ClientIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ClientIdLabel.setBounds(23, 132, 80, 25);
		panel.add(ClientIdLabel);
		
	    lblDateDePresent = new JLabel("Date de present:"); /* make it global by deleting JLabel */ 
		lblDateDePresent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateDePresent.setBounds(23, 182, 134, 25);
		panel.add(lblDateDePresent);
		
	    lblHeureDePresent = new JLabel("Heure de present:" ); /* Global */
		lblHeureDePresent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeureDePresent.setBounds(23, 235, 134, 25);
		panel.add(lblHeureDePresent);
		
		JLabel lblDateDeRdv = new JLabel("Date de RDV:");
		lblDateDeRdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateDeRdv.setBounds(23, 284, 134, 25);
		panel.add(lblDateDeRdv);
		
		JLabel lblHeureDeRdv = new JLabel("Heure de RDV:");
		lblHeureDeRdv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeureDeRdv.setBounds(23, 331, 134, 25);
		panel.add(lblHeureDeRdv);
		
		JLabel lblRemarques = new JLabel("Remarques:");
		lblRemarques.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemarques.setBounds(23, 375, 134, 25);
		panel.add(lblRemarques);
		
		JLabel lblPrix = new JLabel("Prix:");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrix.setBounds(23, 498, 102, 25);
		panel.add(lblPrix);
		
		JLabel lblRsultatDanalyse = new JLabel("R\u00E9sultat d'analyse:");
		lblRsultatDanalyse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRsultatDanalyse.setBounds(23, 576, 151, 25);
		panel.add(lblRsultatDanalyse);
		
		remarque_textField = new JTextField();
		remarque_textField.setColumns(10);
		remarque_textField.setBounds(385, 380, 220, 106);
		panel.add(remarque_textField);
		
		prix_textField = new JTextField();
		prix_textField.setColumns(10);
		prix_textField.setBounds(385, 503, 142, 19);
		panel.add(prix_textField);
		
		JLabel Client_ID = new JLabel(Gestion_Patient.seaarch_value);
		Client_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		Client_ID.setBounds(385, 132, 107, 21);
		panel.add(Client_ID);
		
		
		
		
		JRadioButton PositifRadioButton = new JRadioButton("Positif");
		positifNegatif.add(PositifRadioButton);
		PositifRadioButton.setActionCommand("Positif");
		PositifRadioButton.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 13));
		PositifRadioButton.setBounds(385, 580, 103, 21);
		panel.add(PositifRadioButton);
		
		JRadioButton NegatifRadioButton = new JRadioButton("Negatif");
		positifNegatif.add(NegatifRadioButton);
		NegatifRadioButton.setActionCommand("Negatif");
		NegatifRadioButton.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 13));
		NegatifRadioButton.setBounds(385, 618, 103, 21);
		panel.add(NegatifRadioButton);
		
		date_textField = new JLabel("");
		date_textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		date_textField.setBounds(385, 184, 142, 19);
		panel.add(date_textField);
		
		heure_textField = new JLabel("");
		heure_textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		heure_textField.setBounds(385, 235, 158, 21);
		panel.add(heure_textField);
		
		date__textField = new JTextField();
		date__textField.setBounds(385, 284, 220, 24);
		panel.add(date__textField);
		date__textField.setColumns(10);
		
		heure__textField = new JTextField();
		heure__textField.setColumns(10);
		heure__textField.setBounds(385, 331, 220, 24);
		panel.add(heure__textField);		
		
		JButton save_rdv_btn = new JButton("Save");
		save_rdv_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String client_cin=null ;
				String date_present= null;
				String heure_present= null;
				String date_rendv= null;
				String heure_rendv= null;
				String remarques= null;
				String prix= null;
				String resultat= null;
				
				
				
				client_cin = Gestion_Patient.seaarch_value;
				date_present = date_textField.getText();
				heure_present= heure_textField.getText();
				date_rendv= date__textField.getText();
				heure_rendv= heure__textField.getText();
				remarques= remarque_textField.getText();
				prix= prix_textField.getText();
				resultat= positifNegatif.getSelection().getActionCommand();
				
				System.out.println( positifNegatif.getSelection().getActionCommand());
				try {
					Class.forName("org.sqlite.JDBC");
					Connection conn;
					try {
						conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqLite2\\cabinet.db");
						String query = "INSERT INTO rndezvous (client_cin, date_present,heure_present,date_rendv,heure_rendv,remarques,prix,resultat) VALUES (?,?,?,?,?,?,?,?) "; 
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, client_cin);
						pst.setString(2, date_present );
						pst.setString(3, heure_present);
						pst.setString(4, date_rendv);
						pst.setString(5, heure_rendv);
						pst.setString(6, remarques);
						pst.setString(7, prix);
						pst.setString(8, resultat);
						pst.executeUpdate();
						
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		save_rdv_btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		save_rdv_btn.setBounds(565, 657, 158, 40);
		panel.add(save_rdv_btn);
		
		


		
	Datedepreesent();
	Heuredepreesent();

}
}