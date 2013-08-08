package pieces;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		
		//position의 y값에서 x값을 빼준 값 minusGapNum을 구한다. 
		int minusGapNum = super.position.getX() - super.position.getY();
		//position의 y값에서 x값을 더해준 값 plusGapNum을 구한다.
		int plusGapNum = super.position.getY() + super.position.getX();
	
		//current position의 x좌표를 구해 2개 만들어준다. 각각 돌리는데 사용한다.
		int curX1 = super.position.getX();
		int curX2 = super.position.getX();
		
		//임시 포지션 
		Position testPosition;
		
		//좌표가 유효하지 않은 것이 나올때까지 무한루프 
		while(true){
			curX1--;
			curX2++;
			
			//왼쪽 위 대각선 
			testPosition = new Position(curX1, plusGapNum-curX1);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
				
			//왼쪽 아래 대각선 
			testPosition = new Position(curX1, curX1-minusGapNum);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
			
			//오른쪽 아래 대각선 
			testPosition = new Position(curX2, plusGapNum-curX2);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
			
			//오른쪽 위 대각선 
			testPosition = new Position(curX2, curX2-minusGapNum);
			if(testPosition.isValid())
				possibleMoves.add(testPosition);
			
			//네 방향 다 구한 후 유효하지 않은 좌표가 나오면 while을 빠져나간다.
			if(!testPosition.isValid())
				break;
		}

		return possibleMoves;
	}
}

