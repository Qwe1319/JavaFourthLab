import com.seclab.model.Department;

/**
 * Простые тесты для класса Department
 */
public class DepartmentTest {
    
    public static void testDepartmentCreation() {
        System.out.print("testDepartmentCreation... ");
        Department dept = new Department("IT");
        assert dept.getName().equals("IT") : "Название должно быть IT";
        assert dept.getId() > 0 : "ID должен быть больше 0";
        System.out.println("PASSED");
    }
    
    public static void testDepartmentWithId() {
        System.out.print("testDepartmentWithId... ");
        Department dept = new Department(99, "Finance");
        assert dept.getId() == 99 : "ID должен быть 99";
        assert dept.getName().equals("Finance") : "Название должно быть Finance";
        System.out.println("PASSED");
    }
    
    public static void testDepartmentSetters() {
        System.out.print("testDepartmentSetters... ");
        Department dept = new Department("HR");
        dept.setName("Human Resources");
        dept.setId(5);
        assert dept.getName().equals("Human Resources") : "Название должно быть обновлено";
        assert dept.getId() == 5 : "ID должно быть обновлено";
        System.out.println("PASSED");
    }
    
    public static void testDepartmentEquality() {
        System.out.print("testDepartmentEquality... ");
        Department dept1 = new Department(1, "IT");
        Department dept2 = new Department(1, "IT");
        assert dept1.equals(dept2) : "Подразделения с одинаковыми данными должны быть равны";
        System.out.println("PASSED");
    }
    
    public static void runAll() {
        System.out.println("\nDepartment Tests");
        try {
            testDepartmentCreation();
            testDepartmentWithId();
            testDepartmentSetters();
            testDepartmentEquality();
            System.out.println("Все тесты Department прошли успешно\n");
        } catch (AssertionError e) {
            System.err.println("FAILED: " + e.getMessage());
        }
    }
}
