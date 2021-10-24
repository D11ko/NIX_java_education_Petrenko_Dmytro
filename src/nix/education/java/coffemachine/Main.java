package nix.education.java.coffemachine;

import java.util.Scanner;

class CoffeMachine {
    protected int water;
    protected int coffeeBean;
    protected int milk;
    protected int cup;
    protected double money;


    public CoffeMachine(int water, int milk, int coffeeBean, int cup, int money){
        this.water=water;
        this.milk=milk;
        this.coffeeBean=coffeeBean;
        this.cup=cup;
        this.money=money;}

    public boolean examinationEspresso() {

        if ( water>= CoffeeType.ESPRESSO.getWater() &&
                coffeeBean >= CoffeeType.ESPRESSO.getCoffeBeans() &&
                cup >= CoffeeType.ESPRESSO.getCup()) {

            water -= CoffeeType.ESPRESSO.getWater();
            coffeeBean -= CoffeeType.ESPRESSO.getCoffeBeans();
            cup -= CoffeeType.ESPRESSO.getCup();
            money += CoffeeType.ESPRESSO.getMoney();
            return true;
        } else {
            System.out.println("not enough ingredients");
        }
        return false;
    }

    public boolean examinationLatte(){
        if (water >= CoffeeType.LATTE.getWater() &&
                milk >= CoffeeType.LATTE.getMilk()  &&
                coffeeBean >= CoffeeType.LATTE.getCoffeBeans() &&
                cup >= CoffeeType.LATTE.getCup() ) {

            water -= CoffeeType.LATTE.getWater() ;
            milk -= CoffeeType.LATTE.getMilk() ;
            coffeeBean -= CoffeeType.LATTE.getCoffeBeans() ;
            cup -= CoffeeType.LATTE.getCup() ;
            money += CoffeeType.CAPPUCCINO.getMoney();
            return true;
        } else {
            System.out.println("not enough ingredients");
        }
        return false;
    }

    public boolean examinationCapucchino(){
        if (water >= CoffeeType.CAPPUCCINO.getWater() &&
                milk >= CoffeeType.CAPPUCCINO.getMilk() &&
                coffeeBean >= CoffeeType.CAPPUCCINO.getCoffeBeans() &&
                cup >= CoffeeType.CAPPUCCINO.getCup()) {

            water -= CoffeeType.CAPPUCCINO.getWater();
            milk -= CoffeeType.CAPPUCCINO.getMilk();
            coffeeBean -= CoffeeType.CAPPUCCINO.getCoffeBeans();
            cup -= CoffeeType.CAPPUCCINO.getCup();
            money += CoffeeType.CAPPUCCINO.getMoney();
            return true;
        } else {
            System.out.println("not enough ingredients");
        }
        return false;
    }


    public void buy(CoffeeType coffeType ) {

        switch (coffeType) {
            case ESPRESSO:
                examinationEspresso();
                break;
            case LATTE:
                examinationLatte();
                break;
            case CAPPUCCINO:
                examinationCapucchino();
                break;
        }
    }

    public double TakeMoney(){
        double money = this.money;
        this.money = 0;
        return  money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCoffeeBean() {
        return coffeeBean;
    }

    public void setCoffeeBean(int coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {this.money = money;}

    public String showtoIng(){
        return water  + " ml of water\n" +
                milk + " mi of milk\n"+
                coffeeBean  + " of coffee beans\n"+
                cup + " disposable cups\n"+
                money + " of money ";}


    protected void updateIng(int upWater, int upMilk, int upCoffebeans, int upCup){
        water +=upWater;
        milk += upMilk;
        coffeeBean += upCoffebeans;
        cup += upCup;

    }
    protected void updateMoney(){
        money-=money;
    }

    protected void fill(){
        System.out.println("Write how many ml of water you want to add:");
        int upWater = Main.scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int upMilk = Main.scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int upCoffebeans = Main.scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add:");
        int upCup = Main.scanner.nextInt();
        Main.worker.updateIng(upWater, upMilk, upCoffebeans, upCup);
    }
    protected  void buyCoffe(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, or back \n" +
                "if you want to exit the purchase");
        String coffe = Main.scanner.next();
        if (coffe.equals("back")){
        }
        if (coffe.equals("1")) {
            Main.worker.buy(CoffeeType.ESPRESSO);
            System.out.println(Main.worker.showtoIng());
        } else if (coffe.equals("2")) {
            Main.worker.buy(CoffeeType.LATTE);
            System.out.println(Main.worker.showtoIng());
        } else if (coffe.equals("3")) {
            Main.worker.buy(CoffeeType.CAPPUCCINO);
            System.out.println(Main.worker.showtoIng());
        }
    }

    protected void take(){
        System.out.println("I gave you " + Main.worker.money);
        Main.worker.updateMoney();
        System.out.println(Main.worker.showtoIng());
    }

    protected void remaining(){
        System.out.println(Main.worker.showtoIng());
    }


}


public class Main {
    public static final Scanner scanner= new Scanner(System.in);
    public static final CoffeMachine worker = new CoffeMachine(400, 540,120,9,550);

    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining,, exit):");
            String action = scanner.next();
            if (action.equals("exit")){
                break;
            }
            while (true) {
                if (action.equals("buy")) {
                    worker.buyCoffe();
                    break;
                } else if (action.equals("fill")) {
                    worker.fill();
                } else if (action.equals("take")) {
                    worker.take();
                    break;
                }
                else if (action.equals("remaining")){
                    worker.remaining();
                }
                break;
            }
        }
    }
}
