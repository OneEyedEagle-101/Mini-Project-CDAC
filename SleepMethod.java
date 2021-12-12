public class SleepMethod {

    void sleep(int x)
    {
        try {
            Thread.sleep(x);
        }
        catch (Exception e){};
    }
    void strtPage()
    {
        SleepMethod slp1 =new SleepMethod();
        System.out.println("If you want to play Tic-Tac-Toe press        -  1");
        slp1.sleep(150);
        System.out.println("If you want to play Stone-Paper-Sissor press -  2");
        slp1.sleep(150);
        System.out.println("If you want to check Score Board press       -  3");
        slp1.sleep(150);
        System.out.println("If you want Exit Console Press               -  4");
        slp1.sleep(150);
    }

}
