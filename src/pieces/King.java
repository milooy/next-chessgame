package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		
		//현재 x, y 좌표를 넣어준다.
		int curX = super.position.getX();
		int curY = super.position.getY();
		
		//현재 x, y좌표를 중점으로 둘러싼 좌표들을 구한다. 
		for(int horizon=curX-1; horizon<=curX+1; horizon++){
			for(int vertical=curY-1; vertical<=curY+1; vertical++){
				Position pos = new Position(horizon, vertical);
				if(horizon==curX && vertical==curY)	//자기 자신은 제외한다.
					continue;
				if(pos.isValid())
					possibleMoves.add(pos);
			}
		}
		return possibleMoves;
	}
}

