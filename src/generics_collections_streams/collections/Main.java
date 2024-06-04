package generics_collections_streams.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arr.add(scanner.nextInt());
        }
        for (int i=arr.size()-1; i>=0; --i) {
            if (i % 2 == 1) {
                System.out.print(arr.get(i).toString() + ' ');
            }
        }
    }
}
