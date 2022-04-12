abstract class drinkDecorator extends appetizerDecorator {
    public drinkDecorator(pizza newPizza) {
        super(newPizza);
        System.out.println("Adding drink");
    }

    @Override
    public String ingredientDetails() {
        return super.ingredientDetails();
    }

    @Override
    public int cost() {
        return super.cost();
    }
}
