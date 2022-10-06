import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class registrationTest {
    @Test
    public void testRegistration(){
        StudentRegSys regSys = new StudentRegSys();
        Student student1 = new Student("Steve", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        regSys.registerStudent(student1, "CS&IT");
        for (Course course : regSys.getCourses()){

            System.out.println("Course Name = " + course.getName());
            System.out.println("Course Modules = " + course.getModules());
            System.out.println("----------------------------------------");
        }
        System.out.println("\n\n");
        for (Student student : regSys.getStudents()) {
            System.out.println("Student Name = " + student.getName());
            System.out.println("Student Username = " + student.getUsername());
            System.out.println("Student Modules = " + student.getModules());
            System.out.println("Student Course = " + student.getCourse());
            System.out.println("----------------------------------------");
        }
        Assertions.assertEquals("CS&IT", student1.getCourse().getName());
    }

    @Test
    public void testAddStudentToModule(){
        StudentRegSys regSys = new StudentRegSys();
        Student student1 = new Student("Steve", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        regSys.registerStudent(student1, "CS&IT");
        regSys.addStudentToModule(student1, "System on Chip Design");
        for(Module module : student1.getCourse().getModules()){
            if(module.getName().equals("System on Chip Design")){
                Assertions.assertTrue(module.getStudents().contains(student1));
            }
        }
    }
}
