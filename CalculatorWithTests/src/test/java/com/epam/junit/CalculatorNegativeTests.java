package com.epam.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorNegativeTests {
	private Calculator calculator;

	@Before()
	public void prepeare() {
		this.calculator = new Calculator();
	}

	//Addition Tests	
	//Addition Negative Scenarios
	@Test(expected = IllegalArgumentException.class)
	public void testAddition_OneIncorrectValue(){
		Object numInteger = new Integer(5);
		Object incorrectValue = new String("incorect value for add operation");
		
		Object result = calculator.addition(numInteger, incorrectValue);
		
		assertNotNull(result);
	}
	
	
	//Division Tests	
	//Division Negative Scenarios
	@Test(expected = IllegalArgumentException.class)
	public void testDivision_DivisionByZeroForInt(){
		int a = 5;
		int b = 0;
		
		double result = calculator.division(a, b);
		
		assertNotNull(result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivision_DivisionByZeroForFloat(){
		float a = 5;
		float b = 0;
		
		double result = calculator.division(a, b);
		
		assertNotNull(result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivision_DivisionByZeroForObjectValues(){
		Object numInteger = new Integer(5);
		Object numFloat = new Integer(0);
		
		Object resultIntegerDevidedByInteger = calculator.division(numInteger, numFloat);
		
		assertNotNull(resultIntegerDevidedByInteger);

	}

	@Test(expected = NullPointerException.class)
	public void testDivision_OneOfParamsIsNull(){
		Object numInteger = new Integer(5);
		Object nullParam = null;

		Object resultIntegerDevidedByInteger = calculator.division(numInteger, nullParam);

		assertNotNull(resultIntegerDevidedByInteger);
	}

	
	//Root Negative Scenarios
	@Test(expected = IllegalArgumentException.class)
	public void testRoot_TheSecondParamIsZeroForInt(){
		int a = 5;
		int b = 0;
		
		double result = calculator.root(a, b);
		
		assertNotNull(result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRoot_TheSecondParamIsZeroForFloat(){
		float a = 5;
		float b = 0;
		
		double result = calculator.root(a, b);
		
		assertNotNull(result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRoot_TheSecondParamIsZeroForObjectValues(){
		Object numInteger = new Integer(5);
		Object numZero = new Integer(0);

		Object result = calculator.root(numInteger, numZero);

		assertNotNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRoot_OneOfParamsIsNull(){
		Object numInteger = new Integer(5);
		Object nullParam = null;

		Object result = calculator.root(numInteger, nullParam);

		assertNotNull(result);
	}


	//isPrime Tests
	//Negative timeout scenario
	//This test will be failed
	@Ignore
	@Test(timeout=3000)
	public void testIsPrime_Timeout() throws InterruptedException{
		int primeNumber = 99971;
		boolean result;
		result = calculator.isPrime(primeNumber);
		assertNotNull(result);

	}
}

