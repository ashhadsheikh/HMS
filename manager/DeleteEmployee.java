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

import businessLogic.Employee;
import receptionist.Receptionist;


public class DeleteEmployee  implements ActionListener{
	 ManagerController HMS;
	public JFrame frmSearchEmployee;
	private JTextField name;
	private JLabel lblEmpId;
	private JTextField emp_id;
	private JLabel lblContactNo;
	private JTextField cont_num;
	private JLabel lblAccNo;
	private JTextField account_num;
	private JButton btnSearch;
	private JTable table;
	private JButton btnDeleteEmployee;
	private JButton btnClose;
    int id;


	/**
	 * Create the application.
	 */
	public DeleteEmployee( ManagerController h, int i) {
		HMS=h;
		id=i;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchEmployee = new JFrame();
		frmSearchEmployee.setTitle("Delete Employee");
		frmSearchEmployee.setBounds(100, 100, 713, 300);
		frmSearchEmployee.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmSearchEmployee.getContentPane().setLayout(springLayout);
		
		JLabel lblSearchEmployee = new JLabel("Delete Employee");
		springLayout.putConstraint(SpringLayout.NORTH, lblSearchEmployee, 10, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		lblSearchEmployee.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmSearchEmployee.getContentPane().add(lblSearchEmployee);
		
		JLabel lblName = new JLabel("Name");
		springLayout.putConstraint(SpringLayout.WEST, lblSearchEmployee, 0, SpringLayout.WEST, lblName);
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 48, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, frmSearchEmployee.getContentPane());
		frmSearchEmployee.getContentPane().add(lblName);
		
		name = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, name, 6, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.SOUTH, name, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(name);
		name.setColumns(10);
		
		lblEmpId = new JLabel("Emp ID");
		springLayout.putConstraint(SpringLayout.WEST, lblEmpId, 6, SpringLayout.EAST, name);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmpId, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(lblEmpId);
		
		emp_id = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, emp_id, 6, SpringLayout.EAST, lblEmpId);
		springLayout.putConstraint(SpringLayout.SOUTH, emp_id, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(emp_id);
		emp_id.setColumns(10);
		
		lblContactNo = new JLabel("Contact No");
		springLayout.putConstraint(SpringLayout.WEST, lblContactNo, 6, SpringLayout.EAST, emp_id);
		springLayout.putConstraint(SpringLayout.SOUTH, lblContactNo, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(lblContactNo);
		
		cont_num = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, cont_num, 6, SpringLayout.EAST, lblContactNo);
		springLayout.putConstraint(SpringLayout.SOUTH, cont_num, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(cont_num);
		cont_num.setColumns(10);
		
		lblAccNo = new JLabel("Acc No");
		springLayout.putConstraint(SpringLayout.WEST, lblAccNo, 6, SpringLayout.EAST, cont_num);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAccNo, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(lblAccNo);
		
		account_num = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, account_num, 6, SpringLayout.EAST, lblAccNo);
		springLayout.putConstraint(SpringLayout.SOUTH, account_num, 0, SpringLayout.SOUTH, lblName);
		frmSearchEmployee.getContentPane().add(account_num);
		account_num.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<table.getRowCount();i++) {

				    // 0 is for the column Part number
				    if(table.getValueAt(i, 0).equals(Integer.valueOf(emp_id.getText()))) {
				    	table.setRowSelectionInterval(i, i);
				        break;
				    }
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnSearch, 0, SpringLayout.EAST, account_num);
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
		springLayout.putConstraint(SpringLayout.SOUTH, table, 223, SpringLayout.NORTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, account_num);
		frmSearchEmployee.getContentPane().add(table);
		
		btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				     String Name= name.getText().toString();
				     String Emp_num=emp_id.getText().toString();
					int EmployeeNumber= Integer.parseInt(Emp_num);
					String Cont_num=cont_num.getText().toString();
					int ContactNumber= Integer.parseInt(Cont_num);
					 String acc_num= account_num.getText().toString();
					 int AccountNumber=Integer.parseInt(acc_num);
					 HMS.deleteEmployee(Name ,EmployeeNumber,  ContactNumber,AccountNumber);
					 
					 
					 
					 JOptionPane.showMessageDialog(frmSearchEmployee, "Employee deleted successfully");
					Manager window2 = new Manager(HMS);
					window2.frmUpdateSalary.setVisible(true);
					frmSearchEmployee.setVisible(false);
					 
				}
			
		});
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteEmployee, 0, SpringLayout.WEST, account_num);
		frmSearchEmployee.getContentPane().add(btnDeleteEmployee);
		
		btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, frmSearchEmployee.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -31, SpringLayout.WEST, btnDeleteEmployee);
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteEmployee, 0, SpringLayout.NORTH, btnClose);
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
