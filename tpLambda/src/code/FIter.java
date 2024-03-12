package code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FIter {


    public static <T, R> Iterable<R> map(Iterable<T> source, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : source) {
            result.add(mapper.apply(item));
        }
        return result;
    }


    public static <T> Iterable<T> filter(Iterable<T> source, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : source) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Iterable<Integer> squaredNumbers = map(numbers, x -> x * x);
        squaredNumbers.forEach(System.out::println);

        // Exemple d'utilisation de filter
        Iterable<Integer> evenNumbers = filter(numbers, x -> x % 2 == 0);
        evenNumbers.forEach(System.out::println);
    }
}
