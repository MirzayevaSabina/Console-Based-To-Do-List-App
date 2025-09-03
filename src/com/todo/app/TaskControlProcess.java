package com.todo.app;

import java.util.Scanner;

public class TaskControlProcess {
    boolean exit = false;
    Scanner scanner = new Scanner(System.in);
    TaskService taskService = new TaskService();

    public void TaskControlProcess() {
        while(!exit) {
            menu();
            checkChoice();
            int option = scanner.nextInt();
            switch(option) {
                case 1: taskService.addTask();
                break;
                case 2: taskService.removeTask();
                break;
                case 3: taskService.getTaskList();
                break;
                case 4: taskService.getTaskById();
                break;
                case 5: taskService.changeStatus();
                break;
                case 6: taskService.readFromFile();
                break;
                case 7: exit = true;
                System.out.println("Would you like to save tasks? (y/n)");
                scanner.nextLine();
                String answer = scanner.nextLine();
                if(answer.equals("y")) {
                    taskService.writeToFile();
                }
                break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    public void checkChoice() {
        while(!scanner.hasNextInt()) {
            System.out.println("Invalid task choise, try again: ");
            scanner.next();
        }
    }

    public void menu() {
        System.out.println("________________________\n" +
                "Add task: 1 \n" +
                "Remove task: 2 \n" +
                "Show task list: 3 \n" +
                "Show task : 4 \n" +
                "Change task status: 5 \n" +
                "Show saved tasks: 6 \n" +
                "Exit program : 7");
        System.out.println("Enter your choice: ");
    }
}
