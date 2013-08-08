package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class EmptyTest extends TestCase {
	public void testEmptyMove() throws Exception {
		Position source = new Position("d3");		//(3,3)위치 
		Piece empty = new Empty(Color.NOCOLOR, source);
		
		assertTrue(empty.getPossibleMoves().isEmpty());
	}
}
