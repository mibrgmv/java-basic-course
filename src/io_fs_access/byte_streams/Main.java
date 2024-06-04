package io_fs_access.byte_streams;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int prev = System.in.read(), next;
        while (prev != -1) {
            next = System.in.read();
            if (next != 10 || prev != 13) {
                System.out.write(prev);
            }
            prev = next;
        }
        System.out.flush();
    }
}
