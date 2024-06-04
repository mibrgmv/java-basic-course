package generics_collections_streams.functional_interfaces;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> func = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(func.apply(null));
        System.out.println(func.apply("123"));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return u -> (condition.test(u)) ? ifTrue.apply(u) : ifFalse.apply(u);
    }
}
