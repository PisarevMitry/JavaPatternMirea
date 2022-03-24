import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    final static Comparator<String> comparator = (a, b) -> {
        int sumA = 0, sumB = 0;
        sumA = IntStream.range(0, a.length()).filter(i -> Character.isDigit(a.charAt(i))).map(i -> a.charAt(i) - '0').sum();
        sumB = IntStream.range(0, b.length()).filter(i -> Character.isDigit(b.charAt(i))).map(i -> b.charAt(i) - '0').sum();
        return Integer.compare(sumA, sumB);
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(comparator.compare(a, b));
    }
}
