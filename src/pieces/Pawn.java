package pieces;

import java.util.ArrayList;
import java.util.List;

import chess.Board;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> possibleMoves = new ArrayList<Position>();
		
		//현재 x, y 좌표를 넣어준다.
		int curX = super.position.getX();
		int curY = super.position.getY();
		
		//white pawn이라면, 한 칸 위로 올라간 위치 추가. 
		if(super.color==Color.WHITE){
			if(curX==1)	//시작위치면 2칸 이동도 add해준다.
				possibleMoves.add(new Position(curX, curY+2));
			
			Position posW = new Position(curX, curY+1);
			if(posW.isValid())
				possibleMoves.add(posW);
		}
		
		//black pawn이라면, 한 칸 밑으로 내려간 위치 추가. 
		 if(super.color==Color.BLACK){
			if(curX==6)	//시작위치면 2칸 이동도 add해준다.
				possibleMoves.add(new Position(curX, curY-2)); 
			 
			Position posB = new Position(curX, curY-1);
			if(posB.isValid())
				possibleMoves.add(posB);
		 }
		 
		return possibleMoves;
	}
}
