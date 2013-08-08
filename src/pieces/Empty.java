package pieces;

import java.util.ArrayList;
import java.util.List;

public class Empty extends Piece {
	public Empty(Color color, Position position) {
		super(color, Type.EMPTY, position);
	}

	
	//비어있는 리스트를 리턴해준다.
	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		return possibleMoves;

	}
}
