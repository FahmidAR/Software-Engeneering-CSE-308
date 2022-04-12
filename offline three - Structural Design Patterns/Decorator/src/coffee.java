public class coffee extends drinkDecorator {
    public coffee(pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Onion Coffee");
    }

    @Override
    public String ingredientDetails() {
        return super.ingredientDetails()+" , Coffee";
    }

    @Override
    public int cost() {
        System.out.println("Cost of Coffee = "+50);
        return super.cost()+50;
    }
}
