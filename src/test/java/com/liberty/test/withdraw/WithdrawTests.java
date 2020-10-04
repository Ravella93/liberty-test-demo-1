package com.liberty.test.withdraw;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.liberty.test.error.ArgumentException;

public class WithdrawTests {

	static double balance;

	/**
	 * Making sure the paramters are reset before each test case
	 */
	@Before
	public void intializeParameters() {
		balance = 100.00;
	}

	/**
	 * Assumption User enter or system enters withdraw amount zero.
	 */
	@Test
	public void withdrawForZeroTest() {
		withdraw(0);
		assertEquals("100.0", Double.toString(balance));
	}

	/**
	 * Assumption User enter or system enters withdraw amount 90.
	 */
	@Test
	public void withdrawSuccessTest() {
		withdraw(90);
		assertEquals("10.0", Double.toString(balance));
	}

	/**
	 * Assumption User enter or system enters a neg amount due to upstream or
	 * user interfacing issues
	 */
	@Test
	public void withdrawNegativeSuccessTest() {
		withdraw(-9.99);
		assertEquals("109.99", Double.toString(balance));
	}

	/**
	 * Exception test case with huge amount
	 */
	@Test(expected = ArgumentException.class)
	public void withdrawFailureTest() {
		withdraw(1000);

	}

	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
		} else {
			throw new ArgumentException(amount, "Withdrawal exceeds balance!");
		}
	}

}
