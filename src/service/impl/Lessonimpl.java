package service.impl;

import Groups.Generator;
import Groups.Lesson;
import Groups.Student;
import database.DataBase;
import service.LessonService;

import java.util.Arrays;
import java.util.Scanner;

public class Lessonimpl implements LessonService {


    @Override
    public void addNewlessonGroup() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Группанын аты: ");
        String group = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(group)) {
                Lesson lesson = new Lesson();

                System.out.print("Сабактын аты: ");
                lesson.setLessonName(sc.nextLine());

                System.out.print("Описание: ");
                lesson.setTaskDiscription(sc.nextLine());

                lesson.setId(Generator.generatelessonId());

                DataBase.groups[i].lessons = Arrays.copyOf(DataBase.groups[i].getLessons(), DataBase.groups[i].getLessons().length + 1);
                DataBase.groups[i].lessons[DataBase.groups[i].lessons.length - 1] = lesson;
            }
        }

    }

    @Override
    public void getlessonByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Саактын аталышын жазыныз: ");
        String lessonName = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].lessons.length; j++) {
                if (DataBase.groups[i].lessons[j].getLessonName().equalsIgnoreCase(lessonName)){
                    System.out.println(DataBase.groups[i].lessons[j]);
                }
            }
        }
    }

    @Override
    public void getlessonByGroupName() {
        Scanner sc =new Scanner(System.in);
        System.out.print("Группанын атын жазыныз: ");
        String groupName = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(groupName)){
                System.out.println(Arrays.toString(DataBase.groups[i].getLessons()));
            }
        }
    }

    @Override
    public void deleteLessonById() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Сабактын ID син жазыныз:");
        int scId = sc.nextInt();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].lessons.length -1; j++) {
                if (DataBase.groups[i].students[j].getId() == scId){
                    DataBase.groups[i].lessons[j] = DataBase.groups[i].lessons[j + 1];
                    DataBase.groups[i].setLessons(Arrays.copyOf(DataBase.groups[i].lessons, DataBase.groups[i].lessons.length - 1));
                }
            }
        }
    }
}
