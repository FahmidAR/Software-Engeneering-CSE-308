public class onionRings extends appetizerDecorator {

    public onionRings(pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Onion Rings");
    }

    @Override
    public String ingredientDetails() {
        return super.ingredientDetails()+" , Onion Rings";
    }

    @Override
    public int cost() {
        System.out.println("Cost of Onion Rings = "+100);
        return super.cost()+100;
    }
}
