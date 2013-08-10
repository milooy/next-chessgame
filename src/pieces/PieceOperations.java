package pieces;

import pieces.Piece.Color;

public interface PieceOperations {
	char getSymbol();
	boolean isEmpty();
	boolean matchColor(Color color);
	Piece leave();
	

}
