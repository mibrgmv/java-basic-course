package basic_syntax.primitive_types;

public class PrimitiveTypes {

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a & b & !(c | d)) | (a & c & !(b | d)) | (a & d & !(b | c)) | (b & c& !(a | d)) | (b & d& !(a | c)) | (c & d& !(a | b));
    }

    public static int leapYearCount(int year) {
        int c = 0;
        c += year / 4;
        c -= year / 100;
        c += year / 400;
        return c;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a+b-c) < 1e-4;
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        int mask = (int)Math.pow(2, bitIndex-1);
        return value ^ mask;
    }
}
