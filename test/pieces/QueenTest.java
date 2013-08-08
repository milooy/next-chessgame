package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class QueenTest extends TestCase {
	public void testQueenMove() throws Exception {
		Position source = new Position("d5");		//(3,4)위치 
		Piece queen = new Queen(Color.WHITE, source);
	
		System.out.println(queen.getPossibleMoves());
		assertEquals(27, queen.getPossibleMoves().size());
	}
}
