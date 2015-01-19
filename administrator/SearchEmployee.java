package administrator;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.Color;

public class SearchEmployee implements ActionListener{
	AdministratorController HMS;
	public JFrame frmMakeNewAccount;
	private JTextField uname;
	JButton btnSearch;

	

	/**
	 * Create the application.
	 */
	public SearchEmployee(AdministratorController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnClose;
	private void initialize() {
		frmMakeNewAccount = new JFrame();
		frmMakeNewAccount.getContentPane().setBackground(SystemColor.window);
		frmMakeNewAccount.setTitle("Search Account");
		frmMakeNewAccount.setBounds(100, 100, 476, 175);
		frmMakeNewAccount.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmMakeNewAccount.getContentPane().setLayout(springLayout);
		
		JLabel lblMakeNewAccount = new JLabel("Search  Account");
		springLayout.putConstraint(SpringLayout.NORTH, lblMakeNewAccount, 10, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMakeNewAccount, 122, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		lblMakeNewAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmMakeNewAccount.getContentPane().add(lblMakeNewAccount);
		
		JLabel lblUserName = new JLabel("User Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblUserName, 68, SpringLayout.NORTH, frmMakeNewAccount.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUserName, 73, SpringLayout.WEST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(lblUserName);
		
		uname = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, uname, -3, SpringLayout.NORTH, lblUserName);
		springLayout.putConstraint(SpringLayout.WEST, uname, 18, SpringLayout.EAST, lblUserName);
		springLayout.putConstraint(SpringLayout.EAST, uname, -168, SpringLayout.EAST, frmMakeNewAccount.getContentPane());
		frmMakeNewAccount.getContentPane().add(uname);
		uname.setColumns(10);
		uname.addActionListener(this);
		btnClose = new JButton("Close");
		btnClose.setBackground(new Color(188, 143, 143));
		springLayout.putConstraint(SpringLayout.NORTH, btnClose, -4, SpringLayout.NORTH, lblUserName);
		frmMakeNewAccount.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
		 btnSearch = new JButton("Search");
		 btnSearch.setBackground(new Color(188, 143, 143));
		 springLayout.putConstraint(SpringLayout.WEST, btnClose, 6, SpringLayout.EAST, btnSearch);
		 springLayout.putConstraint(SpringLayout.NORTH, btnSearch, -4, SpringLayout.NORTH, lblUserName);
		 springLayout.putConstraint(SpringLayout.WEST, btnSearch, 6, SpringLayout.EAST, uname);
		frmMakeNewAccount.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);
	
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnClose){
			 Administrator window2 = new Administrator(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmMakeNewAccount.setVisible(false);
		}
		if(e.getSource()==btnSearch){
			String name=uname.getText().toString();
			String pass=HMS.searchAccount(name);
			 JOptionPane.showMessageDialog(frmMakeNewAccount, "Username: "+name+"    Password: "+pass);
			
		}
		
	}
}
