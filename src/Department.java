package com.seclab.model;

/**
 * Представляет подразделение (отдел) компании.
 * Каждое подразделение имеет уникальный ID и название.
 */
public class Department {
    private int id;
    private String name;
    private static int idCounter = 1;

    /**
     * Создает подразделение с автоматически генерируемым ID.
     * 
     * @param name название подразделения
     */
    public Department(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    /**
     * Создает подразделение с указанным ID и названием.
     * 
     * @param id уникальный идентификатор
     * @param name название подразделения
     */
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Возвращает ID подразделения.
     * 
     * @return уникальный идентификатор
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Возвращает название подразделения.
     * 
     * @return название
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
