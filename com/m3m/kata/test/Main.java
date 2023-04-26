package com.m3m.kata.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) {
		try (var in = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println(calc(in.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String calc(String line) {
		return Calculator.getCalculatorForLine(line).calc();
	}
}
