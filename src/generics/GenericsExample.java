package generics;


import a.example.Example;

public class GenericsExample implements Example {
    @Override
    public void run() {
        // Sử dụng lớp Pair
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Double, Character> pair2 = new Pair<>(2.0, 'B');
        System.out.println("Pair1: " + pair1);
        System.out.println("Pair2: " + pair2);

        // Sử dụng lớp GenericMethods
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original array: ");
        GenericMethods.printArray(intArray);
        GenericMethods.swap(intArray, 0, 4);
        System.out.println("Array after swap: ");
        GenericMethods.printArray(intArray);

        // Sử dụng lớp BoundedTypeParameter
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Sum of doubleArray: " + BoundedTypeParameter.calculateSum(doubleArray));
        System.out.println("Larger between 4 and 5: " + BoundedTypeParameter.compare(4, 5));
        System.out.println("Larger between 3.1 and 2.9: " + BoundedTypeParameter.compare(3.1, 2.9));
    }
}
