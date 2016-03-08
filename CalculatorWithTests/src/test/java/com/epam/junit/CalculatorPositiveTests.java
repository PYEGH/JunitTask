package com.epam.junit;

import static org.junit.Assert.assertEquals;
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
import java.util.List;

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
		int correctResult = 15;
		assertNotNull(result);
		assertEquals(correctResult, result);
	}

	@Test
	public void testAddition_TwoFloatValues() {
		float a = 5;
		float b = 10;
		float result = calculator.addition(a, b);
		float correctResult = 15;
		assertNotNull(result);
		// Use Float Object instead float promitive type to avoid using of
		// depricated method assertEquals(float, float)
		assertEquals(Float.valueOf(correctResult), Float.valueOf(result));
	}

	@Test
	public void testAddition_TwoCorrectOjectValues() {
		Object numInteger = new Integer(5);
		Object numFloat = new Float(10);

		Object resultIntegerPlusInteger = calculator.addition(numInteger,
				numInteger);		
		
		Object resultFloatPlusFloat = calculator.addition(numFloat, numFloat);
		Object resultIntegerPlusFloat = calculator.addition(numInteger,
				numFloat);
		Object resultFloatPlusInteger = calculator.addition(numFloat,
				numInteger);
		Object correctResultIntegerPlusInteger = new Integer(10);
		Object correctResultFloatPlusFloat = new Float(20.0);
		Object correctResultIntegerPlusFloat = new Float(15.0);
		Object correctResultFloatPlusInteger = new Float(15.0);		

		assertNotNull(resultIntegerPlusInteger);
		assertNotNull(resultFloatPlusFloat);
		assertNotNull(resultIntegerPlusFloat);
		assertNotNull(resultFloatPlusInteger);
		
		assertEquals(correctResultIntegerPlusInteger, resultIntegerPlusInteger);
		assertEquals(correctResultFloatPlusFloat, resultFloatPlusFloat);
		assertEquals(correctResultIntegerPlusFloat, resultIntegerPlusFloat);
		assertEquals(correctResultFloatPlusInteger, resultFloatPlusInteger);
	}

	// Division Tests
	// Division Positive Scenarios
	@Test
	public void testDivision_TwoCorrectIntValues() {
		int a = 10;
		int b = 5;

		double result = calculator.division(a, b);
		double correctResult = 2.0;
		assertNotNull(result);
		assertEquals(Double.valueOf(correctResult), Double.valueOf(result));
	}

	@Test
	public void testDivision_TwoCorrectFloatValues() {
		float a = 10;
		float b = 5;

		double result = calculator.division(a, b);
		double correctResult = 2.0;

		assertNotNull(result);
		assertEquals(Double.valueOf(correctResult), Double.valueOf(result));
	}

	@Test()
	public void testDivision_TwoCorrectObjectValues() {
		Object numInteger = new Integer(10);
		Object numFloat = new Float(5);

		Object resultIntegerDevidedByInteger = calculator.division(numInteger,
				numInteger);
		Object resultFloatDevidedByFloat = calculator.division(numFloat,
				numFloat);
		Object resultIntegerDevidedByFloat = calculator.division(numInteger,
				numFloat);
		Object resultFloatDevidedByInteger = calculator.division(numFloat,
				numInteger);
		
		Object correctResultIntegerDevidedByInteger = new Float(1.0);
		Object correctResultFloatDevidedByFloat = new Float(1.0);
		Object correctResultIntegerDevidedByFloat = new Float(2.0);
		Object correctResultFloatDevidedByInteger = new Float(0.5);

		assertNotNull(resultIntegerDevidedByInteger);
		assertNotNull(resultFloatDevidedByFloat);
		assertNotNull(resultIntegerDevidedByFloat);
		assertNotNull(resultFloatDevidedByInteger);
		
		assertEquals(correctResultIntegerDevidedByInteger, resultIntegerDevidedByInteger);
		assertEquals(correctResultFloatDevidedByFloat, resultFloatDevidedByFloat);
		assertEquals(correctResultIntegerDevidedByFloat, resultIntegerDevidedByFloat);
		assertEquals(correctResultFloatDevidedByInteger, resultFloatDevidedByInteger);
	}

	// Root Tests
	// Root Positive Scenarios
	@Test()
	public void testRoot_TwoCorrectIntValues() {
		int a = 27;
		int b = 3;
		Object correctResult= new Double(3.0);

		double result = calculator.root(a, b);


		assertNotNull(result);
		assertEquals(correctResult, Double.valueOf(result));
	}

	@Test
	public void testRoot_TwoCorrectFloatValues() {
		float a = 27;
		float b = 3;
		Object correctResult= new Double(3.0);

		double result = calculator.root(a, b);


		assertNotNull(result);
		assertEquals(correctResult, Double.valueOf(result));
	}

	@Test()
	public void testRoot_TwoCorrectObjectValues() {
		Object numInteger = new Integer(27);
		Object numFloat = new Integer(27);
		
		Object degreeInteger = new Integer(3);
		Object degreeFloat = new Integer(3);
		
		Object correctResult= new Double(3.0);

		Object resultForIntegerIntegerParams = calculator.root(numInteger,
				degreeInteger);
		Object resultForFloatFloatParams = calculator.root(numFloat, degreeFloat);
		Object resultForIntegerFloatParams = calculator.root(numInteger,
				degreeFloat);
		Object resultForFloatIntegerParams = calculator.root(numFloat,
				degreeInteger);

		assertNotNull(resultForIntegerIntegerParams);
		assertNotNull(resultForFloatFloatParams);
		assertNotNull(resultForIntegerFloatParams);
		assertNotNull(resultForFloatIntegerParams);
		
		assertEquals(correctResult, resultForIntegerIntegerParams);
		assertEquals(correctResult, resultForFloatFloatParams);
		assertEquals(correctResult, resultForIntegerFloatParams);
		assertEquals(correctResult, resultForFloatIntegerParams);
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
		List<Integer> sequence = calculator
				.generateFiboncciSequence(sequenceSize);

		assertThat(sequence.toArray(), arrayWithSize(greaterThan(1))); // sequence
																		// must
																		// be
																		// not
																		// empty
		assertThat(sequence, everyItem(greaterThan(0))); // only value > 0 is
															// allowed

		// Check that sequence was generated correctly
		// Check Fibonacci generator on sequence with size 5
		assertThat(sequence, hasItem(equalTo(1)));
		assertThat(sequence, hasItem(equalTo(2)));
		assertThat(sequence, hasItem(equalTo(3)));
		assertThat(sequence, hasItem(equalTo(5)));
	}

}
