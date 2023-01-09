import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class Person {
    private String middleName = "Christoper";
    private String firstName;
    private LocalDate dob;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public  static int[] nums = initNums();
    /*
comment or uncomment block: command + /
    static {
        nums = new int[5];
        nums[0] = 5;
        nums[1] = 5;
        nums[2] = 5;
        nums[3] = 5;
        nums[4] = 5;
        nums[5] = 5;
    }
*/

    public static int[] initNums(){
        int[] nums = new int[5];
        nums[0] = 5;
        nums[1] = 5;
        nums[2] = 5;
        nums[3] = 5;
        nums[4] = 5;
        return  nums;
    }
    public void sayHello(){
        System.out.println("Hello");
    }

    public void saySomething(String message){
        System.out.println(message);
    }

    public char getMiddleInitial(){
        return middleName.charAt(0);
    }

    public static int add(int num1, int num2){
        return num1 + num2;
    }

    public static void printAdd(int num1, int num2){
        System.out.println(add(num1, num2));
    }
    private void test(int num1, int num2, String[] words) {
        //do something clever with words
    }
    public void test2(int num1, int num2, String... words){
        // do something clever.
    }

    public int getAgeInYear(){
        return getExactAge().getYears();
    }
    private Period getExactAge(){
        return Period.between(dob, LocalDate.now());
    }
    public static void main(String[] args) {
        //public & static method can be used as an entry point for the class to run.
        Person p1 = new Person();
        p1.sayHello();
        p1.saySomething("My groovy message");
        p1.saySomething("Here's something else to say");
//        System.out.println(p1.getMiddleInitial());
        System.out.println(Person.add(4,5));
        String[] words = new String[]{"one", "two", "three"};
//        p1.test(4, 5, words);
//        p1.test2(3, 5, "one", "two", "three");
        System.out.format("The person's first name is %s", p1.getFirstName());
        Calendar c = Calendar.getInstance();
        c.set(1990, Calendar.SEPTEMBER, 1);
        System.out.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);

    }
}
