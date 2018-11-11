
package myMath;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	
	private double _coefficient; 
	private int _power; 

	
	/**
	 * This function is the constructor it's get a as a coefficient and b as a power.
	 * @param a - coefficient.
	 * @param b - power.
	 */
	public Monom(double a, int b){
		this._coefficient=a;	
		if(b < 0)
	       {
	          throw new IllegalArgumentException("pow is negative");
	       }
	       // Do some stuffs
		this._coefficient=a;
		this._power = b;		
	}
	/**
	 * This function is constructor to deep copy the values of one Monom to another.
	 * @param ot - the Monom to copy.
	 */
	public Monom(Monom ot) {	
		this(ot.get_coefficient(), ot.get_power());
	}
	
	
	// ***************** add your code below **********************
	
	/**
	 * This function is gets value x and returns the f(x)= a*x^b.
	 * @param x the value for calculate.
	 */
	public double f(double x) {
		return (this._coefficient*Math.pow(x, this._power));
	}
	/**
	 * 	This function is take the coefficient and multiply by the power and substract the power with -1.
	 * @return the derivative Monom;
	 */

	public Monom derivative() {
		return new Monom(this._coefficient*this._power,this._power-1);
	}
	/**
	 * 	This function add to this Monom another Monom only if the values of power is equal.
	 * @param a - Monom to add with this Monom.
	 * @return	true if The 'Monom a' can add with this Monom ,return false if can't add.
	 */
	public boolean add(Monom a) {
		if(this._power == a._power) {
		this.set_coefficient(this._coefficient+a._coefficient);
		return true;
		}
		else {
			return false;
		}
		
		
	}
	/**
	 * This function is multiply this Monom with another by multiply the coefficients and the powers
	 * @param a - The Monom to multiply with.
	 */
	
	public void multi(Monom a) {
		this.set_coefficient(this._coefficient*a._coefficient); 
		this.set_power(this._power+a._power);
	}
	/**
	 * This function get a string and makes it Monom object;
	 * @param s string represent Monom.
	 * @return return Monom after converting the string.
	 */
	public Monom toString(String s) {
		double a=0;
		int b=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='x') {
				a = Double.parseDouble(s.substring(0, i));
			}
			if(s.charAt(i)=='^') {
				b = Integer.parseInt(s.substring(s.length()-1,s.length()));
			}
		}
		return new Monom(a, b);
	
	}
	/**
	 * This function print the Monom as a string
	 * @return Monom as a string.
	 */
	public String toString() {
			return ""+this._coefficient+'x'+'^'+this._power;
		
	}

	
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	
	private void set_power(int p) {
		this._power = p;
	}
	/*
	 * return the value of current coefficient
	 */
	public double get_coefficient() {
		return this._coefficient;
	}
	/*
	 * return the value of current power.
	 */
	public int get_power() {
		return this._power;
	}


	
}
