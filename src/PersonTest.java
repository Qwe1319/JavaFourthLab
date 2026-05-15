import com.seclab.model.Department;
import com.seclab.model.Person;
import java.time.LocalDate;

/**
 * Простые тесты для класса Person
 */
public class PersonTest {
    
    public static void testPersonCreation() {
        System.out.print("testPersonCreation... ");
        Department dept = new Department("I");
        Person person = new Person(1, "Иван Петров", "М", dept, 75000, LocalDate.of(1990, 5, 15));
        
        assert person.getId() == 1 : "ID должен быть 1";
        assert person.getName().equals("Иван Петров") : "Имя неправильное";
        assert person.getGender().equals("М") : "Пол должен быть М";
        assert person.getSalary() == 75000 : "Зарплата должна быть 75000";
        System.out.println("PASSED");
    }
    
    public static void testPersonWithStringDate() {
        System.out.print("testPersonWithStringDate... ");
        Department dept = new Department("H");
        Person person = new Person(2, "Мария Сидорова", "Ж", dept, 65000, "1992-08-22");
        
        assert person.getName().equals("Мария Сидорова") : "Имя неправильное";
        assert person.getDateOfBirth().getYear() == 1992 : "Год рождения должен быть 1992";
        System.out.println("PASSED");
    }
    
    public static void testPersonSetters() {
        System.out.print("testPersonSetters... ");
        Department dept = new Department("Finance");
        Person person = new Person(3, "Алексей", "М", dept, 70000, "1988-03-10");
        
        person.setName("Алексей Иванов");
        person.setSalary(80000);
        
        assert person.getName().equals("Алексей Иванов") : "Имя не обновилось";
        assert person.getSalary() == 80000 : "Зарплата не обновилась";
        System.out.println("PASSED");
    }
    
    public static void testPersonDepartment() {
        System.out.print("testPersonDepartment... ");
        Department dept1 = new Department("I");
        Department dept2 = new Department("Marketing");
        Person person = new Person(4, "Павел", "М", dept1, 62000, "1996-04-11");
        
        assert person.getDepartment().equals(dept1) : "Подразделение должно быть I";
        person.setDepartment(dept2);
        assert person.getDepartment().equals(dept2) : "Подразделение должно быть обновлено";
        System.out.println("PASSED");
    }
    
    public static void testPersonEquality() {
        System.out.print("testPersonEquality... ");
        Department dept = new Department(1, "I");
        Person person1 = new Person(1, "Иван", "М", dept, 75000, "1990-05-15");
        Person person2 = new Person(1, "Иван", "М", dept, 75000, "1990-05-15");
        
        assert person1.equals(person2) : "Люди с одинаковыми данными должны быть равны";
        System.out.println("PASSED");
    }
    
    public static void runAll() {
        System.out.println("\nPerson Tests");
        try {
            testPersonCreation();
            testPersonWithStringDate();
            testPersonSetters();
            testPersonDepartment();
            testPersonEquality();
            System.out.println("Все тесты Person прошли успешно\n");
        } catch (AssertionError e) {
            System.err.println("FAILED: " + e.getMessage());
        }
    }
}
