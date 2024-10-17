package ru.mirea.pkmn;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String surName;
    private String familyName;
    private String group;

    public Student(String firstName, String surName, String familyName, String group) {
        this.firstName = firstName;
        this.surName = surName;
        this.familyName = familyName;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGroup() {
        return group;
    }
}