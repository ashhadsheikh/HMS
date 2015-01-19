package accountant;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;


import javax.swing.JTextField;


public class viewAllIncome implements ActionListener{
	AccountantController HMS;
	JFrame frmviewAllIncome;
	private JTable table;

	public viewAllIncome(AccountantController h) {
		HMS=h;
		initialize();
	}
	private void initialize() {
		frmviewAllIncome = new JFrame();
		
		frmviewAllIncome.setTitle("Income");
		frmviewAllIncome.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmviewAllIncome.getContentPane().setBackground(new Color(0, 102, 153));
		frmviewAllIncome.setBounds(350, 70, 625, 585);
		frmviewAllIncome.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmviewAllIncome.getContentPane().setLayout(springLayout);
		
		JLabel lblUpdateSalary = new JLabel("TOTAL INCOME TABLE");
		springLayout.putConstraint(SpringLayout.NORTH, lblUpdateSalary, 10, SpringLayout.NORTH, frmviewAllIncome.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUpdateSalary, 82, SpringLayout.NORTH, frmviewAllIncome.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUpdateSalary, 360, SpringLayout.WEST, frmviewAllIncome.getContentPane());
		lblUpdateSalary.setForeground(Color.WHITE);
		lblUpdateSalary.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frmviewAllIncome.getContentPane().add(lblUpdateSalary);
		
		table = new JTable(HMS.viewAllIncome());
		JScrollPane scrollPane = new JScrollPane( table );
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 48, SpringLayout.SOUTH, lblUpdateSalary);
		springLayout.putConstraint(SpringLayout.WEST, lblUpdateSalary, 0, SpringLayout.WEST, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frmviewAllIncome.getContentPane());
		frmviewAllIncome.getContentPane().add(scrollPane);
		
		JButton btnSave = new JButton("Save", null);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -18, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 486, SpringLayout.NORTH, frmviewAllIncome.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 449, SpringLayout.WEST, frmviewAllIncome.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -26, SpringLayout.SOUTH, frmviewAllIncome.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -31, SpringLayout.EAST, frmviewAllIncome.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Accountant window2 = new Accountant(HMS);
				 window2.frame.setVisible(true);
				 frmviewAllIncome.setVisible(false);
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSave.setBackground(new Color(51, 153, 204));
		frmviewAllIncome.getContentPane().add(btnSave);
	}
	public void actionPerformed(ActionEvent e){
		
	}
}
