package receptionist;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuItem;


import javax.swing.JLabel;

import receptionist.AllGuests;
import receptionist.AllReservations;
import receptionist.CancelReservation;
import receptionist.CheckIN;
import receptionist.CheckOut;
import receptionist.Guest_Report;
import receptionist.Room_Report;
import receptionist.Room_Service;

import java.awt.Font;

public class Receptionist {

	public JFrame frame;
	ReceptionistController HMS;


	/**
	 * Create the application.
	 */
	public Receptionist(ReceptionistController h) {
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
		
		JButton btnCheckin = new JButton("Room Service",null);
		btnCheckin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckin.setForeground(new Color(255, 255, 255));
		btnCheckin.setBackground(new Color(51, 153, 204));
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Room_Service window2 = new Room_Service(HMS);
					window2.frmRequestRoomService.setVisible(true);
					frame.setVisible(false);
			}
		});
		//button.setSize(187, 77);
		btnCheckin.setBounds(10, 361, 187, 77);
		frame.getContentPane().add(btnCheckin);
		
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
		
		JLabel lblReceptionist = new JLabel("Receptionist");
		lblReceptionist.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setBounds(10, 124, 131, 39);
		frame.getContentPane().add(lblReceptionist);
		
		JButton btnBookRoom = new JButton("Book Room", null);
		btnBookRoom.setForeground(Color.WHITE);
		btnBookRoom.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBookRoom.setBackground(new Color(51, 153, 204));
		btnBookRoom.setBounds(10, 185, 187, 77);
		frame.getContentPane().add(btnBookRoom);
		btnBookRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CheckIN window2 = new CheckIN(HMS);
				window2.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		JButton btnCheckout = new JButton("Checkout", null);
		btnCheckout.setForeground(Color.WHITE);
		btnCheckout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckout.setBackground(new Color(51, 153, 204));
		btnCheckout.setBounds(10, 273, 187, 77);
		frame.getContentPane().add(btnCheckout);
		btnCheckout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 CheckOut window2 = new CheckOut(HMS);
					window2.frame.setVisible(true);
					frame.setVisible(false);
				
			}
		});
		
		JButton btnAllGuests = new JButton("All Guests", null);
		btnAllGuests.setForeground(Color.WHITE);
		btnAllGuests.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAllGuests.setBackground(new Color(51, 153, 204));
		btnAllGuests.setBounds(207, 361, 187, 77);
		frame.getContentPane().add(btnAllGuests);
		btnAllGuests.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 AllGuests window2 = new AllGuests(HMS);
					window2.frame.setVisible(true);
					frame.setVisible(false);
				
			}
		});
		
		JButton btnGuestReport = new JButton("Guest Report", null);
		btnGuestReport.setForeground(Color.WHITE);
		btnGuestReport.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnGuestReport.setBackground(new Color(51, 153, 204));
		btnGuestReport.setBounds(207, 185, 187, 77);
		frame.getContentPane().add(btnGuestReport);
		btnGuestReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Guest_Report window2 = new Guest_Report(HMS);
					window2.frmGuestReport.setVisible(true);
					frame.setVisible(false);
				
			}
		});
		
		JButton btnRoomReport = new JButton("Room Report", null);
		btnRoomReport.setForeground(Color.WHITE);
		btnRoomReport.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnRoomReport.setBackground(new Color(51, 153, 204));
		btnRoomReport.setBounds(207, 273, 187, 77);
		frame.getContentPane().add(btnRoomReport);
		btnRoomReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Room_Report window2 = new Room_Report(HMS);
					window2.frame.setVisible(true);
					frame.setVisible(false);
			}
		});
		
		JButton btnAllReservations = new JButton("All Reservations", null);
		btnAllReservations.setForeground(Color.WHITE);
		btnAllReservations.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAllReservations.setBackground(new Color(51, 153, 204));
		btnAllReservations.setBounds(404, 185, 187, 77);
		frame.getContentPane().add(btnAllReservations);
		btnAllReservations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 AllReservations window2 = new AllReservations(HMS);
					window2.frame.setVisible(true);
					frame.setVisible(false);
				
			}
		});
		
		JButton btnCancelBooking = new JButton("Cancel Booking", null);
		btnCancelBooking.setForeground(Color.WHITE);
		btnCancelBooking.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelBooking.setBackground(new Color(51, 153, 204));
		btnCancelBooking.setBounds(404, 273, 187, 77);
		btnCancelBooking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 CancelReservation window2 = new CancelReservation(HMS);
					window2.frame.setVisible(true);
					frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnCancelBooking);
		
		JButton btnBack = new JButton("Manage Rooms", null);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageRooms m=new ManageRooms(HMS);
				m.frmUpdateSalary.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBack.setBackground(new Color(51, 153, 204));
		btnBack.setBounds(404, 361, 187, 77);
		frame.getContentPane().add(btnBack);
		
		JLabel lblHotelManagmentSystem = new JLabel("Hotel Managment System");
		lblHotelManagmentSystem.setForeground(Color.WHITE);
		lblHotelManagmentSystem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 35));
		lblHotelManagmentSystem.setBounds(109, 36, 461, 59);
		frame.getContentPane().add(lblHotelManagmentSystem);
		
		
	}
}
