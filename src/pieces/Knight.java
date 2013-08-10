package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();

		PositionController posC = new PositionController(super.position);
		for(int i=0; i<posC.findsKnightPositionAll().size(); i++){
			possibleMoves.add(posC.findsKnightPositionAll().get(i));
		}
		return possibleMoves;
	}
}
