import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Subscriber implements Observer{

    private String subscriberName;
    private Socket sk;

    public String getSubscriberName() {
        return subscriberName;
    }

    public Socket getSk() {
        return sk;
    }

    public Subscriber(String subscriberName)
    {
        this.subscriberName = subscriberName;
    }

    public Subscriber(String subscriberName, Socket sk) {
        this.subscriberName = subscriberName;
        this.sk = sk;
    }

    public String update(String stockName, String change)
    {
        return  "#"+subscriberName +" a update have been done in "+stockName+" changed is "+ change ;
    }

    public static void main(String args[]) throws Exception
    {
        Socket sk=new Socket("127.0.0.1",5000);
        BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
        PrintStream sout=new PrintStream(sk.getOutputStream());
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));

        boolean flag1 = true;
        boolean flag2 = true;

        String s;
        while (  true )
        {
            if(!flag1)
            {
                System.out.print("Subscriber : ");
            }
            else
            {
                System.out.print("Subscriber name : ");
                flag1 = false;
            }

            s= "";

            if(flag2)
            {
                s=stdin.readLine();
                String[] words = s.split("\\s+");

                if(words[0].equalsIgnoreCase("S"))
                {
                    flag2 =false;
                }
                else if(words[0].equalsIgnoreCase("U"))
                {
                    flag2 =false;
                }
            }
            else
            {
                flag2 = true ;
            }

            sout.println(s);
            if ( s.equalsIgnoreCase("BYE") )
            {
                System.out.println("Connection ended by you");
                break;
            }

            s=sin.readLine();
            System.out.print("Server : "+s+"\n");

        }
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }

}