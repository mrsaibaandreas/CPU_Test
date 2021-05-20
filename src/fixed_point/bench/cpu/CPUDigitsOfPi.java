package fixed_point.bench.cpu;

import fixed_point.bench.IBenchmark;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;


public class CPUDigitsOfPi implements IBenchmark {

    private  int nr_of_digits;
    private static int[] pi_number = new int[100000];
    private static int invalid_number;

    @Override
    public void run() {
        throw new UnsupportedOperationException("Use run(Object)!");
    }

    @Override
    public void run(Object... options) {
        int option = (Integer) options[0];
        switch (option) {
            case 0:
                //computePiMagically();
            case 1:
                Spigot(this.nr_of_digits);
                break;
            case 2:
                //computePiUsingMaths();
                break;
            default:
                throw new IllegalArgumentException("Invalid option, choose between 0-2");
        }
    }

    @Override
    public void initialize(Object... params) {
        this.nr_of_digits = (int) params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {
        Spigot(5000);
    }

    @Override
    public String getResult() {
        String my_string  = pi_number.toString();
        return my_string;
    }

    private void Spigot(int digits) {
        Integer carry = 0;
        Integer size = 10 * digits / 3;
        ArrayList<Integer> array = new ArrayList<Integer>(Collections.nCopies(size,2));

        for (Integer i = 0; i < digits; i++) {
            Integer sum = 0;
            for (Integer j = array.size() - 1; j > 0; j--) {
                sum = array.get(j) * 10 + carry;
                carry = (sum / (2 * j + 1)) * j;
                array.set(j, sum % (2 * j + 1));
            }
            sum = array.get(0) * 10 + carry;
            Integer nextNumber = sum / 10;
            array.set(0, sum % 10);
            nextNumber = non_valid_digits(nextNumber,  i);
            System.out.println(nextNumber);
            pi_number[i] =  nextNumber;
        }
    }

    private Integer non_valid_digits(Integer number, Integer index) {
        if (number == 9) {
            invalid_number++;
            return 9;
        }if (number == 10) {
            for (int where = index - invalid_number; where < index; where++) {
                if (pi_number[index] == 9) {
                    pi_number[index] = 0;
                } else {
                    pi_number[index] = pi_number[index] + 1;
                }
            }
            invalid_number = 0;
            return 0;
        }
        invalid_number = 1;
        return number;
    }

}
