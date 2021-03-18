package machine;

import java.util.Scanner;

enum State {
    BUY, FILL, TAKE, REMAINING, EXIT, ESPRESSO, Latte, CAPPUCCINO, BACK
        }

public class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);
    State state;
    int water = 400; // ml
    int milk = 540; // ml
    int beans = 120; // g
    int cups = 9; // pieces
    int money = 550; // $


    public void userInput () {
        String str = scanner.next();
        switch (str) {
            case "buy":
                state = State.BUY;
                break;
            case "fill":
                state = State.FILL;
                break;
            case "take":
                state = State.TAKE;
                break;
            case "remaining":
                state = State.REMAINING;
                break;
            case "exit":
                state = State.EXIT;
                break;
            case "1":
                state = State.ESPRESSO;
                break;
            case "2":
                state = State.Latte;
                break;
            case "3":
                state = State.CAPPUCCINO;
                break;
            case "back":
                state = State.BACK;
                break;
            default:
                System.out.println("Wrong Input!");
                break;
        }
    }


    public void mainmenu () {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        userInput();
        switch (state) {
            case BUY:
                buy();
                break;
            case FILL:
                fill();
                break;
            case TAKE:
                take();
                break;
            case REMAINING:
                remaining();
                break;
            case EXIT:
                exit();
                break;
            default:
                mainmenu();
        }
    }


    public void buy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3" +
                " - cappuccino, back - to main menu: ");
        userInput();
        switch (state) {
            case ESPRESSO:
                espresso();
                break;
            case Latte:
                latte();
                break;
            case CAPPUCCINO:
                cappuccino();
                break;
            case BACK:
                back();
                break;
            default:
                buy();
                break;
        }
    }


    public void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
        mainmenu();
    }


    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        mainmenu();
    }


    public void remaining() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        mainmenu();
    }

    public void exit() {
    }


    public void espresso() {
        if (water < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= 250;
            beans -= 16;
            cups--;
            money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        }
        mainmenu();
    }


    public void latte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 20) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups--;
            money += 7;
            System.out.println("I have enough resources, making you a coffee!");
        }
        mainmenu();
    }


    public void cappuccino() {
        if (water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 12) {
            System.out.println("Sorry, not enough coffee beans!");
        }else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups--;
            money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        }
        mainmenu();
    }


    public void back () {
        mainmenu();
    }





    public static void main(String[] args) {

        CoffeeMachine myMachine = new CoffeeMachine();

        myMachine.mainmenu();

    }
}
