package sample.comparison;

public class AlgorithmComparison {


    /**
     * Überschrift ausgeben
     */
    public static void h1(String h1) {
        System.out.printf("\n-- %-50s %s\n", h1, "------------------");
    }

    /**
     * Int-Ausdruck und dessen Bitmuster ausgeben
     */
    public static void prtVar(String name, int val, boolean binToo) {
        System.out.printf("%18s == %-12d %36s\n", name, val, binToo ? Integer.toBinaryString(val) : "");
    }

    /**
     * Int-Ausdruck ausgeben
     */
    public static void prtVar(String name, int val) {
        prtVar(name, val, false);
    }

    // Funktionen, die lediglich ihren Namen ausgeben,
    // um die Reihenfolge zu betrachten:
    public static int f() {
        System.out.print("f() ");
        return 1;
    }

    public static int g() {
        System.out.print("g() ");
        return 2;
    }

    public static int h() {
        System.out.print("h() ");
        return 3;
    }

    public static int biVariat(int a, int b) {
        System.out.println(" biVariat");
        return 4;
    }

    public static void main(String[] args) {
        int b = 3, x;


        h1("Shift-Operatoren: Performance");
        final long nTests = 4_000_000L;
        float sum = 0;
        int n = 4, i;
        int zweiHochN = 1 << n;
        // Stoppuhr nullen:
        sample.comparison.Timer.printTimePerWorkItem(0);

        System.out.print(nTests + " mal <<n: ");
        for (i = 0; i < nTests; i++) {
            sum += b << n;
        }
        sample.comparison.Timer.printTimePerWorkItem(nTests);

        System.out.print("\n" + nTests + " mal *16: ");
        for (i = 0; i < nTests; i++) {
            sum += b * zweiHochN;
        }
        sample.comparison.Timer.printTimePerWorkItem(nTests);

        /*
         * Ausgabe: 2000000000 mal <<n: Dauer: 5,743777s; je Stück: 2,871889e-09s
         * 2000000000 mal *16: Dauer: 5,826090s; je Stück: 2,913045e-09s // Gemessen auf
         * jre 1.8.0_40, Intel I7-4650U, Win10
         */

    }
}









