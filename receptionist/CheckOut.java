package receptionist;



import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import businessLogic.Payment;
import businessLogic.Reservation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckOut implements ActionListener{
	ReceptionistController HMS;
	public JFrame frame;
	private JTextField room;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField checko;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	JButton btnSearch ;
	/**
	 * Create the application.
	 */
	public CheckOut(ReceptionistController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnCancel;
	JButton btnCheckout;
	private JTextField reserve;
	private JTextField guest;
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 153));
		frame.setBounds(350, 70, 625, 585);
		frame.setResizable(false);;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("CheckOut");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblReservationId = new JLabel("Reservation ID");
		lblReservationId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblReservationId.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblReservationId = new GridBagConstraints();
		gbc_lblReservationId.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservationId.gridx = 1;
		gbc_lblReservationId.gridy = 2;
		frame.getContentPane().add(lblReservationId, gbc_lblReservationId);
		
		reserve = new JTextField();
		GridBagConstraints gbc_reserve = new GridBagConstraints();
		gbc_reserve.insets = new Insets(0, 0, 5, 5);
		gbc_reserve.fill = GridBagConstraints.HORIZONTAL;
		gbc_reserve.gridx = 3;
		gbc_reserve.gridy = 2;
		frame.getContentPane().add(reserve, gbc_reserve);
		reserve.setColumns(10);
		
		JLabel lblRoomRent = new JLabel("Room Rent");
		lblRoomRent.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblRoomRent.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblRoomRent = new GridBagConstraints();
		gbc_lblRoomRent.anchor = GridBagConstraints.EAST;
		gbc_lblRoomRent.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomRent.gridx = 4;
		gbc_lblRoomRent.gridy = 2;
		frame.getContentPane().add(lblRoomRent, gbc_lblRoomRent);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 5;
		gbc_textField_5.gridy = 2;
		frame.getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblRoomNo.setForeground(Color.WHITE);
		lblRoomNo.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblRoomNo = new GridBagConstraints();
		gbc_lblRoomNo.anchor = GridBagConstraints.EAST;
		gbc_lblRoomNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNo.gridx = 1;
		gbc_lblRoomNo.gridy = 4;
		frame.getContentPane().add(lblRoomNo, gbc_lblRoomNo);
		
		room = new JTextField();
		GridBagConstraints gbc_room = new GridBagConstraints();
		gbc_room.insets = new Insets(0, 0, 5, 5);
		gbc_room.fill = GridBagConstraints.HORIZONTAL;
		gbc_room.gridx = 3;
		gbc_room.gridy = 4;
		frame.getContentPane().add(room, gbc_room);
		room.setColumns(10);
		
		JLabel lblTotalCharges = new JLabel("Total Charges");
		lblTotalCharges.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblTotalCharges.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTotalCharges = new GridBagConstraints();
		gbc_lblTotalCharges.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCharges.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCharges.gridx = 4;
		gbc_lblTotalCharges.gridy = 4;
		frame.getContentPane().add(lblTotalCharges, gbc_lblTotalCharges);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 4;
		frame.getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGuestId = new JLabel("Guest ID");
		lblGuestId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblGuestId.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblGuestId = new GridBagConstraints();
		gbc_lblGuestId.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestId.gridx = 1;
		gbc_lblGuestId.gridy = 6;
		frame.getContentPane().add(lblGuestId, gbc_lblGuestId);
		
		guest = new JTextField();
		GridBagConstraints gbc_guest = new GridBagConstraints();
		gbc_guest.insets = new Insets(0, 0, 5, 5);
		gbc_guest.fill = GridBagConstraints.HORIZONTAL;
		gbc_guest.gridx = 3;
		gbc_guest.gridy = 6;
		frame.getContentPane().add(guest, gbc_guest);
		guest.setColumns(10);
		
		JLabel lblOtherCharges = new JLabel("Other Charges");
		lblOtherCharges.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblOtherCharges.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblOtherCharges = new GridBagConstraints();
		gbc_lblOtherCharges.anchor = GridBagConstraints.EAST;
		gbc_lblOtherCharges.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtherCharges.gridx = 4;
		gbc_lblOtherCharges.gridy = 6;
		frame.getContentPane().add(lblOtherCharges, gbc_lblOtherCharges);
		
		textField_7 = new JTextField();
		textField_7.setText("0");
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 5;
		gbc_textField_7.gridy = 6;
		frame.getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		 
		 JLabel lblGuestName = new JLabel("Guest Name");
		 lblGuestName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblGuestName.setForeground(Color.WHITE);
		 lblGuestName.setVerticalAlignment(SwingConstants.TOP);
		 GridBagConstraints gbc_lblGuestName = new GridBagConstraints();
		 gbc_lblGuestName.anchor = GridBagConstraints.EAST;
		 gbc_lblGuestName.insets = new Insets(0, 0, 5, 5);
		 gbc_lblGuestName.gridx = 1;
		 gbc_lblGuestName.gridy = 8;
		 frame.getContentPane().add(lblGuestName, gbc_lblGuestName);
		 
		 textField_1 = new JTextField();
		 GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		 gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_1.gridx = 3;
		 gbc_textField_1.gridy = 8;
		 frame.getContentPane().add(textField_1, gbc_textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel lblDiscount = new JLabel("Discount %");
		 lblDiscount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblDiscount.setForeground(Color.WHITE);
		 GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		 gbc_lblDiscount.anchor = GridBagConstraints.EAST;
		 gbc_lblDiscount.insets = new Insets(0, 0, 5, 5);
		 gbc_lblDiscount.gridx = 4;
		 gbc_lblDiscount.gridy = 8;
		 frame.getContentPane().add(lblDiscount, gbc_lblDiscount);
		 
		 textField_9 = new JTextField();
		 textField_9.setText("0");
		 GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		 gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_9.gridx = 5;
		 gbc_textField_9.gridy = 8;
		 frame.getContentPane().add(textField_9, gbc_textField_9);
		 textField_9.setColumns(10);
		 
		 JLabel lblTotal = new JLabel("Total");
		 lblTotal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblTotal.setForeground(Color.WHITE);
		 GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		 gbc_lblTotal.anchor = GridBagConstraints.EAST;
		 gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		 gbc_lblTotal.gridx = 4;
		 gbc_lblTotal.gridy = 10;
		 frame.getContentPane().add(lblTotal, gbc_lblTotal);
		 
		 textField_10 = new JTextField();
		 GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		 gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_10.gridx = 5;
		 gbc_textField_10.gridy = 10;
		 frame.getContentPane().add(textField_10, gbc_textField_10);
		 textField_10.setColumns(10);
		 
		 JLabel lblDurationOfStay = new JLabel("Duration Of Stay");
		 lblDurationOfStay.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblDurationOfStay.setForeground(Color.WHITE);
		 GridBagConstraints gbc_lblDurationOfStay = new GridBagConstraints();
		 gbc_lblDurationOfStay.anchor = GridBagConstraints.EAST;
		 gbc_lblDurationOfStay.insets = new Insets(0, 0, 5, 5);
		 gbc_lblDurationOfStay.gridx = 1;
		 gbc_lblDurationOfStay.gridy = 12;
		 frame.getContentPane().add(lblDurationOfStay, gbc_lblDurationOfStay);
		 
		 textField_4 = new JTextField();
		 GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		 gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_4.gridx = 3;
		 gbc_textField_4.gridy = 12;
		 frame.getContentPane().add(textField_4, gbc_textField_4);
		 textField_4.setColumns(10);
		 
		 JLabel lblAdvance = new JLabel("Advance");
		 lblAdvance.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblAdvance.setForeground(Color.WHITE);
		 GridBagConstraints gbc_lblAdvance = new GridBagConstraints();
		 gbc_lblAdvance.anchor = GridBagConstraints.EAST;
		 gbc_lblAdvance.insets = new Insets(0, 0, 5, 5);
		 gbc_lblAdvance.gridx = 4;
		 gbc_lblAdvance.gridy = 12;
		 frame.getContentPane().add(lblAdvance, gbc_lblAdvance);
		 
		 textField_11 = new JTextField();
		 GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		 gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_11.gridx = 5;
		 gbc_textField_11.gridy = 12;
		 frame.getContentPane().add(textField_11, gbc_textField_11);
		 textField_11.setColumns(10);
		 
		 JLabel lblCheckInDate = new JLabel("Check In Date");
		 lblCheckInDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblCheckInDate.setForeground(Color.WHITE);
		 lblCheckInDate.setVerticalAlignment(SwingConstants.TOP);
		 GridBagConstraints gbc_lblCheckInDate = new GridBagConstraints();
		 gbc_lblCheckInDate.anchor = GridBagConstraints.EAST;
		 gbc_lblCheckInDate.insets = new Insets(0, 0, 5, 5);
		 gbc_lblCheckInDate.gridx = 1;
		 gbc_lblCheckInDate.gridy = 14;
		 frame.getContentPane().add(lblCheckInDate, gbc_lblCheckInDate);
		 
		 textField_2 = new JTextField();
		 GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		 gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_2.gridx = 3;
		 gbc_textField_2.gridy = 14;
		 frame.getContentPane().add(textField_2, gbc_textField_2);
		 textField_2.setColumns(10);
		 
		 JLabel lblBalance = new JLabel("Balance");
		 lblBalance.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblBalance.setForeground(Color.WHITE);
		 GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		 gbc_lblBalance.anchor = GridBagConstraints.EAST;
		 gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		 gbc_lblBalance.gridx = 4;
		 gbc_lblBalance.gridy = 14;
		 frame.getContentPane().add(lblBalance, gbc_lblBalance);
		 
		 textField_12 = new JTextField();
		 GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		 gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_12.gridx = 5;
		 gbc_textField_12.gridy = 14;
		 frame.getContentPane().add(textField_12, gbc_textField_12);
		 textField_12.setColumns(10);
		 
		 JLabel lblCheckOutDate = new JLabel("Check Out Date");
		 lblCheckOutDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblCheckOutDate.setForeground(Color.WHITE);
		 lblCheckOutDate.setVerticalAlignment(SwingConstants.TOP);
		 GridBagConstraints gbc_lblCheckOutDate = new GridBagConstraints();
		 gbc_lblCheckOutDate.anchor = GridBagConstraints.EAST;
		 gbc_lblCheckOutDate.insets = new Insets(0, 0, 5, 5);
		 gbc_lblCheckOutDate.gridx = 1;
		 gbc_lblCheckOutDate.gridy = 16;
		 frame.getContentPane().add(lblCheckOutDate, gbc_lblCheckOutDate);
		 checko = new JTextField(dateFormat.format(cal.getTime()));
		 GridBagConstraints gbc_checko = new GridBagConstraints();
		 gbc_checko.insets = new Insets(0, 0, 5, 5);
		 gbc_checko.fill = GridBagConstraints.HORIZONTAL;
		 gbc_checko.gridx = 3;
		 gbc_checko.gridy = 16;
		 frame.getContentPane().add(checko, gbc_checko);
		 checko.setColumns(10);
		 
		 JLabel lblTaxes = new JLabel("Taxes");
		 lblTaxes.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		 lblTaxes.setForeground(Color.WHITE);
		 GridBagConstraints gbc_lblTaxes = new GridBagConstraints();
		 gbc_lblTaxes.anchor = GridBagConstraints.EAST;
		 gbc_lblTaxes.insets = new Insets(0, 0, 5, 5);
		 gbc_lblTaxes.gridx = 4;
		 gbc_lblTaxes.gridy = 16;
		 frame.getContentPane().add(lblTaxes, gbc_lblTaxes);
		 
		 textField_13 = new JTextField();
		 GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		 gbc_textField_13.insets = new Insets(0, 0, 5, 5);
		 gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		 gbc_textField_13.gridx = 5;
		 gbc_textField_13.gridy = 16;
		 frame.getContentPane().add(textField_13, gbc_textField_13);
		 textField_13.setColumns(10);
		
		 btnSearch = new JButton("Search");
		 btnSearch.setForeground(Color.WHITE);
		 btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnSearch.setBackground(new Color(51, 153, 204));
		 btnSearch.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		 gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		 gbc_btnSearch.gridx = 3;
		 gbc_btnSearch.gridy = 18;
		 frame.getContentPane().add(btnSearch, gbc_btnSearch);
		 btnSearch.addActionListener(this);
		btnCheckout = new JButton("CheckOut");
		btnCheckout.setForeground(Color.WHITE);
		btnCheckout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckout.setBackground(new Color(51, 153, 204));
		btnCheckout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckout.gridx = 4;
		gbc_btnCheckout.gridy = 18;
		frame.getContentPane().add(btnCheckout, gbc_btnCheckout);
		btnCheckout.addActionListener(this);
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(188, 143, 143));
		btnCancel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 18;
		frame.getContentPane().add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancel.setBackground(new Color(51, 153, 204));
	}
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource()==btnSearch){
			 int reservationID=Integer.parseInt(reserve.getText().toString());
			 String checkout=checko.getText().toString();
			 Reservation r=HMS.checkOut(reservationID, checkout);
			 room.setText(""+r.getRoomID());
			 guest.setText(""+r.getGuestID());
			 textField_2.setText(r.returncheckIn());
			 checko.setText(r.returncheckOut());
			 textField_11.setText(""+r.returnAdvance());
			 textField_4.setText(""+r.returnStay());
			 textField_1.setText(HMS.guestName(r.getGuestID()));
			 Payment p=HMS.makePayment(r,Integer.parseInt(textField_9.getText()));
			 textField_6.setText(""+p.getCharges());
			 textField_5.setText(""+p.getRent());
			 textField_10.setText(""+(p.getTotal()));
			 textField_12.setText(""+(p.getTotal()-Integer.parseInt(textField_11.getText().toString())));
			 textField_13.setText(""+p.getTax());
		 }
		  if(e.getSource()==btnCheckout){
			HMS.vacateRoom(Integer.parseInt(room.getText().toString()));
			 JOptionPane.showMessageDialog(frame,
						"CheckOut Successful");
			 Receptionist window2 = new Receptionist(HMS);
			 window2.frame.setVisible(true);
			frame.setVisible(false);
		 }
		  if(e.getSource()==btnCancel){
			 Receptionist window2 = new Receptionist(HMS);
			 window2.frame.setVisible(true);
			frame.setVisible(false);
		 }
		 
	 }

}
