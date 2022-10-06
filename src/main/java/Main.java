import org.joda.time.DateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Initialise students and lecturer
        Student student1 = new Student("Steve", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        Student student2 = new Student("Mary", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        Student student3 = new Student("John", 22, new DateTime(2000, 1, 1, 0, 0), 123456);
        Student student4 = new Student("Jane", 22, new DateTime(2000, 1, 1, 0, 0), 123456);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Lecturer lecturer1 = new Lecturer("Bob", 32, new DateTime(1990, 1, 1, 0, 0), 123456);
        Lecturer lecturer2 = new Lecturer("Alice", 35, new DateTime(1987, 1, 1, 0, 0), 123456);
        Lecturer lecturer3 = new Lecturer("Fearghal", 40, new DateTime(1982, 1, 1, 0, 0), 123456);
        Lecturer lecturer4 = new Lecturer("Brian", 45, new DateTime(1977, 1, 1, 0, 0), 123456);

        ArrayList<Module> compSciModules = new ArrayList<Module>(); //Module array initialised
        ArrayList<Module> engModules = new ArrayList<Module>();
        Module module1 = new Module("Software Engineering", "CT417", lecturer1); //Initialise module
        Module module2 = new Module("Machine Learning", "CT4101", lecturer2);
        Module module3 = new Module("System on Chip Design", "EE451", lecturer3);
        Module module4 = new Module("Digital Signal Processing", "EE445", lecturer4);

        compSciModules.add(module1); //Add it to array
        compSciModules.add(module2);
        engModules.add(module3);
        engModules.add(module4);
        //Initialise compSci, with list of modules included
        Course compSci = new Course("CS&IT", compSciModules, new DateTime(2020, 9, 1, 0, 0), new DateTime(2021, 5, 1, 0, 0));
        Course eng = new Course("Engineering", engModules, new DateTime(2020, 9, 1, 0, 0), new DateTime(2021, 5, 1, 0, 0));
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(compSci);
        courses.add(eng);
        student1.register(compSci); //Register students with compSci
        student2.register(compSci);
        student3.register(eng);
        student4.register(eng);
        for (Course course : courses) {

            System.out.println("Course Name = " + course.getName());
            System.out.println("Course Modules = " + course.getModules());
            System.out.println("----------------------------------------");
        }
        System.out.println("\n\n");
        for (Student student : students) {
            System.out.println("Student Name = " + student.getName());
            System.out.println("Student Username = " + student.getUsername());
            System.out.println("Student Modules = " + student.getModules());
            System.out.println("Student Course = " + student.getCourse());
            System.out.println("----------------------------------------");
        }
    }
}