package myMath;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;





/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{

	private ArrayList <Monom> polynom ;
	private final Monom_Comperator cmpbypow = new Monom_Comperator();

	/**
	 * a constructor for building an array to store the Monoms;
	 */

	public Polynom() {
		this.polynom = new ArrayList<>();
	}

	/**
	 * This function is gets value x and returns the f(x)= a*x^b over all Monom at the array list
	 * and sum them;
	 * @param x is a value from axis x;
	 */
	public double f(double x) {
		Iterator<Monom> it = iteretor();
		double a=0;
		while(it.hasNext()) {
			a+=it.next().f(x);
		}
		return a;
	}

	/**
	 * This function is adding two polynoms by runnig all over the array list and add between two with add Monom function
	 * @param p1 the polynom to add with;
	 */
	public void add(Polynom_able p1) {
		Iterator<Monom> itp1= p1.iteretor();
		while(itp1.hasNext()) {
			this.add(itp1.next());
		}
	}

	/**
	 * This function is to add a single Monom to array list;
	 * @param m1 The Monom object to add;
	 */
	public void add(Monom m1) {
		Iterator<Monom> it = iteretor();
		boolean flag =false;
		if(!it.hasNext()) {
			this.polynom.add(m1);
		}
		else {
			while(it.hasNext() && !flag) {

				flag = it.next().add(m1);

			}
			if(flag == false) {
				this.polynom.add(m1);
			}

		}
		this.polynom.sort(cmpbypow);

	}

	/**
	 * This function is to substract between to polynom by multiply the given polynom p1 by -1
	 * and use the add polynom function to substract;
	 * @param p1 polynom to substract with.
	 */
	public void substract(Polynom_able p1) {
		Polynom p =(Polynom) p1.copy();
		Iterator<Monom> itp = p.iteretor();
		Monom a= new Monom (-1, 0);
		while(itp.hasNext()) {
			itp.next().multi(a);
		}
		this.add(p);
	}

	/**
	 * This function is to multiply between two polynoms by running over this polynom and multiply 
	 * between the Monom at this polynom and p1 Monom
	 * @param p1 polynom to multiply with.
	 */

	public void multiply(Polynom_able p1) {

		Polynom tmp = new Polynom();
		Iterator<Monom> itp1 = p1.iteretor();
		Iterator<Monom> it= iteretor();
		while(it.hasNext()) {
			Monom temp = new Monom(it.next());
			while(itp1.hasNext()) {
				Monom temp2 = new Monom(temp);
				temp2.multi(itp1.next());
				tmp.add(temp2);
			}
			itp1 = p1.iteretor();
		}
		Polynom p = (Polynom)tmp.copy();
		this.polynom =p.polynom;

	}

	/**
	 * This function is to check if two polynoms are equals by running over two polynoms 
	 * and check if the Monoms are equals
	 * @param p1 polynom to equal with.
	 */

	public boolean equals(Polynom_able p1) {
		Polynom p = (Polynom)p1.copy();
		Iterator<Monom> it = iteretor();
		Iterator<Monom> itp = p.iteretor();

		while(it.hasNext()) {
			Monom temp = it.next();
			Monom temp2 = itp.next();
			if (temp.get_coefficient() != temp2.get_coefficient() ||
					temp.get_power() != temp2.get_power()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This function is to check if the polynom is zero by running over polynom and check if 
	 * the coefficient at the Monoms are 0;
	 */
	public boolean isZero() {
		Iterator<Monom> it = iteretor();
		while(it.hasNext()){
			if(it.next().get_coefficient() != 0) {
				return false;
			}
		}
		return true;

	}

	/**
	 * This function is to find the cut of the polynom with axis x between the rang of x0 ,x1 and precision of eps .
	 * @param x0 start range in axis x.
	 * @param x1 end range in axis x.
	 * @param eps precision to reach.
	 * @return return the approximate f(x);
	 */
	public double root(double x0, double x1, double eps) {
		double xmid = (x0+x1)/2;
		double ymid = this.f(xmid);
		double a_x=x0 ;
		double b_x=x1;
		if(this.f(a_x)>0) {
			a_x=x1;
			b_x=x0;
		}

		while(Math.abs(ymid)>eps) {
			if(ymid<0 ) {
				a_x=xmid;
				xmid = (xmid+b_x)/2;
				ymid=this.f(xmid);

			}
			else {
				b_x=xmid;
				xmid=(a_x+xmid)/2;
				ymid = this.f(xmid);

			}
		}
		System.out.println(xmid);
		return ymid;
	}

	/**
	 * This function is a deep copy of this polynom;
	 * @return return the copied polynom.
	 */
	public Polynom_able copy() {
		Iterator<Monom> it = iteretor();
		Polynom p = new Polynom();
		while(it.hasNext()) {
			p.add(new Monom(it.next()));
		}
		return p;

	}

	/**
	 * This function is to derivative this polynom;
	 * @return the derivarive polynom.
	 * 
	 */
	public Polynom_able derivative() {
		Polynom p = new Polynom();
		Iterator<Monom> it = this.iteretor();

		while(it.hasNext()) {
			p.add(it.next().derivative());
		}
		return p;
	}

	/**
	 * This function is compute the area above the axis x of this polynom at range of x0,x1 and step of eps.
	 * @param x0 start range in axis x.
	 * @param x1 end range in axis x.
	 * @param eps the step in axis x.
	 * @return the area of this polynom above axis x.
	 */
	public double area(double x0, double x1, double eps) {
		double Parts = (Math.abs(x0-x1))/eps;
		double temp1 = x0+eps;
		double area=0;

		for (int i = 0; i < Parts; i++) {
			if(this.f(temp1)>0) {
				area+=this.f(temp1)*eps;
				temp1= temp1+eps;
			}
			temp1= temp1+eps;

		}
		return area;
	}

	public double AreaUnderAxisX(double x0, double x1, double eps) {
		double Parts = (Math.abs(x0-x1))/eps;
		double temp1 = x0+eps;
		double area=0;

		for (int i = 0; i < Parts; i++) {
			if(this.f(temp1)<0) {
				area+=Math.abs(this.f(temp1))*eps;
				temp1= temp1+eps;
			}
			temp1= temp1+eps;

		}
		return area;
	}

	/**
	 * This function is to create an iterator over this polynom.
	 * @return the iterator of this polynom.
	 */
	public Iterator<Monom> iteretor() {
		Iterator<Monom> it = polynom.iterator();
		return it;
	}
	/**
	 * This function print the polynom as a string
	 * @return polynom as a string.
	 */
	public String toString() {
		String ans = "";
		Iterator<Monom> it = iteretor();
		Monom temp = it.next();
		ans= temp.toString();

		while(it.hasNext()) {
			temp =it.next();
			if(temp.get_coefficient()>0) {
				ans += "+"+temp.toString();
			}
			else {
				ans+=temp.toString();
			}

		}
		return ans;
	}
	/*
	 * This function get a string and makes it polynom object;
	 * @param s string represent polynom.
	 * @return return polynom after converting the string.
	 */
	public Polynom (String s) {
		this.polynom = new ArrayList<>();
		s=s.replace("-","+-");
		String str [] = s.split("\\+");    
		for (int i = 0; i < str.length; i++) {
			if(!str[i].equals("")) {
				this.add(new Monom(str[i]));
			}
		}
	}
	public void DrawPolynom() {
		LinePlotTest frame = new LinePlotTest(this);
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		//		Polynom p = new Polynom("x^2+4x-16");
		//		System.out.println(p.toString());
		//		System.out.println(p.root(-9, -2, 0.01));
		//		System.out.println(p.toString());
		Polynom p2 = new Polynom("-3x^2+2x");
		System.out.println(p2.toString());
		Polynom p = new Polynom("-2x^2-x");
		
		
		p.multiply(p2);
		System.out.println(p.toString());
//		Polynom p = new Polynom("2x^2-3x");
//		System.out.println(p.derivative().toString());

//		Polynom p1 = new Polynom("0.2x^4-1.5x^3+3.0x^2-1.0x-5.0");
//		p1.DrawPolynom();
		//		Polynom p = new Polynom("2x^2-2x");
		//		Polynom p1 = new Polynom("-3x^3-4x");
		//		p.add(p1);
		//		System.out.println(p.toString());
	}


}
