package chess;

public class BoardHtml implements BoardStrategy{
	@Override
	public String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = Board.ROW_SIZE; i > 0; i--) {
			sb.append(Board.generateRank(i-1) + Board.NEW_LINE);
		}
		sb.append("This is Html");
		return sb.toString();
	}

}
