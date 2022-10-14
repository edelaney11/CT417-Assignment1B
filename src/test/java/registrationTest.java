import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class registrationTest {
    static StudentRegSys regSys = new StudentRegSys();
    Student student1 = new Student("Steve", 20, new DateTime(2002, 1, 1, 0, 0), 789654);
    Student student2 = new Student("Bobby", 21, new DateTime(2001, 1, 1, 0, 0), 908765);
    Student student3 = new Student("Mary", 19, new DateTime(2004, 1, 1, 0, 0), 546312);

    /**
     * Test that the student can be registered to a course
     */
    @Test
    public void testRegistration(){
        regSys.registerStudent(student1, "CS&IT");
        regSys.registerStudent(student2, "Engineering");
        System.out.println(regSys);
        Assertions.assertEquals("CS&IT", student1.getCourse().getName());
        Assertions.assertEquals("Engineering", student2.getCourse().getName());
    }

    /**
     * Test that the student can be added to a module, separately to being added to course
     */
    @Test
    public void testAddStudentToModule(){
        System.out.println(regSys);
        regSys.registerStudent(student3, "CS&IT");
        regSys.addStudentToModule(student3, "System on Chip Design");
        System.out.println(regSys);
        for(Module module : student3.getCourse().getModules()){
            if(module.getName().equals("System on Chip Design")){
                Assertions.assertTrue(module.getStudents().contains(student3));
            }
        }
    }
}
