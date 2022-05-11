package ru.netology.javacore;

import java.util.*;


public class Todos {

    ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask(String task) {

        tasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        for (Object o : tasks) {
            sb.append(o.toString());
            sb.append("\n");
        }
        return sb.toString();

    }

}
