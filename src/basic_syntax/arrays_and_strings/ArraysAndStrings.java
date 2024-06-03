package basic_syntax.arrays_and_strings;

public class ArraysAndStrings {

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
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
}
