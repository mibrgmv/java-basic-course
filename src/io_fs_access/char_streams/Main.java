package io_fs_access.char_streams;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                sum += Double.parseDouble(scanner.next());
            } catch (Exception ignored) { }
        }
        System.out.printf("%.6f", sum);
    }
}
