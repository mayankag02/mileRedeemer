/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Mayank Agarwal (Z1828333)                   *  
 *                                                          *
 *  Date Due:   11/28/2018                                  *                          
 *                                                          *
 *  Purpose:   This is a Destination class for              *
 *  		   Assignment 8                                 *
 *                                                          *
 *                                                          *
 ***********************************************************/

package assignment8;

public class Destination {
	
	// Six private instance variables 
	private String nameOfTheDestinationCity;
	private int normalMilesRequired;
	private int frequentFlyerMilesRequired;
	private int additionalMilesForUpgrading;
	private int startMonth;
	private int endMonth;
	
	//Default constructor
	public Destination() {
		
	}
	
	/**
	 * @return the nameOfTheDestinationCity
	 */
	public String getNameOfTheDestinationCity() {
		return nameOfTheDestinationCity;
	}

	/**
	 * @param nameOfTheDestinationCity the nameOfTheDestinationCity to set
	 */
	public void setNameOfTheDestinationCity(String nameOfTheDestinationCity) {
		this.nameOfTheDestinationCity = nameOfTheDestinationCity;
	}

	/**
	 * @return the normalMilesRequired
	 */
	public int getNormalMilesRequired() {
		return normalMilesRequired;
	}

	/**
	 * @param normalMilesRequired the normalMilesRequired to set
	 */
	public void setNormalMilesRequired(int normalMilesRequired) {
		this.normalMilesRequired = normalMilesRequired;
	}

	/**
	 * @return the frequentFlyerMilesRequired
	 */
	public int getFrequentFlyerMilesRequired() {
		return frequentFlyerMilesRequired;
	}

	/**
	 * @param frequentFlyerMilesRequired the frequentFlyerMilesRequired to set
	 */
	public void setFrequentFlyerMilesRequired(int frequentFlyerMilesRequired) {
		this.frequentFlyerMilesRequired = frequentFlyerMilesRequired;
	}

	/**
	 * @return the additionalMilesForUpgrading
	 */
	public int getAdditionalMilesForUpgrading() {
		return additionalMilesForUpgrading;
	}

	/**
	 * @param additionalMilesForUpgrading the additionalMilesForUpgrading to set
	 */
	public void setAdditionalMilesForUpgrading(int additionalMilesForUpgrading) {
		this.additionalMilesForUpgrading = additionalMilesForUpgrading;
	}

	/**
	 * @return the startMonth
	 */
	public int getStartMonth() {
		return startMonth;
	}

	/**
	 * @param startMonth the startMonth to set
	 */
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	/**
	 * @return the endMonth
	 */
	public int getEndMonth() {
		return endMonth;
	}

	/**
	 * @param endMonth the endMonth to set
	 */
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
}