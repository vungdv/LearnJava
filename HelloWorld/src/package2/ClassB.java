package package2;

public class ClassB {
    public void publicMethod(){
        System.out.println("This is public method");
    }
    private void privateMethod(){
        System.out.println("This is private method");
    }
    protected void protectedMethod(){
        System.out.println("This is protected method");
    }

    //The same as protected one, but can't access by child class in another package.
    //The package can't extend package, it is able to use only!
    void packageProtected(){
        System.out.println("This is package protected");
    }
}
