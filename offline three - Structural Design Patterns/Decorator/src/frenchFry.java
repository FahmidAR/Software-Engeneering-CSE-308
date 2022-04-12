public class frenchFry extends appetizerDecorator {
    public frenchFry(pizza newPizza) {
        super(newPizza);
        System.out.println("Adding  French Fry");
    }

    @Override
    public String ingredientDetails() {
        return super.ingredientDetails()+" ,  French Fry";
    }

    @Override
    public int cost() {
        System.out.println("Cost of  French Fry = "+100);
        return super.cost()+100;
    }
}
