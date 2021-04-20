package com.sonatype.interview;

import com.sonatype.interview.utils.ValidateNumeric;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.getProperty;

// this is the main class - EXECUTION POINT
public class numToWordRun extends numToWordSupport {
	public static void main(String[] args) {
		System.out.println(welcomeMessage());
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String str = in.nextLine();
			str = str.trim();
			if (str.matches("^(q)")) {
				break;
			}
			String hint = ValidateNumeric.validateWithHints(str);
			if (hint != null) {
				System.err.println(String.format("%s %s", hint, instructions()));
			} else {
				System.out.println();
				System.out.println(numberToWords(str));
				System.out.println();
			}
		}
	}

//---------------------------------------------------------------------------------
	private static String instructions() {
		return "Enter 'q' to quit at any moment:";
	}

//----------------------------------------------------------------------------------
	private static String welcomeMessage() {

		return "Welcome to Number to Word Convesion Program (Also called as WORDIFY)";
	}
}
