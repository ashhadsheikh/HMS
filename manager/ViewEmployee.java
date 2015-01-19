package manager;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;


public class ViewEmployee  implements ActionListener{
	 ManagerController HMS;
	public JFrame frmSearchEmployee;
	private JTable table;
	private JButton btnUpdateInfo;
	private JButton btnClose;

	
	/**
	 * Create the application.
	 */
	public ViewEmployee( ManagerController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchEmployee = new JFrame();
		frmSearchEmployee.setTitle("View All");
		frmSearchEmployee.setBounds(100, 100, 626, 300);
		frmSearchEmployee.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmSearchEmployee.getContentPane().setLayout(springLayout);
		
		JLabel lblSearchEmployee = new JLabel("View All Employee");
		springLayout.putConstraint(SpringLayout.NORTH, lblSearchEmployee, 10, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSearchEmployee, 10, SpringLayout.WEST, frmSearchEmployee.getContentPane());
		lblSearchEmployee.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmSearchEmployee.getContentPane().add(lblSearchEmployee);
		
		String[] columnNames = {"EmpID#",
                "Name",
                "Address",
                "ContactNumber",
                "Account Number"};
		Object[][] data = {
			   
			     {"EmpID#",
		                "Name",
		                "Address",
		                "ContactNumber",
		                "Account Number"}
			};
		table = new JTable(data,columnNames);
		springLayout.putConstraint(SpringLayout.NORTH, table, 14, SpringLayout.SOUTH, lblSearchEmployee);
		springLayout.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, lblSearchEmployee);
		springLayout.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, frmSearchEmployee.getContentPane());
		frmSearchEmployee.getContentPane().add(table);
		
		btnUpdateInfo = new JButton("Save");
		springLayout.putConstraint(SpringLayout.EAST, btnUpdateInfo, -10, SpringLayout.EAST, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, -6, SpringLayout.NORTH, btnUpdateInfo);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdateInfo, -10, SpringLayout.SOUTH, frmSearchEmployee.getContentPane());
		frmSearchEmployee.getContentPane().add(btnUpdateInfo);
		
		btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, btnUpdateInfo);
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -6, SpringLayout.WEST, btnUpdateInfo);
		frmSearchEmployee.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnClose){
			 Manager window2 = new Manager(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmSearchEmployee.setVisible(false);
		}
		
	}
}
