package io_fs_access.char_streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class CharStreams {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int a;
        StringBuilder sb = new StringBuilder();
        while ((a = reader.read()) != -1) {
            sb.append((char)a);
        }
        return sb.toString();
    }
}
