package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class BishopTest extends TestCase {
	public void testBishopMove() throws Exception {
		Position source = new Position("d5");		//(3,4)위치 
		Piece bishop = new Bishop(Color.WHITE, source);
	
		System.out.println(bishop.getPossibleMoves());
		assertEquals(13, bishop.getPossibleMoves().size());
	}

}
