import com.seclab.model.Person;
import com.seclab.service.PersonCSVService;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Основной класс для тестирования чтения CSV файла и создания списка Person объектов
 */
public class Main {
    /**
     * Главный метод приложения.
     * Читает CSV файл с информацией о сотрудниках и выводит:
     * - Полный список всех сотрудников
     * - Статистику по подразделениям (количество сотрудников, среднюю зарплату)
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        try {
            // Определяем путь к CSV файлу
            String csvPath = "data" + File.separator + "people.csv";
            System.out.println("Чтение CSV файла: " + csvPath);
            System.out.println("=" + "=".repeat(70) + "=");
            
            // Читаем данные из CSV файла
            List<Person> persons = PersonCSVService.readPersonsFromCSV(csvPath);
            
            System.out.println("\nВсего прочитано записей: " + persons.size());
            System.out.println("=" + "=".repeat(70) + "=\n");
            
            // Выводим всех людей
            if (!persons.isEmpty()) {
                System.out.println("Список сотрудников:\n");
                for (int i = 0; i < persons.size(); i++) {
                    System.out.printf("%2d. %s%n", (i + 1), persons.get(i));
                }
            } else {
                System.out.println("Список людей пуст!");
            }
            
            System.out.println("\n" + "=".repeat(72) + "\n");
            System.out.println("СТАТИСТИКА ПО ПОДРАЗДЕЛЕНИЯМ:");
            System.out.println();
            
            persons.stream()
                    .map(Person::getDepartment)
                    .distinct()
                    .forEach(dept -> {
                        long count = persons.stream()
                                .filter(p -> p.getDepartment().equals(dept))
                                .count();
                        double avgSalary = persons.stream()
                                .filter(p -> p.getDepartment().equals(dept))
                                .mapToDouble(Person::getSalary)
                                .average()
                                .orElse(0);
                        System.out.printf("Подразделение: %-15s | Сотрудников: %d | Средняя зарплата: %.2f%n",
                                dept.getName(), count, avgSalary);
                    });

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
