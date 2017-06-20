package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            new Thread(new Cash_Register(), "" + i).start();
        }

        new Thread(new Add_Queue(), "Add_Queue").start();
    }
}
