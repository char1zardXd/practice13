package com.alghoritm;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final String FILEPATH = "file.txt";

    public static int getLineCount() {
        int count = 0;

        File file = new File(FILEPATH);
        if (!file.exists()) return 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {

            while (reader.readLine() != null ) {
                count++;
            }
        } catch(IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        return count + 1;
    }

    static public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true))) {
            System.out.println("Введіть повідомлення: ");
            String message = scanner.nextLine();
            int lineNum = getLineCount();

            writer.write(lineNum + ". " + message);
            writer.newLine();

            System.out.println("Строка {" + message + "} додана до файлу.");
            System.out.println();
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    static public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))){
            String line;

            while ((line = reader.readLine()) != null) {
                if (new File(FILEPATH).length() == 0) {
                    System.out.println("Файл порожній");
                    return;
                }

                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("--=Головне меню=--");
            System.out.println("1. Записати до файлу");
            System.out.println("2. Прочитати увесь зміст файлу");
            System.out.println("3. Вийти з редактору");
            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Введіть число");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                writeToFile();
            } else if (choice == 2) {
                readFile();
            } else if (choice == 3) {
                break;
            }
        }
    }
}