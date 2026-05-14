import com.seclab.model.Person;
import com.seclab.service.PersonCSVService;
import java.io.IOException;
import java.util.List;

/**
 * Простые тесты для класса PersonCSVService
 */
public class PersonCSVServiceTest {
    
    public static void testReadPersonsFromCSV() {
        System.out.print("testReadPersonsFromCSV... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("data/people.csv");
            assert persons != null : "Список не должен быть null";
            assert persons.size() > 0 : "Список должен содержать хотя бы одного сотрудника";
            assert persons.size() == 10 : "Должно быть 10 сотрудников";
            System.out.println("✓ PASSED");
        } catch (IOException e) {
            System.err.println("✗ FAILED: " + e.getMessage());
        }
    }
    
    public static void testPersonDataIntegrity() {
        System.out.print("testPersonDataIntegrity... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("data/people.csv");
            Person firstPerson = persons.get(0);
            
            assert firstPerson.getId() == 1 : "ID первого сотрудника должен быть 1";
            assert firstPerson.getName().equals("Иван Петров") : "Имя неправильное";
            assert firstPerson.getSalary() == 75000 : "Зарплата неправильная";
            assert firstPerson.getDepartment() != null : "Подразделение не должно быть null";
            System.out.println("✓ PASSED");
        } catch (IOException e) {
            System.err.println("✗ FAILED: " + e.getMessage());
        }
    }
    
    public static void testDepartmentGrouping() {
        System.out.print("testDepartmentGrouping... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("data/people.csv");
            
            long itCount = persons.stream()
                    .filter(p -> p.getDepartment().getName().equals("IT"))
                    .count();
            
            assert itCount == 4 : "В IT должно быть 4 сотрудника, а есть " + itCount;
            System.out.println("✓ PASSED");
        } catch (IOException e) {
            System.err.println("✗ FAILED: " + e.getMessage());
        }
    }
    
    public static void testFileNotFound() {
        System.out.print("testFileNotFound... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("nonexistent.csv");
            System.err.println("✗ FAILED: Должна была выброситься IOException");
        } catch (IOException e) {
            System.out.println("✓ PASSED");
        }
    }
    
    public static void runAll() {
        System.out.println("\n=== PersonCSVService Tests ===");
        testReadPersonsFromCSV();
        testPersonDataIntegrity();
        testDepartmentGrouping();
        testFileNotFound();
        System.out.println("✓ Все тесты PersonCSVService завершены\n");
    }
}
