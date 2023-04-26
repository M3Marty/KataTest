package com.m3m.kata.test;

public class ArabicCalculator extends Calculator {

	public ArabicCalculator(String args[]) {
		super(args);
	}

	@Override
	public int parseNumber(String numberString) {
		return Integer.parseInt(numberString);
	}

	@Override
	public String formatNumber(int number) {
		return Integer.toString(number);
	}

}
