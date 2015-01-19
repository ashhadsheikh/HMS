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

import businessLogic.Expense;


public class viewTaxStatement implements ActionListener{
	int id;
	AccountantController HMS;
	JFrame frmTax;
	private JTextField date;
	private JTextField name;
	private JTextField amount;
	JButton btnSave;
	/**
	 * Create the application.
	 */
	public viewTaxStatement(AccountantController h) {
		HMS=h;
		initialize();
	}
	private void initialize() {
		frmTax = new JFrame();
		frmTax.setTitle("Tax Statement");
		frmTax.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmTax.getContentPane().setBackground(new Color(0, 102, 153));
		frmTax.setBounds(350, 70, 625, 585);
		frmTax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTax.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmTax.getContentPane().setLayout(springLayout);
		
		JLabel lblAddExpense = new JLabel("Tax Statement");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddExpense, -545, SpringLayout.SOUTH, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAddExpense, 10, SpringLayout.WEST, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAddExpense, -456, SpringLayout.SOUTH, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAddExpense, 188, SpringLayout.WEST, frmTax.getContentPane());
		lblAddExpense.setForeground(Color.WHITE);
		lblAddExpense.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		frmTax.getContentPane().add(lblAddExpense);
		
		
		
		JLabel lblDate = new JLabel("Total Income");
		springLayout.putConstraint(SpringLayout.WEST, lblDate, 10, SpringLayout.WEST, frmTax.getContentPane());
		lblDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDate.setForeground(Color.WHITE);
		frmTax.getContentPane().add(lblDate);
		
		date = new JTextField(HMS.getIncome()+"");
		springLayout.putConstraint(SpringLayout.NORTH, date, 42, SpringLayout.SOUTH, lblAddExpense);
		springLayout.putConstraint(SpringLayout.NORTH, lblDate, 0, SpringLayout.NORTH, date);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDate, 0, SpringLayout.SOUTH, date);
		springLayout.putConstraint(SpringLayout.EAST, lblDate, -6, SpringLayout.WEST, date);
		springLayout.putConstraint(SpringLayout.EAST, date, -140, SpringLayout.EAST, frmTax.getContentPane());
		frmTax.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblExpenseName = new JLabel("Total Expense");
		springLayout.putConstraint(SpringLayout.WEST, lblExpenseName, 10, SpringLayout.WEST, frmTax.getContentPane());
		lblExpenseName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblExpenseName.setForeground(Color.WHITE);
		frmTax.getContentPane().add(lblExpenseName);
		
		name = new JTextField(HMS.getAllExpense()+"");
		springLayout.putConstraint(SpringLayout.WEST, date, 0, SpringLayout.WEST, name);
		springLayout.putConstraint(SpringLayout.SOUTH, date, -6, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.WEST, name, 7, SpringLayout.EAST, lblExpenseName);
		springLayout.putConstraint(SpringLayout.EAST, name, -140, SpringLayout.EAST, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblExpenseName, 0, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.NORTH, name, 184, SpringLayout.NORTH, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, name, -333, SpringLayout.SOUTH, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblExpenseName, 3, SpringLayout.NORTH, name);
		frmTax.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblAmount = new JLabel("Tax");
		springLayout.putConstraint(SpringLayout.NORTH, lblAmount, 8, SpringLayout.SOUTH, lblExpenseName);
		springLayout.putConstraint(SpringLayout.WEST, lblAmount, 10, SpringLayout.WEST, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAmount, -291, SpringLayout.SOUTH, frmTax.getContentPane());
		lblAmount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAmount.setForeground(Color.WHITE);
		frmTax.getContentPane().add(lblAmount);
		
		amount = new JTextField(HMS.getTax()+"");
		springLayout.putConstraint(SpringLayout.WEST, amount, 122, SpringLayout.WEST, frmTax.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAmount, -33, SpringLayout.WEST, amount);
		springLayout.putConstraint(SpringLayout.NORTH, amount, 6, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.EAST, amount, -140, SpringLayout.EAST, frmTax.getContentPane());
		frmTax.getContentPane().add(amount);
		amount.setColumns(10);
		
		 btnSave = new JButton("Save");
		 springLayout.putConstraint(SpringLayout.NORTH, btnSave, 286, SpringLayout.NORTH, frmTax.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, amount, -21, SpringLayout.NORTH, btnSave);
		 springLayout.putConstraint(SpringLayout.WEST, btnSave, 347, SpringLayout.WEST, frmTax.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -222, SpringLayout.SOUTH, frmTax.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnSave, -139, SpringLayout.EAST, frmTax.getContentPane());
		 btnSave.setBackground(new Color(51, 153, 204));
		 btnSave.setForeground(Color.WHITE);
		 btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		frmTax.getContentPane().add(btnSave);
		btnSave.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 Accountant window2 = new Accountant(HMS);
		 window2.frame.setVisible(true);
		 frmTax.setVisible(false);
		
	}
	
		
}

