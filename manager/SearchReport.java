package manager;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;



public class SearchReport implements ActionListener{
	 ManagerController HMS;
	public JFrame frmSearchEmployee;
	private JTextField textField;
	private JLabel lblEmpId;
	private JTextField textField_1;
	private JLabel lblContactNo;
	private JTextField textField_2;
	private JLabel lblAccNo;
	private JTextField textField_3;
	private JButton btnSearch;
	private JButton btnCalcel;
	private JTable table;



	/**
	 * Create the application.
	 */
	public SearchReport( ManagerController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchEmployee = new JFrame();
		frmSearchEmployee.setTitle("Search Employee");
		frmSearchEmployee.setBounds(100, 100, 711, 300);
		frmSearchEmployee.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmSearchEmployee.getContentPane().setLayout(springLayout);
		
		JLabel lblSearchEmployee = new JLabel("Search Employee");
		springLayout.putConstraint(SpringLayout.NORTH, lblSearchEmployee, 10, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		lblSearchEmployee.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmSearchEmployee.getContentPane().add(lblSearchEmployee);
		
		JLabel lblName = new JLabel("Name");
		springLayout.putConstraint(SpringLayout.WEST, lblSearchEmployee, 0, SpringLayout.WEST, lblName);
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 48, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, frmSearchEmployee.getContentPane());
		frmSearchEmployee.getContentPane().add(lblName);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblEmpId = new JLabel("Emp ID");
		springLayout.putConstraint(SpringLayout.WEST, lblEmpId, 6, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmpId, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(lblEmpId);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblEmpId);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblContactNo = new JLabel("Contact No");
		springLayout.putConstraint(SpringLayout.WEST, lblContactNo, 6, SpringLayout.EAST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblContactNo, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(lblContactNo);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 6, SpringLayout.EAST, lblContactNo);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblAccNo = new JLabel("Acc No");
		springLayout.putConstraint(SpringLayout.WEST, lblAccNo, 6, SpringLayout.EAST, textField_2);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAccNo, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(lblAccNo);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblAccNo);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_3, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnSearch = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch, 21, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, -10, SpringLayout.EAST, frmSearchEmployee.getContentPane());
		frmSearchEmployee.getContentPane().add(btnSearch);
		
		btnCalcel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.NORTH, btnCalcel, 0, SpringLayout.NORTH, btnSearch);
		springLayout.putConstraint(SpringLayout.EAST, btnCalcel, -6, SpringLayout.WEST, btnSearch);
		btnCalcel.addActionListener(this);
		frmSearchEmployee.getContentPane().add(btnCalcel);
		
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
		springLayout.putConstraint(SpringLayout.NORTH, table, 56, SpringLayout.SOUTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, lblName);
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, btnSearch);
		frmSearchEmployee.getContentPane().add(table);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnCalcel){
			 Manager window2 = new Manager(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmSearchEmployee.setVisible(false);
		}
		
	}
}
