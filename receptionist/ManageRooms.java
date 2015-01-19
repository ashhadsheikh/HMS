package receptionist;
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

import accountant.Accountant;


public class ManageRooms implements ActionListener{
	ReceptionistController HMS;
	JFrame frmUpdateSalary;
	private JTable table;

	public ManageRooms(ReceptionistController h) {
		HMS=h;
		initialize();
	}
	private JTextField textField;
	private void initialize() {
		frmUpdateSalary = new JFrame();
		
		frmUpdateSalary.setTitle("Room");
		frmUpdateSalary.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmUpdateSalary.getContentPane().setBackground(new Color(0, 102, 153));
		frmUpdateSalary.setBounds(350, 70, 625, 585);
		frmUpdateSalary.setResizable(false);;
		SpringLayout springLayout = new SpringLayout();
		frmUpdateSalary.getContentPane().setLayout(springLayout);
		
		JLabel lblUpdateSalary = new JLabel("Rooms");
		springLayout.putConstraint(SpringLayout.SOUTH, lblUpdateSalary, 61, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUpdateSalary, 120, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		lblUpdateSalary.setForeground(Color.WHITE);
		lblUpdateSalary.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblUpdateSalary, 10, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblUpdateSalary, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		frmUpdateSalary.getContentPane().add(lblUpdateSalary);
		
		table = new JTable(HMS.getRooms());
		JScrollPane scrollPane = new JScrollPane( table );
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -89, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -31, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		frmUpdateSalary.getContentPane().add(scrollPane);
		
		JLabel lblEmployeeId = new JLabel("Room ID");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 16, SpringLayout.SOUTH, lblEmployeeId);
		springLayout.putConstraint(SpringLayout.NORTH, lblEmployeeId, 18, SpringLayout.SOUTH, lblUpdateSalary);
		springLayout.putConstraint(SpringLayout.WEST, lblEmployeeId, 10, SpringLayout.WEST, frmUpdateSalary.getContentPane());
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frmUpdateSalary.getContentPane().add(lblEmployeeId);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 69, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 20, SpringLayout.EAST, lblEmployeeId);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -16, SpringLayout.NORTH, scrollPane);
		textField.setColumns(10);
		frmUpdateSalary.getContentPane().add(textField);
		
		JButton btnCancel = new JButton("Cancel", null);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Receptionist window2 = new Receptionist(HMS);
				 window2.frame.setVisible(true);
				 frmUpdateSalary.setVisible(false);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 19, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, 63, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, -31, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancel.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnCancel);
		
		JButton btnUpdate = new JButton("Delete", null);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnUpdate, -176, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 6, SpringLayout.EAST, btnUpdate);
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, 19, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnUpdate.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnUpdate);
		
		JButton btnUpdate_1 = new JButton("Update", null);
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnUpdate_1, -317, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 6, SpringLayout.EAST, btnUpdate_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate_1, 19, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate_1, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		btnUpdate_1.setForeground(Color.WHITE);
		btnUpdate_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnUpdate_1.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnUpdate_1);
		
		JButton btnAdd = new JButton("Add", null);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -462, SpringLayout.EAST, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate_1, 6, SpringLayout.EAST, btnAdd);
		springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 19, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 0, SpringLayout.WEST, lblUpdateSalary);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAdd, -26, SpringLayout.SOUTH, frmUpdateSalary.getContentPane());
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(btnAdd);
		
		JButton button = new JButton("Search", null);
		springLayout.putConstraint(SpringLayout.NORTH, button, 69, SpringLayout.NORTH, frmUpdateSalary.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, btnCancel);
		springLayout.putConstraint(SpringLayout.SOUTH, button, -16, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, scrollPane);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		button.setBackground(new Color(51, 153, 204));
		frmUpdateSalary.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<table.getRowCount();i++) {

				    // 0 is for the column Part number
				    if(table.getValueAt(i, 0).equals(Integer.valueOf(textField.getText()))) {
				    	table.setRowSelectionInterval(i, i);
				        break;
				    }
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e){
		
	}
}
