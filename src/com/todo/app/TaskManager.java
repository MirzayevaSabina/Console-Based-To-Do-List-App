package com.todo.app;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> taskList = new ArrayList<>();
    FileUtility fileUtility = new FileUtility();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public Task getTaskById(int id) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
            return null;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (Task task : taskList) {
                if (task.getId() == id) {
                    return task;
                }
            }
            System.out.println("Task not found. Please enter a valid task ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public boolean removeTask(int id) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
            return false;
        } else {
            taskList.remove(getTaskById(id));
            return true;
        }
    }

    public ArrayList<Task> getTaskList() { //bunu duzelt
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty");
        }
        return taskList;
    }

    public void writeToFile(){
        if (taskList.isEmpty()){
            System.out.println("Task list is empty");
        } else {
            fileUtility.writeFile(taskList,"tasks.txt");
            System.out.println("Tasks saved successfully!");
        }
    }

    public void readFromFile(){
        if(taskList.isEmpty()){
            System.out.println("Task list is empty");
        } else {
        fileUtility.readFile(taskList,"tasks.txt");
        System.out.println("Tasks read successfully: ");
        }
    }

}