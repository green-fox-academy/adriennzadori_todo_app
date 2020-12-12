package com.greenfox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoApp {

    public static void main(String[] args) {
        if (args.length == 0) {
            printInstructions();
        }
        if (args[0].equals("-l")){
            listTasks();
        }
        if (args[0].equals("-a")){
            String task = args[1];
            addTask(task);
        }
    }

    private static void printInstructions() {
        System.out.println("Parancssori Todo applikáció");
        System.out.println("===========================");
        System.out.println();
        System.out.println("Parancssori argumentumok:");
        System.out.println("-l   Kilistázza a feladatokat");
        System.out.println("-a   Új feladatot ad hozzá");
        System.out.println("-r   Eltávolít egy feladatot");
        System.out.println("-c   Teljesít egy feladatot");
    }

    private static List<String> readFile() {
        List<String> lines = new ArrayList<>();

        try {
            File file = new File("Tasks.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return lines;
    }

    private static void listTasks() {
        List<String> lines = readFile();

        if (lines.size() == 0) {
            System.out.println("Nincs mára tennivalód! :)");
            return;
        }

        for (int i = 0; i < lines.size(); i++) {
            String[] line = lines.get(i).split("\\|");
            String checkbox = line[0].isEmpty() ? "[ ] " : "[X] ";
            System.out.println((i + 1) + " - " + checkbox + line[1]);
        }
    }
    private static void addTask(String task) {
        if (task.isEmpty()) {
            System.out.println("Nem lehetséges új feladat hozzáadása: nincs megadva a feladat!");
            return;
        }

        try {
            File file = new File("Tasks.txt");
            Files.write(file.toPath(), ("\n" + "|" + task).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Can't write file.");
            e.printStackTrace();
        }
    }
}
