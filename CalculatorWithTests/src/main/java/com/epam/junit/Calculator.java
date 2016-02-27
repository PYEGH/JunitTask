package com.epam.junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

	/**
	 * Add operation for int
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int addition(final int a, final int b) {
		return a + b;
	}

	/**
	 * Add operation for float
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public float addition(final float a, final float b) {
		return a + b;
	}

	/**
	 * Add operation for Object. Just Integer and Float params are available. In
	 * other cases IllegalArgumentException will be thrown
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Object addition(final Object a, final Object b) {
		if (a == null || b == null) {
			throw new NullPointerException("One of input parameter is null");
		} else if (a instanceof Integer && b instanceof Integer) {
			return (Integer) a + (Integer) b;
		} else if (a instanceof Float && b instanceof Float) {
			return (Float) a + (Float) b;
		} else if (a instanceof Integer && b instanceof Float) {
			return (Integer) a + (Float) b;
		} else if (a instanceof Float && b instanceof Integer) {
			return (Float) a + (Integer) b;
		} else {
			throw new IllegalArgumentException(
					"Incorrect input param were provided: input objects "
							+ "must have only Integer and Float types. *reference can have Object type");
		}
	}

	/**
	 * Division for int values. Returns a/b
	 * 
	 * @param a
	 * @param b
	 */
	public float division(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Division by 0");
		}
		return a / b;
	}

	/**
	 * Division for float values. Returns a/b
	 * 
	 * @param a
	 * @param b
	 */
	public float division(float a, float b) {
		if (b == 0) {
			throw new IllegalArgumentException("Division by 0");
		}
		return a / b;
	}

	/**
	 * Division for float values. Returns a/b
	 * 
	 * @param a
	 * @param b
	 */
	public float division(Object a, Object b) {
		if (a == null || b == null) {
			throw new NullPointerException("One of input parameter is null");
		} else if (a instanceof Integer && b instanceof Integer) {
			if ((Integer) b != 0) {
				return (Integer) a / (Integer) b;
			} else {
				throw new IllegalArgumentException("Division by 0");
			}
		} else if (a instanceof Float && a instanceof Float) {
			if ((Float) b != 0) {
				return (Float) a / (Float) b;
			} else {
				throw new IllegalArgumentException("Division by 0");
			}
		} else if (a instanceof Integer && a instanceof Float) {
			if ((Float) b != 0) {
				return (Integer) a / (Float) b;
			} else {
				throw new IllegalArgumentException("Division by 0");
			}
		} else if (a instanceof Float && a instanceof Integer) {
			if ((Integer) b != 0) {
				return (Float) a / (Integer) b;
			} else {
				throw new IllegalArgumentException("Division by 0");
			}
		} else {
			throw new IllegalArgumentException(
					"Incorrect input param were provided");
		}
	}

	/**
	 * Returns root of a power for b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double root(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException(
					"Impossible to get root for 0 power");
		}
		return Math.pow(a, 1.0 / b);
	}

	/**
	 * Returns root of a power for b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double root(float a, float b) {
		if (b == 0) {
			throw new IllegalArgumentException(
					"Impossible to get root for 0 power");
		}
		return Math.pow(a, 1.0 / b);
	}

	/**
	 * Returns root of a power for b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double root(final Object a, Object b) {

		if (a == null || b == null) {
			throw new NullPointerException("One of input parameter is null");
		} else if (a instanceof Integer || a instanceof Float
				&& b instanceof Integer) {
			if ((Integer) b != 0) {
				return Math.pow(Double.parseDouble(a.toString()),
						1.0 / Double.parseDouble(b.toString()));
			} else {
				throw new IllegalArgumentException(
						"Impossible to get root for 0 power");
			}
		} else if (a instanceof Integer || a instanceof Float
				&& b instanceof Float) {
			if ((Float) b != 0) {
				return Math.pow(Double.parseDouble(a.toString()),
						1.0 / Double.parseDouble(b.toString()));
			} else {
				throw new IllegalArgumentException(
						"Impossible to get root for 0 power");
			}
		} else {
			throw new IllegalArgumentException(
					"Incorrect input param were provided");
		}
	}

	public boolean isPrime(int number) {
		boolean isPrime = true;
		int temp;

		for (int i = 2; i <= number / 2; i++) {
			temp = number % i;
			try {
				Thread.sleep(100); // we do pause to model negative timeout
									// scenario
			} catch (InterruptedException e) {
				throw new RuntimeException(
						"Incorrect input param were provided");
			}
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	public ArrayList<Integer> generateFiboncciSequence(int sizeOfSequence) {
		if (sizeOfSequence < 1) {
			throw new IllegalArgumentException(
					"You are inattentive person or just idiot if you try to generate "
							+ "sequence with negatie or zero size of elements");
		}
		ArrayList<Integer> sequence = new ArrayList();
		Integer firstElement = new Integer(1);
		Integer temp = new Integer(1);
		sequence.add(firstElement);

		for (int i = 0; i < sizeOfSequence - 1; i++) {
			if (i == 0) {
				sequence.add(temp);
			} else {
				temp = sequence.get(i - 1) + sequence.get(i);
				sequence.add(temp);
			}

		}

		return sequence;
	}

}
