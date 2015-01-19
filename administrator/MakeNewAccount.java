package administrator;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import java.awt.SystemColor;
import java.awt.Color;

public class MakeNewAccount implements ActionListener{
	AdministratorController HMS;
	public JFrame frmMakeNewAccount;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnAddAccount;

	/**
	 * Create the application.
	 */
	public MakeNewAccount(AdministratorController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnClose;
	private void initialize() {
		frmMakeNewAccount = new JFrame();
		frmMakeNewAccount.setTitle("Make New Account");
		frmMakeNewAccount.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().setBackground(new Color(0, 102, 153));
		frmMakeNewAccount.setBounds(350, 70, 625, 585);
		frmMakeNewAccount.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmMakeNewAccount.getContentPane().setLayout(springLayout);
		
		JLabel lblMakeNewAccount = new JLabel("Make New Account");
		lblMakeNewAccount.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblMakeNewAccount, 10, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMakeNewAccount, 26, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		lblMakeNewAccount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		frmMakeNewAccount.getContentPane().add(lblMakeNewAccount);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblUserName, 0, SpringLayout.WEST, lblMakeNewAccount);
		lblUserName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 22, SpringLayout.SOUTH, lblMakeNewAccount);
		springLayout.putConstraint(SpringLayout.WEST, textField, 59, SpringLayout.EAST, lblUserName);
		springLayout.putConstraint(SpringLayout.EAST, textField, -156, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUserName, 0, SpringLayout.SOUTH, textField);
		frmMakeNewAccount.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblNewPassword, 0, SpringLayout.WEST, lblMakeNewAccount);
		lblNewPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblConfirmPassword, 0, SpringLayout.WEST, lblMakeNewAccount);
		lblConfirmPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 126, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -22, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewPassword, 0, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 170, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -156, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(passwordField);
		passwordField.addActionListener(this);
		passwordField_1 = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, passwordField_1, 6, SpringLayout.EAST, lblConfirmPassword);
		springLayout.putConstraint(SpringLayout.EAST, passwordField_1, -156, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblConfirmPassword, 0, SpringLayout.SOUTH, passwordField_1);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField_1, 185, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField, -23, SpringLayout.NORTH, passwordField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordField_1, -330, SpringLayout.SOUTH, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(passwordField_1);
		
		 btnAddAccount = new JButton("Add Account");
		 springLayout.putConstraint(SpringLayout.NORTH, btnAddAccount, 20, SpringLayout.SOUTH, passwordField_1);
		 springLayout.putConstraint(SpringLayout.WEST, btnAddAccount, 325, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, btnAddAccount, -261, SpringLayout.SOUTH, frmMakeNewAccount.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnAddAccount, -156, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		 btnAddAccount.setForeground(Color.WHITE);
		 btnAddAccount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnAddAccount.setBackground(new Color(51, 153, 204));
		frmMakeNewAccount.getContentPane().add(btnAddAccount);
		btnAddAccount.addActionListener(this);
		
		btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnClose, 201, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, 0, SpringLayout.SOUTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -18, SpringLayout.WEST, btnAddAccount);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnClose.setBackground(new Color(51, 153, 204));
		
		frmMakeNewAccount.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAddAccount){
			String user=textField.getText().toString();
			String pass = new String(passwordField.getPassword());
			String passCheck=new String(passwordField_1.getPassword());

			if(pass.equals(passCheck)){
				HMS.addAccount(user, pass);
				JOptionPane.showMessageDialog(frmMakeNewAccount, "Account Created Successful!");
				Administrator window2 = new Administrator(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmMakeNewAccount.setVisible(false);
			}
			else{
				 JOptionPane.showMessageDialog(frmMakeNewAccount, "Passwords doesn't match");
			}
			
		}
		else if(e.getSource()==btnClose){
			 Administrator window2 = new Administrator(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmMakeNewAccount.setVisible(false);
		}
		
	}
}
