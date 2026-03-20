package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private final String filename = "tasks.dat";

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (List<Task>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, создается новый список задач.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Неправильный индекс задачи.");
        }
    }

    public void editTask(int index, String newTitle) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setTitle(newTitle);
        } else {
            System.out.println("Неправильный индекс задачи.");
        }
    }
}
