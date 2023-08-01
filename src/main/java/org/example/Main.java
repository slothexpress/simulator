package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String inputSizeAndStartingPosition = scan.nextLine();
        String inputCommands = scan.nextLine();
        String[] commands = inputCommands.split(",");

        int width = Integer.parseInt(inputSizeAndStartingPosition.split(",")[0]);
        int height = Integer.parseInt(inputSizeAndStartingPosition.split(",")[1]);
        int x = Integer.parseInt(inputSizeAndStartingPosition.split(",")[2]);
        int y = Integer.parseInt(inputSizeAndStartingPosition.split(",")[3]);

        Table table = new Table(width, height, x, y);
        for (String com : commands) {
            int value = Integer.parseInt(com);
            table.moveObject(value);
        }
        scan.close();
    }
}