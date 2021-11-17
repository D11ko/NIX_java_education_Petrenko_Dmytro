package nix.education.java.coffemachine;


public enum   CoffeeType {

    ESPRESSO(300,0,16,1,4),
    LATTE(350,75,20,1,7),
    CAPPUCCINO(200,100,12,1,6);
    private final int water;
    private final int milk;
    private final int coffeBeans;
    private final int cup;
    public final int money;

    CoffeeType(int water, int milk, int coffeBeans, int cup, int money){
        this.water = water;
        this.milk = milk;
        this.coffeBeans = coffeBeans;
        this.cup = cup;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeBeans() {
        return coffeBeans;
    }

    public int getCup() {
        return cup;

    }

    public int getMoney(){
        return money;
    }

}

