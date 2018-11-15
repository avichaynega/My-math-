package myMath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * This class represents a Polynom with add, multiply functionality, it also
 * should support the following: 1. Riemann's Integral:
 * https://en.wikipedia.org/wiki/Riemann_integral 2. Finding a numerical value
 * between two values (currently support root only f(x)=0). 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able {

	private ArrayList<Monom> polynom;
	private final Monom_Comperator cmpbypow = new Monom_Comperator();

	/**
	 * a constructor for building an array to store the Monoms;
	 */

	public Polynom() {
		this.polynom = new ArrayList<>();
	}

	/**
	 * This function is gets value x and returns the f(x)= a*x^b over all Monom at
	 * the array list and sum them;
	 * 
	 * @param x
	 *            value to calculate from axis x.
	 * @return y value at point x;
	 */
	public double f(double x) {
		Iterator<Monom> it = iteretor();
		double a = 0;
		while (it.hasNext()) {
			a += it.next().f(x);
		}
		return a;
	}

	/**
	 * This function is adding two polynoms by runnig all over the array list and
	 * add between two with add Monom function
	 * 
	 * @param p1
	 *            the polynom to add with;
	 */
	public void add(Polynom_able p1) {
		Iterator<Monom> itp1 = p1.iteretor();
		while (itp1.hasNext()) {
			this.add(itp1.next());// use add(Monom) to sum Monoms with same power
		}
	}

	/**
	 * This function is to add a single Monom to array list;
	 * 
	 * @param m1
	 *            The Monom object to add;
	 */
	public void add(Monom m1) {
		Iterator<Monom> it = iteretor();
		boolean flag = false;// flag to check if the Monom m1 can be sum with the current polynom Monom's.
		if (!it.hasNext()) {// check if the polynoms is empty
			this.polynom.add(m1); // add first Monom
		} else {
			while (it.hasNext() && !flag) {// check if the Monom m1 can be summed with this polynom Monom's.

				flag = it.next().add(m1);// return true if current Monom and m1 was summed.

			}
			if (flag == false) {// if Monom m1 can't be summed
				this.polynom.add(m1);// add the Monom 1 to this polynom.
			}

		}
		this.polynom.sort(cmpbypow);// sort the thid polynom by powers.

	}

	/**
	 * This function is subtract between to polynom by multiply the given polynom p1
	 * by -1 and use the add polynom function to subtract;
	 * 
	 * @param p1
	 *            polynom to substract with.
	 */
	public void substract(Polynom_able p1) {
		Polynom p = (Polynom) p1.copy();
		Iterator<Monom> itp = p.iteretor();
		Monom a = new Monom(-1, 0);
		while (itp.hasNext()) {
			itp.next().multi(a);// multiply every Monom in polynom p by -1.
		}
		this.add(p);// use add polynoms function
	}

	/**
	 * This function is to multiply between two polynoms by running over this
	 * polynom and multiply between the Monom at this polynom and p1 Monom
	 * 
	 * @param p1
	 *            polynom to multiply with.
	 */

	public void multiply(Polynom_able p1) {

		Polynom tmp = (Polynom) this.copy();// temporary poloynom to save the multiplies Monoms.
		this.polynom.clear();
		Iterator<Monom> itp1 = p1.iteretor();
		Iterator<Monom> it_tmp = tmp.iteretor();
		while (it_tmp.hasNext()) {// run on this polynom.
			Monom temp = new Monom(it_tmp.next());// save the current Monom of this polynom.
			while (itp1.hasNext()) {// run on polynom p1.
				Monom temp2 = new Monom(temp);// save the current Monom of polynom p1.
				temp2.multi(itp1.next());// multiply the Monoms of each.
				this.add(temp2);// add to temporary polynom.
			}
			itp1 = p1.iteretor();// return to first Monom in polynom p1 to multiply by next Monom in this
									// polynom.
		}
	}

	/**
	 * This function is to check if two polynoms are equals by running over two
	 * polynoms and check if the Monoms are equals
	 * @param p1 polynom to equal with.
	 * @return true if tow Polynoms are equals.
	 */

	public boolean equals(Polynom_able p1) {
		Iterator<Monom> it = iteretor();
		Iterator<Monom> itp1 = p1.iteretor();
			while (it.hasNext()) {
				Monom temp = it.next();
				Monom temp2 = itp1.next();
				if (temp.get_coefficient() != temp2.get_coefficient() || temp.get_power() != temp2.get_power()) {
					return false;
				}
			}
		return true;
	}

	/**
	 * This function is to check if the polynom is zero by running over polynom and
	 * check if the coefficient at the Monoms are 0;
	 * 
	 * @return true if the Polynom is zero.
	 */
	public boolean isZero() {
		Iterator<Monom> it = iteretor();
		while (it.hasNext()) {
			if (it.next().get_coefficient() != 0) {
				return false;
			}
		}
		return true;

	}

	/**
	 * This function is to find the cut of the polynom with axis x between the rang
	 * of x0 ,x1 and precision of eps .
	 * 
	 * @param x0 start range in axis x.
	 *            
	 * @param x1 end range in axis x.
	 *            
	 * @param eps precision to reach.
	 *            
	 * @return return the approximate f(x);
	 */
	public double root(double x0, double x1, double eps) {
		double xmid = (x0 + x1) / 2;//find the middle x 
		double ymid = this.f(xmid);//find the middle y
		double a_x = x0;//save start
		double b_x = x1;//save end
		if (this.f(a_x) > 0) {//check if the function is going up or down
			a_x = x1;//replace the start and end points
			b_x = x0;
		}

		while (Math.abs(ymid) > eps) {//check precision
			if (ymid < 0) {
				a_x = xmid;
				xmid = (xmid + b_x) / 2;//new x middle
				ymid = this.f(xmid);//new x middle

			} else {
				b_x = xmid;
				xmid = (a_x + xmid) / 2;
				ymid = this.f(xmid);

			}
		}
		System.out.println(xmid);
		return ymid;
	}

	/**
	 * This function is a deep copy of this polynom;
	 * 
	 * @return the copied polynom.
	 */
	public Polynom_able copy() {
		Iterator<Monom> it = iteretor();
		Polynom p = new Polynom();
		while (it.hasNext()) {
			p.add(new Monom(it.next()));
		}
		return p;

	}

	/**
	 * This function is to derivative this polynom;
	 * 
	 * @return the derivarive polynom.
	 */
	public Polynom_able derivative() {
		Polynom p = new Polynom();
		Iterator<Monom> it = this.iteretor();

		while (it.hasNext()) {
			p.add(it.next().derivative());
		}
		return p;
	}

	/**
	 * This function is compute the area above the axis x of this polynom at range
	 * of x0,x1 and step of eps.
	 * 
	 * @param x0 start range in axis x.
	 *            
	 * @param x1 end range in axis x.
	 *            
	 * @param eps the step in axis x.
	 *            
	 * @return the area of this polynom above axis x.
	 */
	public double area(double x0, double x1, double eps) {
		double area = 0;
		for (double i = x0 + eps; i < x1; i += eps) {//run on x0 and x1 range with eps steps
			if (this.f(i) > 0) {//check if the area above the x axis.
				area += Math.abs(this.f(i)) * eps;//calculate the area of each square
			}
		}
		return area;
	}

	/*
	 * This function calculate the area for some Polynom only under Axis x.
	 * 
	 * @param x0 start range in axis x.
	 * 
	 * @param x1 end range in axis x.
	 * 
	 * @param eps the step in axis x.
	 * 
	 * @return the area of this polynom under axis x.
	 */
	public double AreaUnderAxisX(double x0, double x1, double eps) {
		double area = 0;
		for (double i = x0 + eps; i < x1; i += eps) {//run on x0 and x1 range with eps steps
			if (this.f(i) < 0) {//check if the area under the x axis.
				area += Math.abs(this.f(i)) * eps;//calculate the area of each square
			}
		}
		return area;
	}

	/**
	 * This function is to create an iterator over this polynom.
	 * 
	 * @return the iterator of this polynom.
	 */
	public Iterator<Monom> iteretor() {
		Iterator<Monom> it = polynom.iterator();
		return it;
	}

	/**
	 * This function print the polynom as a string
	 * 
	 * @return polynom as a string.
	 */
	public String toString() {
		String ans = "";
		Iterator<Monom> it = iteretor();
		Monom temp = it.next();
		ans = temp.toString();//copy the first Monom to string

		while (it.hasNext()) {//run on this polynom
			temp = it.next();
			if (temp.get_coefficient() > 0) {//if positive add char '+'
				ans += "+" + temp.toString();
			} else {//if negative add as it is.
				ans += temp.toString();
			}

		}
		return ans;
	}

	/*
	 * This function get a string and makes it polynom object;
	 * 
	 * @param s string represent polynom.
	 * 
	 * @return return polynom after converting the string.
	 */
	public Polynom(String s) {
		this.polynom = new ArrayList<>();
		s = s.replace("-", "+-");//replace the char '-' by '+-'
		String str[] = s.split("\\+");//split to array by '+' to save this char '-'.
		for (int i = 0; i < str.length; i++) {
			if (!str[i].equals("")) {//check if the string is empty
				this.add(new Monom(str[i]));//add to polynom by using the Monom string constructor
			}
		}
	}

	/*
	 * This function get Polynom and draw it by using LinePlotTest class/object.
	 */
	public void DrawPolynom() {
		LinePlotTest frame = new LinePlotTest(this);//get this polynom.
		frame.setVisible(true);
	}

}
