package com.sonatype.interview;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import static com.sonatype.interview.utils.Dictionary.*;

class numToWordSupport {
	static String numberToWords(@NotNull String number) {
		boolean isNegative = false;
		ArrayList<String> parts = new ArrayList<>(1);
		if (number.charAt(0) == '-') {
			isNegative = true;
			number = number.startsWith("-") ? number.substring(1) : number;
		}
		int[] groups = groupNonNegativeIntegers(number);
		if (isNegative) {
			addWords(parts, NEGATIVE);
		}
		for (int i = 0; i < groups.length; i++) {
			if (i == groups.length - 1) {

				if (groups.length == 1 && groups[0] == 0) {
					addWords(parts, ONE_TO_NINETEEN[0]);
				}
				boolean withAnd = groups.length > 1 || groups[0] > 100;
				addWords(parts, smallIntToWords(groups[i], withAnd));
			} else {

				if (groups[i] != 0) {
					addWords(parts, smallIntToWords(groups[i]));
					addWords(parts, THOUSAND_SCALES[groups.length - 2 - i]);
				}
			}
		}

		return String.join(SPACING, parts);
	}

	private static void addWords(ArrayList<String> arr, String str) {
		if (!str.isEmpty()) {
			if (arr.size() == 0) {
				str = str.substring(0, 1).toUpperCase() + str.substring(1);
			}
			arr.add(str);
		}
	}

	static String smallIntToWords(int nnNumber) {
		return smallIntToWords(nnNumber, false);
	}

	private static String smallIntToWords(int nnNumber, boolean withAnd) {
		String andStr = (withAnd ? AND + SPACING : ""); // add an 'and' between 100 and the remainder

		if (nnNumber <= 0 || nnNumber >= 1000) {
			return "";
		}
		if (nnNumber < 20) {
			return andStr + ONE_TO_NINETEEN[nnNumber];
		}
		if (nnNumber < 100) {
			if (nnNumber % 10 == 0) {
				return andStr + TENS[nnNumber / 10];
			} else {
				return andStr + TENS[nnNumber / 10] + SPACING + smallIntToWords(nnNumber % 10, false);
			}
		}
		if (nnNumber % 100 == 0) {
			return ONE_TO_NINETEEN[nnNumber / 100] + SPACING + HUNDRED;
		} else {
			return smallIntToWords((nnNumber / 100) * 100, false) // Round to nearest hundred
					+ SPACING + smallIntToWords(nnNumber % 100, withAnd);
		}
	}

	static int[] groupNonNegativeIntegers(@NotNull String number) {
		int size = 3;
		int evenLength = (int) Math.ceil(number.length() / (double) size) * size;
		int[] groups = new int[evenLength / size];

		String paddedNumber = String.format("%" + evenLength + "s", number);

		for (int group = 0; group < groups.length; group++) {
			groups[group] = Integer.parseInt(paddedNumber.substring(group * size, (group * size) + size).trim(), 10);
		}

		return groups;
	}
}
