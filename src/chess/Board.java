package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.PieceOperations;
import pieces.Position;

public class Board{
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	public BoardStrategy boardStrategy = new BoardConsole();
	
	static List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	//모두 빈칸으로 초기화되었나 
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}


	Piece findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	Piece findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
	
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		Piece targetPiece = findPiece(source);
		Piece sourcePiece = targetPiece.leave();
		
		//옮길 말이 비지 않았고, 유효한 위치면 옮겨준다.
		if(!(targetPiece.isEmpty()) && (target.isValid())){
			if(!(findPiece(source).color==findPiece(target).color) && //같은색말이면 안옮김 
					targetPiece.getPossibleMoves().contains(target)){ //이동할 수 있는 목표지점	
				Rank sourceRank = ranks.get(source.getY());
				sourceRank.move(sourcePiece, source);
				
				Rank targetRank = ranks.get(target.getY());
				targetRank.move(targetPiece, target);
			}
		}
	}
	
	static String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	public String generateBoard() {
		return boardStrategy.generateBoard();
	}

	public void setHonors(BoardStrategy boardStrategy) {
		this.boardStrategy = boardStrategy;
		
	}

}
