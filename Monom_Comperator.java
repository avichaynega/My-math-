package myMath;

import java.util.Comparator;

/*
 * this class is comparing between two Monoms by checking the value of power.
 */

public class Monom_Comperator implements Comparator<Monom> {

	/**
	 * this function is checking the powers of the Monom and return integer value;
	 */
	public int compare(Monom arg0, Monom arg1) {
		if(arg0.get_power() < arg1.get_power()) {
			return 1;
		}
		else if(arg0.get_power() == arg1.get_power()){
			return 0;
		}
		else 
			return -1;
		
	}
}
