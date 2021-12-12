import java.util.Scanner;
import java.io.*;

public class MainClass {
	
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args)throws Exception
    {
        ScoreReadWrite s1=new ScoreReadWrite();
        
		TicTac g1 =new TicTac();
		
		RockPaperScissors r1 =new RockPaperScissors();
        
		DateTime t1 =new DateTime();

        SleepMethod slp1 =new SleepMethod();
        
		System.out.print("Enter your name to login: ");
        
		Scanner sc = new Scanner(System.in);
        
		String name =sc.next();
        
		int choice = 0;

        slp1.strtPage();
		do {
            choice = sc.nextInt();
            System.out.flush();
            CleanScrn.clearScreen();
            switch (choice) {

                case 1: {


                        for(int i = 1;i<=3;i++)
                        {
                            System.out.println("\n \n \n \n\n\n");
                            System.out.println("\t \t \t \t \t \t"+ANSI_YELLOW+ String.valueOf(i)+ANSI_RESET);
                            slp1.sleep(1500);
                            CleanScrn.clearScreen();
                        }
                        System.out.println("\n \n \n \n\n\n");
                        String wel = "\t \t \t \t \t \t Get Ready "+name;
                        for(int i=0;i<wel.length();i++)
                        {
                            System.out.print(wel.charAt(i));
                            if(!String.valueOf(wel.charAt(i)).equals("\t"))
                            slp1.sleep(125);
                        }
                        slp1.sleep(75);
                        System.out.println();
                    String returnStatus=g1.playGame(name, t1.date());
                    if(returnStatus=="WIN")
                    {
                        String loginDetails= String.format("%-30s %-14s    %-15s%s",name,"Tic-Tac-Toe","WIN",t1.date() );
                        s1.addScoreRecord(loginDetails);
                    }
                    else if(returnStatus=="LOST")
                    {
                        String loginDetails= String.format("%-30s %-14s    %-15s%s",name,"Tic-Tac-Toe","LOST",t1.date() );
                        s1.addScoreRecord(loginDetails);
                    }
                    else
                    {
                        String loginDetails= String.format("%-30s %-14s    %-15s%s",name,"Tic-Tac-Toe","DRAW",t1.date() );
                        s1.addScoreRecord(loginDetails);
                    }
                    System.out.println();
                    System.out.println();
                    slp1.strtPage();
                    break;
                }
                case 2: {
					 for(int i = 1;i<=3;i++)
                        {
                            System.out.println("\n \n \n \n\n\n");
                            System.out.println("\t \t \t \t \t \t"+ANSI_YELLOW+ String.valueOf(i)+ANSI_RESET);
                            slp1.sleep(1500);
                            CleanScrn.clearScreen();
                        }
                    System.out.println("\n \n \n \n\n\n");
                        String wel = "\t \t \t \t \t \t Get Ready "+name;
                        for(int i=0;i<wel.length();i++)
                        {
                            System.out.print(wel.charAt(i));
                            if(!String.valueOf(wel.charAt(i)).equals("\t"))
                            slp1.sleep(125);
                        }
                        slp1.sleep(75);
                        System.out.println();
                    System.out.println();
					String returnStatus2 = r1.rockPaper();

					 if(returnStatus2=="WIN")
                    {
                        String loginDetails= String.format("%-30s %-14s    %-15s%s",name,"RockPaperSissor","WIN",t1.date() );
                        s1.addScoreRecord(loginDetails);
                    }
                    else if(returnStatus2=="LOST")
                    {
                        String loginDetails= String.format("%-30s %-14s    %-15s%s",name,"RockPaperSissor","LOST",t1.date() );
                        s1.addScoreRecord(loginDetails);
                    }
                    else
                    {
						String loginDetails= String.format("%-30s %-14s    %-15s%s",name,"RockPaperSissor","DRAW",t1.date() );
                        s1.addScoreRecord(loginDetails);
                    }
					
                    System.out.println();
					
                    slp1.strtPage();
                    break;
                }
                case 3: {
                    CleanScrn.clearScreen();
                    s1.getScore();
                    System.out.println();
                    System.out.println();
                    slp1.strtPage();
                    System.out.println();
                    break;
                }

            }

        }while (choice!=4);


    }
}
