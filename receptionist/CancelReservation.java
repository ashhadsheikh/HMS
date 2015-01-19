package receptionist;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.sql.Time;

import businessLogic.Reservation;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

public class CancelReservation {

	 JFrame frame;
	 ReceptionistController HMS;
	private JTextField resNo;
	private JTextField roomNo;
	private JTextField guestId;
	private JTextField resDate;
	private JTextField advance;


	/**
	 * Create the application.
	 */
	public CancelReservation(ReceptionistController h) {
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
		

		JLabel lblReceptionist = new JLabel("Cancel Reservation");
		lblReceptionist.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setBounds(10, 35, 319, 39);
		frame.getContentPane().add(lblReceptionist);
		
		JButton btnBookRoom = new JButton("Search", null);
		btnBookRoom.setForeground(Color.WHITE);
		btnBookRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBookRoom.setBackground(new Color(51, 153, 204));
		btnBookRoom.setBounds(498, 93, 101, 46);
		frame.getContentPane().add(btnBookRoom);
		btnBookRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 int reservationID=Integer.parseInt(resNo.getText());
					Reservation r=HMS.returnReservation(reservationID );
					 roomNo.setText(""+r.getRoomID());
					 guestId.setText(r.returncheckIn());
					 //resNo.setText(r.returncheckIn());
					 resDate.setText(""+r.getGuestID());
				
					advance.setText(""+r.returnAdvance());
			}
		});
		
		JLabel lblRoomId = new JLabel("Reservation ID");
		lblRoomId.setForeground(Color.WHITE);
		lblRoomId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblRoomId.setBounds(10, 102, 157, 39);
		frame.getContentPane().add(lblRoomId);
		
		resNo = new JTextField();
		resNo.setBounds(177, 98, 311, 43);
		frame.getContentPane().add(resNo);
		resNo.setColumns(10);
		
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
		button.setBounds(10, 462, 101, 46);
		frame.getContentPane().add(button);
		
		JLabel lblRoomId_1 = new JLabel("Room ID");
		lblRoomId_1.setForeground(Color.WHITE);
		lblRoomId_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblRoomId_1.setBounds(10, 177, 157, 39);
		frame.getContentPane().add(lblRoomId_1);
		
		JLabel lblReservationDate = new JLabel("Booking Date");
		lblReservationDate.setForeground(Color.WHITE);
		lblReservationDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblReservationDate.setBounds(10, 248, 200, 39);
		frame.getContentPane().add(lblReservationDate);
		
		JLabel lblGuestId = new JLabel("Guest ID");
		lblGuestId.setForeground(Color.WHITE);
		lblGuestId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblGuestId.setBounds(10, 307, 157, 39);
		frame.getContentPane().add(lblGuestId);
		
		JLabel lblAdvance = new JLabel("Advance");
		lblAdvance.setForeground(Color.WHITE);
		lblAdvance.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblAdvance.setBounds(10, 375, 157, 39);
		frame.getContentPane().add(lblAdvance);
		
		roomNo = new JTextField();
		roomNo.setColumns(10);
		roomNo.setBounds(177, 173, 311, 43);
		frame.getContentPane().add(roomNo);
		
		guestId = new JTextField();
		guestId.setColumns(10);
		guestId.setBounds(177, 244, 311, 43);
		frame.getContentPane().add(guestId);
		
		resDate = new JTextField();
		resDate.setColumns(10);
		resDate.setBounds(177, 307, 311, 43);
		frame.getContentPane().add(resDate);
		
		advance = new JTextField();
		advance.setColumns(10);
		advance.setBounds(177, 371, 311, 43);
		frame.getContentPane().add(advance);
		
		JButton button_1 = new JButton("End Reservation", null);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int reservationID=Integer.parseInt(resNo.getText());
				 HMS.endReservation(Integer.parseInt(roomNo.getText().toString()));
				 HMS.returnReservationAtCancelBooking( reservationID);
				 
				 
				 JOptionPane.showMessageDialog(frame,
							"End Reservation Successful");
				 Receptionist window2 = new Receptionist(HMS);
				 window2.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		button_1.setBackground(new Color(51, 153, 204));
		button_1.setBounds(425, 462, 174, 46);
		frame.getContentPane().add(button_1);
		
		
	}
}
