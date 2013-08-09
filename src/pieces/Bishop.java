package pieces;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();

		PositionController posC = new PositionController(super.position);
		for(int i=0; i<posC.findsDiagonalPositionAll().size(); i++){
			possibleMoves.add(posC.findsDiagonalPositionAll().get(i));
		}
		return possibleMoves;
	}
}

