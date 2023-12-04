package Groups;

import java.util.Arrays;

public class Group {
    private int id;
    private String nameGroup;
    public Lesson[] lessons = new Lesson[0];
    public Student[] students = new Student[0];
    private String description;

    public Group() {
    }

    public Group(int id, String nameGroup, Lesson[] lessons, Student[] students, String description) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.lessons = lessons;
        this.students = students;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", Группа: '" + nameGroup + '\'' +
                ", Сабак: " + Arrays.toString(lessons) +
                ", Студент: " + Arrays.toString(students) +
                ", Описание: '" + description + '\'' +
                '}';
    }
}
