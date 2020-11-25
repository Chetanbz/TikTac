import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TikTacToeGame {
	
	static char [] board = new char[10];
	static int [] boardFill = {0,0,0,0,0,0,0,0,0,0};
	static int [] sumBoard  = new int[8];
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
		while(true) {
			if(tossOutcome == 1) {
				System.out.println("Player is playing ");
				int numberPlayer = userTurn();
				System.out.println(showcurrentBoard());
				tossOutcome = 0;
			}
			else {
				System.out.println("Computer  is playing ");
				int numberComputer = computerTurn();
				System.out.println(showcurrentBoard());
				tossOutcome = 1;
			}
			if(winnerCondition()) {
				System.out.println(" Winner decided ");
				break;
			}
			else if(tieCondition()) {
				System.out.println("Game tie  ");
				break;
			}
			updateBoard();
			//System.out.println(Arrays.toString(boardFill));
			//System.out.println(Arrays.toString(board));
			//System.out.println(Arrays.toString(sumBoard));
		}
	}
	public static void updateBoard() {
		sumBoard[0] = boardFill[1]+boardFill[2]+boardFill[3];
		sumBoard[1] = boardFill[4]+boardFill[5]+boardFill[6];
		sumBoard[2] = boardFill[7]+boardFill[8]+boardFill[9];
		sumBoard[3] = boardFill[1]+boardFill[4]+boardFill[7];
		sumBoard[4] = boardFill[2]+boardFill[5]+boardFill[8];
		sumBoard[5] = boardFill[3]+boardFill[6]+boardFill[9];
		sumBoard[6] = boardFill[1]+boardFill[5]+boardFill[9];
		sumBoard[7] = boardFill[3]+boardFill[5]+boardFill[7];
	}
	
	public static boolean winner() {
		for(int i =0; i<=7; i++) {
			sumBoard[i] = 2;
			return true;
		}
			return false;
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
				boardFill[number] = 3;
				board[number] = userMove;
				return number;
			}
		}	
	}
	
	private static boolean winnerCondition() {
	 boolean condition1 = ((board[1] == board[2] && board[1] == board[3]) && boardFill[1] == 1 ) || ((board[1] == board[4] && board[1] == board[7]) && boardFill[1] == 1 ) || ((board[3] == board[6] && board[3] == board[9]) && boardFill[3] == 1 ) || ((board[7] == board[8] && board[7] == board[9]) && boardFill[7] == 1 );
	 boolean diagonal   = ((board[1] == board[5] && board[1] == board[9]) && boardFill[1] == 1  ) || ((board[3] == board[5] && board[3] == board[7]) && boardFill[3] == 1  );
	 return (condition1||diagonal);
	}
	public static boolean tieCondition() {
		for (int entry : boardFill) {
			if ( entry == 0 ) {
				return false;
			}
		}
		return true;
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
