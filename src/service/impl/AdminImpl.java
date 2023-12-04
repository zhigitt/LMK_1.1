package service.impl;

import Role.Admin;
import service.AdminService;

import java.util.Scanner;

public class AdminImpl implements AdminService {
    private String email = "zhigit";
    private String password = "";
    @Override
    public Admin login() {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        admin.setEmail("zhigit@gmail.com");
        admin.setPassword("admin1234");


        boolean loginFalse = false;

        while (!loginFalse) {
            System.out.print("E-mail: ");
            String login = sc.nextLine();

            System.out.print("Пароль: ");
            String password = sc.nextLine();


            try {
                if (admin.getEmail().equals(login) && admin.getPassword().equals(password) && login.contains("@gmail.com")) {
                    loginFalse = true;
                    return admin;
                } else {
                    throw new Exception("Email же пароль туура эмес!");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }

    @Override
    public Admin update() {
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);

        TryLoop:
        while (true) {
            try {
                System.out.print("E-amil жазыныз: ");
                String email = sc.nextLine();

                if (admin.getEmail().equalsIgnoreCase(email) && email.contains(email)) {
                    System.out.println("Жаны email жазыныз: ");
//                    admin.setEmail(sc.nextLine());

                    System.out.println("Жаны пароль жазыныз: ");
                    admin.setPassword(sc.nextLine());
                    break TryLoop;
                } else {
                    throw new Exception("Мындай email жок!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return admin;
    }
}
