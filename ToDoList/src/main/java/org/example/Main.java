package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        taskManager.loadTasks();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать задачи");
            System.out.println("2. Добавить задачи");
            System.out.println("3. Удалить задачи");
            System.out.println("4. Редактировать задачи");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Список задач:");
                    for (int i = 0; i < taskManager.getTasks().size(); i++) {
                        System.out.println(i + ":" + taskManager.getTasks().get(i));
                    }
                    break;
                case 2:
                    System.out.print("Введите название задачи: ");
                    String title = scanner.nextLine();
                    taskManager.addTask(title);
                    break;
                case 3:
                    System.out.print("Введите индекс задачи для удаления: ");
                    int removeindex = scanner.nextInt();
                    taskManager.removeTask(removeindex);
                    break;
                case 4:
                    System.out.print("Введите индекс задачи для редактирования: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите новое название задачи: ");
                    String newTitle = scanner.nextLine();

                    taskManager.editTask(editIndex, newTitle);
                    break;
                case 0:
                    taskManager.saveTasks();
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:

                    System.out.println("Неправильный выбор, попробуйте снова.");
            }
        }
    }
}