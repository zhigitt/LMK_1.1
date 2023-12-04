package service;

import Groups.Student;

public interface StudentsService {
    void addNewStudent();
    void updateStudent();
    void findStudent();
    void getAllStudentByGroupName();
    void getAllStudentLesson();
    void deleteStudentByEmail();
}
