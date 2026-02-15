class FavouriteFood2 {
    String name;
    String taste;
    int price;

    FavouriteFood2(String n, String t, int p) {
        name = n;
        taste = t;
        price = p;
    }

    public static void main(String[] args) {
        FavouriteFood2 food = new FavouriteFood2("Pizza", "Cheesy", 300);

        System.out.println(food.name);
        System.out.println(food.taste);
        System.out.println(food.price);
    }
}
