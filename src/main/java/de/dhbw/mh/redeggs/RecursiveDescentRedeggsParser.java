package de.dhbw.mh.redeggs;

import static de.dhbw.mh.redeggs.CodePointRange.range;
import static de.dhbw.mh.redeggs.CodePointRange.single;

import de.dhbw.mh.redeggs.RegularEggspression.Alternation;
import de.dhbw.mh.redeggs.RegularEggspression.Concatenation;
import de.dhbw.mh.redeggs.RegularEggspression.EmptySet;
import de.dhbw.mh.redeggs.RegularEggspression.EmptyWord;
import de.dhbw.mh.redeggs.RegularEggspression.Literal;
import de.dhbw.mh.redeggs.RegularEggspression.Star;
/**
 * A parser for regular expressions using recursive descent parsing.
 * This class is responsible for converting a regular expression string into a
 * tree representation of a {@link RegularEggspression}.
 */
public class RecursiveDescentRedeggsParser {
    private String input;
    private int pos = 0;

	private char peek() {
		return (pos < input.length()) ? input.charAt(pos) : '\0';
	}
	
	private char consume() {
		return input.charAt(pos++);
	}

	private boolean isAtomStart(char c) {
		return isLiteral(c) || c == '[' || c == 'ε' || c == '∅';
	}
	
	private boolean isLiteral(char c) {
		return Character.isLetterOrDigit(c) || c == '_';
	}

	/**
	 * The symbol factory used to create symbols for the regular expression.
	 */
	protected final SymbolFactory symbolFactory;

	/**
	 * Constructs a new {@code RecursiveDescentRedeggsParser} with the specified
	 * symbol factory.
	 *
	 * @param symbolFactory the factory used to create symbols for parsing
	 */
	public RecursiveDescentRedeggsParser(SymbolFactory symbolFactory) {
		this.symbolFactory = symbolFactory;
	}

	/**
	 * Parses a regular expression string into an abstract syntax tree (AST).
	 * 
	 * This class uses recursive descent parsing to convert a given regular
	 * expression into a tree structure that can be processed or compiled further.
	 * The AST nodes represent different components of the regex such as literals,
	 * operators, and groups.
	 *
	 * @param regex the regular expression to parse
	 * @return the {@link RegularEggspression} representation of the parsed regex
	 * @throws RedeggsParseException if the parsing fails or the regex is invalid
	 */
	public RegularEggspression parse(String regex) throws RedeggsParseException {
		this.input = regex;
		this.pos = 0;

		RegularEggspression result = parseAlternation();

		if (pos != input.length()) { // <
			throw new RedeggsParseException("Unexpected character at position ", pos);
		}

		return result;
	}

	private RegularEggspression parseAlternation() throws RedeggsParseException {
		RegularEggspression left = parseConcatenation();
		while (peek() == '|') {
			consume();
			RegularEggspression right = parseConcatenation();
			left = new Alternation(left, right);
		}
    	return left;
	}

	private RegularEggspression parseConcatenation() throws RedeggsParseException {
		RegularEggspression left = parseTerm();
		while (isAtomStart(peek())) {
			RegularEggspression right = parseTerm();
			left = new Concatenation(left, right);
		}
		return left;
	}

	private RegularEggspression parseTerm() throws RedeggsParseException {
		RegularEggspression atom = parseAtom();
		if (peek() == '*') {
			consume();
			return new Star(atom);
		}
		return atom;
	}
	
	private RegularEggspression parseAtom() throws RedeggsParseException {
		char c = peek();
		if (c == '[') return parseCharClass();
		if (c == 'ε') { consume(); return new EmptyWord(); }
		if (c == '∅') { consume(); return new EmptySet(); }
		if (isLiteral(c)) return new Literal(createSymbol(consume()));
		throw new RedeggsParseException("Unexpected character: ", c);
	}

	private RegularEggspression parseCharClass() throws RedeggsParseException {
		consume(); // '['
		SymbolFactory.Builder builder = symbolFactory.newSymbol();
		while (peek() != ']') {
			char first = consume();
			if (peek() == '-') {
				consume();
				char last = consume();
				builder.include(range(first, last));
			} else {
				builder.include(single(first));
			}
		}
		consume(); // ']'
		VirtualSymbol symbol = builder.andNothingElse();
		return new RegularEggspression.Literal(symbol);
	}
	
	private VirtualSymbol createSymbol(char c) {
		return symbolFactory.newSymbol().include(single(c)).andNothingElse();
	}

}
