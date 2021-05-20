package fixed_point.bench.cpu;
import fixed_point.bench.IBenchmark;
import static java.lang.String.valueOf;


public class CPUFixedPoint implements IBenchmark {


    private long size;
    private int num[];
    private int res[];
    private int j, k, l;
    private double mop;


    public void initialize(Object... params) {

        this.size = (long) params[0];
        num = new int[]{0, 1, 2, 3};
        res = new int[4];
        mop = 0;
    }


    public void warmUp() {

        for(int i=0;i<3;i++) {
            integerArithmetic();
            branching();
            arrayAssignments();
        }
    }



    public void run() {
        throw new UnsupportedOperationException("Use run(Object)!");

    }


    public void run(Object... options) {
            switch((Integer) options[0]) {
                case 0:
                    branching();
                    mop += 11.0 * size / 1e6;
                    break;
                case 1:
                    integerArithmetic();
                    mop += 29.0 * size / 1e6;
                    break;
                case 2:
                    arrayAssignments();
                    mop += 12.0 * size / 1e6;
                    break;
                default:
                    break;
            }
    }


    public void cancel() {

    }

    public void clean() {
    }

    public String getResult() {
        return valueOf(mop);
    }


    public void integerArithmetic() {
        j = 1;
        k = 2;
        l = 3;
        for (int i = 0; i < size; i++) {
            j = num[1] * (k - j) * (l - k);
            k = num[3] * k - (l - j) * k;
            l = (l - k) * (num[2] + j);
            res[l - 2] = j + k + l;
            res[k - 2] = j * k * l;
        }
    }

    private void branching()
    {
        int i, j=0;

        for(i=0;i<size;i++) {
            if (j == 1) {
                j = num[2];
            } else {
                j = num[3];
            }

            if (j > 2) {
                j = num[0];
            } else
            {
                j = num[1];
            }

            if (j < 1) {
                j = num[1];
            } else
            {
                j = num[0];
            }
        }
    }

    private void arrayAssignments()
    {
        int i, j=0, k=1, l=2;

        for(i = 0; i<size;i++)
        {
            res[j] = res[k];
            res[k] = res[l];
            res[l] = res[j];
        }

    }

}

