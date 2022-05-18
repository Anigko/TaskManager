package ru.netology.javacore;

import com.jayway.jsonpath.JsonPath;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    final int port = 8989;

    public TodoServer(int port, Todos todos) {
        //  стартуем сервер на порту 8989
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            while (true) {
                // становимся в ожидание подключения к сокету под именем - "clientSocket" на серверной стороне
                try (Socket clientSocket = serverSocket.accept();
                     // инициируем каналы для  общения в сокете, для сервера

                     // канал чтения из сокета
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     // канал записи в сокет
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                ) {

                    // сервер ждёт в канале чтения (inputstream) получения данных клиента
                    String json = in.readLine();
                    // инициализация получения данных о типе задачи и самой задачи с последующей записью или удалением в/из массива
                    String type = JsonPath.read(json, "$.type");
                    String task = JsonPath.read(json, "$.task");
                    if (type.equals("ADD")) {
                        todos.addTask(task);
//                    } else if (type.equals("REMOVE")) {
//                        todos.removeTask(task);
                    }
                    // возврат клиенту актуального списка задач
                    out.printf(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
    }
}
