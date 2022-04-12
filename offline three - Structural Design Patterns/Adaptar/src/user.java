import java.util.Scanner;

public class user {

    public static void main(String[] args) {

        System.out.println("Sum with Adapter ");
        System.out.println("Fahmid 1705087 \n");


        System.out.println("Give the file name =");

        Scanner userInput = new Scanner(System.in);
        String input = new String();

        input = userInput.nextLine();
        System.out.println("Your  "+input+" ready for Calculate");

        mathSpecial m = new sumAdapter();
        m.calculateCharSum(input);

    }
}
