package receptionist;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;


import java.awt.Font;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.awt.Color;


public class CheckIN implements ActionListener {
	ReceptionistController HMS;
	public JFrame frame;
	private JTextField nationality;
	private JTextField passport;
	private JTextField address;
	private JTextField name;
	private JTextField date1;
	private JTextField advance;
	JButton btnSearch_1;
	JLabel lblRoomNo;
	JButton btnCheckin;
	JButton btnBooking;
	JComboBox<String> comboBox_2, comboBox_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public CheckIN(ReceptionistController h) {
		HMS = h;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Check-In");
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(0, 102, 153));
		frame.setBounds(350, 70, 625, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JLabel lblGuestInformation = new JLabel("Guest Information");
		springLayout.putConstraint(SpringLayout.WEST, lblGuestInformation, 10, SpringLayout.WEST, frame.getContentPane());
		lblGuestInformation.setForeground(Color.WHITE);
		lblGuestInformation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frame.getContentPane().add(lblGuestInformation);

		JLabel lblName = new JLabel("Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblName, 184, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblGuestInformation, -6, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, lblName, 10, SpringLayout.WEST, frame.getContentPane());
		lblName.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblName.setForeground(Color.WHITE);
		frame.getContentPane().add(lblName);

		JLabel lblAddress = new JLabel("Address");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddress, 6, SpringLayout.SOUTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, lblAddress, 0, SpringLayout.WEST, lblGuestInformation);
		lblAddress.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAddress.setForeground(Color.WHITE);
		frame.getContentPane().add(lblAddress);

		JLabel lblCnic = new JLabel("Passport");
		springLayout.putConstraint(SpringLayout.NORTH, lblCnic, 6, SpringLayout.SOUTH, lblAddress);
		springLayout.putConstraint(SpringLayout.WEST, lblCnic, 0, SpringLayout.WEST, lblGuestInformation);
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frame.getContentPane().add(lblCnic);

		JLabel lblNationality = new JLabel("Nationality");
		springLayout.putConstraint(SpringLayout.NORTH, lblNationality, 4, SpringLayout.SOUTH, lblCnic);
		springLayout.putConstraint(SpringLayout.WEST, lblNationality, 0, SpringLayout.WEST, lblGuestInformation);
		lblNationality.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblNationality.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNationality);

		nationality = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, nationality, 6, SpringLayout.NORTH, lblNationality);
		springLayout.putConstraint(SpringLayout.WEST, nationality, 13, SpringLayout.EAST, lblNationality);
		springLayout.putConstraint(SpringLayout.EAST, nationality, -229, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(nationality);
		nationality.setColumns(10);
		nationality.addActionListener(this);
		passport = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, passport, 6, SpringLayout.NORTH, lblCnic);
		springLayout.putConstraint(SpringLayout.WEST, passport, 0, SpringLayout.WEST, nationality);
		springLayout.putConstraint(SpringLayout.EAST, passport, -229, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(passport);
		passport.setColumns(10);
		passport.addActionListener(this);
		address = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, address, 6, SpringLayout.NORTH, lblAddress);
		springLayout.putConstraint(SpringLayout.WEST, address, 0, SpringLayout.WEST, nationality);
		springLayout.putConstraint(SpringLayout.EAST, address, -229, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(address);
		address.setColumns(10);
		address.addActionListener(this);
		name = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, name, 6, SpringLayout.NORTH, lblName);
		springLayout.putConstraint(SpringLayout.WEST, name, 50, SpringLayout.EAST, lblName);
		springLayout.putConstraint(SpringLayout.EAST, name, -229, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(name);
		name.setColumns(10);
		name.addActionListener(this);
		JLabel lblCheckinInformation = new JLabel("Check-In Information");
		springLayout.putConstraint(SpringLayout.WEST, lblCheckinInformation, 0, SpringLayout.WEST, lblGuestInformation);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCheckinInformation, -118, SpringLayout.SOUTH, frame.getContentPane());
		lblCheckinInformation.setForeground(Color.WHITE);
		lblCheckinInformation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frame.getContentPane().add(lblCheckinInformation);

		JLabel lblCheckinDate = new JLabel("Date");
		springLayout.putConstraint(SpringLayout.NORTH, lblCheckinDate, 453, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCheckinDate, 0, SpringLayout.WEST, lblGuestInformation);
		lblCheckinDate.setForeground(Color.WHITE);
		lblCheckinDate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frame.getContentPane().add(lblCheckinDate);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		date1 = new JTextField(dateFormat.format(cal.getTime()));
		springLayout.putConstraint(SpringLayout.NORTH, date1, 459, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, date1, 0, SpringLayout.WEST, nationality);
		springLayout.putConstraint(SpringLayout.EAST, date1, 0, SpringLayout.EAST, nationality);
		frame.getContentPane().add(date1);
		date1.setColumns(10);
		date1.addActionListener(this);
		advance = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, advance, 0, SpringLayout.WEST, nationality);
		springLayout.putConstraint(SpringLayout.SOUTH, advance, -33, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, advance, 0, SpringLayout.EAST, nationality);
		frame.getContentPane().add(advance);
		advance.setColumns(10);
		advance.addActionListener(this);
		btnCheckin = new JButton("Book Room");
		springLayout.putConstraint(SpringLayout.EAST, btnCheckin, -26, SpringLayout.EAST, frame.getContentPane());
		btnCheckin.setForeground(Color.WHITE);
		btnCheckin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCheckin.setBackground(new Color(51, 153, 204));
		frame.getContentPane().add(btnCheckin);
		btnCheckin.addActionListener(this);
		btnBooking = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheckin, -6, SpringLayout.NORTH, btnBooking);
		springLayout.putConstraint(SpringLayout.WEST, btnBooking, 72, SpringLayout.EAST, date1);
		springLayout.putConstraint(SpringLayout.EAST, btnBooking, -26, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCheckin, 0, SpringLayout.WEST, btnBooking);
		springLayout.putConstraint(SpringLayout.NORTH, btnBooking, 470, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBooking, 0, SpringLayout.SOUTH, advance);
		btnBooking.setForeground(Color.WHITE);
		btnBooking.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnBooking.setBackground(new Color(51, 153, 204));
		frame.getContentPane().add(btnBooking);
		btnBooking.addActionListener(this);

		
		JLayeredPane layeredPane = new JLayeredPane();
		springLayout.putConstraint(SpringLayout.EAST, layeredPane, -268, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, layeredPane, 30, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(layeredPane);

		btnSearch_1 = new JButton("Search");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearch_1, -131, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnCheckin, 6, SpringLayout.SOUTH, btnSearch_1);
		springLayout.putConstraint(SpringLayout.WEST, btnSearch_1, 0, SpringLayout.WEST, btnCheckin);
		springLayout.putConstraint(SpringLayout.EAST, btnSearch_1, 0, SpringLayout.EAST, btnCheckin);
		btnSearch_1.setForeground(Color.WHITE);
		btnSearch_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnSearch_1.setBackground(new Color(51, 153, 204));
		frame.getContentPane().add(btnSearch_1);
		btnSearch_1.addActionListener(this);
		JLabel lblNoOfBeds = new JLabel("No Of Beds");
		lblNoOfBeds.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		lblNoOfBeds.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNoOfBeds);
		JLabel lblRoomType = new JLabel("Room Type");
		springLayout.putConstraint(SpringLayout.WEST, lblRoomType, 0, SpringLayout.WEST, lblGuestInformation);
		springLayout.putConstraint(SpringLayout.SOUTH, lblRoomType, -6, SpringLayout.NORTH, lblGuestInformation);
		lblRoomType.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		lblRoomType.setForeground(Color.WHITE);
		frame.getContentPane().add(lblRoomType);

		comboBox_1 = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 22, SpringLayout.EAST, lblRoomType);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_1, -6, SpringLayout.NORTH, lblGuestInformation);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, 0, SpringLayout.EAST, nationality);
		comboBox_1.setBackground(new Color(51, 153, 204));
		comboBox_1.addItem("Premium");
		comboBox_1.addItem("Standard");
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(this);

		lblRoomNo = new JLabel("Room No: N/A");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearch_1, 240, SpringLayout.SOUTH, lblRoomNo);
		springLayout.putConstraint(SpringLayout.NORTH, lblRoomNo, 93, SpringLayout.NORTH, frame.getContentPane());
		lblRoomNo.setForeground(Color.WHITE);
		lblRoomNo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frame.getContentPane().add(lblRoomNo);
		JLabel lblAdvance = new JLabel("Advance");
		springLayout.putConstraint(SpringLayout.NORTH, lblAdvance, -6, SpringLayout.NORTH, advance);
		springLayout.putConstraint(SpringLayout.WEST, lblAdvance, 0, SpringLayout.WEST, lblGuestInformation);
		lblAdvance.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblAdvance.setForeground(Color.WHITE);
		frame.getContentPane().add(lblAdvance);
		comboBox_2 = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.WEST, lblRoomNo, 27, SpringLayout.EAST, comboBox_2);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2, 109, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2, -226, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNoOfBeds, -20, SpringLayout.WEST, comboBox_2);
		comboBox_2.setBackground(new Color(51, 153, 204));
		comboBox_2.addItem("1");
		comboBox_2.addItem("2");
		comboBox_2.addItem("3");
		comboBox_2.addItem("4");
		comboBox_2.addItem("5");
		comboBox_2.addItem("6");
		comboBox_2.addActionListener(this);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblRoomInformation = new JLabel("Room Information");
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2, 17, SpringLayout.SOUTH, lblRoomInformation);
		springLayout.putConstraint(SpringLayout.NORTH, lblNoOfBeds, 17, SpringLayout.SOUTH, lblRoomInformation);
		springLayout.putConstraint(SpringLayout.NORTH, lblRoomInformation, 27, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblRoomInformation, 10, SpringLayout.WEST, frame.getContentPane());
		lblRoomInformation.setForeground(Color.WHITE);
		lblRoomInformation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 25));
		frame.getContentPane().add(lblRoomInformation);
		
		JLabel lblNoOf = new JLabel("Adults");
		springLayout.putConstraint(SpringLayout.NORTH, lblNoOf, 6, SpringLayout.SOUTH, lblNationality);
		springLayout.putConstraint(SpringLayout.WEST, lblNoOf, 0, SpringLayout.WEST, lblGuestInformation);
		lblNoOf.setForeground(Color.WHITE);
		lblNoOf.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		frame.getContentPane().add(lblNoOf);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.NORTH, lblNoOf);
		springLayout.putConstraint(SpringLayout.WEST, textField, 48, SpringLayout.EAST, lblNoOf);
		springLayout.putConstraint(SpringLayout.EAST, textField, -229, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblInfants = new JLabel("Infants");
		springLayout.putConstraint(SpringLayout.NORTH, lblInfants, 6, SpringLayout.SOUTH, lblNoOf);
		springLayout.putConstraint(SpringLayout.WEST, lblInfants, 0, SpringLayout.WEST, lblGuestInformation);
		lblInfants.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		lblInfants.setForeground(Color.WHITE);
		frame.getContentPane().add(lblInfants);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.NORTH, lblInfants);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, nationality);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, nationality);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

	}

	public void actionPerformed(ActionEvent e) {
		int rid = 0;
		if (e.getSource() == btnBooking) {
			Receptionist window2 = new Receptionist(HMS);
			window2.frame.setVisible(true);
			frame.setVisible(false);
		} else if (e.getSource() == btnSearch_1) {
			int beds = Integer
					.parseInt(comboBox_2.getSelectedItem().toString());
			rid = HMS.findRoom(beds, comboBox_1.getSelectedItem().toString());
			//System.out.println(beds + "" + rid);
			if(rid!=0)
			lblRoomNo.setText("Room No: " + rid);
			else
				lblRoomNo.setText("Room No: N/A ");
		}

		if (e.getSource() == btnCheckin) {
			String checkin =date1.getText();
			int advancearg = Integer.parseInt(advance.getText());
			int beds = Integer
					.parseInt(comboBox_2.getSelectedItem().toString());
			rid = HMS.findRoom(beds, comboBox_1.getSelectedItem().toString());
			int s=(HMS.addGuest(
					passport.getText(), name.getText(),
					nationality.getText(), address.getText())).getID();
			int idnum=(HMS.reserveRoom(rid, s, checkin,advancearg)).getID();
			JOptionPane.showMessageDialog(frame, "Reservation Successful!"
			+ "Reservation ID is " +idnum+" ,"
			+ "Guest ID is "+s+" ,"
			+ "Room ID is "+rid+" .");
			Receptionist window2 = new Receptionist(HMS);
			window2.frame.setVisible(true);
			frame.setVisible(false);
		}

	}
}
