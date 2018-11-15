package myMath;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void testF() {
		Monom a = new Monom(2, 2);
		double acutal =a.f(2);
		double expected = 8.0;
		assertEquals(expected, acutal);
		
		
	}

	@Test
    void testDerivative() {
		Monom a = new Monom(2, 2);
		Monom b =new Monom(a.derivative());
		double actual = b.get_coefficient()+b.get_power();
		double expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	void testAdd() {
		Monom a = new Monom(2, 2);
		Monom b = new Monom(3, 2);
		a.add(b);
		double actual =a.get_coefficient()+a.get_power();
		double expected = 7;
		assertEquals(expected,actual);
	}

	@Test
	void testMulti() {
		Monom a = new Monom(2, 2);
		Monom b = new Monom(3, 2);
		a.multi(b);
		double actual =a.get_coefficient()+a.get_power();
		double expected = 10;
		assertEquals(expected,actual );
	}

	@Test
	void testToStringString() {
		Monom a = new Monom(-2, 2);
		String actual = a.toString();
		String expected  = "-2.0x^2";	
		assertEquals(expected, actual);
	}
	

	

}
