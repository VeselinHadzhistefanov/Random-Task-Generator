package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please input a list of tasks:");

        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> tasks = new ArrayList<>();
        int n = 1;

        do {
            System.out.print("Task " + n + ": ");
            s = scanner.nextLine();
            if (!s.isEmpty()) {
                tasks.add(s);
                n++;
            }
        } while (!s.isEmpty());

        System.out.println("The chosen tasks are: ");
        for (String a : tasks) {
            System.out.print(a);
            if (tasks.indexOf(a) != tasks.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }

        System.out.println("\nChoose a number of random tasks to pick: ");
        int numRandomTasks = 0;
        do {
            try {
                numRandomTasks = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if (numRandomTasks == 0) {
                System.out.println("Please pick a number other than 0:");
            }
        } while (numRandomTasks == 0);

        Random r = new Random();
        System.out.println("The tasks to do are: ");
        for (int i = 0; i < numRandomTasks; i++) {
            int num = r.nextInt() % numRandomTasks;
            String task = tasks.get(num);
            tasks.remove(num);
            System.out.println("Task " + i + 1 + ": " + task);
        }
        System.out.println("Thanks for using out program. Happy tasking!");
    }
}