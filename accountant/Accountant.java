package accountant;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


import javax.swing.JLabel;

import java.awt.Font;

public class Accountant {

	public JFrame frame;
	AccountantController HMS;


	/**
	 * Create the application.
	 */
	public Accountant(AccountantController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(0, 102, 153));
		frame.setBounds(350, 70, 625, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\logout.png"));
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setBounds(509, 125, 82, 38);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 String message = " Are you sure you want to Exit ? ";
	             String title = "Quit";
	             int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	             if (reply == JOptionPane.YES_OPTION){
	            	 
					frame.setVisible(false);
	             }
				
				
			}
		});
		
		JLabel lblReceptionist = new JLabel("Accountant");
		lblReceptionist.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setBounds(10, 124, 131, 39);
		frame.getContentPane().add(lblReceptionist);
		
		JButton btnBookRoom = new JButton("Manage Expense", null);
		btnBookRoom.setForeground(Color.WHITE);
		btnBookRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBookRoom.setBackground(new Color(51, 153, 204));
		btnBookRoom.setBounds(10, 185, 187, 77);
		frame.getContentPane().add(btnBookRoom);
		btnBookRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SearchExpense se=new SearchExpense(HMS);
				se.frmUpdateSalary.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		JButton btnCheckout = new JButton("Profit Loss Statement", null);
		btnCheckout.setForeground(Color.WHITE);
		btnCheckout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckout.setBackground(new Color(51, 153, 204));
		btnCheckout.setBounds(10, 273, 187, 77);
		frame.getContentPane().add(btnCheckout);
		btnCheckout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewProfitLoss profitLoss = new viewProfitLoss(HMS);
				profitLoss.frmProfitLoss.setVisible(true);
				frame.setVisible(false);				
			}
		});
		
		JButton btnGuestReport = new JButton("Manage Salary", null);
		btnGuestReport.setForeground(Color.WHITE);
		btnGuestReport.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnGuestReport.setBackground(new Color(51, 153, 204));
		btnGuestReport.setBounds(207, 185, 187, 77);
		frame.getContentPane().add(btnGuestReport);
		btnGuestReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 ViewAllSalaries window2 = new ViewAllSalaries(HMS);
				 window2.frmUpdateSalary.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		JButton btnviewIncome = new JButton("View Income", null);
		btnviewIncome.setForeground(Color.WHITE);
		btnviewIncome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnviewIncome.setBackground(new Color(51, 153, 204));
		btnviewIncome.setBounds(207, 273, 187, 77);
		frame.getContentPane().add(btnviewIncome);
		btnviewIncome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 viewAllIncome viewIncome = new viewAllIncome(HMS);
				 viewIncome.frmviewAllIncome.setVisible(true);
				 frame.setVisible(false);
			}
		});
		
		JButton btnTax = new JButton("Tax Statement", null);
		btnTax.setForeground(Color.WHITE);
		btnTax.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnTax.setBackground(new Color(51, 153, 204));
		btnTax.setBounds(404, 185, 187, 77);
		frame.getContentPane().add(btnTax);
		btnTax.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewTaxStatement tax = new viewTaxStatement(HMS);
				tax.frmTax.setVisible(true);
				frame.setVisible(false);	 
				
			}
		});
		
		JButton btnBack = new JButton("Exit", null);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String message = " Are you sure you want to Quit ? ";
	             String title = "Quit";
	             int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	             if (reply == JOptionPane.YES_OPTION){
	            	 frame.setVisible(false);
	             }
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBack.setBackground(new Color(51, 153, 204));
		btnBack.setBounds(404, 273, 187, 77);
		frame.getContentPane().add(btnBack);
		
		JLabel lblHotelManagmentSystem = new JLabel("Hotel Managment System");
		lblHotelManagmentSystem.setForeground(Color.WHITE);
		lblHotelManagmentSystem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		lblHotelManagmentSystem.setBounds(109, 36, 461, 59);
		frame.getContentPane().add(lblHotelManagmentSystem);
		
		
	}
}
