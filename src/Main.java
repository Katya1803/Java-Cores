import a.example.ExampleOption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.print("Choose your choice: ");
            int choice = scanner.nextInt();
            ExampleOption selectedOption = ExampleOption.fromOptionNumber(choice);
            if (selectedOption != null) {
                if (selectedOption == ExampleOption.EXIT) {
                    System.out.println("Exit.");
                    scanner.close();
                    break;
                } else {
                    selectedOption.getExample().run();
                }
            } else {
                System.out.println("Choice is not valid.");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("Choose your topic:");
        for (ExampleOption option : ExampleOption.values()) {
            System.out.println(option.getOptionNumber() + ". " + option.getDescription());
        }
    }
}
