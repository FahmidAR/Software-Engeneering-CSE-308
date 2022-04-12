abstract class appetizerDecorator implements pizza {

    protected pizza basicPizza;

    public appetizerDecorator(pizza newPizza) {

        this.basicPizza = newPizza;
        System.out.println("Adding appetizer");
    }

    @Override
    public String ingredientDetails() {
        return basicPizza.ingredientDetails();
    }

    @Override
    public int cost() {
        return basicPizza.cost();
    }
}
