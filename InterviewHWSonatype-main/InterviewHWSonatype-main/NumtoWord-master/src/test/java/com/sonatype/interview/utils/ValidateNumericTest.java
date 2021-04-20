package com.sonatype.interview.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.sonatype.interview.utils.ValidateNumeric.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateNumericTest
{
	private final static String INVISIBLE_WHITESPACE = "123" + Character.toString( (char)8203 ) + "456";

	private static String[] validStrings()
	{
		
		return new String[]{
			"-123",
			"0",
			"85",
			"5237",
			
		};
	}
// invalid strings and print corresponding messages
	private static String[][] invalidStringsWithHints()
	{
		
		return new String[][]{
			{"", "number is empty"},
			{" ", "number contains white space , please remove"},
			{"pq", "Numbers can only contain the numerals 0-9 and start with a -."},
			{"100s", "Numbers can only contain the numerals 0-9 and start with a -."},
			{"--100", "please provide one - at the start of number"},
			{"100-", "please provide one - at the start of number"},
			{"06", "integer starts from 1 to 9 only"},
			{"006", "integer starts from 1 to 9 only"},
			{"1.0", "Fractions not supported"},
			{"123H234", "Numbers can only contain the numerals 0-9 and start with a -."},
			{"-0", "Zero is a non-negative number and cannot be made negative."},
			{"- ", "number contains white space , please remove"},
			{"- 123", "number contains white space , please remove"},
			{".", "Fractions not supported"},
			{ValidateNumeric.maxIntegerRepresentation()+'9', "String too long"},
			{"-"+ValidateNumeric.maxIntegerRepresentation()+'9', "String too long"}

		};
	}

	@ParameterizedTest
	@MethodSource( value = "validStrings" )
	void isValidIntegerRepresentation_valid( String number )
	{
		assertTrue( ValidateNumeric.isValidIntegerRepresentation( number ) );
	}

	@ParameterizedTest
	@MethodSource( value = "invalidStringsWithHints" )
	void isValidIntegerRepresentation_invalid( String number, String ignored )	// Ignore the hint
	{
		assertFalse( ValidateNumeric.isValidIntegerRepresentation( number ) );
	}

	@ParameterizedTest
	@MethodSource( value = "invalidStringsWithHints" )
	void validateWithHints( String number, String hint )
	{
		assertEquals( hint, ValidateNumeric.validateWithHints( number ) );
	}
}