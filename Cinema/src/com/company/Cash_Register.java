package com.company;

import java.util.*;

public class Cash_Register implements Runnable {
    public static final int hallMax_1 = 5;
    public static final int hallMax_2 = 10;
    public static int hall_1;
    public static int hall_2;

    private LinkedList<Integer> numberTicket_1 = new LinkedList<Integer>();
    private LinkedList<Integer> numberTicket_2 = new LinkedList<Integer>();
    private int randNumberTicket_1;
    private int randNumberTicket_2;

    Cash_Register() {
        for (int i = 0; i < hallMax_1; i++) {
            numberTicket_1.add(i, i+1);
        }
        for (int i = 0; i < hallMax_2; i++ ) {
            numberTicket_2.add(i, i+1);
        }
    }

    private synchronized void NumberTicket(int numberTicket) {
        Random rand = new Random();
        int rand_1;
        int rand_2;

        if (numberTicket == 1) {
            rand_1 = rand.nextInt(numberTicket_1.size());

            randNumberTicket_1 = numberTicket_1.get(rand_1);
            numberTicket_1.remove(rand_1);
        }
        if (numberTicket == 2) {
            rand_2 = rand.nextInt(numberTicket_2.size());

            randNumberTicket_2 = numberTicket_2.get(rand_2);
            numberTicket_2.remove(rand_2);
        }
    }

    @Override
    public void run() {
        int cashRegister = Integer.parseInt(Thread.currentThread().getName());
        Random rand = new Random();

        while (hall_1 < hallMax_1 || hall_2 < hallMax_2) {
            switch (cashRegister) {
                case 1:
                    int millis_1 = rand.nextInt(400) +800;
                    try {
                        Thread.sleep(millis_1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Add_Queue.people_1.isEmpty() == false) {
                        People people_1_Get = Add_Queue.people_1.getFirst();

                        if (people_1_Get.getHall() == 1) {
                            NumberTicket(1);
                            hall_1++;

                            System.out.printf("Exit: ID: %d, Name: %s, Cash Register: %d, Hall: %d, Number Ticket: %d \n",
                                    people_1_Get.getId(), people_1_Get.getName(), people_1_Get.getCashRegister(), people_1_Get.getHall(), randNumberTicket_1);

                            Add_Queue.people_1.removeFirst();
                        }
                        if (people_1_Get.getHall() == 2) {
                            NumberTicket(2);
                            hall_2++;

                            System.out.printf("Exit: ID: %d, Name: %s, Cash Register: %d, Hall: %d, Number Ticket: %d \n",
                                    people_1_Get.getId(), people_1_Get.getName(), people_1_Get.getCashRegister(), people_1_Get.getHall(), randNumberTicket_2);

                            Add_Queue.people_1.removeFirst();
                        }
                    }
                    break;
                case 2:
                    int millis_2 = rand.nextInt(400) +800;
                    try {
                        Thread.sleep(millis_2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Add_Queue.people_2.isEmpty() == false) {
                        People people_2_Get = Add_Queue.people_2.getFirst();

                        if (people_2_Get.getHall() == 1) {
                            NumberTicket(1);
                            hall_1++;

                            System.out.printf("Exit: ID: %d, Name: %s, Cash Register: %d, Hall: %d, Number Ticket: %d \n",
                                    people_2_Get.getId(), people_2_Get.getName(), people_2_Get.getCashRegister(), people_2_Get.getHall(), randNumberTicket_1);

                            Add_Queue.people_2.removeFirst();
                        }
                        if (people_2_Get.getHall() == 2) {
                            NumberTicket(2);
                            hall_2++;

                            System.out.printf("Exit: ID: %d, Name: %s, Cash Register: %d, Hall: %d, Number Ticket: %d \n",
                                    people_2_Get.getId(), people_2_Get.getName(), people_2_Get.getCashRegister(), people_2_Get.getHall(), randNumberTicket_2);

                            Add_Queue.people_2.removeFirst();
                        }
                    }
                    break;
                case 3:
                    int millis_3 = rand.nextInt(400) +800;
                    try {
                        Thread.sleep(millis_3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Add_Queue.people_3.isEmpty() == false) {
                        People people_3_Get = Add_Queue.people_3.getFirst();

                        if (people_3_Get.getHall() == 1) {
                            NumberTicket(1);
                            hall_1++;

                            System.out.printf("Exit: ID: %d, Name: %s, Cash Register: %d, Hall: %d, Number Ticket: %d \n",
                                    people_3_Get.getId(), people_3_Get.getName(), people_3_Get.getCashRegister(), people_3_Get.getHall(), randNumberTicket_1);

                            Add_Queue.people_3.removeFirst();
                        }
                        if (people_3_Get.getHall() == 2) {
                            NumberTicket(2);
                            hall_2++;

                            System.out.printf("Exit: ID: %d, Name: %s, Cash Register: %d, Hall: %d, Number Ticket: %d \n",
                                    people_3_Get.getId(), people_3_Get.getName(), people_3_Get.getCashRegister(), people_3_Get.getHall(), randNumberTicket_2);

                            Add_Queue.people_3.removeFirst();
                        }
                    }
                    break;
            }
        }
    }
}