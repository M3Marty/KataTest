package com.m3m.kata.test;

public abstract class Calculator {

	protected String args[];
	
	public abstract int parseNumber(String numberString);
	
	public abstract String formatNumber(int number);
	
	private int doAction(int a, int b, String operator) {
		switch (operator) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		default: throw new UnsupportedOperationException("Operator" + operator + " is not supported.");
		}
	}
	
	protected Calculator(String args[]) {
		this.args = args;
	}
	
	public String calc() {
		int a = parseNumber(args[0]);
		int b = parseNumber(args[2]);
		
		// Weird checks
		if (a < 1 || a > 10 || b < 1 || a > 10)
			throw new IllegalArgumentException();
		
		String res = formatNumber(doAction(a, b, args[1]));
		if (res == null || res.equals(""))
			throw new NullPointerException();
		return res;
	}
	
	public static Calculator getCalculatorForLine(String line) {
		String args[] = line.split(" ");
		if (args[0].charAt(0) >= '0' && args[0].charAt(0) <= '9')
			return new ArabicCalculator(args);
		else
			return new LatinCalculator(args);
	}
}
