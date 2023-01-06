package models;

import java.time.LocalDate;

public class Dog extends Pet {
    public void bark(){
        System.out.println("Woff woff!");
    }

    public Dog() {
    }

    public Dog(String name, LocalDate dob) {
        super(name, dob);
    }
}
