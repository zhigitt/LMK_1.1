package Groups;

public class Generator {

    public static int id = 0;
    public static int studentId = 0;
    public static int lessonId = 0;

    public static int generateId(){
        return (++id);
    }
    public static int generateStudentId(){
        return (++studentId);
    }
    public static int generatelessonId(){
        return (++lessonId);
    }
}
