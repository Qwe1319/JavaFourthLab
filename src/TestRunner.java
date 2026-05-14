/**
 * Главный запускатель всех тестов
 */
public class TestRunner {
    
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("         ЗАПУСК ВСЕХ ТЕСТОВ");
        System.out.println("=".repeat(60));
        
        long startTime = System.currentTimeMillis();
        
        DepartmentTest.runAll();
        PersonTest.runAll();
        PersonCSVServiceTest.runAll();
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("=".repeat(60));
        System.out.printf("✓ ВСЕ ТЕСТЫ УСПЕШНО ПРОЙДЕНЫ (%.3f сек)%n", (endTime - startTime) / 1000.0);
        System.out.println("=".repeat(60) + "\n");
    }
}
