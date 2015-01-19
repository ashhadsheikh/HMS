package administrator;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Administrator implements ActionListener{
	AdministratorController HMS;
	public JFrame frmUpdateSalary;
	private JTable table;

	public Administrator(AdministratorController h) {
		HMS=h;
		initialize();
	}
	private JTextField textField;
	private void initialize() {
		frmUpdateSalary = new JFrame();
		
		frmUpdateSalary.setTitle("User Accounts");
		frmUpdateSalary.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmUpdateSalary.getContentPane().setBackground(new Color(0, 102, 153));
		frmUpdateSalary.setBounds(350, 70, 625, 585);
		frmUpdateSalary.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmUpdateSalary.getContentPane().setLayout(springLayout);
		
		JLabel lblUpdateSalary = new JLabel("Administrator");
		springLayout.putConstraint(SpringLayout.SOUTH, lblUpdateSalary, 61, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUpdateSalary, 202, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		lblUpdateSalary.setForeground(Color.WHITE);
		lblUpdateSalary.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblUpdateSalary, 10, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUpdateSalary, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		frmUpdateSalary.getContentPane().add(lblUpdateSalary);
		
		table = new JTable(HMS.userAccounts());
		JScrollPane scrollPane = new JScrollPane( table );
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -31, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		frmUpdateSalary.getContentPane().add(scrollPane);
		
		JLabel lblEmployeeId = new JLabel("Username");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 31, SpringLayout.SOUTH, lblEmployeeId);
		springLayout.putConstraint(SpringLayout.NORTH, lblEmployeeId, 18, SpringLayout.SOUTH, lblUpdateSalary);
		springLayout.putConstraint(SpringLayout.WEST, lblEmployeeId, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frmUpdateSalary.getContentPane().add(lblEmployeeId);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 8, SpringLayout.SOUTH, lblUpdateSalary);
		springLayout.putConstraint(SpringLayout.WEST, textField, 20, SpringLayout.EAST, lblEmployeeId);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -31, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, textField, -186, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		textField.setColumns(10);
		frmUpdateSalary.getContentPane().add(textField);
		
		JButton btnCancel = new JButton("Exit", null);
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 486, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -4, SpringLayout.NORTH, btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String message = " Are you sure you want to Exit ? ";
	             String title = "Quit";
	             int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	             if (reply == JOptionPane.YES_OPTION){
					 frmUpdateSalary.setVisible(false);
					
	             }
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, -31, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancel.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnCancel);
		
		JButton btnUpdate = new JButton("Delete", null);
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, 4, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String message = " Are you sure you want to Delete ? ";
	             String title = "Delete";
	             int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	             if (reply == JOptionPane.YES_OPTION){
	            	 String uname=textField.getText();
	            	 HMS.deleteAccount(uname);
					 Administrator window2 = new Administrator(HMS);
						window2.frmUpdateSalary.setVisible(true);
						 frmUpdateSalary.setVisible(false);
	            	 
					
	             }
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnUpdate, -176, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 6, SpringLayout.EAST, btnUpdate);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnUpdate.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnUpdate);
		
		JButton btnUpdate_1 = new JButton("Update", null);
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate_1, 4, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate_1, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 EditAccount window2 = new EditAccount(HMS);
				 window2.frmMakeNewAccount.setVisible(true);
				 frmUpdateSalary.setVisible(false);
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnUpdate_1, -317, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 6, SpringLayout.EAST, btnUpdate_1);
		btnUpdate_1.setForeground(Color.WHITE);
		btnUpdate_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnUpdate_1.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnUpdate_1);
		
		JButton btnAdd = new JButton("Add", null);
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 373, SpringLayout.SOUTH, lblEmployeeId);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAdd, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -462, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MakeNewAccount window2 = new MakeNewAccount(HMS);
				 window2.frmMakeNewAccount.setVisible(true);
				 frmUpdateSalary.setVisible(false);
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate_1, 6, SpringLayout.EAST, btnAdd);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnAdd);
		
		JButton btnSearch = new JButton("Search", null);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++) {

				    // 0 is for the column Part number
				    if(table.getValueAt(i, 0).equals(textField.getText())) {
				    	table.setRowSelectionInterval(i, i);
				        break;
				    }
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnSearch, 0, SpringLayout.WEST, btnCancel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, 0, SpringLayout.SOUTH, lblEmployeeId);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, scrollPane);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSearch.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnSearch);
	}
	public void actionPerformed(ActionEvent e){
		
	}
}
