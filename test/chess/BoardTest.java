package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override	//시작할때마다 보드 생성
	protected void setUp() throws Exception {	
		board = new Board();
	}
	
	//n번째 랭크를 생성하고 비교
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	//전체 보드판이 잘 생성이 되었나 
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	//"a8"이렇게 string으로 검색하면 심볼값이 나오는가  
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	//모두 빈칸으로 초기화되었나 
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	//말 옮기기
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);	//source자리에 흰폰이 있냐?
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	//비어있는 말 옮기기
	public void testWrongMovement() throws Exception {
		board.initialize();
		Position source = new Position("g6");	//(6,5)자리. 비어있다.
		Position target = new Position("g7");	//(6,6)자리. 블랙폰이 있다.

		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.BLACK, target), board.findPiece(target));
	
		System.out.println(board.generateBoard());
	}

	//유효하지 않은 위치 옮기
	public void testWrongTargetMovement() throws Exception {
		board.initialize();
		Position source = new Position("a7");	//(0,7)자리. 블랙이 있다.
		Position target = new Position("a9");	//판을 넘어간 위치다.
		
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.BLACK, source), board.findPiece(source));
	
		System.out.println(board.generateBoard());
	}
}
