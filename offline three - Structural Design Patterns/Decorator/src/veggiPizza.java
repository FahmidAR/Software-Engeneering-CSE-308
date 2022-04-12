public class veggiPizza implements pizza{
    public veggiPizza() {
        System.out.println("Adding Veggi Pizza");
    }

    @Override
    public String ingredientDetails() {
        return "Veggi Pizza ";
    }

    @Override
    public int cost() {
        System.out.println("Cost of Veggi Pizza = "+1000);
        return 1000;
    }
}
