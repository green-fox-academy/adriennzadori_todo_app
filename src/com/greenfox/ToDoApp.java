package com.greenfox;

import com.greenfox.controller.TodoControllerImpl;

public class ToDoApp {

    public static void main(String[] args) {
        TodoControllerImpl controller = new TodoControllerImpl();
        controller.chooseUsage(args);
    }
}
