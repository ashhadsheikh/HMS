package receptionist;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.sql.Time;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTable;

public class Room_Report {

	JFrame frame;
	ReceptionistController HMS;
	private JTextField textField;
	private JTable table;


	/**
	 * Create the application.
	 */
	public Room_Report(ReceptionistController h) {
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
		
		//lblNewLabel.setIcon(new ImageIcon(".\\HSW_logo_proposal_1_by_khawarbilal.jpg"));
		Icon a =new ImageIcon(".\\hh.png");
		
		JLabel lblReceptionist = new JLabel("Rooms Information");
		lblReceptionist.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setBounds(10, 35, 240, 39);
		frame.getContentPane().add(lblReceptionist);
		
		JButton btnBookRoom = new JButton("Search", null);
		btnBookRoom.setForeground(Color.WHITE);
		btnBookRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBookRoom.setBackground(new Color(51, 153, 204));
		btnBookRoom.setBounds(339, 95, 130, 46);
		frame.getContentPane().add(btnBookRoom);
		btnBookRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<table.getRowCount();i++) {

				    // 0 is for the column Part number
				    if(table.getValueAt(i, 0).equals(Integer.valueOf(textField.getText()))) {
				    	table.setRowSelectionInterval(i, i);
				        break;
				    }
				}
			}
		});
		
		JLabel lblRoomId = new JLabel("Room ID");
		lblRoomId.setForeground(Color.WHITE);
		lblRoomId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblRoomId.setBounds(10, 102, 109, 39);
		frame.getContentPane().add(lblRoomId);
		
		textField = new JTextField();
		textField.setBounds(129, 95, 200, 46);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable(HMS.getRooms());
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(10, 167, 589, 368);
		frame.getContentPane().add(scrollPane);
		
		JButton button = new JButton("Cancel", null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Receptionist window2 = new Receptionist(HMS);
				 window2.frame.setVisible(true);
				 frame.setVisible(false);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		button.setBackground(new Color(51, 153, 204));
		button.setBounds(479, 95, 120, 46);
		frame.getContentPane().add(button);
		
		
	}
}
