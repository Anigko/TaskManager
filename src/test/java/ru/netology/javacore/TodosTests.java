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
    private final List<String> list1 = Arrays.asList("A", "B", "C");
    private final List<String> list2 = Arrays.asList("B", "C");
    private final String[] vol = {"A", "B", "C", "D", "E", "F", "G"};

    @Test
    public void taskCheck() {
        Client task = new Client();
        String expected = String.valueOf(task.pickRandomChar()); // генерируем задачу
        String[] taskArray = vol; // создаем список доступных задач
        int x = Arrays.asList(taskArray).indexOf(expected); // проверяем наличие сгенерированной задачи в массиве и получаем индекс
        String result = taskArray[x]; // по индексу получаем задачу из списка доступных задач
        assertEquals(expected, result); // сравниваем
    }

    @Test
    public void testAddMethod() {
        todos.addTask(a);
        todos.addTask(b);
        todos.addTask(c);
        assertThat(todos.getTaskList(), is(list1));
    }

    @Test
    public void testRemoveMethod() {
        todos.addTask(a);
        todos.addTask(b);
        todos.addTask(c);
        todos.removeTask(a);
        assertThat(todos.getTaskList(), is(list2));
    }
}



