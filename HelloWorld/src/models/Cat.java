package models;

public class Cat extends Pet{
    public void Meow(){
        System.out.println("Meow meow");
    }

    //control + o (for override)


    @Override
    public String toString() {
        return "Cat - name: Bin" + super.toString();
    }

    //psvm -> snipet code for default main hello world
    //sout -> snipet for System.out.println()
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println(cat1);
    }
}
