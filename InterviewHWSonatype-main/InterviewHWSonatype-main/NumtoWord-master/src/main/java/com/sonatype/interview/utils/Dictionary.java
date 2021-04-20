package com.sonatype.interview.utils;

abstract public class Dictionary
{
	final static public String SPACING = " ";
	final static public String NEGATIVE = "negative";
	final static public String HUNDRED = "hundred";
	final static public String AND = ",";
	
	static String maxlength()
	{
		return Dictionary.THOUSAND_SCALES[ Dictionary.THOUSAND_SCALES.length-1 ];
	}

	static int numScales()
	{
		return Dictionary.THOUSAND_SCALES.length;
	}

	final static public String[] ONE_TO_NINETEEN = new String[]{
		"zero",
		"one",
		"two",
		"three",
		"four",
		"five",
		"six",
		"seven",
		"eight",
		"nine",
		"ten",
		"eleven",
		"twelve",
		"thirteen",
		"fourteen",
		"fifteen",
		"sixteen",
		"seventeen",
		"eighteen",
		"nineteen"
	};

	final static public String[] TENS = new String[]{
		"",
		"ten",
		"twenty",
		"thirty",
		"forty",
		"fifty",
		"sixty",
		"seventy",
		"eighty",
		"ninety",
	};

	final static public String[] THOUSAND_SCALES = new String[]{
		"thousand",
		"million",

	};
}
