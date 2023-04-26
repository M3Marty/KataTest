package com.m3m.kata.test;

public class LatinCalculator extends Calculator {

	protected LatinCalculator(String[] args) {
		super(args);
	}

	private enum LatinNumber {
		I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

		LatinNumber(int j) {
			value = j;
		}
		
		private final int value;
	}
	
	private String repeat(String s, int times) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < times; i++)
			b.append(s);
		return b.toString();
	}
	
	@Override
	public int parseNumber(String numberString) {
	    return LatinNumber.valueOf(numberString).value;
	}

	@Override
	public String formatNumber(int number) {
		if (number < 0)
			throw new IllegalArgumentException();
		
		if (number == 0)
			return "";
		
		if (number < 10)
			return LatinNumber.values()[(number - 1)].toString();
		
		if (number < 40)
			return repeat("X", number / 10) + formatNumber(number % 10);
		
		if (number < 50)
			return "XL" + formatNumber(number % 10);
		
		if (number < 90)
			return "L" + formatNumber(number - 50);
		
		if (number < 100)
			return "XC" + formatNumber(number % 10);
		
		if (number == 100)
			return "C";
		
		throw new IllegalArgumentException();
	}
}
