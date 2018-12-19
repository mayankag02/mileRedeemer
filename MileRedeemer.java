/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Mayank Agarwal (Z1828333)                   *  
 *                                                          *
 *  Date Due:   11/28/2018                                  *                          
 *                                                          *
 *  Purpose:   This is a MileRedeemer class for             *
 *  		   Assignment 8                                 *
 *                                                          *
 *                                                          *
 ***********************************************************/

package assignment8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MileRedeemer {

	// creation of Array of Destination objects to add all the destinations listed
	// in the text file
	ArrayList<Destination> destinationList = new ArrayList<Destination>();
	Destination[] destinationArray; // declaration

	private int remainingMiles;

	/**
	 * This method uses the Scanner object to read and parse the destination data
	 * into an ArrayList of Destination objects
	 * 
	 * @param fileScan
	 * @throws IOException
	 */
	public void readDestination(Scanner fileScan) throws IOException {

		String record;
		while (fileScan.hasNext()) {
			record = fileScan.nextLine();

			String[] initialList = record.split("[;-]");

			Destination destinations = new Destination();

			// use of setter methods of Destination class to set the values from the
			// destination data
			destinations.setNameOfTheDestinationCity(initialList[0]);
			destinations.setNormalMilesRequired(Integer.parseInt(initialList[1]));
			destinations.setFrequentFlyerMilesRequired(Integer.parseInt(initialList[2]));
			destinations.setAdditionalMilesForUpgrading(Integer.parseInt(initialList[3]));
			destinations.setStartMonth(Integer.parseInt(initialList[4]));
			destinations.setEndMonth(Integer.parseInt(initialList[5]));

			destinationList.add(destinations);
		}

		// ArrayList of Destination objects is converted to normal array of destination
		// objects for sorting

		//destinationArray = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);

		  destinationArray = new Destination[destinationList.size()]; //definition
		  destinationList.toArray(destinationArray); //populating
		 
		// sorting the array of Destination objects in descending order by normal
		// mileage using MileageComparator inner class
		MileageComparator comparator = new MileageComparator();

		Arrays.sort(destinationArray, comparator);

	}

	/**
	 * This method loops through the array of Destination objects and creates an
	 * array of String objects from the city names. Sorts the array in ascending
	 * order and return an array of Strings
	 * 
	 * @return Array of String objects
	 */
	public String[] getCityNames() {

		String[] cityNames = new String[destinationList.size()];
		ArrayList<String> destinations = new ArrayList<>();

		for (int i = 0; i < destinationList.size(); i++) {
			destinations.add(destinationList.get(i).getNameOfTheDestinationCity());
		}

		// to convert ArrayList of String objects to normal array of strings
		cityNames = destinations.toArray(cityNames);

		/* Arrays.sort(cityNames); */ // sorting the array of strings in ascending order
		return cityNames;
	}

	/**
	 * This method sorts the ArrayList of destination objects to normal array of
	 * destination objects by descending order of normal miles. Implements the major
	 * algorithm to redeem miles based on the miles and month and creates a list of
	 * eligible cities
	 * 
	 * @param miles
	 * @param month
	 * @return Array of Strings objects containing descriptions of redeemed tickets
	 */
	public String[] redeemMiles(int miles, int month) {

		ArrayList<String> eligibleCitiesList = new ArrayList<>();

		// iterates to create an eligible list of cities based on the miles and month
		// input
		for (int i = 0; i < destinationArray.length; i++) {

			// implementation to check frequent flyer miles when input month lies in between
			// frequent flyer months
			if (month >= destinationArray[i].getStartMonth() && month <= destinationArray[i].getEndMonth()) {
				if (miles >= destinationArray[i].getFrequentFlyerMilesRequired()) {
					miles = miles - destinationArray[i].getFrequentFlyerMilesRequired();
					eligibleCitiesList.add(destinationArray[i].getNameOfTheDestinationCity());
				}
			}
			// implementation to check normal miles when input month doesn't lies in between
			// frequent flyer months
			else if (miles >= destinationArray[i].getNormalMilesRequired()) {
				miles = miles - destinationArray[i].getNormalMilesRequired();
				eligibleCitiesList.add(destinationArray[i].getNameOfTheDestinationCity());
			}
		}

		remainingMiles = miles;

		// Calls redeemedTicketDescription() method to return an array of strings which
		// gets returned to the driver class
		String[] redeemedTicketDescriptionForPrint = redeemedTicketDescription(destinationArray, eligibleCitiesList);
		return redeemedTicketDescriptionForPrint;
	}

	/**
	 * This is a sub method of redeemMiles() method which implements logic to check
	 * for if client has not accumulated enough Frequent Flyer Miles, check the
	 * remaining miles for upgrade and creates a string of redeemed ticket
	 * description to return
	 * 
	 * @param destinationArray
	 * @param eligibleCitiesList
	 * @return String[]
	 */
	public String[] redeemedTicketDescription(Destination[] destinationArray, ArrayList<String> eligibleCitiesList) {

		String[] redeemedTicketDescription = new String[eligibleCitiesList.size()];

		// implementation to check if client has not accumulated enough Frequent Flyer
		// Miles
		if (eligibleCitiesList.isEmpty()) {
			return redeemedTicketDescription;
		}

		// implementation to check the remaining miles for upgrade for any of the
		// destinations to which the customer is eligible
		else {
			for (int j = 0; j < eligibleCitiesList.size(); j++) {
				if (remainingMiles >= destinationArray[j].getAdditionalMilesForUpgrading()) {
					String ticketDescription = "* A trip to " + eligibleCitiesList.get(j) + " in First Class";
					redeemedTicketDescription[j] = ticketDescription;
					remainingMiles = remainingMiles - destinationArray[j].getAdditionalMilesForUpgrading();
				} else {
					String ticketDescription = "* A trip to " + eligibleCitiesList.get(j) + " in Economy Class";
					redeemedTicketDescription[j] = ticketDescription;
				}
			}
			return redeemedTicketDescription;
		}
	}

	/**
	 * This method returns remaining miles to the driver program
	 * 
	 * @return remainingMiles
	 */
	public int getRemainingMiles() {
		return remainingMiles;
	}

	/**
	 * This an inner class to implement the Comparator class and sort the
	 * destination objects in descending order of normal miles
	 * 
	 * @author Mayank
	 * @return the difference between two destination objects normal miles
	 */
	public class MileageComparator implements Comparator<Destination> {
		public int compare(Destination d1, Destination d2) {
			return (d2.getNormalMilesRequired() - d1.getNormalMilesRequired());
		}
	}

	/**
	 * Function to create a destination object for a selected city from the jList to
	 * populate corresponding values in the four jTextFields
	 * 
	 * @param selectedCityIndex
	 * @return Destination class object
	 */

	public Destination findDestination(int selectedCityIndex) {

		Destination destination = new Destination();
		int i = selectedCityIndex;

		destination.setNormalMilesRequired(destinationList.get(i).getNormalMilesRequired());
		destination.setFrequentFlyerMilesRequired(destinationList.get(i).getFrequentFlyerMilesRequired());
		destination.setAdditionalMilesForUpgrading(
				destinationList.get(selectedCityIndex).getAdditionalMilesForUpgrading());
		destination.setStartMonth(destinationList.get(i).getStartMonth());
		destination.setEndMonth(destinationList.get(i).getEndMonth());

		return destination;
	}
}