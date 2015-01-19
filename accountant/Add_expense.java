package accountant;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;




public class Add_expense implements ActionListener{
	AccountantController HMS;
	JFrame frmAddExpense;
	private JTextField date;
	private JTextField name;
	private JTextField amount;
	JButton btnSave;
	TextArea details;
	JComboBox<String> type ;
	/**
	 * Create the application.
	 */
	public Add_expense(AccountantController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnClose;
	private void initialize() {
		frmAddExpense = new JFrame();
		frmAddExpense.setTitle("Add Expense");
		frmAddExpense.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmAddExpense.getContentPane().setBackground(new Color(0, 102, 153));
		frmAddExpense.setBounds(350, 70, 625, 585);
		frmAddExpense.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddExpense.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmAddExpense.getContentPane().setLayout(springLayout);
		
		JLabel lblAddExpense = new JLabel("Add Expense");
		springLayout.putConstraint(SpringLayout.WEST, lblAddExpense, 10, SpringLayout.WEST, frmAddExpense.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAddExpense, -509, SpringLayout.SOUTH, frmAddExpense.getContentPane());
		lblAddExpense.setForeground(Color.WHITE);
		lblAddExpense.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		frmAddExpense.getContentPane().add(lblAddExpense);
		
		
		
		JLabel lblDate = new JLabel("Date");
		springLayout.putConstraint(SpringLayout.WEST, lblDate, 10, SpringLayout.WEST, frmAddExpense.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDate, -552, SpringLayout.EAST, frmAddExpense.getContentPane());
		lblDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDate.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblDate, 23, SpringLayout.SOUTH, lblAddExpense);
		frmAddExpense.getContentPane().add(lblDate);
		
		date = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, date, 0, SpringLayout.NORTH, lblDate);
		springLayout.putConstraint(SpringLayout.WEST, date, 70, SpringLayout.EAST, lblDate);
		springLayout.putConstraint(SpringLayout.SOUTH, date, 0, SpringLayout.SOUTH, lblDate);
		springLayout.putConstraint(SpringLayout.EAST, date, -239, SpringLayout.EAST, frmAddExpense.getContentPane());
		frmAddExpense.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblType.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblType, 31, SpringLayout.SOUTH, lblDate);
		springLayout.putConstraint(SpringLayout.WEST, lblType, 10, SpringLayout.WEST, frmAddExpense.getContentPane());
		frmAddExpense.getContentPane().add(lblType);
		
		type = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.NORTH, type, 0, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, type, 91, SpringLayout.EAST, lblType);
		springLayout.putConstraint(SpringLayout.SOUTH, type, 0, SpringLayout.SOUTH, lblType);
		springLayout.putConstraint(SpringLayout.EAST, type, -239, SpringLayout.EAST, frmAddExpense.getContentPane());
		type.addItem("Transport Expense");
		type.addItem("Inventory Expense");
		type.addItem("Marketing Expense");
		type.addItem("Interest Expense");
		type.addItem("Administrative Expense");
		type.addItem("General Expenses");
		type.addItem("Insurance Expense");
		
		type.setBackground(new Color(51, 153, 204));
		frmAddExpense.getContentPane().add(type);
		JLabel lblExpenseName = new JLabel("Expense Name");
		springLayout.putConstraint(SpringLayout.WEST, lblExpenseName, 0, SpringLayout.WEST, lblAddExpense);
		springLayout.putConstraint(SpringLayout.SOUTH, lblExpenseName, -354, SpringLayout.SOUTH, frmAddExpense.getContentPane());
		lblExpenseName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblExpenseName.setForeground(Color.WHITE);
		frmAddExpense.getContentPane().add(lblExpenseName);
		
		name = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, name, 177, SpringLayout.NORTH, frmAddExpense.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, name, 14, SpringLayout.EAST, lblExpenseName);
		springLayout.putConstraint(SpringLayout.SOUTH, name, 0, SpringLayout.SOUTH, lblExpenseName);
		springLayout.putConstraint(SpringLayout.EAST, name, -239, SpringLayout.EAST, frmAddExpense.getContentPane());
		frmAddExpense.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		springLayout.putConstraint(SpringLayout.NORTH, lblAmount, 21, SpringLayout.SOUTH, lblExpenseName);
		springLayout.putConstraint(SpringLayout.WEST, lblAmount, 0, SpringLayout.WEST, lblAddExpense);
		lblAmount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAmount.setForeground(Color.WHITE);
		frmAddExpense.getContentPane().add(lblAmount);
		
		amount = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, amount, 0, SpringLayout.NORTH, lblAmount);
		springLayout.putConstraint(SpringLayout.WEST, amount, 0, SpringLayout.WEST, date);
		springLayout.putConstraint(SpringLayout.SOUTH, amount, 0, SpringLayout.SOUTH, lblAmount);
		springLayout.putConstraint(SpringLayout.EAST, amount, 0, SpringLayout.EAST, date);
		frmAddExpense.getContentPane().add(amount);
		amount.setColumns(10);
		
		JLabel lblDetails = new JLabel("Details");
		springLayout.putConstraint(SpringLayout.NORTH, lblDetails, 25, SpringLayout.SOUTH, lblAmount);
		springLayout.putConstraint(SpringLayout.WEST, lblDetails, 0, SpringLayout.WEST, lblAddExpense);
		lblDetails.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDetails.setForeground(Color.WHITE);
		frmAddExpense.getContentPane().add(lblDetails);
		
		 details = new TextArea();
		 springLayout.putConstraint(SpringLayout.NORTH, details, 27, SpringLayout.SOUTH, amount);
		 springLayout.putConstraint(SpringLayout.WEST, details, 0, SpringLayout.WEST, date);
		 springLayout.putConstraint(SpringLayout.SOUTH, details, -148, SpringLayout.SOUTH, frmAddExpense.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, details, 0, SpringLayout.EAST, date);
		frmAddExpense.getContentPane().add(details);
		
		 btnSave = new JButton("Save");
		 springLayout.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, date);
		 btnSave.setBackground(new Color(51, 153, 204));
		 btnSave.setForeground(Color.WHITE);
		 btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		frmAddExpense.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
		 btnClose = new JButton("Close");
		 springLayout.putConstraint(SpringLayout.WEST, btnSave, 112, SpringLayout.EAST, btnClose);
		 springLayout.putConstraint(SpringLayout.SOUTH, btnSave, 0, SpringLayout.SOUTH, btnClose);
		 springLayout.putConstraint(SpringLayout.NORTH, btnClose, 55, SpringLayout.SOUTH, details);
		 springLayout.putConstraint(SpringLayout.SOUTH, btnClose, -45, SpringLayout.SOUTH, frmAddExpense.getContentPane());
		 springLayout.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, btnClose);
		 springLayout.putConstraint(SpringLayout.EAST, btnClose, 19, SpringLayout.EAST, lblExpenseName);
		 springLayout.putConstraint(SpringLayout.WEST, btnClose, 0, SpringLayout.WEST, lblAddExpense);
		 btnClose.setBackground(new Color(51, 153, 204));
		 btnClose.setForeground(Color.WHITE);
		 btnClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		frmAddExpense.getContentPane().add(btnClose);
		btnClose.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnSave ){
			Object item = type.getSelectedItem();
			String Name = name.getText().toString();
			String Type =item.toString();
			String Date = date.getText().toString();
			String Amount=amount.getText().toString();
			long am=Long.parseLong(Amount);
			String Details=details.getText().toString();
			
			HMS.addExpense(Name, Type,Date,am,Details);
			JOptionPane.showMessageDialog(frmAddExpense, "Expense added successfully");
			SearchExpense se=new SearchExpense(HMS);
			se.frmUpdateSalary.setVisible(true);
			frmAddExpense.setVisible(false);
		}
		else if(e.getSource()==btnClose){
			SearchExpense se=new SearchExpense(HMS);
			se.frmUpdateSalary.setVisible(true);
			frmAddExpense.setVisible(false);
		}
		
	}
}
