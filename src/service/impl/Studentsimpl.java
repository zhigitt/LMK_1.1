package service.impl;

import Groups.Generator;
import Groups.Group;
import Groups.Student;
import database.DataBase;
import service.StudentsService;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Scanner;

public class Studentsimpl implements StudentsService {
    @Override
    public void addNewStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Группанын аты: ");
        String group = sc.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(group)) {
                Student student = new Student();

                System.out.print("Студенттин аты: ");
                String name = sc.nextLine();

                System.out.print("Студенттин фамилиясы: ");
                String lastName = sc.nextLine();

                while (true) {
                    System.out.print("Студенттин email: ");
                    String email = sc.nextLine();
                    if (method(email) == 0 && email.endsWith("@gmail.com")) {
                        student.setEmail(email);
                        break;
                    }

                }
                System.out.print("Студенттин пароль: ");
                String password = sc.nextLine();

                System.out.print("Гендер(M же Ж): ");
                String gender = sc.nextLine();
                student.setName(name);
                student.setLastName(lastName);
                student.setPassword(password);
                student.setGender(gender);

                student.setId(Generator.generateStudentId());

                DataBase.groups[i].students = Arrays.copyOf(DataBase.groups[i].getStudents(), DataBase.groups[i].getStudents().length + 1);
                DataBase.groups[i].students[DataBase.groups[i].students.length - 1] = student;
            }
        }
    }

    @Override
    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Студенттин email: ");
        String scEmail = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int l = 0; l < DataBase.groups[i].students.length; l++) {
                if (DataBase.groups[i].students[l].getEmail().equalsIgnoreCase(scEmail)) {
                    System.out.print("Студенттин жаны атын жазыныз: ");
                    DataBase.groups[i].students[l].setEmail(sc.nextLine());
                    System.out.print("Студент ийгиликтуу жаныланды: ");
                }
            }

        }
    }

    @Override
    public void findStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Студенттин атын жазыныз: ");
        String studentName = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (DataBase.groups[i].students[j].getName().equalsIgnoreCase(studentName)) {
                    System.out.println(DataBase.groups[i].students[j]);
                }
            }
        }
    }

    @Override
    public void getAllStudentByGroupName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Группанын атын жазыныз: ");
        String groupName = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(groupName)) {
                System.out.println(Arrays.toString(DataBase.groups[i].getStudents()));
            }
        }
    }

    @Override
    public void getAllStudentLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сабактын аталышы: ");
        String scLesson = scanner.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int l = 0; l < DataBase.groups[i].lessons.length; l++) {
                if (DataBase.groups[i].lessons[l].getLessonName().equalsIgnoreCase(scLesson)) {
                    for (int k = 0; k < DataBase.groups[i].students.length; k++) {
                        System.out.println(DataBase.groups[i].students[k]);
                    }
                }
            }
        }
    }

    @Override
    public void deleteStudentByEmail() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Студенттин email жазыныз:");
        String scEmail = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length - 1; j++) {
                if (DataBase.groups[i].students[j].getEmail().equalsIgnoreCase(scEmail)) {
                    DataBase.groups[i].students[j] = DataBase.groups[i].students[j + 1];
                    DataBase.groups[i].setStudents(Arrays.copyOf(DataBase.groups[i].students, DataBase.groups[i].students.length - 1));
                }
            }
        }
    }


    private static int method(String email) {
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int l = 0; l < DataBase.groups[i].getStudents().length; l++) {
                if (DataBase.groups[i].students[l].getEmail().equals(email)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
