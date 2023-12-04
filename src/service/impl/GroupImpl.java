package service.impl;

import Groups.Generator;
import Groups.Group;
import database.DataBase;
import service.GroupService;

import java.util.Arrays;
import java.util.Scanner;

public class GroupImpl implements GroupService {

    @Override
    public Group[] addNewgroups() {
        Scanner sc = new Scanner(System.in);
        Group group = new Group();
        while (true) {
            System.out.print("Жаны группа: ");
            String newGroup = sc.nextLine();

            if (groupNameUniver(newGroup) == 0) {
                group.setNameGroup(newGroup);
                break;
            }
        }
        System.out.print("Описание: ");
        String newDescreption = sc.nextLine();

        group.setDescription(newDescreption);

        group.setId(Generator.generateId());
        DataBase.groups = Arrays.copyOf(DataBase.groups, DataBase.groups.length + 1);
        DataBase.groups[DataBase.groups.length - 1] = group;

        return DataBase.groups;
    }

    @Override
    public void getGroup() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Группанын аты: ");
        String groupName = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(groupName)) {
                System.out.println(DataBase.groups[i]);
            } else {
                System.out.println("Мындай группа жок!");
            }
        }
    }

    @Override
    public void updateGroup() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Озгорто турчу группанын аты: ");
        String groupName = sc.nextLine();

        for (Group group : DataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                System.out.print("Группанын жаны атын жазыныз: ");
                group.setNameGroup(sc.nextLine());
                System.out.println("Группанын аты ийгиликтуу алмашылды!");
                return;
            }
        }
        System.out.println("Мындай группа жок!");
    }

    @Override
    public Group[] getAllGroup() {
        Group[] groups = DataBase.groups;
        return groups;
    }

    @Override
    public void deleteGroupByName() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Группанын атын жазыныз:");
        String scGroupName = sc.nextLine();

        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(scGroupName)) {
                for (int k = 0; k < DataBase.groups.length - 1; k++) {
                    DataBase.groups[i] = DataBase.groups[i + 1];
                }
                DataBase.groups = Arrays.copyOf(DataBase.groups, DataBase.groups.length - 1);
                System.out.println("Группа очурулду!");
            }
        }
    }

    private static int groupNameUniver(String name) {
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getNameGroup().equalsIgnoreCase(name)) {
                return 1;
            }
        }
        return 0;
    }
}
