package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		
		//현재 x, y 좌표를 넣어준다.
		int curX = super.position.getX();
		int curY = super.position.getY();
		
		possibleMoves.add(new Position(curX-2, curY-1));
		possibleMoves.add(new Position(curX-2, curY+1));
		possibleMoves.add(new Position(curX+2, curY-1));
		possibleMoves.add(new Position(curX+2, curY+1));
		possibleMoves.add(new Position(curX-1, curY-2));
		possibleMoves.add(new Position(curX-1, curY+2));
		possibleMoves.add(new Position(curX+1, curY-2));
		possibleMoves.add(new Position(curX+1, curY+2));
		
		return possibleMoves;
	}
}
