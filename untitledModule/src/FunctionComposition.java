import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> inc = x -> x + 1;
        Function<Integer, Integer> square = x -> x * x;

        Function<Integer, Integer> h = compose(square, inc);
        int result = h.apply(6);
        System.out.println(result);  // Output: 49
    }

    public static <T> Function<T, T> compose(Function<T, T> f, Function<T, T> g) {
        return f.compose(g);
    }
}