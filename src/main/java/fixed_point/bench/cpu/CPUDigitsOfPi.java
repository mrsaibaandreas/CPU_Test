package fixed_point.bench.cpu;

import fixed_point.bench.IBenchmark;

import java.math.BigInteger;


public class CPUDigitsOfPi implements IBenchmark {

    private int nr_of_digits;

    @Override
    public void run() {

    }

    @Override
    public void run(Object... options) {
        int option = (Integer) options[0];
        switch (option){
            case 0:
                //computePiMagically();
            case 1:
                Spigot(this.nr_of_digits   );
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

    }

    @Override
    public String getResult() {
        return null;
    }
    private void Spigot(int digits){
        int carry = 0;
        int size = 10*digits/3;
        int[] array = new int[digits] ;
        for(int i = 0; i < digits; i++)
        {
            int sum = 0;
            for(int j = size - 1; j > 0; j--)
            {
                sum = array[j] * 10 + carry;
                carry = (sum / ( 2 * j +1)) * j;
                array[j] = sum % (2 * j + 1);
            }
        }
    }

}
