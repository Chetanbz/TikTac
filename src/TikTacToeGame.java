import java.util.Arrays;
import java.util.Scanner;


public class TikTacToeGame {
	
	static char [] board = new char[10];
	static int [] boardFill = {1,0,0,0,0,0,0,0,0,0};
	static char userMove ;
	static char computerMove;
	static int desired = 0;
	
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
			System.out.println(Arrays.toString(boardFill));
			System.out.println(Arrays.toString(board));
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
			if(winningStrategy()) {
				int number = desired;
				boardFill[number] = 1;
				board[number] = computerMove;
				return number;
			}
			else if(blockStrategy()) {
				int number = desired;
				boardFill[number] = 1;
				board[number] = computerMove;
				return number;
			}
			else if(cornerAvailable()) {
				int number = desired;
				boardFill[number] = 1;
				board[number] = computerMove;
				return number;
			}
			else if(middleAvailable()) {
				int number = desired;
				boardFill[number] = 1;
				board[number] = computerMove;
				return number;
			}
			else {
				int number = (int)Math.floor(Math.random()*10)%9 + 1;
				if (boardFill[number] == 0) {
					boardFill[number] = 1;
					board[number] = computerMove;
					return number;
				}
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
	private static boolean winningStrategy() {
		for (int i =1; i <=9; i++) {
			if (boardFill[i] == 0) {
				board[i] = computerMove;
				boardFill[i] = 1;
				if (winnerCondition()) {
					desired = i; 
					return true;
				}
				else {
					board[i] = " ".charAt(0);
					boardFill[i] =0;
				}
			}
		}
		return false;
	}
	private static boolean blockStrategy() {
		for (int i =1; i <=9; i++) {
			if (boardFill[i] == 0) {
				board[i] = userMove;
				boardFill[i] = 1;
				if (winnerCondition()) {
					desired = i; 
					board[i] = " ".charAt(0);
					return true;
				}
				else {
					board[i] = " ".charAt(0);
					boardFill[i] = 0;
				}
			}
		}
		return false;
	}
	private static boolean cornerAvailable() {
		if (boardFill[1] ==0) {
			desired = 1;
			return true;
		}
		else if (boardFill[3]==0) {
			desired = 3;
			return true;	
		}
		else if (boardFill[7] ==0) {
			desired = 7;
			return true;
		}
		else if (boardFill[9] ==0) {
			desired = 9;
			return true;
		}
		else {
			return false;
		}
	}
	private static boolean middleAvailable() {
		if (boardFill[5] == 0) {
			desired = 5;
			return true;
		}
		else {
			return false;
		}
	}
	
	private static boolean winnerCondition() {
	 boolean conditionhor1 = ((board[1] == board[2] && board[1] == board[3]) && boardFill[1] == 1 );
	 boolean conditionhor2 = ((board[4] == board[5] && board[4] == board[6]) && boardFill[4] == 1 );
	 boolean conditionhor3 = ((board[7] == board[8] && board[7] == board[9]) && boardFill[7] == 1 );
	 boolean conditionver1 = ((board[1] == board[4] && board[1] == board[7]) && boardFill[1] == 1 );
	 boolean conditionver2 = ((board[2] == board[5] && board[2] == board[8]) && boardFill[2] == 1 );
	 boolean conditionver3 = ((board[3] == board[6] && board[3] == board[9]) && boardFill[3] == 1 );
	 boolean diagonal1     = ((board[9] == board[5] && board[1] == board[9]) && boardFill[1] == 1 );
	 boolean diagonal2     = ((board[3] == board[5] && board[3] == board[7]) && boardFill[3] == 1 );
	 
	 return (conditionhor1 || conditionhor2 || conditionhor3 || conditionver1 || conditionver2 || conditionver3 || diagonal1 || diagonal2);
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
	// method to assign mark to playeras
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