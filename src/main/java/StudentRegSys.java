import org.joda.time.DateTime;
import java.util.ArrayList;

/**
 * Student Registration System
 * Designed to allow for students to register for modules and courses
 * Created by Ethan Delaney for Assignment 1 of CT417.
 */
public class StudentRegSys {
    private final ArrayList<Course> courses;
    private final ArrayList<Module> modules;
    private final ArrayList<Student> students;

    private final ArrayList<Lecturer> lecturers;

    /**
     * Constructor for StudentRegSys class
     * This assumes that the courses and modules are already created, with lecturers associated with each module
     * This system can then be used to add students to the system, and assign them to courses and modules
     */
    public StudentRegSys(){
        Lecturer lecturer1 = new Lecturer("Bob", 32, new DateTime(1990, 1, 1, 0, 0), 123456);
        Lecturer lecturer2 = new Lecturer("Alice", 35, new DateTime(1987, 1, 1, 0, 0), 123456);
        Lecturer lecturer3 = new Lecturer("Fearghal", 40, new DateTime(1982, 1, 1, 0, 0), 123456);
        Lecturer lecturer4 = new Lecturer("Brian", 45, new DateTime(1977, 1, 1, 0, 0), 123456);
        lecturers = new ArrayList<>();
        lecturers.add(lecturer1);
        lecturers.add(lecturer2);
        lecturers.add(lecturer3);
        lecturers.add(lecturer4);

        ArrayList<Module> compSciModules = new ArrayList<>(); //Module array initialised
        ArrayList<Module> engModules = new ArrayList<>();
        Module module1 = new Module("Software Engineering", "CT417", lecturer1); //Initialise module
        Module module2 = new Module("Machine Learning", "CT4101", lecturer2);
        Module module3 = new Module("System on Chip Design", "EE451", lecturer3);
        Module module4 = new Module("Digital Signal Processing", "EE445", lecturer4);

        compSciModules.add(module1); //Add it to array
        compSciModules.add(module2);
        engModules.add(module3);
        engModules.add(module4);
        //Initialise compSci, with list of modules included
        final Course compSci = new Course("CS&IT", compSciModules, new DateTime(2020, 9, 1, 0, 0), new DateTime(2021, 5, 1, 0, 0));
        final Course eng = new Course("Engineering", engModules, new DateTime(2020, 9, 1, 0, 0), new DateTime(2021, 5, 1, 0, 0));

        modules = new ArrayList<>();
        modules.add(module1);
        modules.add(module2);
        modules.add(module3);
        modules.add(module4);

        courses = new ArrayList<>();
        courses.add(eng);
        courses.add(compSci);

        students = new ArrayList<>();
    }

    /**
     * Add a student to the system, and register them for the selected course
     * @param student Student to be added
     */
    public void registerStudent(Student student, String courseName){
        for(Course course : courses){
            if(course.getName().equals(courseName)){
                students.add(student); //Add student to the system
                student.setCourse(course); //Set the students course
                student.setModules(course.getModules()); //Set their modules
                course.addStudent(student); //Add student to the course
                return;
            }
        }
        System.out.println("Invalid course name");
    }

    /**
     * Add student to individual module (i.e. for optional modules)
     * @param student Student to be added
     * @param moduleName Module to add student to
     */
    public void addStudentToModule(Student student, String moduleName){
        for(Module m : modules){
            if(m.getName().equals(moduleName)){
                m.addStudent(student);
                student.addModule(m);
            }
        }
    }

    /**
     * Get the list of courses
     * @return List of courses
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }

    /**
     * Get list of students
     * @return List of students
     */
    public ArrayList<Student> getStudents(){
        return students;
    }

    /**
     * Get list of modules
     * @return List of modules
     */
    public ArrayList<Module> getModules(){
        return modules;
    }

    /**
     * Get list of lecturers
     * @return List of lecturers
     */
    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    /**
     * Method to print out the current state of the registration system, with info about all the courses,
     * all of the students, and all of the courses on the system.
     * @return a String representation of the system
     */
    public String toString(){
        String output = "Courses:\n";
        for (Course course : getCourses()){
            output = output.concat("Course Name = " + course.getName() + "\n");
            output = output.concat("Course Modules = " + course.getModules() + "\n");
            output = output.concat("----------------------------------------\n");
        }
        output = output.concat("\n");
        output = output.concat("Students:\n");
        for (Student student : getStudents()) {
            output = output.concat("Student Name = " + student.getName() + "\n");
            output = output.concat("Student Username = " + student.getUsername() + "\n");
            output = output.concat("Student Modules = " + student.getModules() + "\n");
            output = output.concat("Student Course = " + student.getCourse() + "\n");
            output = output.concat("----------------------------------------\n");
        }
        output = output.concat("\n");
        output = output.concat("Lecturers:\n");
        for (Lecturer lecturer : getLecturers()){
            output = output.concat("Lecturer Name = " + lecturer.getName() + "\n");
            output = output.concat("Lecturer Modules = " + lecturer.getModules() + "\n");
            output = output.concat("----------------------------------------\n");
        }
        return output;
    }
}