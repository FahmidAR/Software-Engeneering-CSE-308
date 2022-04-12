import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class sumAdapter implements mathSpecial {

    calculate c = new calculate();

    @Override
    public void calculateCharSum(String fileName)  {
        try{
            FileWriter fw=new FileWriter("temp.txt");

            File myFIle = new File(fileName);
            Scanner input = new Scanner(myFIle);
            while (input.hasNextLine()) {
                String data = input.nextLine();
                //System.out.println(data);
                String s[]= data.split(" ");

                int asciOne = (int) s[0].charAt(0);
                int ascitwo = (int) s[1].charAt(0);

                fw.write(asciOne+" "+ascitwo);
            }


            fw.close();
            input.close();


        }catch(Exception e){System.out.println(e);}

        c.calculateSum("temp.txt");

    }
}
