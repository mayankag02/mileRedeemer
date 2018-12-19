/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Mayank Agarwal (Z1828333)                   *  
 *                                                          *
 *  Date Due:   11/28/2018                                  *                          
 *                                                          *
 *  Purpose:   This is a MileRedemptionGUI class for        *
 *  		   Assignment 8                                 *
 *                                                          *
 *                                                          *
 ***********************************************************/

package assignment8;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MileRedemptionGUI extends JFrame {

	private final GridBagLayout layout;
	private final GridBagConstraints constraints;

	private final JList<String> jList;
	private final JButton jButton;
	private final JTextArea jTextArea;
	private final JScrollPane scrollPane;
	private JFileChooser jFileChooser;
	private final JSpinner jSpinner;

	private final JLabel jLabel1;
	private final JLabel jLabel2;
	private final JLabel jLabel3;
	private final JLabel jLabel4;
	private final JLabel jLabel5;
	private final JLabel jLabel6;
	private final JLabel jLabel7;

	private final JTextField jTextField1;
	private final JTextField jTextField2;
	private final JTextField jTextField3;
	private final JTextField jTextField4;
	private final JTextField jTextField5;
	private final JTextField jTextField6;

	MileRedeemer mileRedeemer = new MileRedeemer();

	/**
	 * Constructor
	 * 
	 * @throws IOException
	 */
	public MileRedemptionGUI() throws IOException {
		super("Mile Redemption App"); // Title for the GUI app

		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		
		// Colors for jList and jLabels
		Color seaGreen = new Color(46,139,87); 	
		Color seaBlue = new Color(0, 105, 148);
		
		// code to implement titled border
		Border blackLine;
		blackLine = BorderFactory.createLineBorder(Color.black);

		TitledBorder leftTitle;
		leftTitle = BorderFactory.createTitledBorder(blackLine, "Destinations");
		leftTitle.setTitleJustification(TitledBorder.CENTER);

		TitledBorder rightTitle;
		rightTitle = BorderFactory.createTitledBorder(blackLine, "Redeem Miles");
		rightTitle.setTitleJustification(TitledBorder.CENTER);

		String fileName = getFileName(); // using JFileChooser
		//fileName = JOptionPane.showInputDialog("Please enter the name of the .txt file: ");
		
		Scanner fileScan = new Scanner(new File(fileName));

		mileRedeemer.readDestination(fileScan);
		
		String[] cityNames = mileRedeemer.getCityNames(); //return unsorted list to match the order with the .txt file

		jList = new JList<String>(cityNames);
		jList.setVisibleRowCount(10);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setBackground(seaGreen);
		jList.setBorder(leftTitle);
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jList, 0, 0, 2, 4);

		jLabel1 = new JLabel("Normal Miles ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel1.setBackground(seaGreen);
		jLabel1.setOpaque(true); // if set true then only the color is painted
		addComponent(jLabel1, 4, 0, 1, 1);

		jLabel2 = new JLabel("Supersaver Miles ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel2.setBackground(seaGreen);
		jLabel2.setOpaque(true);
		addComponent(jLabel2, 5, 0, 1, 1);

		jLabel3 = new JLabel("Upgrade Cost ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel3.setBackground(seaGreen);
		jLabel3.setOpaque(true);
		addComponent(jLabel3, 6, 0, 1, 1);

		jLabel4 = new JLabel("Supersaver Dates ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel4.setBackground(seaGreen);
		jLabel4.setOpaque(true);
		addComponent(jLabel4, 7, 0, 1, 1);

		jLabel5 = new JLabel("Enter your miles ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel5.setBackground(seaBlue);
		jLabel5.setOpaque(true);
		jLabel5.setBorder(rightTitle);
		addComponent(jLabel5, 0, 2, 1, 1);

		jLabel6 = new JLabel("Select the month of departure ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel6.setBackground(seaBlue);
		jLabel6.setOpaque(true);
		addComponent(jLabel6, 1, 2, 1, 1);

		jLabel7 = new JLabel("Your remaining miles ");
		constraints.fill = GridBagConstraints.BOTH;
		jLabel7.setBackground(seaBlue);
		jLabel7.setOpaque(true);
		addComponent(jLabel7, 7, 2, 1, 1);

		jTextField1 = new JTextField(15); // 15 is the random number to set the column size
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jTextField1, 4, 1, 1, 1);
		jTextField1.setEditable(false); // all the output fields are set editable as false
		
		jTextField2 = new JTextField(15);
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jTextField2, 5, 1, 1, 1);
		jTextField2.setEditable(false);

		jTextField3 = new JTextField(15);
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jTextField3, 6, 1, 1, 1);
		jTextField3.setEditable(false);

		jTextField4 = new JTextField(15);
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jTextField4, 7, 1, 1, 1);
		jTextField4.setEditable(false);

		jTextField5 = new JTextField(15);
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jTextField5, 0, 3, 1, 1);
		jTextField5.setToolTipText("Please enter the miles in integer format");

		jTextField6 = new JTextField(15);
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jTextField6, 7, 3, 1, 1);
		jTextField6.setEditable(false);

		String[] monthStrings = getMonthStrings();
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		jSpinner = new JSpinner(monthModel);
		addComponent(jSpinner, 1, 3, 1, 1);

		jButton = new JButton("Redeem Miles");
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(jButton, 2, 2, 2, 1);

		ButtonHandler buttonHandler = new ButtonHandler(); // to handle operation on click of button
		jButton.addActionListener(buttonHandler);

		jTextArea = new JTextArea();
		scrollPane = new JScrollPane(jTextArea); // to have a vertical scroll bar if we have a million record
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(scrollPane, 3, 2, 2, 4);
		
		jTextArea.setEditable(false);
		jTextArea.setBorder(blackLine);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true); // to wrap at word boundaries
		
		jList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				int selectedCityIndex = jList.getSelectedIndex();
				Destination destination = mileRedeemer.findDestination(selectedCityIndex);

				jTextField1.setText(Integer.toString(destination.getNormalMilesRequired()));
				jTextField2.setText(Integer.toString(destination.getFrequentFlyerMilesRequired()));
				jTextField3.setText(Integer.toString(destination.getAdditionalMilesForUpgrading()));

				int startMonth = destination.getStartMonth();
				String startMonthName = getMonthName(startMonth);

				int endMonth = destination.getEndMonth();
				String endMonthName = getMonthName(endMonth);

				jTextField4.setText(startMonthName + " - " + endMonthName);
			}
		});
	}
	
	/**
	 * Function to let user choose a file from system's file folder
	 * 
	 * @return String
	 */
	public String getFileName() {
		
		jFileChooser = new JFileChooser();
		
		jFileChooser.setDialogTitle("Please select the .txt file");
		int result = jFileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.CANCEL_OPTION) {
			System.exit(1);
		}
		
		String fileName = jFileChooser.getSelectedFile().getPath();
		return fileName;
	}

	/**
	 * ButtonHandler method to get miles value from jTextField and months value from
	 * jSpinner to perform redeemMiles function on click of jButton and output
	 * description of tickets in textArea and remaining miles in textField.
	 * 
	 * @author Mayank
	 *
	 */
	private class ButtonHandler implements ActionListener {
		boolean validMiles;
		String inputMiles;
		@Override
		public void actionPerformed(ActionEvent event) {

			inputMiles = jTextField5.getText();
			/*validMiles = MileRedemptionValidator.validateInputMiles(inputMiles);

			while (validMiles == false) {
				Timer t = new Timer (500, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						inputMiles = jTextField5.getText();
						validMiles = MileRedemptionValidator.validateInputMiles(inputMiles);
					}	
				});
				if (validMiles == false) {
				JOptionPane.showMessageDialog(jTextField5, "Please enter the miles in correct format!", 
						"Error", JOptionPane.ERROR_MESSAGE);
				jTextField5.setText(null);
				t.setRepeats(false);
				t.start();
			}
		}*/
			int miles = Integer.parseInt(inputMiles);
			
			String monthName = jSpinner.getValue().toString(); // to convert object to string
			int month = getMonthNumber(monthName);

			String[] redeemableTickets = mileRedeemer.redeemMiles(miles, month);

			if (redeemableTickets.length == 0) {
				jTextArea.setText("Your client has not accumulated enough Frequent Flyer Miles!");
			}

			else {
				jTextArea.setText(
						"Your client's Frequent Flyer Miles can be used to redeem the following tickets: \n\n");

				for (int j = 0; j < redeemableTickets.length; j++) {
					jTextArea.append(redeemableTickets[j] + "\n");
				}
			}
			jTextField6.setText(Integer.toString(mileRedeemer.getRemainingMiles()));
		}
	}

	/**
	 * Function to convert number month to name month to populate the value in
	 * jTextField
	 * 
	 * @param int month
	 * @return String of name month's
	 */
	public String getMonthName(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}

	/**
	 * Function to convert name month to number month from jSpinner and pass it to
	 * redeemMiles function
	 * 
	 * @param monthName
	 * @return int of number month
	 */
	private int getMonthNumber(String monthName) {
		return Month.valueOf(monthName.toUpperCase()).getValue();
	}

	/**
	 * Function to set the names of the months in jSpinner component
	 * 
	 * @return String[] months
	 */
	protected String[] getMonthStrings() {
		String[] months = new DateFormatSymbols().getMonths();
		int lastIndex = months.length - 1;
		if (months[lastIndex] == null || months[lastIndex].length() <= 0) {
			String[] monthStrings = new String[lastIndex];
			System.arraycopy(months, 0, monthStrings, 0, lastIndex);
			return monthStrings;
		} else {
			return months;
		}
	}

	/**
	 * Function to add the components in the GridBag Layout according to the params
	 * 
	 * @param component
	 * @param row
	 * @param column
	 * @param width
	 * @param height
	 */
	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;

		layout.setConstraints(component, constraints);
		add(component);
	}
}