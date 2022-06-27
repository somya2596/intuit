package demoProject;

import java.util.HashSet;
import java.util.List;

public class StringsComparison {


	/**
	 * Returns a field matcher that will execute a regular `equals` operation
	 * between <var>recordOneField</var> and <var>recordTwoField</var>.
	 */
	public static boolean equals(String recordOneField, String recordTwoField) {
		return recordOneField.equals(recordTwoField);
	}

	/**
	 * This is just an experimental matcher in order to try to match abbreviations.
	 * For example, "BANK XY Corporation" will "BANK XY Corp."
	 * <p>
	 * It will only execute the matching functionality for the columns defined in
	 * <var>columnsToMatch</var>.
	 * </p>
	 * <p>
	 * How it works: It splits the words (leaving the spaces aside). Then it checks
	 * if the shortest sub-word has different letters than its longer counterpart
	 * </p>
	 * 
	 * @param columnsToMatch the sole columns over with the matching functionality
	 *                       will be executed.
	 */

	static boolean abbreviations(List<String> columnsToMatch, String recordOneField, String recordTwoField) {

		if (columnsToMatch == null || columnsToMatch.size() == 0) {
			throw new IllegalArgumentException("columnsToMatch cannot be null or empty.");
		}

		if (recordOneField != null && recordTwoField != null) {
			String[] recordOneSplitValue = recordOneField.split("\\s+");
			String[] recordTwoSplitValue = recordTwoField.split("\\s+");
			if (recordOneSplitValue.length != recordTwoSplitValue.length) {
				return false;
			}
			for (int i = 0; i < recordOneSplitValue.length; i++) {
				String record1Substring = recordOneSplitValue[i];
				String record2Substring = recordTwoSplitValue[i];
				if (record1Substring.equals(record2Substring)) {
					continue;
				}
				String longest = record1Substring.length() > record2Substring.length() ? record1Substring
						: record2Substring;
				String shortest = longest.equals(record1Substring) ? record2Substring : record1Substring;
				HashSet<Character> setA = new HashSet<Character>();
				char[] arrayA = shortest.toCharArray();
				for (char charA : arrayA) {
					if (charA != '.') {
						setA.add(charA);
					}
				}
				HashSet<Character> setB = new HashSet<Character>();
				char[] arrayB = longest.toCharArray();
				for (char charB : arrayB) {
					if (charB != '.') {
						setB.add(charB);
					}
				}
				if (setA.retainAll(setB)) {
					return false;
				}
			}
		}

		return true;
	};

//	/**
//	 * This field matcher will only return <code>false</code> if the expected
//	 * <var>columnToMatch</var> is not equal for <var>recordOneField</var> and
//	 * <var>recordTwoField</var>. It will return <code>true</code> in any other
//	 * case.
//	 * <p>
//	 * For example, lets' assume that <var>columnToMatch</var> param is
//	 * <code>TransactionID</code>, them this matcher will behave the following way:
//	 * <ul>
//	 * <li>If <var>columnName</var> equals `TransactionID`: then the matcher will
//	 * check if the value of the column `TransactionID` in <var>recordOneField</var>
//	 * equals <var>recordTwoField</var>.</li>
//	 * <li>If <var>columnName</var> is not `TransactionID` then this matcher will
//	 * just return `true`.</li>
//	 * </ul>
//	 * </p>
//	 * 
//	 * @param columnToMatch the expected column to match. In other words, the sole
//	 *                      column that will be compared for equality. Other columns
//	 *                      will always return true.
//	 * @return <code>false</code> if the expected <var>columnToMatch</var> is not
//	 *         equal for <var>recordOneField</var> and <code>recordTwoField</code>.
//	 *         It will return <code>true</code> in any other case.
//	 */
//	static boolean equalColumnValue(String columnToMatch, String recordOneField, String recordTwoField) {
//
//		if (columnToMatch == null || columnToMatch.length() == 0) {
//			throw new IllegalArgumentException("columnToMatch cannot be null or empty");
//		}
//
//		return recordOneField.equals(recordTwoField);
//
//	}

}
