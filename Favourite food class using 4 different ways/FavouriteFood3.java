class FavouriteFood3 {
    String name;
    String taste;

    void setFood(String n, String t) {
        name = n;
        taste = t;
    }

    void display() {
        System.out.println("Favourite Food: " + name);
        System.out.println("Taste: " + taste);
    }

    public static void main(String[] args) {
        FavouriteFood3 food = new FavouriteFood3();
        food.setFood("Pizza", "Delicious");
        food.display();
    }
}
