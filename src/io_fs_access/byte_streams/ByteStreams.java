package io_fs_access.byte_streams;

import java.io.IOException;
import java.io.InputStream;

public class ByteStreams {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int C_n = 0, b;
        while ((b = inputStream.read()) != -1) {
            C_n =  Integer.rotateLeft(C_n, 1) ^ b;
        }
        return C_n;
    }
}
