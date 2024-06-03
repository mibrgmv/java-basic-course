import java.util.Scanner;

public class SymbolReader {

    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                sum += Double.parseDouble(scanner.next());
            } catch (Exception e) {
            }

        }
        System.out.printf("%.6f", sum);
    }
}
