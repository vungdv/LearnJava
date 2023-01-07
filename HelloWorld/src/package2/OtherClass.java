package package2;

public class OtherClass {
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.protectedMethod();
        //protected can be accessed in the same package!
    }
}
