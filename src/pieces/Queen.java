package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		
		//linear position
		for(int x=0; x<chess.Board.COLUMN_SIZE; x++){
			if(x==super.position.getX())
				continue;
			possibleMoves.add(new Position(x, super.position.getY()));
			}
		
		for(int y=0; y<chess.Board.ROW_SIZE; y++){
			if(y==super.position.getY())
				continue;
			possibleMoves.add(new Position(super.position.getX(), y));
		}
		
		//Diagonal Position
		PositionController posC = new PositionController(super.position);
		for(int i=0; i<posC.findsDiagonalPositionAll().size(); i++){
			possibleMoves.add(posC.findsDiagonalPositionAll().get(i));
		}
		return possibleMoves;
	}
}
