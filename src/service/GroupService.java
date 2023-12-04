package service;

import Groups.Group;

public interface GroupService {
    Group[] addNewgroups();
    void getGroup();
    void updateGroup();
    Group[] getAllGroup();
    void deleteGroupByName();
}
