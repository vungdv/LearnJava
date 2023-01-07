import models.Dog;
import models.Person;

import java.time.LocalDate;
//No package -> Default Package.
public class HelloWorld {
    //shift + return for the new line
    public static void main(String[] args) {
        System.out.println("Hello World, nice to meet you!");
        //use control + R to run the code.

        Person david = new Person("David", "Do", LocalDate.of(1984, 6, 3));
        Person cuong = new Person("Cuong", "Nguyen", LocalDate.of(1985, 9, 2));
        david.setSpouse(cuong);

        Dog dog = new Dog("Bitcuit", LocalDate.of(2022, 12,1));
        cuong.setPet(dog);

        //command + 1 to show/hide project

        //command [ or ] to move forth/back

        //shift + return make new line
        dog.bark();

        System.out.println(cuong);

    }
}
