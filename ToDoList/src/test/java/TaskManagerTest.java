//import org.junit.Assert;
//import org.junit.Test;
//
//import public org.example.TaskManager;
//
//public class TaskManagerTest {
//    @Test
//    public void testGetTasks() {
//
//    }
//    @Test
//    public void testLoadTasks() {
//    }
//    public void testRemoveTask() {
//
//    }
//}
package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TaskManagerTest {

    private TaskManager taskManager;

        @BeforeEach
        void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    @DisplayName("Добавление задачи должно увеличивать размер списка")
    void testAddTask() {
        taskManager.addTask("Купить хлеб");
        assertEquals(1, taskManager.getTasks().size());
        assertEquals("Купить хлеб", taskManager.getTasks().get(0).getTitle());
    }

    @Test
    @DisplayName("Удаление задачи по корректному индексу")
    void testRemoveTask() {
        taskManager.addTask("Задача 1");
        taskManager.addTask("Задача 2");

        taskManager.removeTask(0);

        assertEquals(1, taskManager.getTasks().size());
        assertEquals("Задача 2", taskManager.getTasks().get(0).getTitle());
    }

    @Test
    @DisplayName("Редактирование названия задачи")
    void testEditTask() {
        taskManager.addTask("Старое название");
        taskManager.editTask(0, "Новое название");

        assertEquals("Новое название", taskManager.getTasks().get(0).getTitle());
    }

    @Test
    @DisplayName("Проверка работы класса Task")
    void testTaskEntity() {
        Task task = new Task("Тест");
        task.setTitle("Обновлено");
        assertEquals("Обновлено", task.toString());
    }
}


