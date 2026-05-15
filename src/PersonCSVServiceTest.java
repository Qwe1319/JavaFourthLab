import java.io.IOException;
import java.util.List;

import com.seclab.model.Person;
import com.seclab.service.PersonCSVService;

/**
 * Простые тесты для класса PersonCSVService
 */
public class PersonCSVServiceTest {
    
    public static void testReadPersonsFromCSV() {
        System.out.print("testReadPersonsFromCSV... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("data/foreign_names.csv");
            assert persons != null : "Список не должен быть null";
            assert persons.size() > 0 : "Список должен содержать хотя бы одного сотрудника";
            assert persons.size() == 25898 : "Должно быть 25898 сотрудников";
            System.out.println("PASSED");
        } catch (IOException e) {
            System.err.println("FAILED: " + e.getMessage());
        }
    }
    
    public static void testPersonDataIntegrity() {
        System.out.print("testPersonDataIntegrity... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("data/foreign_names.csv");
            Person firstPerson = persons.get(0);
            
            assert firstPerson.getId() == 28281 : "ID первого сотрудника должен быть 28281";
            assert firstPerson.getName().equals("Aahan") : "Имя неправильное";
            assert firstPerson.getSalary() == 4800 : "Зарплата неправильная";
            assert firstPerson.getDepartment() != null : "Подразделение не должно быть null";
            System.out.println("PASSED");
        } catch (IOException e) {
            System.err.println("FAILED: " + e.getMessage());
        }
    }
    
    public static void testDepartmentGrouping() {
        System.out.print("testDepartmentGrouping... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("data/foreign_names.csv");
            
            long itCount = persons.stream()
                    .filter(p -> p.getDepartment().getName().equals("I"))
                    .count();
            
            assert itCount > 0 : "В отделе I должны быть сотрудники, а есть " + itCount;
            System.out.println("PASSED");
        } catch (IOException e) {
            System.err.println("FAILED: " + e.getMessage());
        }
    }
    
    public static void testFileNotFound() {
        System.out.print("testFileNotFound... ");
        try {
            List<Person> persons = PersonCSVService.readPersonsFromCSV("nonexistent.csv");
            System.err.println("FAILED: Должна была выброситься IOException");
        } catch (IOException e) {
            System.out.println("PASSED");
        }
    }
    
    public static void runAll() {
        System.out.println("\nPersonCSVService Tests");
        testReadPersonsFromCSV();
        testPersonDataIntegrity();
        testDepartmentGrouping();
        testFileNotFound();
        System.out.println("Все тесты PersonCSVService завершены\n");
    }
}
