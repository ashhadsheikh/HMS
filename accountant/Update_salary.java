package accountant;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Update_salary implements ActionListener{
	AccountantController HMS;
	JFrame frmAddSalary;
	private JTextField textField_1;
	JComboBox<String> comboBox;
	public Update_salary(AccountantController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnClose,btnSave;
	private void initialize() {
		frmAddSalary = new JFrame();
		frmAddSalary.setTitle("Add Salary");
		frmAddSalary.getContentPane().setBackground(new Color(0, 102, 153));
		frmAddSalary.setBounds(350, 70, 625, 585);
		frmAddSalary.setResizable(false);
		SpringLayout springLayout = new SpringLayout();
		frmAddSalary.getContentPane().setLayout(springLayout);
		
		JLabel lblAddSalary = new JLabel("Update Salary");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddSalary, 27, SpringLayout.NORTH, frmAddSalary.getContentPane());
		lblAddSalary.setForeground(Color.WHITE);
		lblAddSalary.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		frmAddSalary.getContentPane().add(lblAddSalary);
		
		JLabel EmpId = new JLabel("Employee ID");
		EmpId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 19));
		EmpId.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, EmpId, 70, SpringLayout.SOUTH, lblAddSalary);
		springLayout.putConstraint(SpringLayout.WEST, EmpId, 0, SpringLayout.WEST, lblAddSalary);
		frmAddSalary.getContentPane().add(EmpId);
		
		comboBox = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -10, SpringLayout.NORTH, EmpId);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 35, SpringLayout.EAST, EmpId);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 35, SpringLayout.NORTH, EmpId);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -321, SpringLayout.EAST, frmAddSalary.getContentPane());
		frmAddSalary.getContentPane().add(comboBox);
		comboBox.addItem("0");
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		 comboBox.setBackground(new Color(51, 153, 204));
		JLabel Salary = new JLabel("Salary");
		Salary.setForeground(Color.WHITE);
		Salary.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 19));
		springLayout.putConstraint(SpringLayout.NORTH, Salary, 60, SpringLayout.SOUTH, EmpId);
		springLayout.putConstraint(SpringLayout.WEST, Salary, 0, SpringLayout.WEST, lblAddSalary);
		frmAddSalary.getContentPane().add(Salary);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, Salary);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 10, SpringLayout.SOUTH, Salary);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, comboBox);
		frmAddSalary.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		 btnSave = new JButton("Save");
		 springLayout.putConstraint(SpringLayout.NORTH, btnSave, 446, SpringLayout.NORTH, frmAddSalary.getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, btnSave, 434, SpringLayout.WEST, frmAddSalary.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -56, SpringLayout.SOUTH, frmAddSalary.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnSave, -32, SpringLayout.EAST, frmAddSalary.getContentPane());
		frmAddSalary.getContentPane().add(btnSave);
		 btnSave.setBackground(new Color(51, 153, 204));
		btnSave.addActionListener(this);
		
		btnClose = new JButton("Close");
		springLayout.putConstraint(SpringLayout.WEST, lblAddSalary, 0, SpringLayout.WEST, btnClose);
		springLayout.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.WEST, btnClose, 39, SpringLayout.WEST, frmAddSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnClose, 0, SpringLayout.SOUTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, btnClose, -254, SpringLayout.WEST, btnSave);
		frmAddSalary.getContentPane().add(btnClose);
		 btnClose.setBackground(new Color(51, 153, 204));
		btnClose.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnSave ){
			Object item = comboBox.getSelectedItem();
			int Emp_id=Integer.parseInt((String) item);
			String sal = textField_1.getText().toString();
			int Sal=Integer.parseInt(sal);
			HMS.updateSalary(Emp_id,Sal);
			JOptionPane.showMessageDialog(frmAddSalary, "Salary updated successfully");
			 ViewAllSalaries window2 = new ViewAllSalaries(HMS);
			 window2.frmUpdateSalary.setVisible(true);
			 frmAddSalary.setVisible(false);	}
		else if(e.getSource()==btnClose){
			 ViewAllSalaries window2 = new ViewAllSalaries(HMS);
			 window2.frmUpdateSalary.setVisible(true);
			 frmAddSalary.setVisible(false);
		}

		
	}
}
