
public class TikTacToeGame {
	public static void main(String[] args) {
		TikTacToeGame game = new TikTacToeGame();
		game.createBoard();
	}
	
	
	public void createBoard() {
		char [] Board = new char[10];
		for (char obj : Board) {
			obj = " ".charAt(0);
		}
	}

}
