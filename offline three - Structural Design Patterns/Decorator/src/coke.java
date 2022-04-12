public class coke extends drinkDecorator {
    public coke(pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Coke");
    }

    @Override
    public String ingredientDetails() {
        return super.ingredientDetails()+" , Coke";
    }

    @Override
    public int cost() {
        System.out.println("Cost of Coke = "+20);
        return super.cost()+20;
    }
}
