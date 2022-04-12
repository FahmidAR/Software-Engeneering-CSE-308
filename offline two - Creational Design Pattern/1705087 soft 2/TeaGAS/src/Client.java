import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        System.out.println("Tea Gas System ");
        System.out.println("Fahmid 1705087 \n");

        System.out.println("Choose from the available PACKAGES ");
        System.out.println("1.Silver : ATMega32 with load sensor\n2.Gold : Arduino with weight module");
        System.out.println("3.Diamond : Raspberry Pi with load sensor\n4.Platinum : Raspberry Pi with load sensor");

        Scanner userInput = new Scanner(System.in);
        String input = new String();
        String input2 = new String();
        String input3 = new String();

        director d=new director();

        input = userInput.nextLine();
        //System.out.println("You have choosen "+input+" package\n");

        System.out.println("Choose from the available Internet System for the package ");
        System.out.println("1.Wifi\n2.GSM\n3.Ethernet");

        input2 = userInput.nextLine();
        System.out.println("");

        if(input.equalsIgnoreCase("Silver")||input.equalsIgnoreCase("Gold"))
        {
            if(input2.equalsIgnoreCase("Ethernet"))
            {
                System.out.println("Ethernet Not available with this package");
                d.construct(input,"WiFi");
            }
            else
            {
                d.construct(input,input2);
            }
        }
        else
        {
            d.construct(input,input2);
        }

        System.out.println("\nChoose from the available FrameWorks ");
        System.out.println("1.Django\n2.Spring\n3.Laravel");

        input3 = userInput.nextLine();
        System.out.println("You have choosen "+input3+" FrameWorks");
        frameWork f = new frameWorkFactory().getFrameWork(input3);
        f.frameworksNmae();

    }
}
