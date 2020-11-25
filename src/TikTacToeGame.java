import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TikTacToeGame {
	
	static char [] board = new char[10];
	static int [] boardFill = {1,0,0,0,0,0,0,0,0,0};
	static int []boardFinal = {(boardFill[1]+boardFill[2]+boardFill[3]),(boardFill[4]+boardFill[5]+boardFill[6]),(boardFill[7]+boardFill[8]+boardFill[9]),(boardFill[1]+boardFill[4]+boardFill[7]),(boardFill[2]+boardFill[5]+boardFill[8]),(boardFill[3]+boardFill[6]+boardFill[9]),(boardFill[1]+boardFill[5]+boardFill[9]),(boardFill[3]+boardFill[5]+boardFill[7])};
	static char userMove ;
	static char computerMove;
	static List computerPositions = new ArrayList();
	static List userPositions = new ArrayList();
	static int desired=0;
	
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
				userPositions.add(numberPlayer);
				tossOutcome = 0;
			}
			else {
				System.out.println("Computer  is playing ");
				win();
				if (desired ==0) {
					int numberComputer = computerTurn();
					computerPositions.add(numberComputer);
					System.out.println(showcurrentBoard());
					tossOutcome = 1;
				}
				else {
					board[desired] =computerMove;
					System.out.println(showcurrentBoard());
				}
			}
			if(winnerCondition()) {
				System.out.println(" Winner decided ");
				break;
			}
			else if(tieCondition()) {
				System.out.println("Game tie  ");
				break;
			}
			//check3();
			System.out.println(Arrays.toString(boardFinal));
			//System.out.println(Arrays.toString(board));
			System.out.println("UserPositions : " +  userPositions + " ComputerPosition : " +computerPositions);
			//win();
			System.out.println("Desired" + desired);
			//System.out.println(Arrays.toString(winningStrategy()));
		}
	}	
	public static void check3() {
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			for(int k :boardFinal[i]) {
				sum = sum + boardFinal[i][k];
			}
			sumInt[i] = sum;
		}
	}
	
	
	private static void win() {
		Outer:
		for (int i =1; i <=7; i = i+3) {
			char [] subArray = Arrays.copyOfRange(board, (i+0), (i+3));
			System.out.println(Arrays.toString(subArray));
			int count = 0;
			for (char element :subArray) {
				if(element == userMove) {
					break;
				}
				else if(element == computerMove) {
					count++;
				}
				if (count == 2) {
					for (int k =0; k<3;i++) {
						if(subArray[k] == " ".charAt(0)) {
							desired = k +i;
							break Outer;
						}
					}
				}
			}
		}
	}
	
	private static int toss() {
		int toss = (int)Math.floor(Math.random()*10)%2 ;
		return toss;
	}
	
	public void check() {
		
	}
	
	/*userTurn method  player asked to choose position to mark entry
	 to check entry fill condition boaedFill will be check if 0 then return will executed
	 */
	
	private static int computerTurn() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int number = (int)Math.floor(Math.random()*10)%9 + 1;
			if (boardFill[number] == 0) {
				boardFill[number] = 3;
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
	
	private static boolean winnerCondition() {
		for (int i =1; i<=7 ; i = i+3) {
			if((board[i] == board[i+1] && board[i] == board[i+2]) && boardFill[i] == 1 ) {
				return true;
			}
		}
		for (int i =1; i<=3 ; i++) {
			if((board[i] == board[i+3] && board[i] == board[i+6]) && boardFill[i] == 1 ) {
				return true;
			}
		}
	 //boolean condition1 = ((board[1] == board[2] && board[1] == board[3]) && boardFill[1] == 1 ) || ((board[1] == board[4] && board[1] == board[7]) && boardFill[1] == 1 ) || ((board[3] == board[6] && board[3] == board[9]) && boardFill[3] == 1 ) || ((board[7] == board[8] && board[7] == board[9]) && boardFill[7] == 1 ) || ((board[2] == board[5] && board[2] == board[8]) && boardFill[2] == 1 )|| ((board[4] == board[5] && board[5] == board[6]) && boardFill[4] == 1 );
	 boolean diagonal   = ((board[1] == board[5] && board[1] == board[9]) && boardFill[1] == 1  ) || ((board[3] == board[5] && board[3] == board[7]) && boardFill[3] == 1  );
	 return (diagonal);
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
	public static void winningStrategy() {
		for (Object j : computerPositions) {
		int computerPosition = (int)j;
		// Calculate row and column for given position
		int col = computerPosition % 3;
		int row = 0;
		if (computerPosition <=3) {
			row = 1;
		}
		else if (computerPosition <=6) {
			row =2;
		}
		else {
			row = 3;
		}
		
		// Decide pointer limit
		int horizontalMin = 1 - row ;
		int horizontalMax = 3 - row ;
		int verticallMin =  1 - col ;
		int verticalMax =   3 - col ;
		
		char [] boardComputer = {" ".charAt(0)," ".charAt(0)," ".charAt(0)};
		int count =0;
		for(int i = horizontalMin; i<=horizontalMax; i++) {
			boardComputer[count] = board[computerPosition+i];
		
		}
		
		/*for(int i = horizontalMin; i<=horizontalMax; i++) {
			if (computerPosition == i) {
				continue;
			}
			if (board[computerPosition+i] == userMove) {
				break;
			}
			if (board[computerPosition+i] == board[computerPosition]) {
				
			}
		}*/
	}
		//return boardComputer;
	}

	
}
