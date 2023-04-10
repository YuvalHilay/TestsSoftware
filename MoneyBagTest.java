package Junit;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import methods.Money;
import methods.MoneyBag;

public class MoneyBagTest extends TestCase{
	
	private Money m12chf;
	private Money m24chf;
	private Money m14chf;
	private Money m7usd;
	private Money m21usd;
	private MoneyBag mB1;
	private MoneyBag mB2;

	@Before
	public void setUp() throws Exception {
		m12chf = new Money(12, "CHF");
		m24chf = new Money(24, "CHF");
		m14chf = new Money(14, "CHF");
		m7usd = new Money(7, "USD");
		m21usd = new Money(21, "USD");
		mB1 = new MoneyBag(m12chf, m7usd);
		mB2 = new MoneyBag(m14chf, m21usd);
	}

//Tests for addMoney

	// Test1 checking functionality: adding the same type of money to MoneyBag
	// input data: object Money amount 10, type CHF
	// expected result: 24CHF (object Money(24, "CHF"))
	@Test
	public void testAddMoney1() {
		Money expected = m24chf;
		Money bag[] = {new Money(10, "CHF")};
		MoneyBag result = new MoneyBag(bag);

		assertEquals(expected, result.addMoney(new Money(14, "CHF")));
	}

	// Test2 checking functionality: adding different type of money to MoneyBag
	// input data: object Money amount 12, type CHF
	// expected result: 12CHF, 7USD (object Money(12, "CHF")) and (object Money(7,
	// "USD"))
	public void testAddMoney2() {
		Money bag[] = {m12chf, m7usd};
		MoneyBag expected = new MoneyBag(bag);

		assertEquals(expected, m12chf.addMoney(m7usd));
	}

	// Test3 checking functionality: adding type of money to an existing MoneyBag
	// mB1
	// input data: object MoneyBag amount 12, type CHF
	// expected result: 24CHF, 7USD
	public void testAddMoney3() {
		Money bag[] = {m24chf, m7usd};
		MoneyBag expected = new MoneyBag(bag);

		assertEquals(expected, mB1.add(m12chf));
	}

	// Test4 checking functionality: adding a new type of money to an existing
	// MoneyBag mB2
	// input data: object Money amount 20, type EU
	// expected result: 14CHF (object Money(14, "CHF")), 21USD (object Money(21,
	// "USD")), 20EU (object Money(20, "EU"))
	public void testAddMoney4() {
		Money m20eu = new Money(20, "EU");
		Money bag[] = { m14chf, m21usd, m20eu };
		MoneyBag expected = new MoneyBag(bag);

		assertEquals(expected, mB2.add(new Money(20, "EU")));
	}

//Tests for contains///////////////////////////////////////////////////////////////////////////////////

	// Test1 checking functionality: checking if a coin is in MoneyBag mB2
	// input data: Object Money amount 21, type USD
	// expected result: True
	public void testContains1() {
		assertTrue(mB2.contains(m21usd));
	}
	
	
	// Test2 checking functionality: checking if a coin is not in MoneyBag mB2
	// input data: Object Money amount 22, type USD
	// expected result: False
	public void testContains2() {
		Money coin = new Money(20, "USD");
		assertFalse(mB2.contains(coin));
	}
	
	
	// Test3 checking functionality: checking if the user puts null to check if it's contains in a bag
	// input data: null
	// expected result: exception
	public void testContains3() {
		try {
			assertTrue(mB1.contains(null));
		}
		catch (NullPointerException e){
			assertTrue(true);
		}
	}
	
	// Test4 checking functionality: checking a new type of coin that not include in the bag
	// input data: Object Money amount 70, type EU
	// expected result: True
	public void testContains4() {
		try {
			assertFalse(mB1.contains(new Money(70,"EU")));
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
}
