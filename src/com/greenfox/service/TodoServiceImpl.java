package com.greenfox.service;

import com.greenfox.model.TodoItem;
import com.greenfox.repository.TodoRepositoryImpl;

import java.util.List;

public class TodoServiceImpl implements TodoService {

    public void printInstructions() {
        System.out.println("Parancssori Todo applikáció");
        System.out.println("===========================");
        System.out.println();
        System.out.println("Parancssori argumentumok:");
        System.out.println("-l   Kilistázza a feladatokat");
        System.out.println("-a   Új feladatot ad hozzá");
        System.out.println("-r   Eltávolít egy feladatot");
        System.out.println("-c   Teljesít egy feladatot");
    }

    public void listTasks() {
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        List<TodoItem> todoItems = todoRepository.readFile();

        if (todoItems.size() == 0) {
            System.out.println("Nincs mára tennivalód! :)");
            return;
        }

        int number = 1;

        for (TodoItem item : todoItems) {
            String checkbox = item.isCompleted() ? "[X] " : "[ ] ";
            System.out.println(number + " - " + checkbox + item.getName());
            number++;
        }
    }

    public void addTask(String task) {
        if (task.isEmpty()) {
            System.out.println("Nem lehetséges új feladat hozzáadása: nincs megadva a feladat!");
            return;
        }

        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        List<TodoItem> todoItems = todoRepository.readFile();
        todoItems.add(new TodoItem(task, false));
        todoRepository.writeFile(todoItems);
    }

    public void removeTask(String taskNumber) {
        if (taskNumber.isEmpty()) {
            System.out.println("Nem lehetséges az eltávolítás: nem adott meg indexet!");
            return;
        }

        try {
            TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
            List<TodoItem> todoItems = todoRepository.readFile();
            todoItems.remove(Integer.parseInt(taskNumber) - 1);
            todoRepository.writeFile(todoItems);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Nem lehetséges az eltávolítás: túlindexelési probléma adódott!");
        } catch (NumberFormatException n) {
            System.out.println("Nem lehetséges az eltávolítás: a megadott index nem szám!");
        }
    }

    public void completeTask(String completedTaskNumber) {
        if (completedTaskNumber.isEmpty()) {
            System.out.println("Nem lehetséges a feladat végrehajtása: nem adtál meg indexet!");
            return;
        }

        try {
            TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
            List<TodoItem> todoItems = todoRepository.readFile();
            todoItems.get(Integer.parseInt(completedTaskNumber) - 1).setCompleted(true);
            todoRepository.writeFile(todoItems);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Nem lehetséges a feladat végrehajtása: túlindexelési probléma adódott!");
        } catch (NumberFormatException n) {
            System.out.println("Nem lehetséges a feladat végrehajtása: a megadott index nem szám!");
        }
    }
}
