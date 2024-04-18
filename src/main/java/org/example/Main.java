package org.example;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void personalData(String name, int age, int experience)
    {
        System.out.println("Анкета персноала: ");
        System.out.println(STR."Ваше имя: \{name}");
        System.out.println(STR."Ваше возраст: \{age}");
        System.out.println(STR."Ваш опыт работы: \{experience} лет");
    }

    public Boolean isAdult(int age)
    {
        return age >= 18;
    }

    public Boolean isQuiteExperienced(int experience, int requiredExperience)
    {
        return experience >= requiredExperience;
    }

    public int sumSalary(int experience, int selectedIndex)
    {
        switch (selectedIndex)
        {
            case 1:
                if (experience > 7)
                    return 20000;
                else
                    return 15000;
            case 2:
                if (experience > 10)
                    return 45000;
                else
                    return 35000;
            case 3:
                if (experience > 12)
                    return 60000;
                else
                    return 55000;
        }
        return 0;
    }

    public String writeUpdatedInfo()
    {
        return STR."\nОбновление в анкете:\nЗарплата: \{salary}\nДолжность: \{post}";
    }

    public int salary;
    public String post;
    public void selectable(int experience, int selectIndex)
    {
        Main main = new Main();
        switch (selectIndex)
        {
            case 1:
                if (main.isQuiteExperienced(experience, 5))
                {
                    System.out.println("Вы подходите на данную должность!");
                    salary = sumSalary(experience, selectIndex);
                    post = "Токарь";
                    System.out.println(writeUpdatedInfo());
                }
                return;
            case 2:
                if (main.isQuiteExperienced(experience, 7))
                {
                    System.out.println("Вы подходите на данную должность!");
                    salary = sumSalary(experience, selectIndex);
                    post = "Фрезерщик";
                    System.out.println(writeUpdatedInfo());
                }
                return;
            case 3:
                if (main.isQuiteExperienced(experience, 10))
                {
                    System.out.println("Вы подходите на данную должность!");
                    salary = sumSalary(experience, selectIndex);
                    post = "Сверльщик";
                    System.out.println(writeUpdatedInfo());
                }
                return;
        }
        System.out.println("Сожалеем, но вы не проходите из-за маленького опыта работы");
    }

    public static void selectEmployment(int experience)
    {
        Main main = new Main();
        String[] employments = {"Токарный станок", "Фрезерный станок", "Сверлильный станок"};
        for (int i = 0; i < 3; i++)
        {
            System.out.println(STR."\{i + 1}: \{employments[i]}");
        }
        System.out.println("\nВведите индекс желаемой работы: ");
        int selectIndex = scanner.nextInt();
        main.selectable(experience, selectIndex);
    }

    public static void choiceOfProfession(int age, int experience)
    {
        Main main = new Main();
        if (main.isAdult(age))
        {
            selectEmployment(experience);
        }
        else
        {
            System.out.println("Сожалеем, но несовершеннолетние не могут работать на данном заводе");
        }
    }

    public static void main(String[] args) {
        String name;
        int age, experience;

        System.out.println("Введите имя: ");
        name = scanner.next();
        System.out.println("Введите возраст: ");
        age = scanner.nextInt();
        System.out.println("Введите опыт работы: ");
        experience = scanner.nextInt();

        System.out.println("\n");

        personalData(name, age, experience);
        choiceOfProfession(age, experience);
    }
}
