package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputSize = scan.nextLine();
        String inputPosition = scan.nextLine();
        String inputCommands = scan.nextLine();
        String[] commands = inputCommands.split(",");

        int width = Integer.parseInt(inputSize.split(",")[0]);
        int height = Integer.parseInt(inputSize.split(",")[1]);
        int x = Integer.parseInt(inputPosition.split(",")[0]);
        int y = Integer.parseInt(inputPosition.split(",")[1]);

        Table table = new Table(width, height, x, y);
        for (String com : commands) {
            int value = Integer.parseInt(com);
            table.movePosition(value);
        }
        scan.close();
    }
}