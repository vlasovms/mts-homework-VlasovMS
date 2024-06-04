package homework_Multithreading;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class TwoThreadFactorialPreCalculator implements Runnable {


    private BigInteger multiplyResult = BigInteger.valueOf(0);
    private boolean isEvenIntsMultiply = false;
    private int endOfMultiplyRange = 0;

    public TwoThreadFactorialPreCalculator(boolean isEvenIntsMultiply, int endOfMultiplyRange) {
        this.isEvenIntsMultiply = isEvenIntsMultiply;
        this.endOfMultiplyRange = endOfMultiplyRange;
    }

    private void multiplyOnlyOddOrEvenInts() {   //Метод умножает между собой все чётные(isEvenIntsMultiply=true) или нечётные(isEvenIntsMultiply = false) числа в диапазоне от 0 до endOfMultiplyRange
        int n = isEvenIntsMultiply ? 1 : 0;
        if (endOfMultiplyRange < 2) {
            multiplyResult = BigInteger.valueOf(1);
        } else {
            multiplyResult = IntStream
                    .rangeClosed(2, endOfMultiplyRange)
                    .filter(i -> i % 2 == n)
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger::multiply)
                    .get();
        }

    }

    @Override
    public void run() {
        multiplyOnlyOddOrEvenInts();
    }

    public BigInteger getMultiplyResult() {
        return multiplyResult;
    }

}
