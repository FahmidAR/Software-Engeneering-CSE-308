import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    private static Stock P1 = new Stock("P1",3, 40);
    private static Stock P2 = new Stock("P2",4,30);
    private static Stock P3 = new Stock("P3",5,80);
    private static Stock P4 = new Stock("P4",6,25);
    private static Stock P5 = new Stock("P5",7,15);
    private static Stock P6 = new Stock("P6",9,50);

    int port;
    ServerSocket server=null;
    Socket client=null;
    ExecutorService pool = null;
    int client_count=0;

    public static void main(String[] args) throws IOException {


        Server serverobj=new Server(5000);
        serverobj.startServer();
    }

    Server(int port){
        this.port=port;
        pool = Executors.newFixedThreadPool(10);
    }

    public void startServer() throws IOException {

        server=new ServerSocket(5000);
        System.out.println("# Server Engine Started Succesfully #");
        System.out.println("## Press -1 to exit server ##");

        while(true)
        {
            client=server.accept();
            client_count++;
            ServerThread runnable= new ServerThread(client,client_count,this);
            pool.execute(runnable);
        }

    }

    private static class ServerThread implements Runnable {

        Server server=null;
        Socket client=null;
        BufferedReader cin;
        PrintStream cout;
        Scanner sc=new Scanner(System.in);
        String d ;
        String s ;
        String n ;
        int id;

        ServerThread(Socket client, int count ,Server server ) throws IOException {

            this.client=client;
            this.server=server;
            this.id=count;
            System.out.println("Subscriber id [ "+id+" ] Entered the server ");
            //System.out.println("Subscriber id [ "+id+" ] code "+client);

            cin=new BufferedReader(new InputStreamReader(client.getInputStream()));
            cout=new PrintStream(client.getOutputStream());

        }

        @Override
        public void run() {
            int x=1;
            boolean flagD = true ;
            boolean flagP = true ;
            Subscriber subName=new Subscriber("None");;
            String[] words2 = { "BMW", "Ford", "Mazda"};

            try{
                while(true){

                    flagP = true;

                    s=cin.readLine();


                    if(flagD)
                    {
                        System. out.print("Subscriber ("+id+") name :"+s+"\n");
                        n = d ;

                        subName = new Subscriber(s,client);

                        d=   " [ " + P1.showDetailsToObservers()+" ] , "
                                +" [ " + P2.showDetailsToObservers()+" ]  , "
                                +" [ " + P3.showDetailsToObservers()+" ]  , "
                                +" [ "   + P4.showDetailsToObservers()+" ] , "
                                +" [ "   + P5.showDetailsToObservers()+" ] ";
                        flagD =false;
                    }
                    else
                    {
                        System. out.print("Subscriber ("+id+") :"+s+"\n");
                        d="";

                        String[] words = s.split("\\s+");

                        if(words[0].equalsIgnoreCase("S"))
                        {
                            d="Subcription done to " + words[1];

                            if(words[1].equalsIgnoreCase("P1"))
                            {
                                P1.subscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P2.subscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P3.subscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P4.subscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P5.subscribe(subName);
                            }
                        }
                        else if(words[0].equalsIgnoreCase("U"))
                        {
                            d="Unsubcripted to " + words[1];

                            if(words[1].equalsIgnoreCase("P1"))
                            {
                                P1.unsubscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P2.unsubscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P3.unsubscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P4.unsubscribe(subName);
                            }
                            else if(words[1].equalsIgnoreCase("P2"))
                            {
                                P5.unsubscribe(subName);
                            }
                        }


                        System.out.print("Server : ");
                        s=sc.nextLine();
                        words2 = s.split("\\s+");
                    }


                  //  System.out.println(d);



                    //s=stdin.readLine();

                    //s="meu";
                    if (words2[0].equalsIgnoreCase("bye"))
                    {
                        cout.println("BYE buddy ,we closed ");
                        x=0;
                        System.out.println("All Connections ended by server");
                        break;
                    }
                    else if(words2[0].equalsIgnoreCase("I"))
                    {
                        flagP = false;

                        if(words2[1].equalsIgnoreCase("P1"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P1.incStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P2.incStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P3.incStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P4.incStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P5.incStockPrice(t);
                        }
                    }
                    else if(words2[0].equalsIgnoreCase("D"))
                    {
                        flagP = false;

                        if(words2[1].equalsIgnoreCase("P1"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P1.decStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P2.decStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P3.decStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P4.decStockPrice(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            float t =Float.parseFloat(words2[2]);
                            P5.decStockPrice(t);
                        }
                    }
                    else if(words2[0].equalsIgnoreCase("C"))
                    {
                        flagP = false;
                        if(words2[1].equalsIgnoreCase("P1"))
                        {
                            int t=Integer.parseInt(words2[2]);
                            P1.incStockCount(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            int t=Integer.parseInt(words2[2]);
                            P2.incStockCount(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            int t=Integer.parseInt(words2[2]);
                            P3.incStockCount(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            int t=Integer.parseInt(words2[2]);
                            P4.incStockCount(t);
                        }
                        else if(words2[1].equalsIgnoreCase("P2"))
                        {
                            int t=Integer.parseInt(words2[2]);
                            P5.incStockCount(t);
                        }
                    }

                    s=d;

                    if(flagP)
                    {
                        cout.println(s);
                    }


                }


                cin.close();
                client.close();
                cout.close();

                if(x==0) {
                    System.out.println( "Server cleaning up. Bye Bye" );
                    System.exit(0);
                }
            }
            catch(IOException ex){
                System.out.println("Error : "+ex);
            }


        }
    }

}