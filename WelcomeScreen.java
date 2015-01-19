

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuItem;

import accountant.Accountant;
import accountant.AccountantController;
import administrator.Administrator;
import administrator.AdministratorController;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import manager.Manager;
import manager.ManagerController;
import receptionist.Receptionist;
import receptionist.ReceptionistController;

import java.awt.event.ActionListener;
public class WelcomeScreen {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	ReceptionistController Receptionist;
	AdministratorController administrator;
	AccountantController accountant;
	 ManagerController manager;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		Receptionist=ReceptionistController.getController();
		administrator=AdministratorController.getController();
		accountant=AccountantController.getController();
		manager=ManagerController.getController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JComboBox comboBox ;
	JButton btnCancl ,btnLogin;
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(0, 102, 153));
		frame.setBounds(350, 70, 625, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//lblNewLabel.setIcon(new ImageIcon(".\\HSW_logo_proposal_1_by_khawarbilal.jpg"));
		Icon a =new ImageIcon(".\\hh.png");
		
		JLabel lblReceptionist = new JLabel("Login As");
		lblReceptionist.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setBounds(132, 179, 131, 39);
		frame.getContentPane().add(lblReceptionist);
		
		JLabel lblHotelManagmentSystem = new JLabel("Hotel Managment System");
		lblHotelManagmentSystem.setForeground(Color.WHITE);
		lblHotelManagmentSystem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		lblHotelManagmentSystem.setBounds(109, 36, 461, 59);
		frame.getContentPane().add(lblHotelManagmentSystem);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblUsername.setBounds(132, 242, 131, 39);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblPassword.setBounds(132, 308, 131, 39);
		frame.getContentPane().add(lblPassword);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		comboBox.setBackground(new Color(51, 153, 204));
		comboBox.addItem("Receptionist");
		comboBox.addItem("Accountant");
		comboBox.addItem("Manager");
		comboBox.addItem("Administrator");
		comboBox.setBounds(259, 168, 200, 50);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField.setBounds(259, 231, 200, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		passwordField.setBounds(259, 297, 200, 50);
		frame.getContentPane().add(passwordField);
		
		btnCancl = new JButton("Exit", null);
		btnCancl.setForeground(Color.WHITE);
		btnCancl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancl.setBackground(new Color(51, 153, 204));
		btnCancl.setBounds(132, 396, 131, 50);
		btnCancl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 String message = " Are you sure you want to Quit ? ";
	             String title = "Quit";
	             int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	             if (reply == JOptionPane.YES_OPTION){
	            	 frame.setVisible(false);
	             }
			}
		});;
		
		frame.getContentPane().add(btnCancl);
		
		 btnLogin = new JButton("Login", null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(51, 153, 204));
		btnLogin.setBounds(328, 396, 131, 50);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object item = comboBox.getSelectedItem();
				String passText = new String(passwordField.getPassword());
				if (administrator.PasswordCheck(textField.getText(), passText)
						&& "Receptionist".equals(item)) {
					Receptionist window2 = new Receptionist(Receptionist);
					window2.frame.setVisible(true);
					frame.setVisible(false);
				} else if (administrator.PasswordCheck(textField.getText(), passText)
						&& "Manager".equals(item)) {
					Manager window2 = new Manager(manager);
					window2.frmUpdateSalary.setVisible(true);
					frame.setVisible(false);
				} else if (administrator.PasswordCheck(textField.getText(), passText)
						&& "Administrator".equals(item)) {
					Administrator window2 = new Administrator(administrator);
					window2.frmUpdateSalary.setVisible(true);
					frame.setVisible(false);
				} else if (administrator.PasswordCheck(textField.getText(), passText)
						&& "Accountant".equals(item)) {
					Accountant window2 = new Accountant(accountant);
					window2.frame.setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame,"Username or Password incorrect");
				}
			}
		});
		frame.getContentPane().add(btnLogin);
		
		
		
	}
	
}
