import Groups.Group;
import service.AdminService;
import service.GroupService;
import service.LessonService;
import service.StudentsService;
import service.impl.AdminImpl;
import service.impl.GroupImpl;
import service.impl.Lessonimpl;
import service.impl.Studentsimpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminService adminService = new AdminImpl();
        GroupService groupService = new GroupImpl();
        StudentsService studentsService = new Studentsimpl();
        LessonService lessonService = new Lessonimpl();

        OuterLoop:
        while (true) {
            System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калсаныз озгортуу учун 2 басыныз!");
            System.out.print("Select: ");

            switch (sc.nextInt()) {
                case 1 -> {
                    adminService.login();

                    InnerLoop:
                    while (true) {

                        System.out.println("""
                                1. Жаны группа кошуу.
                                2. Группа издоо аты мн.
                                3. Группаны аты мн жанылоо.
                                4. Бардык группаларды чыгаруу.
                                5. Группага жаны студент кошуу.
                                6. Студентти жанылоо.
                                7. Аты аркылуу студент издоо.
                                8. Группанын аты мн бардык студенттерди чыгаруу.
                                9. Сабак аркылуу бардык студенттерди чыгаруу.
                                10. Студентти email аркылуу очуруу.
                                11. Группага жаны сабак кошуу.
                                12. Сабактын аты аркылуу чыгаруу.
                                13. Группанын аты мн бардык сабактарды чыгаруу.
                                14. Сабакты ID аркылуу очуруу.
                                15. Группаны аты аркылуу очуруу.
                                 0. Аккаунттан чыгуу.
                                """);

                        System.out.print("Тандоо: ");
                        int select = sc.nextInt();
                        sc.nextLine();

                        switch (select) {
                            case 1 -> {
                                groupService.addNewgroups();
                            }
                            case 2 -> {
                                groupService.getGroup();
                            }
                            case 3 -> {
                                groupService.updateGroup();
                            }
                            case 4 -> {
                                System.out.println(Arrays.toString(groupService.getAllGroup()));
                            }
                            case 5 -> {
                                studentsService.addNewStudent();
                            }
                            case 6 -> {
                                studentsService.updateStudent();
                            }
                            case 7 -> {
                                studentsService.findStudent();
                            }
                            case 8 -> {
                                studentsService.getAllStudentByGroupName();
                            }
                            case 9 -> {
                                studentsService.getAllStudentLesson();
                            }
                            case 10 -> {
                                studentsService.deleteStudentByEmail();
                            }
                            case 11 -> {
                                lessonService.addNewlessonGroup();
                            }
                            case 12 -> {
                                lessonService.getlessonByName();
                            }
                            case 13 -> {
                                lessonService.getlessonByGroupName();
                            }
                            case 14 -> {
                                lessonService.deleteLessonById();
                            }
                            case 15 -> {
                                groupService.deleteGroupByName();
                            }
                            case 0 -> {
                                break InnerLoop;
                            }
                        }
                    }
                }
                case 2 -> {
                    adminService.update();
                }
            }
        }

    }
}