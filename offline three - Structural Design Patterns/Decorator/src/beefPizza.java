public class beefPizza implements pizza {
    public beefPizza() {
        System.out.println("Adding Beef Pizza");
    }

    @Override
    public String ingredientDetails() {
        return "Beef Pizza ";
    }

    @Override
    public int cost() {
        System.out.println("Cost of Beef Pizza = "+2000);
        return 2000;
    }
}
