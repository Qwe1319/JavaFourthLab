/**
 * Главный запускатель всех тестов
 */
public class TestRunner {
    
    public static void main(String[] args) {
        System.out.println("         ЗАПУСК ВСЕХ ТЕСТОВ");
        
        long startTime = System.currentTimeMillis();
        
        DepartmentTest.runAll();
        PersonTest.runAll();
        PersonCSVServiceTest.runAll();
        
        long endTime = System.currentTimeMillis();
        

        System.out.printf("ВСЕ ТЕСТЫ УСПЕШНО ПРОЙДЕНЫ (%.3f сек)%n", (endTime - startTime) / 1000.0);
    }
}
