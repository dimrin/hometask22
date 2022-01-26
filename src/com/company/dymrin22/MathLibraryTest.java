package com.company.dymrin22;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class MathLibraryTest {

    @Test
    public void testThrowRuntimeException_whenNo4DigitFound_inPassedArray() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                MathLibrary.getValuesAfterFourFromArray(new int[]{1, 2, 3, 5});
            }
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testThrowRuntimeException_whenNoDigitsFound_inPassedArray(int[] array) {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                MathLibrary.getValuesAfterFourFromArray(array);
            }
        });
    }

    @ParameterizedTest
    @MethodSource("arraysToGetValue")
    public void testShowNumbersAfterFour_inArray(int[] array, int[] expected) {
        Assertions.assertArrayEquals(expected, MathLibrary.getValuesAfterFourFromArray(array));

    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testThrowRuntimeException_whenNoValuesFound_inPassedArray(int[] array) {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                MathLibrary.checkArrayForOneAndFour(array);
            }
        });
    }

    @ParameterizedTest
    @MethodSource("arrayWithOneOrFourDigitProvider")
    public void testCheckOneOrFourValuePresents_inPassedArray(int[] array) {
        Assertions.assertTrue(MathLibrary.checkArrayForOneAndFour(array));
    }

    private static Stream<Arguments> arraysToGetValue() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[0]),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 4, 8, 9}, new int[]{8, 9})
        );
    }

    private static Stream<int[]> arrayWithOneOrFourDigitProvider() {
        return Stream.of(
                new int[]{1},
                new int[]{4},
                new int[]{1, 2, 3},
                new int[]{4, 3, 5, 6},
                new int[]{1, 3, 5, 4}
        );
    }


}
