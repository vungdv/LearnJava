package org.example;
import java.util.Scanner;
interface ITestAble{}
class NotProperNameException extends Exception implements ITestAble{
    NotProperNameException(String msg){
        super(msg);
    }
}
public class CustomCheckedException{
    private String name;
    private int age;
    public static boolean containsAlphabet(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }
    public CustomCheckedException(String name, int age) throws NotProperNameException {
        if(!containsAlphabet(name)&&name!=null) {
            String msg = "Improper name (Should contain only characters between a to z (all small))";
            NotProperNameException exName = new NotProperNameException(msg);
            throw exName;
        }
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("Name of the Student: "+this.name );
        System.out.println("Age of the Student: "+this.age );
    }
}
