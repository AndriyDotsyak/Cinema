package com.company;

import java.util.*;

public class Add_Queue implements Runnable {

    private  int id;
    private int name;
    private int cashRegister;
    private int hall;
    private int time;

    public static LinkedList<People> people_1 = new LinkedList<People>();
    public static LinkedList<People> people_2 = new LinkedList<People>();
    public static LinkedList<People> people_3 = new LinkedList<People>();
    private Map<Integer, String> Name = new HashMap<Integer, String>();

    Random rand = new Random();

    Add_Queue() {
        Name();
    }

    private void Random() {
        id = rand.nextInt(1000) + 1000;
        name = rand.nextInt(Name.size());
        cashRegister = rand.nextInt(3) + 1;

        if (Cash_Register.hall_1 < Cash_Register.hallMax_1 && Cash_Register.hall_2 < Cash_Register.hallMax_2) {
            hall = rand.nextInt(2) + 1;
        }
        if (Cash_Register.hall_1 < Cash_Register.hallMax_1 && Cash_Register.hall_2 >= Cash_Register.hallMax_2) {
            hall = 1;
        }
        if (Cash_Register.hall_1 >= Cash_Register.hallMax_1 && Cash_Register.hall_2 < Cash_Register.hallMax_2) {
            hall = 2;
        }

        time = rand.nextInt(2500);
    }

    @Override
    public void run() {
        while (Cash_Register.hall_1 < Cash_Register.hallMax_1 || Cash_Register.hall_2 < Cash_Register.hallMax_2) {
            Random();

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (cashRegister) {
                case 1:
                    people_1.addLast(new People(id, Name.get(name), cashRegister, hall, 0));
                    People last_1 = people_1.getLast();
                    System.out.printf("Enter: ID: %d, Name: %s, Cash Register: %d, Hall: %d \n", last_1.getId(), last_1.getName(), last_1.getCashRegister(), last_1.getHall());
                    break;
                case 2:
                    people_2.addLast(new People(id, Name.get(name), cashRegister, hall, 0));
                    People last_2 = people_2.getLast();
                    System.out.printf("Enter: ID: %d, Name: %s, Cash Register: %d, Hall: %d \n", last_2.getId(), last_2.getName(), last_2.getCashRegister(), last_2.getHall());
                    break;
                case 3:
                    people_3.addLast(new People(id, Name.get(name), cashRegister, hall, 0));
                    People last_3 = people_3.getLast();
                    System.out.printf("Enter: ID: %d, Name: %s, Cash Register: %d, Hall: %d \n", last_3.getId(), last_3.getName(), last_3.getCashRegister(), last_3.getHall());
                    break;
            }
        }
    }

    private void Name() {
        Name.put(0, "Матвій");
        Name.put(1, "Анна");
        Name.put(2, "Максим");
        Name.put(3, "Софія");
        Name.put(4, "Іван");
        Name.put(5, "Анастасія");
        Name.put(6, "Василь");
        Name.put(7, "Марія");
        Name.put(8, "Данило");
        Name.put(9, "Вікторія");
        Name.put(10, "Олександр");
        Name.put(11, "Яна");
        Name.put(12, "Степан");
        Name.put(13, "Вероніка");
        Name.put(14, "Артем");
        Name.put(15, "Злата");
        Name.put(16, "Богдан");
        Name.put(17, "Тетяна");
        Name.put(18, "Денис");
        Name.put(19, "Ангеліна");
        Name.put(20, "Андрій");
        Name.put(21, "Валентина");
        Name.put(22, "Єва");
        Name.put(23, "Владислав");
        Name.put(24, "Соломія");
        Name.put(25, "Маркіян");
        Name.put(26, "Христина");
        Name.put(27, "Марко");
        Name.put(28, "Василина");
        Name.put(29, "Давид");
        Name.put(30, "Дарина");
    }
}