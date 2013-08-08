package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class RookTest extends TestCase {
	public void testRookMove() throws Exception {
		Position source = new Position("d3");		//(3,3)위치 
		Piece rook = new Rook(Color.WHITE, source);
	
		System.out.println(rook.getPossibleMoves());
		assertEquals(14, rook.getPossibleMoves().size());
	}
}
