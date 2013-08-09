package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class KnightTest extends TestCase {
	public void testKnightMove() throws Exception {
		Position source = new Position("d5");		//(3,4)위치 
		Piece knight = new Knight(Color.WHITE, source);
	
		System.out.println(knight.getPossibleMoves());
		assertEquals(8, knight.getPossibleMoves().size());

		Position source2 = new Position("g2");		//(6,1)위치. 경계점. 
		Piece knight2 = new Knight(Color.WHITE, source2);
		
		System.out.println(knight2.getPossibleMoves());
		assertEquals(4, knight2.getPossibleMoves().size());
	}

}
