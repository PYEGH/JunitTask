package com.epam.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;

import java.util.ArrayList;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorPositiveTests {

	@InjectMocks
	private Calculator calculator = new Calculator();

	@Before()
	public void prepeare() {
		this.calculator = new Calculator();
	}

	// Addition Tests
	// Addition Positive Scenarios
	/**
	 * Method implements using of mocks
	 */
	@Test
	public void testAddition_TwoIntValues() {

		LoggerWrapper loggerWrapper = Mockito.mock(LoggerWrapper.class);
		LoggerService loggerService = Mockito.mock(LoggerService.class);

		Mockito.when(loggerService.getLoggerWrapper())
				.thenReturn(loggerWrapper);
		int a = 5;
		int b = 10;
		int result = calculator.addition(a, b);
		assertNotNull(result);
	}

	@Test
	public void testAddition_TwoFloatValues() {
		float a = 5;
		float b = 10;
		float result = calculator.addition(a, b);
		assertNotNull(result);
	}

	@Test
	public void testAddition_TwoCorrectOjectValues() {
		Object numInteger = new Integer(5);
		Object numFloat = new Integer(10);

		Object resultIntegerPlusInteger = calculator.addition(numInteger,
				numInteger);
		Object resultFloatPlusFloat = calculator.addition(numFloat, numFloat);
		Object resultIntegerPlusFloat = calculator.addition(numInteger,
				numFloat);
		Object resultFloatPlusInteger = calculator.addition(numFloat,
				numInteger);

		assertNotNull(resultIntegerPlusInteger);
		assertNotNull(resultFloatPlusFloat);
		assertNotNull(resultIntegerPlusFloat);
		assertNotNull(resultFloatPlusInteger);
	}

	// Division Tests
	// Division Positive Scenarios
	@Test
	public void testDivision_TwoCorrectIntValues() {
		int a = 5;
		int b = 10;

		double result = calculator.division(a, b);

		assertNotNull(result);
	}

	@Test
	public void testDivision_TwoCorrectFloatValues() {
		float a = 5;
		float b = 10;

		double result = calculator.division(a, b);

		assertNotNull(result);
	}

	@Test()
	public void testDivision_TwoCorrectObjectValues() {
		Object numInteger = new Integer(5);
		Object numFloat = new Integer(10);

		Object resultIntegerDevidedByInteger = calculator.division(numInteger,
				numInteger);
		Object resultFloatDevidedByFloat = calculator.division(numFloat,
				numFloat);
		Object resultIntegerDevidedByFloat = calculator.division(numInteger,
				numFloat);
		Object resultFloatDevidedByInteger = calculator.division(numFloat,
				numInteger);

		assertNotNull(resultIntegerDevidedByInteger);
		assertNotNull(resultFloatDevidedByFloat);
		assertNotNull(resultIntegerDevidedByFloat);
		assertNotNull(resultFloatDevidedByInteger);
	}

	// Root Tests
	// Root Positive Scenarios
	@Test()
	public void testRoot_TwoCorrectIntValues() {
		int a = 5;
		int b = 10;

		double result = calculator.root(a, b);

		assertNotNull(result);
	}

	@Test
	public void testRoot_TwoCorrectFloatValues() {
		float a = 5;
		float b = 10;

		double result = calculator.root(a, b);

		assertNotNull(result);
	}

	@Test()
	public void testRoot_TwoCorrectObjectValues() {
		Object numInteger = new Integer(5);
		Object numFloat = new Integer(10);

		Object resultIntegerDevidedByInteger = calculator.root(numInteger,
				numInteger);
		Object resultFloatDevidedByFloat = calculator.root(numFloat, numFloat);
		Object resultIntegerDevidedByFloat = calculator.root(numInteger,
				numFloat);
		Object resultFloatDevidedByInteger = calculator.root(numFloat,
				numInteger);

		assertNotNull(resultIntegerDevidedByInteger);
		assertNotNull(resultFloatDevidedByFloat);
		assertNotNull(resultIntegerDevidedByFloat);
		assertNotNull(resultFloatDevidedByInteger);
	}

	// isPrime Tests
	// Positive scenario 1: provided number is really prime
	@Test()
	public void testIsPrime() {
		int primeNumber = 7;
		boolean result;
		result = calculator.isPrime(primeNumber);
		assertTrue(result);

	}

	// Positive scenario 2: provided number is not prime
	@Test()
	public void testIsNotPrime() {
		int primeNumber = 8;
		boolean result;
		result = calculator.isPrime(primeNumber);
		assertFalse(result);
	}

	// Positive scenario for checking of Fibonacci sequence
	@Test()
	public void test_IsFibonacciSequence() {
		final int sequenceSize = 5;
		ArrayList<Integer> sequence = calculator
				.generateFiboncciSequence(sequenceSize);

		assertThat(sequence.toArray(), arrayWithSize(greaterThan(1))); // sequence
																		// must
																		// be
																		// not
																		// empty
		assertThat(sequence, hasItem(equalTo(1))); // sequence must have number
													// with value '1'
		assertThat(sequence, everyItem(greaterThan(0))); // only value > 0 is
															// allowed

		int temp;
		int n = 1;
		int n_1 = 1;
		// Checking for elements of collection:
		// Calculate i element of real Fibonacci sequence and compare it with
		// elem form provided collection
		for (int i = 0; i < sequenceSize - 1; i++) {
			assertThat(sequence, hasItem(n));
			temp = n;
			n = n + n_1;
			n_1 = temp;
		}
	}

}
