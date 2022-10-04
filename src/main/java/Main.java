import org.joda.time.DateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Steve", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        Student student2 = new Student("Mary", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        Lecturer lecturer1 = new Lecturer("Bob", 20, new DateTime(1990, 1, 1, 0, 0), 123456);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        ArrayList<Module> modules = new ArrayList<>();
        Module module1 = new Module("Software Engineering", "CT417", lecturer1);
        module1.setStudents(students);
        modules.add(module1);
        Course course = new Course("CS&IT", modules, new DateTime(2020, 9, 1, 0, 0), new DateTime(2021, 5, 1, 0, 0));
        student1.register(course);
        student2.register(course);
        System.out.println(course.getStudents());
        System.out.println(student1.getCourse());
        System.out.println(student1.getModules());
        System.out.println(module1.getStudents());
    }
}