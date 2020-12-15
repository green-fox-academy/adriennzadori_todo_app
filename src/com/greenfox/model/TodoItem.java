package com.greenfox.model;

public class TodoItem {
    String name;
    boolean completed;

    public TodoItem(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return name + ";"  + completed;
    }
}
