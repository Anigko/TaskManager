package ru.netology.javacore;

import com.jayway.jsonpath.JsonPath;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    final int port = 8089;

    public TodoServer(int port, Todos todos) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                out.printf(todos.getAllTasks());

                final String json = in.readLine();

                String type = JsonPath.read(json, "$.type");
                String task = JsonPath.read(json, "$.task");
                if (type.equals("ADD")) {
                    todos.addTask(task);
                } else if (type.equals("REMOVE")) {
                    todos.removeTask(task);
                }
                //System.out.println(todos.getAllTasks());

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Connection timeout");

            }

        }

    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
    }
}
