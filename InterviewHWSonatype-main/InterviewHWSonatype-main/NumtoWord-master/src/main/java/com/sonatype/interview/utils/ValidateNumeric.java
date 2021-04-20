package com.sonatype.interview.utils;
import org.jetbrains.annotations.NotNull;

public class ValidateNumeric
{
	/**this class looks at the number entered to see if it is a valid input that 
	 the tool can process**/
		
	public static String validateWithHints( @NotNull String number )
	{
		if ( ! ValidateNumeric.isValidIntegerRepresentation( number ) )
		{
			boolean isNegative = number.startsWith( "-" );


			number = isNegative ? number.substring( 1 ) : number;


			if ( number.charAt( 0 ) == '0' )
			{
				if ( isNegative && number.length() == 1 )
				{
					return "integer starts from 1 to 9 only";
				}
				else if ( number.length() > 1 )
				{
					return "integer starts from 1 to 9 only";
				}
			}


			for ( char chr : number.toCharArray() )
			{
				if ( chr == '-' )
				{
					return "please provide one - at the start of number";
				}
				if ( chr == '.' )
				{
					return "Fractions not supported";
				}

				if ( chr == ' ' )
				{
					return "number contains white space , please remove";
				}
				// ASCII '0' = 48, '9' = 57
				if ( chr < 48 || chr > 57 )
				{
					return "Numbers can only contain the numerals 0-9 and start with a -.";
				}
				
				
				if ( number.length() > (Dictionary.numScales() * 3) + 3 )
				{
					return "String too long";
				}
				
				
			}
			

	
			return "The number is invalid.";
		}

		return null;
	}


	static boolean isValidIntegerRepresentation( @NotNull String number )
	{
		
		boolean isNegative = number.startsWith( "-" );
		number = isNegative ? number.substring( 1 ) : number;

		if ( number.isEmpty() )
		{
			return false;
		}
		
		if ( number.charAt( 0 ) == '0'  )
		{
			if ( number.length() > 1 || isNegative )
			{
				return false;
			}
		}


		if ( number.length() > (Dictionary.numScales() * 3) + 3 )
		{
			return false;
		}


		return number.chars().allMatch( chr ->
			chr >= 48 && chr <= 57
		);
		
		
	}
	
	
	public static String maxIntegerRepresentation()
	{
		return new String( new char[(Dictionary.numScales() * 3) + 3] ).replace( "\0", "9" );
	}

}
