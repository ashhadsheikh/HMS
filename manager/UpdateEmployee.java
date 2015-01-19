package manager;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import businessLogic.Reservation;
import accountant.SearchExpense;

public class UpdateEmployee implements ActionListener{
	 ManagerController HMS;
	 int id;
	public JFrame frmSearchEmployee;
	private JTextField textField;
	private JLabel lblEmpId;
	private JTextField textField_1;
	private JLabel lblContactNo;
	private JTextField textField_2;
	private JLabel lblAccNo;
	private JTextField textField_3;
	private JButton btnSearch;
	private JTable table;
	private JButton btnUpdateInfo;
	private JButton btnClose;



	/**
	 * Create the application.
	 */
	public UpdateEmployee( ManagerController h) {
		HMS=h;
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchEmployee = new JFrame();
		frmSearchEmployee.setTitle("Update Employee");
		frmSearchEmployee.setBounds(100, 100, 713, 300);
		frmSearchEmployee.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmSearchEmployee.getContentPane().setLayout(springLayout);
		
		JLabel lblSearchEmployee = new JLabel("Update Employee");
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
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<table.getRowCount();i++) {

				    // 0 is for the column Part number
				    if(table.getValueAt(i, 0).equals(Integer.valueOf(textField_1.getText()))) {
				    	table.setRowSelectionInterval(i, i);
				    	String Emp_num=textField_1.getText().toString();
						int Employee_num= Integer.parseInt(Emp_num);
				    	HMS.getEmployee(Employee_num);
						JOptionPane.showMessageDialog(frmSearchEmployee, "Employee updated successfully");
						Manager window2 = new Manager(HMS);
						window2.frmUpdateSalary.setVisible(true);
						frmSearchEmployee.setVisible(false);
				        break;
				        
				    }
				}
			}		
		});
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, textField_3);
		frmSearchEmployee.getContentPane().add(btnSearch);
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
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch, -14, SpringLayout.NORTH, table);
		springLayout.putConstraint(SpringLayout.NORTH, table, 118, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, textField_3);
		frmSearchEmployee.getContentPane().add(table);
		
		
		btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnUpdateInfo){
					String Name= textField.getText().toString();
					String Emp_num=textField_1.getText().toString();
					int Employee_num= Integer.parseInt(Emp_num);
					String Cont_Num= textField_2.getText().toString();
					int ContactNumber= Integer.parseInt(Cont_Num);
					String Bank_num= textField_3.getText().toString();
					int BankNumber= Integer.parseInt(Bank_num);
					
					HMS.updateEmployee(Name, Employee_num, ContactNumber, BankNumber);
					JOptionPane.showMessageDialog(frmSearchEmployee, "Employee updated successfully");
					Manager window2 = new Manager(HMS);
					window2.frmUpdateSalary.setVisible(true);
					frmSearchEmployee.setVisible(false);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, table, -6, SpringLayout.NORTH, btnUpdateInfo);
		springLayout.putConstraint(SpringLayout.WEST, btnUpdateInfo, 0, SpringLayout.WEST, textField_3);
		frmSearchEmployee.getContentPane().add(btnUpdateInfo);
		
		btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -31, SpringLayout.WEST, btnUpdateInfo);
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdateInfo, 0, SpringLayout.NORTH, btnClose);
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
