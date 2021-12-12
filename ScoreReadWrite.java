import java.io.*;
public class ScoreReadWrite {
    void getScore()
    {
        File f1 =new File("Score.txt");
        SleepMethod slp1=new SleepMethod();

        try {
            FileReader f2 = new FileReader(f1);

            int i;
            while ((i=f2.read())!=-1)
            {
                System.out.print((char)i);
                slp1.sleep(2);
            }
            f2.close();
        }
        catch (IOException e)
        {
            System.out.println("File Read Error!! Try Again");
        }


    }
    void addScoreRecord(String s)
    {
        File f1 =new File("Score.txt");
        try {
            FileWriter f3 = new FileWriter(f1,true);
            f3.write("\n"+s);
            f3.close();
        }
        catch (IOException e)
        {
            System.out.println("File Write Error!! Try Again");
        }

    }

}
