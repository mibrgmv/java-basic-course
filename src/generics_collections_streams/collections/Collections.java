package generics_collections_streams.collections;

import java.util.HashSet;
import java.util.Set;

public class Collections {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultingSet = new HashSet<>(), additionSet = new HashSet<>();
        additionSet.addAll(set1);
        additionSet.addAll(set2);
        for (T elem : additionSet) {
            if (!set1.contains(elem) && set2.contains(elem) || set1.contains(elem) && !set2.contains(elem)) {
                resultingSet.add(elem);
            }
        }
        return resultingSet;
    }
}
