import java.util.Scanner;


public class TikTacToeGame {
	
	static char [] board = new char[10];
	static char userMove ;
	static char computerMove;
	
	public static void main(String[] args) {
		System.out.println(" Welcome start game");
		TikTacToeGame game = new TikTacToeGame();
		game.createBoard();
		game.chooseMove();
		System.out.println( "UserMove : " +userMove + " ComputerMove : " + computerMove);
	}
	
	//method created for createBoard
	public void createBoard() {
		for (char obj : board) {
			obj = " ".charAt(0);
		}
	}
	
	public void chooseMove() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose what you want to choose X or O ");
		String mark = sc.next();
		userMove = mark.charAt(0);
		if (mark.equals("X")) {
			computerMove = "O".charAt(0);
		}
		else {
			computerMove = "X".charAt(0);
		}
	}
}
