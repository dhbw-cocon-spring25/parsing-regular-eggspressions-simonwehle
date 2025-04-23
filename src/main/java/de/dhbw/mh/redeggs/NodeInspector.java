package de.dhbw.mh.redeggs;

import de.dhbw.mh.redeggs.RegularEggspression.Alternation;
import de.dhbw.mh.redeggs.RegularEggspression.Concatenation;
import de.dhbw.mh.redeggs.RegularEggspression.Literal;
import de.dhbw.mh.redeggs.RegularEggspression.Star;

/**
 * A visitor that inspects nodes of a regular expression AST and returns their string representation.
 */
public class NodeInspector implements RegularEggspression.Visitor<String> {

	/**
	 * Visits an empty word (ε) node.
	 *
	 * @param emptyWord the empty word node
	 * @return the string representation "ε"
	 */
	@Override
	public String visit(RegularEggspression.EmptyWord emptyWord) {
		return "ε";
	}

	/**
	 * Visits an empty set (∅) node.
	 *
	 * @param emptySet the empty set node
	 * @return the string representation "∅"
	 */
	@Override
	public String visit(RegularEggspression.EmptySet emptySet) {
		return "∅";
	}

	/**
	 * Visits a concatenation node after visiting its left and right subexpressions.
	 *
	 * @param concat the concatenation node
	 * @param left   the string representation of the left subexpression
	 * @param right  the string representation of the right subexpression
	 * @return the string representation in the form "(left right)"
	 */
	@Override
	public String visitPost(Concatenation concat, String left, String right) {
		return "(" + left + right + ")";
	}

	/**
	 * Visits an alternation (union) node after visiting its left and right subexpressions.
	 *
	 * @param union the alternation node
	 * @param left  the string representation of the left subexpression
	 * @param right the string representation of the right subexpression
	 * @return the string representation in the form "(left|right)"
	 */
	@Override
	public String visitPost(Alternation union, String left, String right) {
		return "(" + left + "|" + right + ")";
	}

	/**
	 * Visits a Kleene star node after visiting its base subexpression.
	 *
	 * @param star the star node
	 * @param base the string representation of the base subexpression
	 * @return the string representation in the form "(base)*"
	 */
	@Override
	public String visitPost(Star star, String base) {
		return "(" + base + ")*";
	}

	/**
	 * Visits a literal node and returns the string representation of its symbol.
	 *
	 * @param lit the literal node
	 * @param sym the virtual symbol associated with the literal
	 * @return the string representation of the symbol
	 */
	@Override
	public String visitPost(Literal lit, VirtualSymbol sym) {
		return sym.toString();
	}

}
