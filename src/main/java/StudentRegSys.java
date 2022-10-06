import org.joda.time.DateTime;
import java.util.ArrayList;

public class StudentRegSys {
    private ArrayList<Course> courses;
    private ArrayList<Module> modules;
    public StudentRegSys(){
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

        modules = new ArrayList<Module>();
        modules.add(module1);
        modules.add(module2);
        modules.add(module3);
        modules.add(module4);

        courses = new ArrayList<Course>();
        courses.add(eng);
        courses.add(compSci);
    }

    public void registerStudent(Student student, String courseName){
        for(Course course : courses){
            if(course.getName().equals(courseName)){
                student.setCourse(course);
                student.setModules(course.getModules());
                course.addStudent(student);
                for(Module m : course.getModules()){
                    m.addStudent(student);
                }
            }
        }
    }

    public void addStudentToModule(Student student, Module module){
        module.addStudent(student);
    }
}