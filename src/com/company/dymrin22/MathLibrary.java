package com.company.dymrin22;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class MathLibrary {


    public int[] getValuesFromArray(int[] array) {
        if (IntStream.of(array).noneMatch(x -> x == 4)) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, Arrays.stream(array).boxed().toList().lastIndexOf(4) + 1, array.length - 1);
    }


    public boolean arrayChecking(int[] array) {
        if (IntStream.of(array).anyMatch(x -> x == 4) && IntStream.of(array).anyMatch(x -> x == 1)) {
            System.out.println(Arrays.toString(array) + "->" + true);
            return true;
        }
        System.out.println(Arrays.toString(array) + "->" + false);
        return false;
    }
}
