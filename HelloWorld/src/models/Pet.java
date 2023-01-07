package models;

import java.time.LocalDate;

//there is a default class Object
// that meas public class Pet{} equivalent to public class Pet extends Object {}
public class Pet {
    private String name;
    private LocalDate dob;

    public Pet() {
    }

    public Pet(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}' +  super.toString();
    }


}
