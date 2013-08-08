package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class KingTest extends TestCase {
	public void testKingMove() throws Exception {
		Position source = new Position("d5");		//(3,4)위치 
		Piece king = new King(Color.WHITE, source);
	
		System.out.println(king.getPossibleMoves());
		assertEquals(8, king.getPossibleMoves().size());

		Position source2 = new Position("h1");		//(3,4)위치 
		Piece king2 = new King(Color.WHITE, source2);
		
		System.out.println(king2.getPossibleMoves());
		assertEquals(3, king2.getPossibleMoves().size());
	}

}
