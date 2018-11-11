package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void testMonomDoubleInt() {
		
		
	}

	@Test
	void testMonomMonom() {
		fail("Not yet implemented");
	}

	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		Monom a = new Monom(2, 2);
		Monom b = new Monom(3, 2);
		a.add(b);
		Monom result =new Monom(a);
		assertEquals(new Monom(5, 2), result);
	}

	@Test
	void testMulti() {
		fail("Not yet implemented");
	}

	@Test
	void testToStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testGet_coefficient() {
		fail("Not yet implemented");
	}

	@Test
	void testGet_power() {
		fail("Not yet implemented");
	}

}
