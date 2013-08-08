package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
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
		int minusGapNum = super.position.getX() - super.position.getY();
		int plusGapNum = super.position.getY() + super.position.getX();
		int curX1 = super.position.getX();
		int curX2 = super.position.getX();
		Position testPosition;
		
		while(true){
			curX1--;
			curX2++;
			
			testPosition = new Position(curX1, plusGapNum-curX1);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
			testPosition = new Position(curX1, curX1-minusGapNum);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);

			testPosition = new Position(curX2, plusGapNum-curX2);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
			testPosition = new Position(curX2, curX2-minusGapNum);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
			
			if(!testPosition.isValid())
				break;
		}
		return possibleMoves;
	}
}
