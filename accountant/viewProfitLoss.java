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


public class viewProfitLoss implements ActionListener{
	int id;
	AccountantController HMS;
	JFrame frmProfitLoss;
	private JTextField date;
	private JTextField name;
	private JTextField amount;
	JButton btnSave;
	private JTextField textField;
	private JLabel label;
	/**
	 * Create the application.
	 */
	public viewProfitLoss(AccountantController h) {
		HMS=h;
		initialize();
	}
	private void initialize() {
		frmProfitLoss = new JFrame();
		frmProfitLoss.setTitle("Profit/Loss Statement");
		frmProfitLoss.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmProfitLoss.getContentPane().setBackground(new Color(0, 102, 153));
		frmProfitLoss.setBounds(350, 70, 625, 585);
		frmProfitLoss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfitLoss.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmProfitLoss.getContentPane().setLayout(springLayout);
		
		JLabel lblAddExpense = new JLabel("Profit/Loss Statement");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddExpense, -545, SpringLayout.SOUTH, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAddExpense, 10, SpringLayout.WEST, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAddExpense, -456, SpringLayout.SOUTH, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAddExpense, 336, SpringLayout.WEST, frmProfitLoss.getContentPane());
		lblAddExpense.setForeground(Color.WHITE);
		lblAddExpense.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		frmProfitLoss.getContentPane().add(lblAddExpense);
		
		
		
		JLabel lblDate = new JLabel("Total Income");
		springLayout.putConstraint(SpringLayout.WEST, lblDate, 10, SpringLayout.WEST, frmProfitLoss.getContentPane());
		lblDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDate.setForeground(Color.WHITE);
		frmProfitLoss.getContentPane().add(lblDate);
		
		date = new JTextField(HMS.getIncome()+"");
		springLayout.putConstraint(SpringLayout.NORTH, date, 42, SpringLayout.SOUTH, lblAddExpense);
		springLayout.putConstraint(SpringLayout.NORTH, lblDate, 0, SpringLayout.NORTH, date);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDate, 0, SpringLayout.SOUTH, date);
		springLayout.putConstraint(SpringLayout.EAST, lblDate, -6, SpringLayout.WEST, date);
		springLayout.putConstraint(SpringLayout.EAST, date, -140, SpringLayout.EAST, frmProfitLoss.getContentPane());
		frmProfitLoss.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblExpenseName = new JLabel("Total Expense");
		springLayout.putConstraint(SpringLayout.WEST, lblExpenseName, 10, SpringLayout.WEST, frmProfitLoss.getContentPane());
		lblExpenseName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblExpenseName.setForeground(Color.WHITE);
		frmProfitLoss.getContentPane().add(lblExpenseName);
		
		name = new JTextField(HMS.getAllExpense()+"");
		springLayout.putConstraint(SpringLayout.WEST, date, 0, SpringLayout.WEST, name);
		springLayout.putConstraint(SpringLayout.SOUTH, date, -6, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.WEST, name, 7, SpringLayout.EAST, lblExpenseName);
		springLayout.putConstraint(SpringLayout.EAST, name, -140, SpringLayout.EAST, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblExpenseName, 0, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.NORTH, name, 184, SpringLayout.NORTH, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, name, -333, SpringLayout.SOUTH, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblExpenseName, 3, SpringLayout.NORTH, name);
		frmProfitLoss.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblAmount = new JLabel("Profit");
		springLayout.putConstraint(SpringLayout.NORTH, lblAmount, 8, SpringLayout.SOUTH, lblExpenseName);
		springLayout.putConstraint(SpringLayout.WEST, lblAmount, 10, SpringLayout.WEST, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblAmount, -291, SpringLayout.SOUTH, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblAmount, 0, SpringLayout.EAST, lblDate);
		lblAmount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAmount.setForeground(Color.WHITE);
		frmProfitLoss.getContentPane().add(lblAmount);
		
		amount = new JTextField(HMS.getProfit()+"");
		springLayout.putConstraint(SpringLayout.NORTH, amount, 6, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.WEST, amount, 122, SpringLayout.WEST, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, amount, -291, SpringLayout.SOUTH, frmProfitLoss.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, amount, -140, SpringLayout.EAST, frmProfitLoss.getContentPane());
		frmProfitLoss.getContentPane().add(amount);
		amount.setColumns(10);
		
		 btnSave = new JButton("Save");
		 springLayout.putConstraint(SpringLayout.NORTH, btnSave, 86, SpringLayout.SOUTH, amount);
		 springLayout.putConstraint(SpringLayout.WEST, btnSave, 348, SpringLayout.WEST, frmProfitLoss.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -157, SpringLayout.SOUTH, frmProfitLoss.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnSave, -138, SpringLayout.EAST, frmProfitLoss.getContentPane());
		 btnSave.setBackground(new Color(51, 153, 204));
		 btnSave.setForeground(Color.WHITE);
		 btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		frmProfitLoss.getContentPane().add(btnSave);
		
		textField = new JTextField(HMS.getLoss()+"");
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, amount);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, date);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 45, SpringLayout.SOUTH, amount);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, date);
		textField.setColumns(10);
		frmProfitLoss.getContentPane().add(textField);
		
		label = new JLabel("Loss");
		springLayout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblAmount);
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblAddExpense);
		springLayout.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, lblDate);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmProfitLoss.getContentPane().add(label);
		btnSave.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 Accountant window2 = new Accountant(HMS);
		 window2.frame.setVisible(true);
		 frmProfitLoss.setVisible(false);
		
	}
	
		
}

