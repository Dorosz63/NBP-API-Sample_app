package it.dorosz.examples;

import java.util.Scanner;

public class Menu {

    private static String inputData;

    public void readUserInput() {
        System.out.print("\n--------------------------\nExample of NBP API request\n--------------------------\n\n");

        StringBuilder inputData = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type three letter currency code (ex. EUR): ");
        inputData.append(scanner.nextLine());
        inputData.append("/");

        System.out.print("Type start date (ex. 2017-11-20): ");
        inputData.append(scanner.nextLine());
        inputData.append("/");

        System.out.print("Type end date (ex. 2017-11-24): ");
        inputData.append(scanner.nextLine());
        System.out.println();

        this.inputData = inputData.toString();
    }

    public String getInputData() {
        return inputData;
    }
}
