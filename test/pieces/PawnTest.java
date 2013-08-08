package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	public void testPawnMove() throws Exception {
		Position source = new Position("d5");		//(3,4)위치 
		Piece pawnW = new Pawn(Color.WHITE, source);
	
		System.out.println(pawnW.getPossibleMoves());
		assertEquals(1, pawnW.getPossibleMoves().size());

		Position source2 = new Position("d7");		//(3,6)위치 
		Piece pawnB = new Pawn(Color.BLACK, source2);
		
		System.out.println(pawnB.getPossibleMoves());
		assertEquals(1, pawnB.getPossibleMoves().size());

		Position source3 = new Position("h8");		//(7,7)위치.구석이라 이동가능한 위치가 3개뿐이다. 
		Piece pawnW2 = new Pawn(Color.WHITE, source3);
		
		System.out.println(pawnW2.getPossibleMoves());
		assertEquals(0, pawnW2.getPossibleMoves().size());
	}


}
