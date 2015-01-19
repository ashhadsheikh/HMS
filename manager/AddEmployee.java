package manager;




import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;





import accountant.AccountantController;
import accountant.SearchExpense;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployee  implements ActionListener{
	 ManagerController HMS;
	 
	public JFrame frmAddNewEmployee;
	private JTextField name;
	private JTextField cnic;
	private JTextField addr;
	private JTextField cont_num;
	private JTextField email;
	private JTextField dob;
	private JTextField bank_name;
	private JTextField acc_num;
	private JButton button;
	private JButton btnClose;

	/**
	 * Create the application.
	 */
	public AddEmployee( ManagerController h) {
		HMS=h;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNewEmployee = new JFrame();
		frmAddNewEmployee.setTitle("Add New Employee");
		frmAddNewEmployee.setBounds(100, 100, 505, 336);
		frmAddNewEmployee.setResizable(false);
		//frmAddNewEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAddNewEmployee.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAddNewEmployee = new JLabel("Add New Employee");
		lblAddNewEmployee.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblAddNewEmployee = new GridBagConstraints();
		gbc_lblAddNewEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddNewEmployee.gridx = 1;
		gbc_lblAddNewEmployee.gridy = 0;
		frmAddNewEmployee.getContentPane().add(lblAddNewEmployee, gbc_lblAddNewEmployee);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		frmAddNewEmployee.getContentPane().add(lblName, gbc_lblName);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 1;
		gbc_name.gridy = 1;
		frmAddNewEmployee.getContentPane().add(name, gbc_name);
		name.setColumns(10);
		
		JLabel lblCnic = new JLabel("CNIC");
		GridBagConstraints gbc_lblCnic = new GridBagConstraints();
		gbc_lblCnic.anchor = GridBagConstraints.EAST;
		gbc_lblCnic.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnic.gridx = 0;
		gbc_lblCnic.gridy = 2;
		frmAddNewEmployee.getContentPane().add(lblCnic, gbc_lblCnic);
		
		cnic = new JTextField();
		GridBagConstraints gbc_cnic = new GridBagConstraints();
		gbc_cnic.insets = new Insets(0, 0, 5, 5);
		gbc_cnic.fill = GridBagConstraints.HORIZONTAL;
		gbc_cnic.gridx = 1;
		gbc_cnic.gridy = 2;
		frmAddNewEmployee.getContentPane().add(cnic, gbc_cnic);
		cnic.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 3;
		frmAddNewEmployee.getContentPane().add(lblAddress, gbc_lblAddress);
		
		addr = new JTextField();
		GridBagConstraints gbc_addr = new GridBagConstraints();
		gbc_addr.insets = new Insets(0, 0, 5, 5);
		gbc_addr.fill = GridBagConstraints.HORIZONTAL;
		gbc_addr.gridx = 1;
		gbc_addr.gridy = 3;
		frmAddNewEmployee.getContentPane().add(addr, gbc_addr);
		addr.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		GridBagConstraints gbc_lblContactNumber = new GridBagConstraints();
		gbc_lblContactNumber.anchor = GridBagConstraints.EAST;
		gbc_lblContactNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactNumber.gridx = 0;
		gbc_lblContactNumber.gridy = 4;
		frmAddNewEmployee.getContentPane().add(lblContactNumber, gbc_lblContactNumber);
		
		cont_num = new JTextField();
		GridBagConstraints gbc_cont_num = new GridBagConstraints();
		gbc_cont_num.insets = new Insets(0, 0, 5, 5);
		gbc_cont_num.fill = GridBagConstraints.HORIZONTAL;
		gbc_cont_num.gridx = 1;
		gbc_cont_num.gridy = 4;
		frmAddNewEmployee.getContentPane().add(cont_num, gbc_cont_num);
		cont_num.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID");
		GridBagConstraints gbc_lblEmailId = new GridBagConstraints();
		gbc_lblEmailId.anchor = GridBagConstraints.EAST;
		gbc_lblEmailId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailId.gridx = 0;
		gbc_lblEmailId.gridy = 5;
		frmAddNewEmployee.getContentPane().add(lblEmailId, gbc_lblEmailId);
		
		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 1;
		gbc_email.gridy = 5;
		frmAddNewEmployee.getContentPane().add(email, gbc_email);
		email.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.anchor = GridBagConstraints.EAST;
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 0;
		gbc_lblDateOfBirth.gridy = 6;
		frmAddNewEmployee.getContentPane().add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		dob = new JTextField();
		GridBagConstraints gbc_dob = new GridBagConstraints();
		gbc_dob.insets = new Insets(0, 0, 5, 5);
		gbc_dob.fill = GridBagConstraints.HORIZONTAL;
		gbc_dob.gridx = 1;
		gbc_dob.gridy = 6;
		frmAddNewEmployee.getContentPane().add(dob, gbc_dob);
		dob.setColumns(10);
		
		JLabel lblBankName = new JLabel("Bank Name");
		GridBagConstraints gbc_lblBankName = new GridBagConstraints();
		gbc_lblBankName.anchor = GridBagConstraints.EAST;
		gbc_lblBankName.insets = new Insets(0, 0, 5, 5);
		gbc_lblBankName.gridx = 0;
		gbc_lblBankName.gridy = 7;
		frmAddNewEmployee.getContentPane().add(lblBankName, gbc_lblBankName);
		
		bank_name = new JTextField();
		GridBagConstraints gbc_bank_name = new GridBagConstraints();
		gbc_bank_name.insets = new Insets(0, 0, 5, 5);
		gbc_bank_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_bank_name.gridx = 1;
		gbc_bank_name.gridy = 7;
		frmAddNewEmployee.getContentPane().add(bank_name, gbc_bank_name);
		bank_name.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		GridBagConstraints gbc_lblAccountNumber = new GridBagConstraints();
		gbc_lblAccountNumber.anchor = GridBagConstraints.EAST;
		gbc_lblAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountNumber.gridx = 0;
		gbc_lblAccountNumber.gridy = 8;
		frmAddNewEmployee.getContentPane().add(lblAccountNumber, gbc_lblAccountNumber);
		
		acc_num = new JTextField();
		GridBagConstraints gbc_acc_num = new GridBagConstraints();
		gbc_acc_num.insets = new Insets(0, 0, 5, 5);
		gbc_acc_num.fill = GridBagConstraints.HORIZONTAL;
		gbc_acc_num.gridx = 1;
		gbc_acc_num.gridy = 8;
		frmAddNewEmployee.getContentPane().add(acc_num, gbc_acc_num);
		acc_num.setColumns(10);
		
		btnClose = new JButton("Close");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.insets = new Insets(0, 0, 0, 5);
		gbc_btnClose.gridx = 0;
		gbc_btnClose.gridy = 10;
		frmAddNewEmployee.getContentPane().add(btnClose, gbc_btnClose);
		btnClose.addActionListener(this);
		
		button = new JButton("Add Employee");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Name= name.getText().toString();
				String Cnic = cnic.getText().toString();
				int CNIC=Integer.parseInt(Cnic);
				String Address= addr.getText().toString();
				String Contact_num=cont_num.getText().toString();
				int ContactNumber= Integer.parseInt(Contact_num);
				String Email= email.getText().toString();
				String DOB= dob.getText().toString();
				String BankName= bank_name.getText().toString();
				String Acc_no = acc_num.getText().toString();
				int AccNumber= Integer.parseInt(Acc_no);
				
				
				HMS.addEmployee(Name, CNIC, Address, ContactNumber, Email, DOB, BankName, AccNumber);
				JOptionPane.showMessageDialog(frmAddNewEmployee, "Employee added successfully");
				Manager window2= new Manager(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmAddNewEmployee.setVisible(false);
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 10;
		frmAddNewEmployee.getContentPane().add(button, gbc_button);
	}
	public void actionPerformed(ActionEvent e){
	
			 Manager window2 = new Manager(HMS);
				window2.frmUpdateSalary.setVisible(true);
				frmAddNewEmployee.setVisible(false);
		
	}

}
