package com.epam.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorPositiveTests {
	private Calculator calculator;

	@Before()
	public void prepeare() {
		this.calculator = new Calculator();
	}

	//Addition Tests
	//Addition Positive Scenarios
	@Test
	public void testAddition_TwoIntValues() {
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

		Object resultIntegerPlusInteger = calculator.addition(numInteger, numInteger);
		Object resultFloatPlusFloat = calculator.addition(numFloat, numFloat);
		Object resultIntegerPlusFloat = calculator.addition(numInteger, numFloat);
		Object resultFloatPlusInteger = calculator.addition(numFloat, numInteger);
		
		assertNotNull(resultIntegerPlusInteger);
		assertNotNull(resultFloatPlusFloat);
		assertNotNull(resultIntegerPlusFloat);
		assertNotNull(resultFloatPlusInteger);
	}

	
	//Division Tests
	//Division Positive Scenarios
	@Test
	public void testDivision_TwoCorrectIntValues(){
		int a = 5;
		int b = 10;
		
		double result = calculator.division(a, b);
		
		assertNotNull(result);
	}
	
	@Test
	public void testDivision_TwoCorrectFloatValues(){
		float a = 5;
		float b = 10;
		
		double result = calculator.division(a, b);
		
		assertNotNull(result);
	}
	
	@Test()
	public void testDivision_TwoCorrectObjectValues(){
		Object numInteger = new Integer(5);
		Object numFloat = new Integer(10);

		Object resultIntegerDevidedByInteger = calculator.division(numInteger, numInteger);
		Object resultFloatDevidedByFloat = calculator.division(numFloat, numFloat);
		Object resultIntegerDevidedByFloat = calculator.division(numInteger, numFloat);
		Object resultFloatDevidedByInteger = calculator.division(numFloat, numInteger);
		
		assertNotNull(resultIntegerDevidedByInteger);
		assertNotNull(resultFloatDevidedByFloat);
		assertNotNull(resultIntegerDevidedByFloat);
		assertNotNull(resultFloatDevidedByInteger);
	}
		
	
	//Root Tests
	//Root Positive Scenarios
	@Test()
	public void testRoot_TwoCorrectIntValues(){
		int a = 5;
		int b = 10;
		
		double result = calculator.root(a, b);
		
		assertNotNull(result);
	}
	
	@Test
	public void testRoot_TwoCorrectFloatValues(){
		float a = 5;
		float b = 10;
		
		double result = calculator.root(a, b);
		
		assertNotNull(result);
	}
	
	@Test()
	public void testRoot_TwoCorrectObjectValues(){
		Object numInteger = new Integer(5);
		Object numFloat = new Integer(10);

		Object resultIntegerDevidedByInteger = calculator.root(numInteger, numInteger);
		Object resultFloatDevidedByFloat = calculator.root(numFloat, numFloat);
		Object resultIntegerDevidedByFloat = calculator.root(numInteger, numFloat);
		Object resultFloatDevidedByInteger = calculator.root(numFloat, numInteger);
		
		assertNotNull(resultIntegerDevidedByInteger);
		assertNotNull(resultFloatDevidedByFloat);
		assertNotNull(resultIntegerDevidedByFloat);
		assertNotNull(resultFloatDevidedByInteger);
	}
	
	//isPrime Tests
	//Positive scenario 1: provided number is really prime
	@Test()
	public void testIsPrime(){
		int primeNumber = 7;
		boolean result;
		result = calculator.isPrime(primeNumber);
		assertTrue(result);	

	}
	
	
	//Positive scenario 2: provided number is not prime
	@Test()
	public void testIsNotPrime(){
		int primeNumber = 8;
		boolean result;
		result = calculator.isPrime(primeNumber);			
		assertFalse(result);
	}
	
}
