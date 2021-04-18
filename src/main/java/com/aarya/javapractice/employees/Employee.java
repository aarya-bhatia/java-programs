package com.aarya.javapractice.employees;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private long id;

    public Employee() {
    }

    public Employee(String name, long id) {
        setName(name);
        setId(id);
    }

    public String toString() {
        return String.format("[employees.Employee #%d: %s]", id, name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
