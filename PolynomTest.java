package myMath;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Policy;

import javax.xml.stream.events.StartElement;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void testF() {
		Polynom p = new Polynom("2x^2+2x+1");
		double actual = p.f(2);
		double expected = 13;
		assertEquals(expected, actual);
	}

	@Test
	void testAddPolynom_able() {
		Polynom p = new Polynom("2x^2-2x");
		Polynom p1 = new Polynom("-3x^3-4x");
		p.add(p1);
		String actual = p.toString();
		String expected = "-3.0x^3+2.0x^2-6.0x";
		assertEquals(expected, actual);
	}

	@Test
	void testAddMonom() {
		Polynom p = new Polynom("2x^2-5x");
		Monom a = new Monom(2,2);
		p.add(a);
		String actual = p.toString();
		String expected = "4.0x^2-5.0x";
		assertEquals(expected, actual);
	}

	@Test
	void testSubstract() {
		Polynom p = new Polynom("2x^2-5x-1");
		Polynom p1 = new Polynom("3x^3+8x^2-7x+6");
		p.substract(p1);
		String actual = p.toString();
		String expected = "-3.0x^3-6.0x^2+2.0x-7.0";
		assertEquals(expected, actual);
	}

	@Test
	void testMultiply() {
		Polynom p = new Polynom("-2x^2-x");
		Polynom p2 = new Polynom("-3x^2+2x");
		p.multiply(p2);
		String actual = p.toString();
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
		Polynom p = new Polynom("0x^3+0x^2+0x+0");
		boolean actual = p.isZero();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	void testRoot() {
		Polynom p = new Polynom("x^2-2x-4");
		double actual = p.root(1, 5, 0.01);
		double expected = 0;
		assertEquals(expected, actual,0.01);
	}

	@Test
	void testCopy() {
		Polynom p = new Polynom("2x^2-3x");
		Polynom p1 = (Polynom)p.copy();
		Polynom actual = p1;
		Polynom unexpected = p;
		assertNotSame(unexpected, actual);
	}

	@Test
	void testDerivative() {
		Polynom p = new Polynom("2x^2-3x");
		Polynom p1  = new Polynom("4x-3");
		String actual = p.derivative().toString();
		String expected = p1.toString();
		assertEquals(expected, actual);
	}

	@Test
	void testArea() {
		Polynom p = new Polynom("x^3-5x");
		double actual = p.area(-3,1, 0.01);
		double expected = 3.12;
		assertEquals(expected, actual,0.01);
		
	}

	@Test
	void testToString() {
		Polynom p = new Polynom("2x^2+2x+1");
		String actual = p.toString();
		String expected = "2.0x^2+2.0x+1.0";
		assertEquals(expected, actual);
	}

	@Test
	void testPolynomString() {
		Polynom p = new Polynom("2x^2+2x+1");
		Polynom p1 = new Polynom();
		Monom a = new Monom(2, 2);
		Monom b = new Monom(2, 1);
		Monom c = new Monom(1, 0);
		p1.add(a);
		p1.add(b);
		p1.add(c);
		String actual = p.toString();
		String expected = p1.toString();
		assertEquals(expected, actual);
	}

}
