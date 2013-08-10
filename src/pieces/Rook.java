package pieces;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();

		//position을 기준으로 가로줄의 position들을 add해준다. 자기 자신은 빼준다. 	
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
		return possibleMoves;
	}
}
