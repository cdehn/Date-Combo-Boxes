import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class Midterm2 {

	private JFrame frame;
	private JComboBox pickMonth;
	private JComboBox pickDay;
	private JComboBox pickYear;
	private Date date = new Date();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Midterm2 window = new Midterm2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Midterm2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblMonth = new JLabel("Month");
		springLayout.putConstraint(SpringLayout.NORTH, lblMonth, 27, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMonth, 87, SpringLayout.WEST, frame.getContentPane());
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		springLayout.putConstraint(SpringLayout.WEST, lblDay, 87, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblMonth, -14, SpringLayout.NORTH, lblDay);
		springLayout.putConstraint(SpringLayout.NORTH, lblDay, 68, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDay, -136, SpringLayout.SOUTH, frame.getContentPane());
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		springLayout.putConstraint(SpringLayout.WEST, lblYear, 87, SpringLayout.WEST, frame.getContentPane());
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblYear);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date currentTime = calendar.getTime();
		calendar.setTime(date);		
		
		
		String [] months = {"January - 1 ", "February - 2", "March - 3", "April - 4", "May - 5", "June - 6 ", 
				"July - 7", "August - 8", "September - 9", "October - 10", "November - 11", "December - 12"};
		final JComboBox pickMonth = new JComboBox (months);
		springLayout.putConstraint(SpringLayout.EAST, lblMonth, -83, SpringLayout.WEST, pickMonth);
		springLayout.putConstraint(SpringLayout.WEST, pickMonth, -198, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, pickMonth, 32, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pickMonth, -80, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(pickMonth);
		int month = calendar.get(Calendar.MONTH);
		pickMonth.setSelectedIndex(month);
		
		
		final String [] days31 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26","27","28","29","30","31"};
		final String [] days30 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26","27","28","29","30"};
		final String [] days28 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
				"19","20","21","22","23","24","25","26","27","28"};
		
		final JComboBox pickDay = new JComboBox(days31);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		pickDay.setSelectedItem(Integer.toString(day));
		pickDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
	/*
		if(pickMonth.getSelectedItem().equals("February")){
	        pickDay = new JComboBox(days28);
		}	
		
	    else if(pickMonth.getSelectedItem().equals("April - 4")){
	        pickDay = new JComboBox(days30);
		}
		
	    else if(pickMonth.getSelectedItem().equals("June - 6")){
	    	pickDay = new JComboBox(days30);
		}
		
	    else if(pickMonth.getSelectedItem().equals("September - 9"))
	    	pickDay = new JComboBox(days30);
		
	    else if(pickMonth.getSelectedItem().equals("November - 11")){
	    	pickDay = new JComboBox(days30);
		}
		
		else{
	        pickDay = new JComboBox(days31);
		}*/
			}
		});
		
		springLayout.putConstraint(SpringLayout.EAST, lblDay, -140, SpringLayout.WEST, pickDay);
		springLayout.putConstraint(SpringLayout.NORTH, pickDay, 88, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, pickDay, 293, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pickDay, -80, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(pickDay);
		
		
		String [] years = {"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};
		JComboBox pickYear = new JComboBox (years);
		springLayout.putConstraint(SpringLayout.NORTH, pickYear, 154, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, pickYear, 258, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, pickYear, -80, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblYear, -1, SpringLayout.NORTH, pickYear);
		springLayout.putConstraint(SpringLayout.EAST, lblYear, -137, SpringLayout.WEST, pickYear);
		frame.getContentPane().add(pickYear);
		int year = calendar.get(Calendar.YEAR);
		pickYear.setSelectedItem(Integer.toString(year));
	}
}
