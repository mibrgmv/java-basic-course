import io_fs_access.advanced_capabilities.Animal;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.DoubleUnaryOperator;

public class Test {
    public static void main(String[] args) {

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int n = ois.readInt();
            animals = new Animal[n];

            for (int i=1; i<=n; ++i) {
                Animal animal = (Animal) ois.readObject();
                animals[i-1] = animal;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }

    public static void getASCII_code() throws IOException {
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write('ф');
        writer.flush();
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int a, i=0;
        StringBuilder sb = new StringBuilder();
        while ((a = reader.read()) != -1) {
            sb.append((char)a);
        }
        if (i == 0) {
            return "";
        }
        return sb.toString();
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        byte[] bytes = inputStream.readAllBytes();
        int C_n = 0;
        for (byte i : bytes) {
            C_n =  Integer.rotateLeft(C_n, 1) ^ i;
        }
        return C_n;
    }

    public static int calc(int C_n, int b_nPlusOne) {
        return Integer.rotateLeft(C_n, 1) ^ b_nPlusOne;
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length > 3) {
            return stackTraceElements[3].getClassName() + "#" + stackTraceElements[3].getMethodName();
        } else {
            return null;
        }
    }

    public static int flipBit(int value, int bitIndex) {
        int mask = (int)Math.pow(2, bitIndex-1);
        return value ^ mask;
    }

    public static char charExpression(int a) {
        return (char)  ('\\' + a);
    }

    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        return Integer.bitCount(value) == 1;
    }

    public static boolean isPalindrome(String text) {
        text = text.toLowerCase();
        for (int i=0, j=text.length()-1; i<j; ) {
            if (!Character.isLetterOrDigit(text.charAt(j))) {
                --j;
                continue;
            }
            if (!Character.isLetterOrDigit(text.charAt(i))) {
                ++i;
                continue;
            }

            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }

        return true;
    }

    public static BigInteger factorial(int value) {
        BigInteger ans = BigInteger.valueOf(1);
        for (int i = 1; i<=value; ++i) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] ans = new int[a1.length + a2.length];
        int i=0, j=0;
        for (int k = 0; k < ans.length; ++k) {
            if (j >= a2.length || (i < a1.length && a1[i] <= a2[j])) {
                ans[k] = a1[i];
                ++i;
            } else {
                ans[k] = a2[j];
                ++j;
            }
        }
        return ans;
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder builder = new StringBuilder();
        for (String role : roles) {
            builder.append("\n".concat(role).concat(": \n"));
            for (int j = 0; j < textLines.length; ++j) {
                if (textLines[j].startsWith(role.concat(":"))) {
                    builder.append(j + 1)
                            .append(") ")
                            .append(textLines[j].substring(role.length() + 2))
                            .append("\n");
                }
            }
        }
        return builder.toString();
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double ans = 0, d = (b-a) * 0.00000001;
        while (a <= b) {
            ans += f.applyAsDouble(a) * d;
            a += d;
        }
        return ans;
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException(String.format("Expected non-negative number, got %f", x));
        }
        double ans = 0.0001;
        while (x - ans*ans > 0.0001) {
            ans += 0.0001;
        }
        return ans;
    }
}