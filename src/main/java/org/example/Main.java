package org.example;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static String[] persons = {};
    public static String job = "";

    public static int hour = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        main.ShowIsOpen();
        if (hour > 21 || hour < 6) {
            System.exit(0);
        }
        main.OpeningInfo();
        main.ShowOwner();

        System.out.println("Введите имя сотрудника: ");
        String name = scanner.nextLine();
        System.out.println("Введите должность сотрудника: ");
        String profession = scanner.nextLine();
        System.out.println("Введите ЗП сотрудника: ");
        int salary = scanner.nextInt();

        System.out.println("\n");
        ShowPersonInfo(name, profession, salary);

        System.out.println("\n");
        PersonJob(name, profession, salary);

        System.out.println("\n");
        ChangePerson(name, profession, salary, job);
    }
    public static void ShowPersonInfo(String name, String profession, int salary) {
        System.out.println("Введенный сотрудник");
        System.out.println("Имя: " + name);
        System.out.println("Профессия: " + profession);
        System.out.println("ЗП: " + salary);
    }
    public static void PersonJob(String name, String profession, int salary) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите работу для сотрудника: ");
        job = scanner.nextLine();
        persons = new String[]{name, profession, String.valueOf(salary), job};

        System.out.println("Сотрудник успешно добавлен");
        System.out.println(Arrays.toString(persons));
    }
    //
    public static void ChangePerson(String name, String profession, int salary, String job) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите внести изменения? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            System.out.println("1. Изменить имя");
            System.out.println("2. Изменить профессию");
            System.out.println("3. Изменить ЗП");
            System.out.println("4. Изменить работу");
            int newAnswer = scanner.nextInt();
            switch (newAnswer) {
                //Обновление имени
                case 1:
                    System.out.println("Введите новое имя: ");
                    String newName = scanner.nextLine();
                    persons = new String[]{newName, profession, String.valueOf(salary), job};
                    System.out.println(Arrays.toString(persons));
                    break;
                //Обновение профессии
                case 2:
                    System.out.println("Введите новую профессию: ");
                    String newProfession = scanner.nextLine();
                    persons = new String[]{name, newProfession, String.valueOf(salary), job};
                    System.out.println(Arrays.toString(persons));
                    break;
                //Обновление ЗП
                case 3:
                    System.out.println("Введите новую ЗП: ");
                    int newSalary = scanner.nextInt();
                    persons = new String[]{name, profession, String.valueOf(newSalary), job};
                    System.out.println(Arrays.toString(persons));
                    break;
                //Обновление работы
                case 4:
                    System.out.println("Введите новую работу: ");
                    String newJob = scanner.nextLine();
                    persons = new String[]{name, profession, String.valueOf(salary), newJob};
                    System.out.println(Arrays.toString(persons));
                    break;
            }
        }
        else if (answer.equals("n")) {
            System.out.println("-------");
        }
    }
    //Описание
    public void OpeningInfo() {
        System.out.println("Добро пожаловать на завод №52.\n" +
                "Если вы хотите получать зарплату ниже прожиточного минимума и уходить с больной спиной, то вы по адресу!\n" +
                "Приветствуется полное отсутствие стажа и мозгов.\n" +
                "Заинтересовались? Тогда приступим)\n");
    }
    //Часы работы завода
    public void ShowIsOpen() {
        LocalTime currentTime = LocalTime.now();
        hour = currentTime.getHour();

        if (hour > 21 || hour < 6) {
            System.out.println("Завод закрыт.");
        }
        else {
            System.out.println("Завод открыт.\n");
        }
    }
    //Имя хозяина завода
    public void ShowOwner() {
        String userName = System.getProperty("user.name");
        System.out.println("Имя хозяина завода: " + userName);
    }
}