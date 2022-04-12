import java.util.Scanner;

public class user {

    public static void main(String[] args) {

        System.out.println("Program Editor ");
        System.out.println("Fahmid 1705087 \n");

        while (true){
            System.out.println("Give the file name =");

            Scanner userInput = new Scanner(System.in);
            String input = new String();

            input = userInput.nextLine();
            System.out.println("Your  "+input+" ready for Parse");

            String s[]= input.split("\\.");

            if(s[0].equalsIgnoreCase("Close")){
                break;
            }
            else if (s[1].equalsIgnoreCase("cpp")){
                editor e1 = editor.getInstance();
                e1.parseLanguage(s[1]);
            }
            else if (s[1].equalsIgnoreCase("py")){
                editor e1 = editor.getInstance();
                e1.parseLanguage(s[1]);
            }
            else if (s[1].equalsIgnoreCase("c")){
                editor e1 = editor.getInstance();
                e1.parseLanguage(s[1]);
            }
            else
            {
                System.out.println("Give cpp , c , py format file ");
            }
        }
    }
}
