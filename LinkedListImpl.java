class LinkedList1
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    Node head;
    static class Node
    {
        Node next;
        int data;
    }
    void add(int x)
    {
        Node newNode =new Node();
        newNode.data=x;
        Node n = head;
        if(head==null)
        {
            head = newNode;
            return;
        }
        while(n.next!=null)
        {
            n=n.next;
        }
        n.next = newNode;
    }
    void display()
    {
        SleepMethod s1 =new SleepMethod();
        int count=0;
        Node n = head;
        while(n!=null)
        {
            System.out.print("Step : "+ ++count);
            System.out.print(ANSI_YELLOW+n.data+"  "+ANSI_RESET);
            s1.sleep(150);
            n=n.next;
        }
    }
}




