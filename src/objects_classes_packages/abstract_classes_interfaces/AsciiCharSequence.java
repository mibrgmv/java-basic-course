package objects_classes_packages.abstract_classes_interfaces;

public class AsciiCharSequence implements CharSequence {
    private final byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] res = new byte[end-start];
        for (int i=0; i<end-start; ++i) {
            res[i] = bytes[i+start];
        }
        return new AsciiCharSequence(res);
    }

    @Override
    public String toString() {
        return new String(bytes);
    }
}