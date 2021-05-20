package sample.comparison;

public class AlgorithmComparison {


    public static void h1(String h1) {
        System.out.printf("\n-- %-50s %s\n", h1, "------------------");
    }

    public static void prtVar(String name, int val, boolean binToo) {
        System.out.printf("%18s == %-12d %36s\n", name, val, binToo ? Integer.toBinaryString(val) : "");
    }

    public static void prtVar(String name, int val) {
        prtVar(name, val, false);
    }

    public static void main(String[] args) {
        int b = 3, x;


        h1("Shift operations performance");
        final long nTests = 4_000_000L;
        float sum = 0;
        int n = 4, i;
        int twoSquaredN = 1 << n;
        // Set the clock to 0:
        sample.comparison.Timer.printTimePerWorkItem(0);

        System.out.print(nTests + " times <<n: ");
        for (i = 0; i < nTests; i++) {
            sum += b << n;
        }
        sample.comparison.Timer.printTimePerWorkItem(nTests);

        System.out.print("\n" + nTests + " times *16: ");
        for (i = 0; i < nTests; i++) {
            sum += b * twoSquaredN;
        }
        sample.comparison.Timer.printTimePerWorkItem(nTests);

        /*
         * Output: 2000000000 times <<n: Duration: 5,743777s; For each piece: 2,871889e-09s
         * 2000000000 times *16: Duration: 5,826090s; For each piece: 2,913045e-09s // Measured on
         * jre 1.8.0_40, Intel I7-4650U, Win10
         */

    }
}









