import java.util.Scanner;


public class TikTacToeGame {
	
	static char [] board = new char[10];
	static int [] boardFill = {0,0,0,0,0,0,0,0,0,0};
	static char userMove ;
	static char computerMove;
	
	public static void main(String[] args) {
		System.out.println(" Welcome start game");
		TikTacToeGame game = new TikTacToeGame();
		game.createBoard();
		game.chooseMove();
		System.out.println( "UserMove : " +userMove + " ComputerMove : " + computerMove);
		
		System.out.println("Board numbering is as follows ");
		System.out.println(" 1 | 2 | 3 \n 4 | 5 | 6 \n 7 | 8 | 9 ");
		System.out.println("Current board position is follows ");
		System.out.println(showcurrentBoard());
		
		int tossOutcome = toss();
		if(tossOutcome == 1) {
			System.out.println("Player is playing ");
			int numberPlayer = userTurn();
			System.out.println(showcurrentBoard());
		}
		else {
			System.out.println("Computer  is playing ");
			int numberComputer = computerTurn();
			System.out.println(showcurrentBoard());
		}
	}
	
	private static int toss() {
		int toss = (int)Math.floor(Math.random()*10)%2 ;
		return toss;
	}
	
	/*userTurn method  player asked to choose position to mark entry
	 to check entry fill condition boaedFill will be check if 0 then return will executed
	 */
	
	private static int computerTurn() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int number = (int)Math.floor(Math.random()*10)%9 + 1;
			if (boardFill[number] == 0) {
				boardFill[number] = 1;
				board[number] = computerMove;
				return number;
			}
		}	
	}
	
	private static int userTurn() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Select the index position where to place mark ");
			int number = sc.nextInt(); 
			if (boardFill[number] == 0) {
				boardFill[number] = 1;
				board[number] = userMove;
				return number;
			}
		}	
	}
	
	//show current board
	private static String showcurrentBoard() {
		return board[1] + " | " + board[2] + " | " + board[3] + "\n" + board[4] + " | " + board[5] + " | " + board[6] + "\n" + board[7] + " | " + board[8] + " | " + board[9];
	}
	//method created for createBoard
	public void createBoard() {
		for (char obj : board) {
			obj = " ".charAt(0);
		}
	}
	// method to assign mark to player
	public void chooseMove() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose what you want to choose X or O ");
		String mark = sc.next().toUpperCase();
		userMove = mark.charAt(0);
		if (mark.equals("X")) {
			computerMove = "O".charAt(0);
		}
		else {
			computerMove = "X".charAt(0);
		}
	}
}
