package com.example.wf.Test;

public class Student {
    private String name;
    private int grade;
    private Parent parent;

    public Student() {

    }

    public Student(String name, int grade, Parent parent) {
        this.name = name;
        this.grade = grade;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
