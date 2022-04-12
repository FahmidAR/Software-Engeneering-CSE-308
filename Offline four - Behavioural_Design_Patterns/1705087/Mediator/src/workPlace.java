import java.util.Scanner;

public class workPlace {

    public static void main(String[] args) {

        System.out.println("### Work Place ###");
        mediatorOrg m =new mediatorOrg();

        while(true)
        {

            System.out.println("Give your command = ");

            Scanner userInput = new Scanner(System.in);
            String input = new String();

            input = userInput.nextLine();
           // System.out.println("You command is "+input+" is ready for Run \n");

            Org1 JWSA = new Org1("JWSA", "WATER",m) ;
            Org2 JPDC = new Org2("JPDC", "ENERGY",m) ;
            Org3 JRTA = new Org3("JRTA", "TRANSPORT",m) ;
            Org4 JTRC = new Org4("JTRC", "TELECOM",m) ;
            OrgMain JCC =new OrgMain("JCC", "MANAGE",m) ;

            if(input.equalsIgnoreCase("Init"))
            {
                System.out.println("All four services are initiated through mediator");

                m.setOrg1(JWSA);
                m.setOrg2(JPDC);
                m.setOrg3(JRTA);
                m.setOrg4(JTRC);
                m.setOrgMain(JCC);
            }
            else if(input.equalsIgnoreCase("close"))
            {
                break;
            }
            else
            {
                String[] words = input.split("\\s+");

                if(words[1].equalsIgnoreCase("SERVE"))
                {
                   // System.out.println("Serve");

                    if(words[0].equalsIgnoreCase("JWSA"))
                    {
                        JCC.giveService(JWSA);
                    }
                    else if(words[0].equalsIgnoreCase("JPDC"))
                    {
                        JCC.giveService(JPDC);
                    }
                    else if(words[0].equalsIgnoreCase("JRTA"))
                    {
                        JCC.giveService(JRTA);
                    }
                    else if(words[0].equalsIgnoreCase("JTRC"))
                    {
                        JCC.giveService(JTRC);
                    }
                }
                else
                {
                   // System.out.println("Req");

                    if(words[0].equalsIgnoreCase("JWSA"))
                    {
                        JWSA.sendMessage(words[1]);
                    }
                    else if(words[0].equalsIgnoreCase("JPDC"))
                    {
                        JPDC.sendMessage(words[1]);
                    }
                    else if(words[0].equalsIgnoreCase("JRTA"))
                    {
                        JRTA.sendMessage(words[1]);
                    }
                    else if(words[0].equalsIgnoreCase("JTRC"))
                    {
                        JTRC.sendMessage(words[1]);
                    }
                }



            }


        }


    }
}
