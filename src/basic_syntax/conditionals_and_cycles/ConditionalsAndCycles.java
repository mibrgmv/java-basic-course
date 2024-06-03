package basic_syntax.conditionals_and_cycles;

import java.math.BigInteger;

public class ConditionalsAndCycles {

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger ans = BigInteger.valueOf(1);
        for (int i = 1; i<=value; ++i) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
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

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder builder = new StringBuilder();
        for (String role : roles) {
            builder.append("\n".concat(role).concat(":\n"));
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
}
