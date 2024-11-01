package ru.mirea.pkmn;
import lombok.Getter;

import java.io.Serializable;

@Getter
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

    @Override
    public String toString() {
        return "firstName = " + firstName + " surName = " + surName + " familyName = " + familyName +  " group = " + group;
    }
}