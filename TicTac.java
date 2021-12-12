import  java.util.*;
import java.util.regex.Pattern;
public class TicTac {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	static String[] board;
	static String turn;
	static String symbol;
	static String WinCheck(String name)
	{
		for (int i = 0; i < 8; i++) {
			String line = null;

			switch (i){
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}

			if (line.equals("XXX")||line.equals("xxx")) 
			{
				return name;
			}
			else if (line.equals("OOO")||line.equals("ooo")) 
			{
				return "CPU";
			}
		}
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}
		System.out.println(
			turn +" turn; enter a slot number to place "
			+ symbol + " in:");
		return null;
	}
	static void printBoard(String name,String time)
	{
		CleanScrn.clearScreen();
		System.out.println();
		System.out.println("Player Name- "+"\t\t\t Login time - ");
		System.out.println( ANSI_RED_BACKGROUND+name+"\t\t\t\t "+ time+" "+ANSI_RESET+" ");
		System.out.println();
		System.out.println("\t\t  " + ANSI_YELLOW+board[0]+ANSI_RESET+ " | "
						+ ANSI_YELLOW+board[1] + ANSI_RESET+" | " + ANSI_YELLOW+board[2]+ANSI_RESET
						+ "  ");
		System.out.println("\t\t----+---+----");
		System.out.println("\t\t  " + ANSI_YELLOW+board[3] +ANSI_RESET+" | "
						+ANSI_YELLOW +board[4] +ANSI_RESET+ " | " +ANSI_YELLOW+board[5]+ANSI_RESET
						+ "  ");
		System.out.println("\t\t----+---+----");
		System.out.println("\t\t  " +ANSI_YELLOW+ board[6]+ANSI_RESET+ " | "
						+ ANSI_YELLOW+board[7] +ANSI_RESET+ " | " +ANSI_YELLOW+ board[8]
						+ ANSI_RESET+"  ");
		System.out.println();
	}

	static String playGame(String name,String time )
	{
		board = new String[9];
		turn = name ;
		symbol="X";
		LinkedList1 l1 =new LinkedList1();
		LinkedList1 l2 =new LinkedList1();
		SleepMethod slp1 = new SleepMethod();
		String winner = null;
		Scanner sc =new Scanner(System.in);
		for (int a = 0; a < 9; a++) {
			board[a] = Integer.toString(a+1);
		}

		System.out.println("Welcome "+name);
		printBoard(name,time);

		System.out.println(
			turn+" will play first. Enter a slot number to place X in:");

		while (winner == null) {
			String numInput1;
			try{
			    numInput1 = sc.next();
				if (Pattern.matches("[^0-9]",numInput1)) {
					System.out.println(
						"Invalid input; re-enter slot number:");
					continue;
				}
			int numInput = Integer.parseInt(numInput1);
			
			if (board[numInput - 1].equals(
					String.valueOf(numInput))) {
				board[numInput - 1] = symbol;

				if (turn.equals(name)) {
					turn = "CPU";
					l1.add(numInput);
					symbol="O";
				}
				else {
					turn = name;
					l2.add(numInput);
					symbol="X";
				}

				printBoard(name,time);
				winner =WinCheck(name);
			}
			else {
				System.out.println("Slot already taken, Please re-enter slot number:");
			}
			}
			catch(Exception e)
			{
				System.out.println("Wrong input, Please enter correct value");
			}
		}
		if (winner.equalsIgnoreCase("draw"))
		{
			System.out.println("It's a draw! Thanks for playing.");
			return "DRAW";
		}
		else {
			if(winner.equals(name) ) {
				String win =
						ANSI_RED_BACKGROUND+"Congratulations! "+ANSI_RESET + ANSI_YELLOW + winner
								+ ANSI_RESET + " you have won! Thanks for playing.";
				for(int i=0; i < win.length();i++)
				{
					System.out.print(win.charAt(i));
					slp1.sleep(50);
				}
				System.out.println();
				System.out.println();
				System.out.println("Steps Played by "+name);
				l1.display();
				System.out.println();
				System.out.println();
				System.out.println("Steps Played by "+"CPU");
				l2.display();
				return "WIN";
			}
			else if(winner.equals("CPU"))
			{
				String lose="Sorry CPU WON...You "+ANSI_RED_BACKGROUND+"LOSE"+ANSI_RESET;
				for(int i=0; i < lose.length();i++)
				{
					System.out.print(lose.charAt(i));
					slp1.sleep(50);
				}

				System.out.println();
				System.out.println();
				System.out.println("Steps Played by "+name);
				l1.display();
				System.out.println();
				System.out.println("Steps Played by "+"CPU");
				l2.display();
				return "LOST";
			}
		}
		return "DRAW";
	}
}
