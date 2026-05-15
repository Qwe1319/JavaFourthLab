package com.seclab.service;

import com.seclab.model.Department;
import com.seclab.model.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Сервис для чтения и парсинга CSV файлов с информацией о сотрудниках.
 * Преобразует строки CSV в объекты Person и Department.
 */
public class PersonCSVService {
    private static final String SEPARATOR = ";";
    private static final int ID_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int GENDER_INDEX = 2;
    private static final int DATE_OF_BIRTH_INDEX = 3;
    private static final int DEPARTMENT_CODE_INDEX = 4;
    private static final int SALARY_INDEX = 5;

    private static final DateTimeFormatter DATE_FORMATTER_IN = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter DATE_FORMATTER_OUT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Читает CSV файл и возвращает список объектов Person.
     * ID;Имя;Пол;ДатаРождения(DD.MM.YYYY);КодОтдела;Зарплата
     * 
     * @param filePath путь к CSV файлу
     * @return список объектов Person, прочитанных из файла
     * @throws IOException если возникла ошибка при чтении файла
     */
    public static List<Person> readPersonsFromCSV(String filePath) throws IOException {
        List<Person> persons = new ArrayList<>();
        Map<String, Department> departments = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.split(SEPARATOR, -1);

                if (fields.length < 6) {
                    System.err.println("Ошибка: строка содержит недостаточно полей: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(fields[ID_INDEX].trim());
                    String name = fields[NAME_INDEX].trim();
                    String gender = fields[GENDER_INDEX].trim();
                    String dateStr = fields[DATE_OF_BIRTH_INDEX].trim();
                    String departmentCode = fields[DEPARTMENT_CODE_INDEX].trim();
                    double salary = Double.parseDouble(fields[SALARY_INDEX].trim());

                    Department department = departments.computeIfAbsent(departmentCode,
                            key -> new Department(key));

                    LocalDate dateOfBirth = LocalDate.parse(dateStr, DATE_FORMATTER_IN);
                    String formattedDate = dateOfBirth.format(DATE_FORMATTER_OUT);

                    Person person = new Person(id, name, gender, department, salary, formattedDate);
                    persons.add(person);

                } catch (NumberFormatException e) {
                    System.err.println("Ошибка парсинга чисел в строке: " + line);
                } catch (Exception e) {
                    System.err.println("Ошибка обработки строки: " + line);
                }
            }
        }

        return persons;
    }
}
