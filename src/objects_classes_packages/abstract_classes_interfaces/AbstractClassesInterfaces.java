package objects_classes_packages.abstract_classes_interfaces;

import java.util.function.DoubleUnaryOperator;

public class AbstractClassesInterfaces {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double ans = 0, d = (b-a) * 0.00000001;
        while (a <= b) {
            ans += f.applyAsDouble(a) * d;
            a += d;
        }
        return ans;
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer textAnalyzer : analyzers) {
            Label label = textAnalyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }

        return Label.OK;
    }
}
