package com.todo.app;

import java.util.Scanner;

public class TaskService {
    public Scanner scanner = new Scanner(System.in);
    public TaskManager taskManager = new TaskManager();

    public void checkId (){
        while(!scanner.hasNextInt()) {
            System.out.println("Invalid task ID, try again: ");
            scanner.next();
        }
    }

    public StatusUtility getTaskStatus() {
        int taskId;
        System.out.println("Choose Task ID: \n" +
                "New: 1 \n" +
                "In progress: 2 \n" +
                "Completed: 3 \n" +
                "Cancelled: 4 \n");
        checkId();

        taskId = scanner.nextInt();

        while (taskId != 1 && taskId != 2 && taskId != 3 && taskId != 4) {
                System.out.println("Invalid task ID, try again: ");
                taskId = scanner.nextInt();
                scanner.nextLine();
        }

        return StatusUtility.fromValue(taskId);
    }

    public void addTask() {
        Task newTask = new Task();
        System.out.println("Enter task id: ");
        checkId();
        newTask.setId(scanner.nextInt());

        scanner.nextLine();

        System.out.println("Enter task title: ");
        newTask.setTitle(scanner.nextLine());

        System.out.println("Enter task description: ");
        newTask.setDescription(scanner.nextLine());

        System.out.println("Enter task status: ");
        newTask.setStatus(getTaskStatus());

        taskManager.addTask(newTask);
        System.out.println("Task entered successfully");
    }

    public void removeTask() {
        System.out.println("Enter task id: ");
        checkId();
        if (taskManager.removeTask(scanner.nextInt())) {
            System.out.println("Task deleted successfully!");
        }
    }

    public void getTaskList() {
        for (Task task : taskManager.getTaskList()) {
            System.out.println(task);
        }
    }

    public void getTaskById() {
        System.out.println("Enter task id: ");
        checkId();

        Task task = taskManager.getTaskById(scanner.nextInt());

        if (task != null) {
            System.out.println(task);
        }
    }

    public void changeStatus() {
        System.out.println("Enter task id: ");

        checkId();
        Task task = taskManager.getTaskById(scanner.nextInt());

        if (task != null) {
            System.out.println("Enter task status: ");
            task.setStatus(getTaskStatus());
            System.out.println("Task status changed successfully!");
        }
    }

    public void writeToFile(){
        taskManager.writeToFile();
    }

    public void readFromFile(){
        taskManager.readFromFile();
    }

    public void closeScanner() {
        scanner.close();
    }
}
