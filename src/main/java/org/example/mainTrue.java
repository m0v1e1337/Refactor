package org.example;

import java.time.LocalTime;
import java.util.Scanner;

// Класс Factory представляет завод
class Factory {
    private static final String OWNER = System.getProperty("user.name");
    private static final int OPENING_HOUR = 6;
    private static final int CLOSING_HOUR = 21;

    public static void showIsOpen() {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        if (hour > CLOSING_HOUR || hour < OPENING_HOUR) {
            System.out.println("Завод закрыт.");
        } else {
            System.out.println("Завод открыт.\n");
        }
    }

    public static void showOwner() {
        System.out.println("Имя хозяина завода: " + OWNER);
    }
}

// Класс Person представляет сотрудника
class Person {
    private String name;
    private String profession;
    private int salary;
    private String job;

    public Person(String name, String profession, int salary) {
        this.name = name;
        this.profession = profession;
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void changePerson(Scanner scanner) {
        System.out.println("Хотите внести изменения? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            System.out.println("1. Изменить имя");
            System.out.println("2. Изменить профессию");
            System.out.println("3. Изменить ЗП");
            System.out.println("4. Изменить работу");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Потребление оставшегося символа новой строки
            switch (choice) {
                case 1:
                    System.out.println("Введите новое имя: ");
                    name = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Введите новую профессию: ");
                    profession = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Введите новую ЗП: ");
                    salary = scanner.nextInt();
                    scanner.nextLine(); // Потребление оставшегося символа новой строки
                    break;
                case 4:
                    System.out.println("Введите новую работу: ");
                    job = scanner.nextLine();
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Профессия: " + profession + ", ЗП: " + salary + ", Работа: " + job;
    }
}

public class mainTrue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Factory.showIsOpen();
        Factory.showOwner();

        System.out.println("Введите имя сотрудника: ");
        String name = scanner.nextLine();
        System.out.println("Введите должность сотрудника: ");
        String profession = scanner.nextLine();
        System.out.println("Введите ЗП сотрудника: ");
        int salary = scanner.nextInt();
        scanner.nextLine(); // Потребление оставшегося символа новой строки

        Person person = new Person(name, profession, salary);
        System.out.println("\nВведенный сотрудник");
        System.out.println(person);

        System.out.println("\nВведите работу для сотрудника: ");
        String job = scanner.nextLine();
        person.setJob(job);
        System.out.println("Сотрудник успешно добавлен");
        System.out.println(person);

        person.changePerson(scanner);
    }
}
