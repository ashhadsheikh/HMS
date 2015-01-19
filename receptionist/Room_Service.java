package receptionist;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import java.awt.SystemColor;
import java.awt.Color;


public class Room_Service  implements ActionListener{
	ReceptionistController HMS;
	public JFrame frmRequestRoomService;

	
	/**
	 * Create the application.
	 */
	public Room_Service(ReceptionistController h) {
		HMS =h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnCancel;
	JComboBox<String> comboBox;
	JButton btnSave ;
	private void initialize() {
		frmRequestRoomService = new JFrame();
		frmRequestRoomService.setTitle("Request Room Service");
		frmRequestRoomService.setResizable(false);
		frmRequestRoomService.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmRequestRoomService.getContentPane().setBackground(new Color(0, 102, 153));
		frmRequestRoomService.setBounds(350, 70, 625, 585);
		frmRequestRoomService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmRequestRoomService.getContentPane().setLayout(springLayout);
		
		JLabel lblRoomService = new JLabel("Room Service");
		lblRoomService.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, lblRoomService, 10, SpringLayout.NORTH, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblRoomService, 10, SpringLayout.WEST, frmRequestRoomService.getContentPane());
		lblRoomService.setFont(new Font("Segoe UI Semilight", Font.BOLD, 25));
		frmRequestRoomService.getContentPane().add(lblRoomService);
		
		JLabel lblRoom = new JLabel("Room#");
		lblRoom.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblRoom, 10, SpringLayout.WEST, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblRoom, 74, SpringLayout.WEST, frmRequestRoomService.getContentPane());
		lblRoom.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmRequestRoomService.getContentPane().add(lblRoom);
		
		comboBox = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.NORTH, lblRoom, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 39, SpringLayout.SOUTH, lblRoomService);
		springLayout.putConstraint(SpringLayout.SOUTH, lblRoom, 0, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 122, SpringLayout.WEST, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -82, SpringLayout.EAST, frmRequestRoomService.getContentPane());
		comboBox.setBackground(new Color(51, 153, 204));
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		comboBox.addItem("13");
		comboBox.addItem("14");
		comboBox.addItem("15");
		comboBox.addItem("16");
		comboBox.addItem("17");
		comboBox.addItem("18");
		comboBox.addItem("19");
		
		
		frmRequestRoomService.getContentPane().add(comboBox);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, lblComments, 10, SpringLayout.WEST, frmRequestRoomService.getContentPane());
		lblComments.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frmRequestRoomService.getContentPane().add(lblComments);
		
		TextArea comments = new TextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -30, SpringLayout.NORTH, comments);
		springLayout.putConstraint(SpringLayout.WEST, comments, 26, SpringLayout.EAST, lblComments);
		springLayout.putConstraint(SpringLayout.EAST, comments, -82, SpringLayout.EAST, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblComments, 0, SpringLayout.NORTH, comments);
		springLayout.putConstraint(SpringLayout.NORTH, comments, 153, SpringLayout.NORTH, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comments, -91, SpringLayout.SOUTH, frmRequestRoomService.getContentPane());
		frmRequestRoomService.getContentPane().add(comments);
		
		btnSave = new JButton("Save");
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, -69, SpringLayout.SOUTH, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -23, SpringLayout.SOUTH, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSave, -82, SpringLayout.EAST, frmRequestRoomService.getContentPane());
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSave.setBackground(new Color(51, 153, 204));
		btnSave.addActionListener(this);
		frmRequestRoomService.getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 123, SpringLayout.WEST, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, -385, SpringLayout.EAST, frmRequestRoomService.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 192, SpringLayout.EAST, btnCancel);
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnSave);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, -23, SpringLayout.SOUTH, frmRequestRoomService.getContentPane());
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancel.setBackground(new Color(51, 153, 204));
		frmRequestRoomService.getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==btnCancel){
			 Receptionist window2 = new Receptionist(HMS);
			 window2.frame.setVisible(true);
			 frmRequestRoomService.setVisible(false);
		 }
		 if(e.getSource()==btnSave ){
			 int reservationID = Integer.parseInt(comboBox.getSelectedItem().toString());
				HMS.roomService(reservationID);;
				JOptionPane.showMessageDialog(frmRequestRoomService, "RoomService saved successfully");
				Receptionist window2 = new Receptionist(HMS);
				 window2.frame.setVisible(true);
				frmRequestRoomService.setVisible(false);
			  
		  }
		 
	 }
}
