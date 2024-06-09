package generics;

public class BoundedTypeParameter {
    public static <T extends Number> double calculateSum(T[] array){
        double sum = 0.0;
        for (T elements : array){
            sum += elements.doubleValue();
        }
        return sum;
    }

    public static <T extends Comparable<T>> T compare(T obj1, T obj2) {
        return (obj1.compareTo(obj2) > 0)? obj1 : obj2;
    }
}
