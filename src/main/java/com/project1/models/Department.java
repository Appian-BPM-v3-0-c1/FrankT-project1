package com.project1.models;

public class Department {
    private int id;
    private String name_dept;

    public Department() {

    }

    public Department(int id, String name_dept) {
        this.id = id;
        this.name_dept = name_dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_dept() {
        return name_dept;
    }

    public void setName_dept(String name_dept) {
        this.name_dept = name_dept;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name_dept='" + name_dept + '\'' +
                '}';
    }
}
