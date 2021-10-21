package nix.education.java.chatbot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String name_bot = "My_project#1";
        int years_bot = 2021;
        System.out.println("Hello! My name is " + name_bot);
        System.out.println("I was created in " + years_bot);


        System.out.println("Please, remind me your name");
        String name = scanner.nextLine();
        System.out.println("What a great name you have, "  + name + '!');


        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int age = (a % 3 * 70 + b % 5 * 21 + c % 7 * 15) % 105;
        System.out.println("Your age is " +  age + ';' + "that's a good time to start programming!");


        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.println(i + " !");
        }


        System.out.println("Let's test your programming knowLedge.");
        System.out.println("What is a class?");
        System.out.println("1.A class is a template that describes the general properties of a group of objects.");
        System.out.println("2.A class is a kind of data type");
        System.out.println("3.A class is a special method that is called when a new object is created.");
        System.out.println("4.A class is a characteristic of an object.");
        String ans;
        while (true) {
            ans = scanner.next();
            if (ans.equals("1")) {
                System.out.println("Great, you right!");
                System.out.println("Goodbye, have a nice day!");
                break;
            } else
            {
            System.out.println("Try again");
            }
        }
    }
}
