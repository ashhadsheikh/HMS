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

public class EditAccount implements ActionListener{
	AdministratorController HMS;
	public JFrame frmMakeNewAccount;
	private JTextField uname;
	private JPasswordField new_pass;
	private JTextField new_uname;
	JButton btnAddAccount;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public EditAccount(AdministratorController h) {
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
		
		JLabel lblMakeNewAccount = new JLabel("Update Account");
		lblMakeNewAccount.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblMakeNewAccount, 10, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMakeNewAccount, 26, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		lblMakeNewAccount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		frmMakeNewAccount.getContentPane().add(lblMakeNewAccount);
		
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().add(lblUserName);
		
		uname = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, uname, 64, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, uname, 210, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, uname, -116, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUserName, 0, SpringLayout.SOUTH, uname);
		springLayout.putConstraint(SpringLayout.EAST, lblUserName, -53, SpringLayout.WEST, uname);
		frmMakeNewAccount.getContentPane().add(uname);
		uname.setColumns(10);
		uname.addActionListener(this);
		
		
		
		JLabel lblNewPassword = new JLabel("New Username");
		springLayout.putConstraint(SpringLayout.WEST, lblNewPassword, 73, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("New Password");
		springLayout.putConstraint(SpringLayout.WEST, lblConfirmPassword, 73, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmMakeNewAccount.getContentPane().add(lblConfirmPassword);
		
		new_pass = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, new_pass, 25, SpringLayout.EAST, lblConfirmPassword);
		springLayout.putConstraint(SpringLayout.SOUTH, new_pass, -351, SpringLayout.SOUTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, new_pass, -116, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblConfirmPassword, 0, SpringLayout.SOUTH, new_pass);
		frmMakeNewAccount.getContentPane().add(new_pass);
		new_pass.addActionListener(this);
		 btnAddAccount = new JButton("Update");
		 springLayout.putConstraint(SpringLayout.NORTH, btnAddAccount, 17, SpringLayout.SOUTH, new_pass);
		 springLayout.putConstraint(SpringLayout.WEST, btnAddAccount, -106, SpringLayout.EAST, uname);
		 springLayout.putConstraint(SpringLayout.SOUTH, btnAddAccount, 59, SpringLayout.SOUTH, new_pass);
		 springLayout.putConstraint(SpringLayout.EAST, btnAddAccount, 0, SpringLayout.EAST, uname);
		 btnAddAccount.setForeground(Color.WHITE);
		 btnAddAccount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnAddAccount.setBackground(new Color(51, 153, 204));
		frmMakeNewAccount.getContentPane().add(btnAddAccount);
		btnAddAccount.addActionListener(this);
		btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.WEST, btnClose, -106, SpringLayout.WEST, btnAddAccount);
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, 0, SpringLayout.SOUTH, btnAddAccount);
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -6, SpringLayout.WEST, btnAddAccount);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnClose.setBackground(new Color(51, 153, 204));
		frmMakeNewAccount.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
		new_uname = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, new_pass, 17, SpringLayout.SOUTH, new_uname);
		springLayout.putConstraint(SpringLayout.SOUTH, uname, -16, SpringLayout.NORTH, new_uname);
		springLayout.putConstraint(SpringLayout.WEST, new_uname, 20, SpringLayout.EAST, lblNewPassword);
		springLayout.putConstraint(SpringLayout.EAST, new_uname, -116, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewPassword, 0, SpringLayout.SOUTH, new_uname);
		springLayout.putConstraint(SpringLayout.SOUTH, new_uname, -404, SpringLayout.SOUTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, new_uname, 116, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(new_uname);
		new_uname.setColumns(10);
		new_uname.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnClose){
			 Administrator window2 = new Administrator(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmMakeNewAccount.setVisible(false);
		}
		else if(e.getSource()== btnAddAccount){
			String u=uname.getText().toString();
			String p = new String(new_pass.getPassword());
			String n_u=new_uname.getText().toString();
			HMS.updateAccount(u, p, n_u);
			JOptionPane.showMessageDialog(frmMakeNewAccount, "Account Updated Successful!");
			 Administrator window2 = new Administrator(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmMakeNewAccount.setVisible(false);
		}
		
	}
}
