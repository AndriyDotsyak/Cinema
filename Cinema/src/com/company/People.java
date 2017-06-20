package com.company;

public class People {

    private int id;
    private String name;
    private int cashRegister;
    private int hall;
    private int numberTicket;

    public People(int id, String name, int cashRegister, int hall, int numberTicket) {
        this.id = id;
        this.name = name;
        this.cashRegister = cashRegister;
        this.hall = hall;
        this.numberTicket = numberTicket;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCashRegister() {
        return cashRegister;
    }

    public int getHall() {
        return hall;
    }

    public int getNumberTicket() {
        return numberTicket;
    }
}