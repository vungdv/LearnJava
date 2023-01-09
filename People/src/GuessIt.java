import java.util.Random;

public class GuessIt {
    public static void main(String[] args) {
        String card = "3";
        int currentValue = switch (card) {
            case "king", "queen", "jack" -> 10;
            case "ace" -> 1;
            default -> Integer.parseInt(card);
        };
        System.out.println(currentValue);
    }
}
