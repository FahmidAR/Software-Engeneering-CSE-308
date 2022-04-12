import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class calculate {

    public void calculateSum(String fileName)
    {
        int sum = 0 ;
        try {
            File myFIle = new File(fileName);
            Scanner input = new Scanner(myFIle);
            while (input.hasNextLine()) {
                String data = input.nextLine();
                //System.out.println(data);
                String s[]= data.split(" ");

                sum = Integer.parseInt(s[0])+Integer.parseInt(s[1]);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening file");
            e.printStackTrace();
        }
        System.out.println("The Sum is "+sum);
    }
}
