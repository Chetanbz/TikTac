
public class TikTacToeGame {
	
	static char [] Board = new char[10];
	
	public static void main(String[] args) {
		System.out.println(" Welcome start game");
		TikTacToeGame game = new TikTacToeGame();
		game.createBoard();
	}
	
	//method created for createBoard
	public void createBoard() {
		for (char obj : Board) {
			obj = " ".charAt(0);
		}
	}

}
