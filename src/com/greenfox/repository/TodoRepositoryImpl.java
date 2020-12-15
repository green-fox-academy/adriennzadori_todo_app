package com.greenfox.repository;

import com.greenfox.model.TodoItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoRepositoryImpl implements TodoRepository {

    public List<TodoItem> readFile() {
        List<TodoItem> todos = new ArrayList<>();

        try {
            File file = new File("Tasks.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";");
                TodoItem item = new TodoItem(fields[0], Boolean.parseBoolean(fields[1]));
                todos.add(item);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return todos;
    }

    public void writeFile(List<TodoItem> todoItems) {
        try {
            List<String> lines = new ArrayList<>();

            for (TodoItem item : todoItems) {
                lines.add(item.toString());
            }

            Files.write(Paths.get("Tasks.csv"), lines);
        } catch (IOException e) {
            System.out.println("Can't write file.");
            e.printStackTrace();
        }
    }
}
