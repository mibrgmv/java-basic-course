package generics_collections_streams.stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (mid(Math.pow(n, 2))));
    }

    private static int mid(double R) {
        return (int) R / 10 % 1000;
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        minMaxConsumer.accept(list.get(0) ,list.get(list.size()-1));
    }
}
