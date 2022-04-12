import java.util.Scanner;

public class client {

    public static void main(String[] args) {

        System.out.println("Pizza with Decorator ");
        System.out.println("Fahmid 1705087 \n");

        System.out.println("These packs are available = \n");
        System.out.println("1. Beef Pizza with French fry \n" +
                "2. Veggi Pizza with onion rings\n" +
                "3. A combo meal with Veggi Pizza, French Fry and Coke\n" +
                "4. A combo meal with Veggi Pizza, Onion Rings and Coffee\n" +
                "5. A Beef Pizza only\n");

        System.out.println("Give the choice Number =");

        Scanner userInput = new Scanner(System.in);
        String input = new String();

        input = userInput.nextLine();
        System.out.println("You Selected pack  "+input+" is ready for Prepare \n");

        int number = Integer.parseInt(input);
        pizza yummyPizza ;

        switch (number) {
            case 1:
                yummyPizza=new frenchFry(new beefPizza());
                break;
            case 2:
                yummyPizza=new onionRings(new veggiPizza());
                break;
            case 3:
                yummyPizza=new coke(new frenchFry(new veggiPizza()));
                break;
            case 4:
                yummyPizza=new coffee(new onionRings(new veggiPizza()));
                break;
            case 5:
                yummyPizza=new beefPizza();
                break;
            default:
                yummyPizza=new veggiPizza();
                System.out.println("Invalid choice , Defauld Seted ^_^");
        }

        System.out.println("\nIngredients = "+yummyPizza.ingredientDetails());
        System.out.println("\nIngredients Added , Calculating Prize\n");
        System.out.println("\nTotal Cost = "+ yummyPizza.cost());



    }
}
