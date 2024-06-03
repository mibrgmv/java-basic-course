package error_processing_exceptions.exceptions_intro;

public class ExceptionsIntro {

    public static double sqrt(double x) {
        if (x < 0) {
            throw new java.lang.IllegalArgumentException(String.format("Expected non-negative number, got %f", x));
        }
        return Math.sqrt(x);
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length > 3) {
            return stackTraceElements[3].getClassName() + "#" + stackTraceElements[3].getMethodName();
        } else {
            return null;
        }
    }
}
