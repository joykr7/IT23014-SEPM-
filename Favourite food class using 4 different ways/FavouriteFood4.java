class FavouriteFood4 {
    private String name;
    private int price;

    public void setFood(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static void main(String[] args) {
        FavouriteFood4 food = new FavouriteFood4();
        food.setFood("Pizza", 300);

        System.out.println("Food: " + food.getName());
        System.out.println("Price: " + food.getPrice());
    }
}
