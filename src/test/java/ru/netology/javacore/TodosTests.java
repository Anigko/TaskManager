package ru.netology.javacore;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TodosTests {

    Todos todos = new Todos();

    private final String a = "A";
    private final String b = "B";
    private final String c = "C";
    private final String d = "D";
    private final String e = "E";
    private final String f = "F";
    private final String g = "G";

    @Test
    public void taskCheck() {
        String expected = String.valueOf(Client.pickRandomChar()); // генерируем задачу методом pickRandomChar в классе Client
        String[] taskArray = {a, b, c, d, e, f, g}; // создаем список доступных задач
        int x = Arrays.asList(taskArray).indexOf(expected); // проверяем наличие сгенерированной задачи в массиве и возвращаем её индекс
        String result = taskArray[x]; // по индексу получаем задачу из списка доступных задач
        assertEquals(expected, result); // сравниваем
        if (expected.equals(result)) {
            System.out.println("Задача сгенерирована верно");
        }
    }

    @Test
    public void testAddMethod() {
        todos.addTask(c);
        todos.addTask(a);
        todos.addTask(b);
        List<String> list1 = Arrays.asList(a, b, c);
        assertThat(todos.getTaskList(), is(list1));
    }

    @Test
    public void testRemoveMethod() {
        todos.addTask(a);
        todos.addTask(b);
        todos.addTask(c);
        todos.removeTask(a);
        List<String> list2 = Arrays.asList(b, c);
        assertThat(todos.getTaskList(), is(list2));
    }
}



