package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class KnightTest extends TestCase {
	public void testKnightMove() throws Exception {
		Position source = new Position("d5");		//(3,4)위치 
		Piece knight = new Knight(Color.WHITE, source);
	
		System.out.println(knight.getPossibleMoves());
		assertEquals(8, knight.getPossibleMoves().size());
	}

}
