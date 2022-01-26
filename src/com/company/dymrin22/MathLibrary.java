package com.company.dymrin22;

import java.util.stream.IntStream;

public final class MathLibrary {


    public static int[] getValuesAfterFourFromArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Inbound array cannot be null nor empty.");
        }
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) index = i;
        }

        if (index == -1) {
            throw new RuntimeException("Inbound array must contain one 4-digit at least.");
        }

        int[] newDigits = new int[array.length - index - 1];
        System.arraycopy(array, index + 1, newDigits, 0, newDigits.length);

        return newDigits;
    }


    public static boolean checkArrayForOneAndFour(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Inbound array cannot be null nor empty.");
        }

        return IntStream.of(array).anyMatch(x -> x == 4) && IntStream.of(array).anyMatch(x -> x == 1);
    }
}
