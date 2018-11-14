package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Policy;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void testF() {
		Polynom p = new Polynom("2x^2+2x+1");
		double actual =p.f(2);
		double expected =13;
		assertEquals(expected, actual);
	}

	@Test
	void testAddPolynom_able() {
		Polynom p = new Polynom("2x^2-2x");
		Polynom p1 = new Polynom("-3x^3-4x");
		p.add(p1);
		String actual = p.toString();
		System.out.println(actual);
		Object expected = "-3x^3+2x^2-6x";
		assertEquals(expected, actual);
	}

	@Test
	void testAddMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testSubstract() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		Polynom p = new Polynom("-2x^2-x");
		Polynom p2 = new Polynom("-3x^2+2x");
		p.multiply(p2);
		String actual = p.toString() ;
		String expected = "6.0x^4-1.0x^3-2.0x^2";
		assertEquals(expected, actual);
		
	}

	@Test
	void testEqualsPolynom_able() {
		Polynom p = new Polynom("2x^2+2x");
		Polynom p1 = new Polynom("2x^2+2x");
		boolean actual = p.equals(p1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		Polynom p =new Polynom("2x^2+2x+1");
		String actual = p.toString();
		String expected="2.0x^2+2.0x+1.0";
		assertEquals(expected, actual);
	}

	@Test
	void testPolynomString() {
			
	}
	
}
