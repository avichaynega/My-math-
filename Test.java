package myMath;

public class Test {
	/**
	 * 
	 * Class for testing the function
	 */
	public static void main(String args[]) {
//	if you want to see result remove the '//' sign for each test
/*--------------Monom test class-----------*/
/**************string function****************/		
//		Monom a = new Monom(2, 2);
//		System.out.println(a.toString());
/************derivative function**********************/
//		
//		System.out.println(a.derivative());
/***********add function*******************/
//		
//		Monom a = new Monom(2, 2);
//		Monom b =new Monom(4, 2);
//		a.add(b);
//		System.out.println(a.toString());
/********f function********************/
//		
//		Monom a = new Monom(2, 2);
//		System.out.println(a.f(4));
/*************multi function**************/		
//		
//		Monom a = new Monom(2, 2);
//		Monom b =new Monom(4, 2);
//		a.multi(a);
//		System.out.println(a.toString());
		
/*--------------Polynom test class-----------*/
/***********add Monom function********************/			
//		
//		Polynom a = new Polynom();
//		Monom b = new Monom(-1, 3);
//		Monom c = new Monom(4, 1);
//		a.add(b);
//		a.add(c);
//		System.out.println(a.toString());
/***********add Polynoms function***********************/
//		
//		Polynom a = new Polynom();
//		Polynom b =  new Polynom();
//		Monom c = new Monom(-1, 3);
//		Monom d = new Monom(4, 1);
//		a.add(c);
//		a.add(d);
//		Monom e = new Monom(-2, 2);
//		Monom f = new Monom(4, 3);
//		b.add(e);
//		b.add(f);
//		a.add(b);
//		System.out.println(a.toString());
/********root function***********************/
//		
//		Polynom a = new Polynom("x^3-5x");
//		System.out.println(a.area(-3,1, 0.01));
/************copy function************************/	
//		Polynom a = new Polynom("x^3-5x");
//		Polynom b =  (Polynom)a.copy();
//		System.out.println(a.equals(b));
/*********derivative function*********************/	
//		
//		Polynom a = new Polynom("x^3-5x");
//		System.out.println(a.derivative());
/*********f function************************/	
//		
//		Polynom a = new Polynom("x^3-5x");
//		System.out.println(a.f(-1));
/**********isZero function************************/		
//		
//		Polynom a = new Polynom("0x^3-0x");
//		System.out.println(a.isZero());
/********multiply function*********************/		
//		
//		Polynom a = new Polynom("x^3-5x");
//		Polynom b = new Polynom("x^2+x");
//		a.multiply(b);
//		System.out.println(a);
		
/*********substract function********************/		
//		
//		Polynom a = new Polynom("x^3-5x");
//		Polynom b = new Polynom("x^2+x");
//		a.substract(b);
//		System.out.println(a);
/**********DrawPolynom function***********************/	
//		Polynom a = new Polynom("x^3-5x");
//		System.out.println(a.area(-3,1, 0.01));
/**********area function***********************/
	Polynom a = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
	System.out.println(a.AreaUnderAxisX(-2, 6, 0.01));
		
/**********Drawing function***********************/
	a.DrawPolynom();
	
	
	}

}
