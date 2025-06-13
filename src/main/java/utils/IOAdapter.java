package utils;

import java.util.Scanner;

public class IOAdapter {
    private static IOAdapter Instance;
    private final Scanner scanner;

    private IOAdapter() {
        scanner = new Scanner(System.in);
    }

    public static IOAdapter getInstance() {
        if (Instance == null) {
            Instance = new IOAdapter();
        }
        return Instance;
    }

    public String read() {
        return scanner.nextLine();
    }

    public void write(String output) {
        System.out.println(output);
    }

    public void clearScreen() {
        if (OSData.getOS() == OSData.OS.LINUX) {
            System.out.print("\033[H\033[2J");
        }
    }

    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
