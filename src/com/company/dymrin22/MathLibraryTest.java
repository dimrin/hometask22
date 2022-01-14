package com.company.dymrin22;



import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MathLibraryTest {


    @ParameterizedTest
    @MethodSource("arraysToGetValue")
    public void testShowNumbersAfterFour_inArray(int[] array) {
        new MathLibrary().getValuesFromArray(array);

    }

    @ParameterizedTest
    @MethodSource("arraysToGetValue")
    public void testCheckArrayForNumbers(int[] array) {
        if (!new MathLibrary().arrayChecking(array)) {
            throw new IllegalArgumentException();
        }

    }

    private static Stream<Arguments> arraysToGetValue() {
        return Stream.of(
                Arguments.of(new int[]{3, 3, 4, 5, 9, 2, 4, 9, 0, 5}),
                Arguments.of(new int[]{1, 5, 3, 0, 8, 1, 4, 0, 2, 6}),
                Arguments.of(new int[]{2, 6, 9, 1, 0, 5, 7, 2, 3, 8}),
                Arguments.of(new int[]{0, 2, 1, 3, 4, 1, 2, 3, 4, 6})
        );
    }


}
