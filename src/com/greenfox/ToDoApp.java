package com.greenfox;

public class ToDoApp {

    public static void main(String[] args) {
        if (args.length == 0) {
            printInstructions();
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
}
