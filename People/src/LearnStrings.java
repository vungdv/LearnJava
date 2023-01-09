public class LearnStrings {
    public static void main(String[] args) {
        String firstName = """
                <html>
                div>here's a div block</div>
                </html>
                """;
//        firstName.compareToIgnoreCase()
        System.out.format("'%s'", firstName.stripIndent());
    }
}
