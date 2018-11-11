package myMath;

public class Test {
	public static void main(String args[]) {
		
//		Monom a = new Monom(2, 2);
//		Monom b =new Monom(4, 2);
//		Monom c =new Monom(3, 3);
//	
//		System.out.println(a.toString());
//		
//		System.out.println(d);
//		System.out.println(a.derivative());
//		System.out.println(a.add(b));
//		
//		
		Polynom a = new Polynom();
		Polynom g = new Polynom();
		Monom b = new Monom(-1, 3);
		Monom c = new Monom(4, 1);
		Monom d = new Monom(1, 3);
//		Monom e = new Monom(4, 1);
//		Monom f = new Monom(5, 3);
		a.add(b);
		a.add(c);
//		a.add(d);
//		g.add(d);
//		g.add(e);
//		g.add(f);
		
		System.out.println(a.toString());
//		System.out.println(g.toString());
//		a.multiply(g);
//		a.substract(g);
//		System.out.println(a.equals(g));
//		System.out.println(a.area(-5, -3, 0.0001));
//		System.out.println(a.root(-4,-1, 0.5));
	}

}
