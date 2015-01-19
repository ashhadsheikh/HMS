package administrator;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;


public class DeleteAccount implements ActionListener{
	AdministratorController HMS;
	public JFrame frmMakeNewAccount;
	private JTextField textField;
	private JTable table;


	/**
	 * Create the application.
	 */
	public DeleteAccount(AdministratorController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnClose;
	private void initialize() {
		frmMakeNewAccount = new JFrame();
		frmMakeNewAccount.setTitle("Delete Account");
		frmMakeNewAccount.setBounds(100, 100, 450, 300);
		frmMakeNewAccount.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmMakeNewAccount.getContentPane().setLayout(springLayout);
		
		JLabel lblMakeNewAccount = new JLabel("Delete Account");
		springLayout.putConstraint(SpringLayout.NORTH, lblMakeNewAccount, 10, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMakeNewAccount, 122, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		lblMakeNewAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmMakeNewAccount.getContentPane().add(lblMakeNewAccount);
		
		JLabel lblUserName = new JLabel("User Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblUserName, 68, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUserName, 73, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 52, SpringLayout.EAST, lblUserName);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -176, SpringLayout.SOUTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -116, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(textField);
		textField.setColumns(10);
		
		 btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.WEST, btnClose, 215, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
		JButton btnSearch = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch, -4, SpringLayout.NORTH, lblUserName);
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, 6, SpringLayout.EAST, textField);
		frmMakeNewAccount.getContentPane().add(btnSearch);
		
		String[] columnNames = {"UserName",
                "Account Owner",
                "Password"};
		Object[][] data = {
			   
			     {"UserName",
		                "Account Owner",
		                "Password"}
			};
		table = new JTable(data,columnNames);
		springLayout.putConstraint(SpringLayout.NORTH, btnClose, 6, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.NORTH, table, 24, SpringLayout.SOUTH, btnSearch);
		springLayout.putConstraint(SpringLayout.WEST, table, 73, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, -39, SpringLayout.SOUTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, -45, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(table);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteAccount, 0, SpringLayout.NORTH, btnClose);
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteAccount, 6, SpringLayout.EAST, btnClose);
		frmMakeNewAccount.getContentPane().add(btnDeleteAccount);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnClose){
			 Administrator window2 = new Administrator(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmMakeNewAccount.setVisible(false);
		}
		
	}
}
