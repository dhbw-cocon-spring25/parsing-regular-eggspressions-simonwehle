package de.dhbw.mh.redeggs;

/**
 * Represents a range of Unicode code points, inclusive.
 * Useful for character class definitions or lexical analysis.
 */
public class Range {

	/**
	 * The first code point in the range (inclusive).
	 */
	public final int firstCodePoint;

	/**
	 * The last code point in the range (inclusive).
	 */
	public final int lastCodePoint;

	/**
	 * Creates a new {@code Range} with the specified bounds.
	 *
	 * @param firstCodePoint the starting code point (inclusive)
	 * @param lastCodePoint  the ending code point (inclusive)
	 */
	public Range(int firstCodepoint, int lastCodepoint) {
		firstCodePoint = firstCodepoint;
		lastCodePoint = lastCodepoint;
	}

	/**
	 * Creates a {@code Range} from the specified code point bounds.
	 *
	 * @param firstCodePoint the starting code point (inclusive)
	 * @param lastCodePoint  the ending code point (inclusive)
	 * @return a new {@code Range} instance
	 */
	public static Range range(int firstCodepoint, int lastCodepoint) {
		return new Range(firstCodepoint, lastCodepoint);
	}

	/**
	 * Creates a {@code Range} that contains a single code point.
	 *
	 * @param codePoint the code point to include
	 * @return a {@code Range} containing only the given code point
	 */
	public static Range single(int codepoint) {
		return range(codepoint, codepoint);
	}

	/**
	 * Returns a string representation of the range in Unicode escape format.
	 * If the range represents a single code point, it returns {@code \\uXXXX}.
	 * Otherwise, it returns {@code \\uXXXX-\\uYYYY}.
	 *
	 * @return the string representation of this range
	 */
	@Override
	public String toString() {
		if (firstCodePoint == lastCodePoint) {
			return String.format("\\u%04X", firstCodePoint);
		}
		return String.format("\\u%04X-\\u%04X", firstCodePoint, lastCodePoint);
	}

}
