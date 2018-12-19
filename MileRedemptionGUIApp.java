/************************************************************
 *                                                          *
 *  CSCI 470/502          Assignment 8           Fall 2018  *                                             
 *                                                          *
 *  Programmer: Mayank Agarwal (Z1828333)                   *  
 *                                                          *
 *  Date Due:   11/28/2018                                  *                          
 *                                                          *
 *  Purpose:   This is a MileRedemptionGUIApp driver        *
 *  		   class for Assignment 8                       *
 *                                                          *
 *                                                          *
 ***********************************************************/

package assignment8;

import java.io.IOException;

import javax.swing.JFrame;

public class MileRedemptionGUIApp {

	public static void main(String[] args) throws IOException {

		MileRedemptionGUI MileRedemption = new MileRedemptionGUI(); // C:\Users\vijay\Desktop\Destination Mileage.txt
		
		MileRedemption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MileRedemption.setSize(650, 310);
		MileRedemption.setVisible(true);
		//MileRedemption.setResizable(false);
	}
}