package receptionist;


//import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import businessLogic.GuestClass;
import businessLogic.Payment;
import businessLogic.Reservation;
import businessLogic.Room;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

public class Guest_Report implements ActionListener{
	ReceptionistController HMS;
	public JFrame frmGuestReport;
	private JTextField reserv;
	private JTextField name;
	private JTextField address;
	private JTextField passport;
	private JTextField gid;
	private JTextField nationality;
	private JTextField checko;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField advance;
	private JTextField textField_15;
	private JTextField type;
	private JTextField checkin;
	private JTextField textField_19;
	private JTextField beds;
	private JTextField floor;
	private JTextField stay;
	private JTextField textField_25;
	JButton btnSearch;
	 JButton btnPrint;

	/**
	 * Create the application.
	 */
	public Guest_Report(ReceptionistController h) {
		HMS=h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JButton btnClose;
	private void initialize() {
		frmGuestReport = new JFrame();
		frmGuestReport.getContentPane().setBackground(new Color(0, 102, 153));
		
		frmGuestReport.setTitle("Guest Report");
		frmGuestReport.setBounds(350, 70, 625, 585);
		frmGuestReport.setResizable(false);;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGuestReport.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblGuestInformation = new JLabel("Guest Information");
		lblGuestInformation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblGuestInformation.setForeground(Color.WHITE);
		
		lblGuestInformation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lblGuestInformation.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblGuestInformation = new GridBagConstraints();
		gbc_lblGuestInformation.anchor = GridBagConstraints.WEST;
		gbc_lblGuestInformation.gridwidth = 2;
		gbc_lblGuestInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuestInformation.gridx = 0;
		gbc_lblGuestInformation.gridy = 1;
		frmGuestReport.getContentPane().add(lblGuestInformation, gbc_lblGuestInformation);
		
		JLabel lblRoomInformation = new JLabel("Room Information");
		lblRoomInformation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblRoomInformation.setForeground(Color.WHITE);
		lblRoomInformation.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRoomInformation.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_lblRoomInformation = new GridBagConstraints();
		gbc_lblRoomInformation.anchor = GridBagConstraints.WEST;
		gbc_lblRoomInformation.gridwidth = 2;
		gbc_lblRoomInformation.insets = new Insets(0, 0, 5, 0);
		gbc_lblRoomInformation.gridx = 2;
		gbc_lblRoomInformation.gridy = 1;
		frmGuestReport.getContentPane().add(lblRoomInformation, gbc_lblRoomInformation);
		
		JLabel lblReservationNo = new JLabel("Reservation No");
		lblReservationNo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblReservationNo.setForeground(Color.WHITE);
		lblReservationNo.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblReservationNo = new GridBagConstraints();
		gbc_lblReservationNo.anchor = GridBagConstraints.EAST;
		gbc_lblReservationNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblReservationNo.gridx = 0;
		gbc_lblReservationNo.gridy = 2;
		frmGuestReport.getContentPane().add(lblReservationNo, gbc_lblReservationNo);
		
		reserv = new JTextField();
		GridBagConstraints gbc_reserv = new GridBagConstraints();
		gbc_reserv.insets = new Insets(0, 0, 5, 5);
		gbc_reserv.fill = GridBagConstraints.HORIZONTAL;
		gbc_reserv.gridx = 1;
		gbc_reserv.gridy = 2;
		frmGuestReport.getContentPane().add(reserv, gbc_reserv);
		reserv.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setForeground(Color.WHITE);
		lblRoomNumber.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		GridBagConstraints gbc_lblRoomNumber = new GridBagConstraints();
		gbc_lblRoomNumber.anchor = GridBagConstraints.EAST;
		gbc_lblRoomNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNumber.gridx = 2;
		gbc_lblRoomNumber.gridy = 2;
		frmGuestReport.getContentPane().add(lblRoomNumber, gbc_lblRoomNumber);
		
		textField_15 = new JTextField();
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.insets = new Insets(0, 0, 5, 0);
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.gridx = 3;
		gbc_textField_15.gridy = 2;
		frmGuestReport.getContentPane().add(textField_15, gbc_textField_15);
		textField_15.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblName.setForeground(Color.WHITE);
		lblName.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		frmGuestReport.getContentPane().add(lblName, gbc_lblName);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 1;
		gbc_name.gridy = 3;
		frmGuestReport.getContentPane().add(name, gbc_name);
		name.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setForeground(Color.WHITE);
		lblRoomType.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		GridBagConstraints gbc_lblRoomType = new GridBagConstraints();
		gbc_lblRoomType.anchor = GridBagConstraints.EAST;
		gbc_lblRoomType.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomType.gridx = 2;
		gbc_lblRoomType.gridy = 3;
		frmGuestReport.getContentPane().add(lblRoomType, gbc_lblRoomType);
		
		type = new JTextField();
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.insets = new Insets(0, 0, 5, 0);
		gbc_type.fill = GridBagConstraints.HORIZONTAL;
		gbc_type.gridx = 3;
		gbc_type.gridy = 3;
		frmGuestReport.getContentPane().add(type, gbc_type);
		type.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 4;
		frmGuestReport.getContentPane().add(lblAddress, gbc_lblAddress);
		
		address = new JTextField();
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.gridx = 1;
		gbc_address.gridy = 4;
		frmGuestReport.getContentPane().add(address, gbc_address);
		address.setColumns(10);
		
		JLabel lblNoOfBeds = new JLabel("No of Beds");
		lblNoOfBeds.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblNoOfBeds.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNoOfBeds = new GridBagConstraints();
		gbc_lblNoOfBeds.anchor = GridBagConstraints.EAST;
		gbc_lblNoOfBeds.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoOfBeds.gridx = 2;
		gbc_lblNoOfBeds.gridy = 4;
		frmGuestReport.getContentPane().add(lblNoOfBeds, gbc_lblNoOfBeds);
		
		beds = new JTextField();
		GridBagConstraints gbc_beds = new GridBagConstraints();
		gbc_beds.insets = new Insets(0, 0, 5, 0);
		gbc_beds.fill = GridBagConstraints.HORIZONTAL;
		gbc_beds.gridx = 3;
		gbc_beds.gridy = 4;
		frmGuestReport.getContentPane().add(beds, gbc_beds);
		beds.setColumns(10);
		
		JLabel lblPassportNo = new JLabel("Passport No");
		lblPassportNo.setForeground(Color.WHITE);
		lblPassportNo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPassportNo = new GridBagConstraints();
		gbc_lblPassportNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassportNo.anchor = GridBagConstraints.EAST;
		gbc_lblPassportNo.gridx = 0;
		gbc_lblPassportNo.gridy = 5;
		frmGuestReport.getContentPane().add(lblPassportNo, gbc_lblPassportNo);
		
		passport = new JTextField();
		GridBagConstraints gbc_passport = new GridBagConstraints();
		gbc_passport.insets = new Insets(0, 0, 5, 5);
		gbc_passport.fill = GridBagConstraints.HORIZONTAL;
		gbc_passport.gridx = 1;
		gbc_passport.gridy = 5;
		frmGuestReport.getContentPane().add(passport, gbc_passport);
		passport.setColumns(10);
		
		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setForeground(Color.WHITE);
		lblFloor.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		GridBagConstraints gbc_lblFloor = new GridBagConstraints();
		gbc_lblFloor.anchor = GridBagConstraints.EAST;
		gbc_lblFloor.insets = new Insets(0, 0, 5, 5);
		gbc_lblFloor.gridx = 2;
		gbc_lblFloor.gridy = 5;
		frmGuestReport.getContentPane().add(lblFloor, gbc_lblFloor);
		
		floor = new JTextField();
		GridBagConstraints gbc_floor = new GridBagConstraints();
		gbc_floor.insets = new Insets(0, 0, 5, 0);
		gbc_floor.fill = GridBagConstraints.HORIZONTAL;
		gbc_floor.gridx = 3;
		gbc_floor.gridy = 5;
		frmGuestReport.getContentPane().add(floor, gbc_floor);
		floor.setColumns(10);
		
		JLabel lblCnic = new JLabel("ID");
		lblCnic.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblCnic.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCnic = new GridBagConstraints();
		gbc_lblCnic.anchor = GridBagConstraints.EAST;
		gbc_lblCnic.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnic.gridx = 0;
		gbc_lblCnic.gridy = 6;
		frmGuestReport.getContentPane().add(lblCnic, gbc_lblCnic);
		
		gid = new JTextField();
		GridBagConstraints gbc_gid = new GridBagConstraints();
		gbc_gid.insets = new Insets(0, 0, 5, 5);
		gbc_gid.fill = GridBagConstraints.HORIZONTAL;
		gbc_gid.gridx = 1;
		gbc_gid.gridy = 6;
		frmGuestReport.getContentPane().add(gid, gbc_gid);
		gid.setColumns(10);
		
		JLabel lblDurationOfStay = new JLabel("Duration of Stay");
		lblDurationOfStay.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDurationOfStay.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDurationOfStay = new GridBagConstraints();
		gbc_lblDurationOfStay.anchor = GridBagConstraints.EAST;
		gbc_lblDurationOfStay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDurationOfStay.gridx = 2;
		gbc_lblDurationOfStay.gridy = 6;
		frmGuestReport.getContentPane().add(lblDurationOfStay, gbc_lblDurationOfStay);
		
		stay = new JTextField();
		GridBagConstraints gbc_stay = new GridBagConstraints();
		gbc_stay.insets = new Insets(0, 0, 5, 0);
		gbc_stay.fill = GridBagConstraints.HORIZONTAL;
		gbc_stay.gridx = 3;
		gbc_stay.gridy = 6;
		frmGuestReport.getContentPane().add(stay, gbc_stay);
		stay.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setForeground(Color.WHITE);
		lblNationality.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNationality = new GridBagConstraints();
		gbc_lblNationality.insets = new Insets(0, 0, 5, 5);
		gbc_lblNationality.anchor = GridBagConstraints.EAST;
		gbc_lblNationality.gridx = 0;
		gbc_lblNationality.gridy = 7;
		frmGuestReport.getContentPane().add(lblNationality, gbc_lblNationality);
		
		nationality = new JTextField();
		GridBagConstraints gbc_nationality = new GridBagConstraints();
		gbc_nationality.insets = new Insets(0, 0, 5, 5);
		gbc_nationality.fill = GridBagConstraints.HORIZONTAL;
		gbc_nationality.gridx = 1;
		gbc_nationality.gridy = 7;
		frmGuestReport.getContentPane().add(nationality, gbc_nationality);
		nationality.setColumns(10);
		
		JLabel lblVisitNumber = new JLabel("Visit Number");
		lblVisitNumber.setForeground(Color.WHITE);
		lblVisitNumber.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		GridBagConstraints gbc_lblVisitNumber = new GridBagConstraints();
		gbc_lblVisitNumber.anchor = GridBagConstraints.EAST;
		gbc_lblVisitNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitNumber.gridx = 2;
		gbc_lblVisitNumber.gridy = 7;
		frmGuestReport.getContentPane().add(lblVisitNumber, gbc_lblVisitNumber);
		
		textField_25 = new JTextField();
		GridBagConstraints gbc_textField_25 = new GridBagConstraints();
		gbc_textField_25.insets = new Insets(0, 0, 5, 0);
		gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_25.gridx = 3;
		gbc_textField_25.gridy = 7;
		frmGuestReport.getContentPane().add(textField_25, gbc_textField_25);
		textField_25.setColumns(10);
		
		JLabel lblMiscellenousDatails = new JLabel("Miscellaneous Details");
		lblMiscellenousDatails.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		lblMiscellenousDatails.setForeground(Color.WHITE);
		
		lblMiscellenousDatails.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		GridBagConstraints gbc_lblMiscellenousDatails = new GridBagConstraints();
		gbc_lblMiscellenousDatails.anchor = GridBagConstraints.WEST;
		gbc_lblMiscellenousDatails.gridwidth = 2;
		gbc_lblMiscellenousDatails.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiscellenousDatails.gridx = 0;
		gbc_lblMiscellenousDatails.gridy = 9;
		frmGuestReport.getContentPane().add(lblMiscellenousDatails, gbc_lblMiscellenousDatails);
		
		JLabel lblCheckoutDate = new JLabel("CheckOut Date");
		lblCheckoutDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblCheckoutDate.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCheckoutDate = new GridBagConstraints();
		gbc_lblCheckoutDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckoutDate.anchor = GridBagConstraints.EAST;
		gbc_lblCheckoutDate.gridx = 0;
		gbc_lblCheckoutDate.gridy = 11;
		frmGuestReport.getContentPane().add(lblCheckoutDate, gbc_lblCheckoutDate);
		
		checko = new JTextField();
		GridBagConstraints gbc_checko = new GridBagConstraints();
		gbc_checko.insets = new Insets(0, 0, 5, 5);
		gbc_checko.fill = GridBagConstraints.HORIZONTAL;
		gbc_checko.gridx = 1;
		gbc_checko.gridy = 11;
		frmGuestReport.getContentPane().add(checko, gbc_checko);
		checko.setColumns(10);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblSubTotal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblSubTotal = new GridBagConstraints();
		gbc_lblSubTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubTotal.anchor = GridBagConstraints.EAST;
		gbc_lblSubTotal.gridx = 2;
		gbc_lblSubTotal.gridy = 11;
		frmGuestReport.getContentPane().add(lblSubTotal, gbc_lblSubTotal);
		
		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 3;
		gbc_textField_11.gridy = 11;
		frmGuestReport.getContentPane().add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		JLabel lblCheckinDate = new JLabel("CheckIn Date");
		lblCheckinDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblCheckinDate.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCheckinDate = new GridBagConstraints();
		gbc_lblCheckinDate.anchor = GridBagConstraints.EAST;
		gbc_lblCheckinDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckinDate.gridx = 0;
		gbc_lblCheckinDate.gridy = 12;
		frmGuestReport.getContentPane().add(lblCheckinDate, gbc_lblCheckinDate);
		
		checkin = new JTextField();
		GridBagConstraints gbc_checkin = new GridBagConstraints();
		gbc_checkin.insets = new Insets(0, 0, 5, 5);
		gbc_checkin.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkin.gridx = 1;
		gbc_checkin.gridy = 12;
		frmGuestReport.getContentPane().add(checkin, gbc_checkin);
		checkin.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount%");
		lblDiscount.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblDiscount.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiscount.anchor = GridBagConstraints.EAST;
		gbc_lblDiscount.gridx = 2;
		gbc_lblDiscount.gridy = 12;
		frmGuestReport.getContentPane().add(lblDiscount, gbc_lblDiscount);
		
		textField_12 = new JTextField();
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 3;
		gbc_textField_12.gridy = 12;
		frmGuestReport.getContentPane().add(textField_12, gbc_textField_12);
		textField_12.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblRate.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.anchor = GridBagConstraints.EAST;
		gbc_lblRate.gridx = 0;
		gbc_lblRate.gridy = 13;
		frmGuestReport.getContentPane().add(lblRate, gbc_lblRate);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 13;
		frmGuestReport.getContentPane().add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblGrandTotal = new JLabel("Grand Total");
		lblGrandTotal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblGrandTotal.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblGrandTotal = new GridBagConstraints();
		gbc_lblGrandTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrandTotal.anchor = GridBagConstraints.EAST;
		gbc_lblGrandTotal.gridx = 2;
		gbc_lblGrandTotal.gridy = 13;
		frmGuestReport.getContentPane().add(lblGrandTotal, gbc_lblGrandTotal);
		
		textField_13 = new JTextField();
		
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.insets = new Insets(0, 0, 5, 0);
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 3;
		gbc_textField_13.gridy = 13;
		frmGuestReport.getContentPane().add(textField_13, gbc_textField_13);
		textField_13.setColumns(10);
		
		JLabel lblTotalCharges = new JLabel("Total Charges");
		lblTotalCharges.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblTotalCharges.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTotalCharges = new GridBagConstraints();
		gbc_lblTotalCharges.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCharges.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCharges.gridx = 0;
		gbc_lblTotalCharges.gridy = 14;
		frmGuestReport.getContentPane().add(lblTotalCharges, gbc_lblTotalCharges);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 14;
		frmGuestReport.getContentPane().add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel lblAdvance = new JLabel("Advance");
		lblAdvance.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAdvance.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblAdvance = new GridBagConstraints();
		gbc_lblAdvance.anchor = GridBagConstraints.EAST;
		gbc_lblAdvance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdvance.gridx = 2;
		gbc_lblAdvance.gridy = 14;
		frmGuestReport.getContentPane().add(lblAdvance, gbc_lblAdvance);
		
		advance = new JTextField();
		GridBagConstraints gbc_advance = new GridBagConstraints();
		gbc_advance.insets = new Insets(0, 0, 5, 0);
		gbc_advance.fill = GridBagConstraints.HORIZONTAL;
		gbc_advance.gridx = 3;
		gbc_advance.gridy = 14;
		frmGuestReport.getContentPane().add(advance, gbc_advance);
		advance.setColumns(10);
		
		JLabel lblOtherCharges = new JLabel("Other Charges");
		lblOtherCharges.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblOtherCharges.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblOtherCharges = new GridBagConstraints();
		gbc_lblOtherCharges.anchor = GridBagConstraints.EAST;
		gbc_lblOtherCharges.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtherCharges.gridx = 0;
		gbc_lblOtherCharges.gridy = 15;
		frmGuestReport.getContentPane().add(lblOtherCharges, gbc_lblOtherCharges);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 15;
		frmGuestReport.getContentPane().add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblBalance.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblBalance = new GridBagConstraints();
		gbc_lblBalance.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalance.anchor = GridBagConstraints.EAST;
		gbc_lblBalance.gridx = 2;
		gbc_lblBalance.gridy = 15;
		frmGuestReport.getContentPane().add(lblBalance, gbc_lblBalance);
		
		textField_19 = new JTextField();
		GridBagConstraints gbc_textField_19 = new GridBagConstraints();
		gbc_textField_19.insets = new Insets(0, 0, 5, 0);
		gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_19.gridx = 3;
		gbc_textField_19.gridy = 15;
		frmGuestReport.getContentPane().add(textField_19, gbc_textField_19);
		textField_19.setColumns(10);
		 
		 JLabel label = new JLabel("");
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.insets = new Insets(0, 0, 5, 5);
		 gbc_label.gridx = 1;
		 gbc_label.gridy = 18;
		 frmGuestReport.getContentPane().add(label, gbc_label);
		 btnClose = new JButton("Close");
		 btnClose.setForeground(Color.WHITE);
		 btnClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnClose.setBackground(new Color(51, 153, 204));
		 btnClose.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 GridBagConstraints gbc_btnClose = new GridBagConstraints();
		 gbc_btnClose.insets = new Insets(0, 0, 5, 5);
		 gbc_btnClose.gridx = 0;
		 gbc_btnClose.gridy = 20;
		 frmGuestReport.getContentPane().add(btnClose, gbc_btnClose);
		 btnClose.addActionListener(this);
		 
		 JButton btnSave = new JButton("Save");
		 btnSave.setForeground(Color.WHITE);
		 btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnSave.setBackground(new Color(51, 153, 204));
		 btnSave.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 GridBagConstraints gbc_btnSave = new GridBagConstraints();
		 gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		 gbc_btnSave.gridx = 1;
		 gbc_btnSave.gridy = 20;
		 frmGuestReport.getContentPane().add(btnSave, gbc_btnSave);
		 
		 btnPrint = new JButton("Print");
		 btnPrint.setForeground(Color.WHITE);
		 btnPrint.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnPrint.setBackground(new Color(51, 153, 204));
		 btnPrint.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 GridBagConstraints gbc_btnPrint = new GridBagConstraints();
		 gbc_btnPrint.insets = new Insets(0, 0, 5, 5);
		 gbc_btnPrint.gridx = 2;
		 gbc_btnPrint.gridy = 20;
		 frmGuestReport.getContentPane().add(btnPrint, gbc_btnPrint);
		 
		 btnSearch = new JButton("Search");
		 btnSearch.setForeground(Color.WHITE);
		 btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		 btnSearch.setBackground(new Color(51, 153, 204));
		 btnSearch.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		 GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		 gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		 gbc_btnSearch.gridx = 3;
		 gbc_btnSearch.gridy = 20;
		 frmGuestReport.getContentPane().add(btnSearch, gbc_btnSearch);
		 btnSearch.addActionListener(this);
		 btnPrint.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnSearch){
			 int reservationID=Integer.parseInt(reserv.getText().toString());
			 Reservation r=HMS.returnReservation(reservationID);
			 textField_15.setText(""+r.getRoomID());
			 checko.setText(""+r.returncheckOut());
			 checkin.setText(""+r.returncheckIn());
			 stay.setText(""+r.returnStay());
			 advance.setText(""+r.returnAdvance());
			 GuestClass guest= HMS.guests.getGuest(r.getGuestID());
			 name.setText(guest.getName());
			 address.setText(guest.getAddress());
			 nationality.setText(guest.getNationality());
			 gid.setText(""+guest.getID());
			 passport.setText(guest.getcnic());
			 
			 Payment p=HMS.collection.returnPayment(r);
			 textField_9.setText(""+p.getCharges());
			 textField_8.setText(""+p.getRent());
			 textField_13.setText(""+(p.getTotal()));
			 textField_19.setText(""+(p.getTotal()-Integer.parseInt(advance.getText().toString())));
			 textField_11.setText(""+p.getCharges());
			 textField_10.setText("0000");
			 textField_12.setText("000");
			 textField_25.setText("001");
			 
			 Room room=HMS.rC.getRoom(r.getRoomID());
			 beds.setText(""+room.getNoOfBeds());
			 floor.setText(""+room.getFloor());
			 type.setText(room.getRoomType());
			 
		 }
	 if(e.getSource()==btnClose){
			 Receptionist window2 = new Receptionist(HMS);
			 window2.frame.setVisible(true);
			 frmGuestReport.setVisible(false);
		 }
	 if(e.getSource()==btnPrint){
		
	 }
		 
	 }

}
