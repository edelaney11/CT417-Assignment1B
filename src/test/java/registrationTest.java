import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class registrationTest {
    @Test
    public void testRegistration(){
        StudentRegSys regSys = new StudentRegSys();
        Student student1 = new Student("Steve", 20, new DateTime(2002, 1, 1, 0, 0), 123456);
        regSys.registerStudent(student1, "CS&IT");
        Assertions.assertEquals("CS&IT", student1.getCourse().getName());
    }
}
