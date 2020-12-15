package com.greenfox.controller;

import com.greenfox.service.TodoServiceImpl;

public class TodoControllerImpl implements TodoController {

    public void chooseUsage(String[] args){
        TodoServiceImpl todoService = new TodoServiceImpl();

        if (args.length == 0) {
            todoService.printInstructions();
        } else if (args[0].equals("-l")) {
            todoService.listTasks();
        } else if (args[0].equals("-a")) {
            String task = args.length > 1 ? args[1] : "";
            todoService.addTask(task);
        } else if (args[0].equals("-r")) {
            String taskNumber = args.length > 1 ? args[1] : "";
            todoService.removeTask(taskNumber);
        } else if (args[0].equals("-c")) {
            String completedTaskNumber = args.length > 1 ? args[1] : "";
            todoService.completeTask(completedTaskNumber);
        } else {
            System.out.println("Nem támogatott argumentum!");
            todoService.printInstructions();
        }
    }
}
