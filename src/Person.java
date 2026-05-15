package com.seclab.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Представляет сотрудника компании.
 * Содержит информацию о ID, имени, поле, подразделении, зарплате и дате рождения.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private double salary;
    private LocalDate dateOfBirth;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Создает сотрудника с указанными параметрами.
     * 
     * @param id уникальный идентификатор
     * @param name имя сотрудника
     * @param gender пол сотрудника0
     * @param department подразделение
     * @param salary зарплата
     * @param dateOfBirth дата рождения
     */
    public Person(int id, String name, String gender, Department department, double salary, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Создает сотрудника с датой рождения в виде строки.
     * 
     * @param id уникальный идентификатор
     * @param name имя сотрудника
     * @param gender пол сотрудника
     * @param department подразделение
     * @param salary зарплата
     * @param dateOfBirth дата рождения в формате yyyy-MM-dd
     */
    public Person(int id, String name, String gender, Department department, double salary, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DATE_FORMATTER);
    }

    /**
     * Возвращает ID сотрудника.
     * 
     * @return уникальный идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Устанавливает ID сотрудника.
     * 
     * @param id новый ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Возвращает имя сотрудника.
     * 
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя сотрудника.
     * 
     * @param name новое имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает пол сотрудника.
     * 
     * @return пол (М/Ж)
     */
    public String getGender() {
        return gender;
    }

    /**
     * Устанавливает пол сотрудника.
     * 
     * @param gender новый пол
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Возвращает подразделение сотрудника.
     * 
     * @return подразделение
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Устанавливает подразделение сотрудника.
     * 
     * @param department новое подразделение
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Возвращает зарплату сотрудника.
     * 
     * @return размер зарплаты
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Устанавливает зарплату сотрудника.
     * 
     * @param salary новая зарплата
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Возвращает дату рождения сотрудника.
     * 
     * @return дата рождения
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Устанавливает дату рождения сотрудника.
     * 
     * @param dateOfBirth новая дата рождения
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (Double.compare(person.salary, salary) != 0) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;
        if (department != null ? !department.equals(person.department) : person.department != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(person.dateOfBirth) : person.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }
}
