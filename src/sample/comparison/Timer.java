package sample.comparison;

public class    Timer {
    static long timeStart = 0L;

    public static void printTimePerWorkItem(long numItems) {
        long timeEnd = System.nanoTime();
        if (0L < timeStart) // Do not print the first time
        {
            double secs = (timeEnd - timeStart) / 1.e9;
<<<<<<< HEAD
            System.out.printf("Duration: %fs; for each one: %es", secs, secs / numItems);
=======
            System.out.printf("Duration: %fs; je St�ck: %es", secs, secs / numItems);
>>>>>>> catricicau
        }
        timeStart = timeEnd;
    }

    private static void stopWatchDifferentStrings() {
        printTimePerWorkItem(0);
        final long NUM = 20_0L;

        {
            String s = ">";
            for (long i = 0; i < NUM; i++) {
                s = '#' + s.substring(1) + "-";
            }
            System.out.println("String Length: " + s.length());
            printTimePerWorkItem(s.length());
        }

        {
            StringBuilder s = new StringBuilder();
            s.append(">");
            for (long i = 0; i < NUM; i++) {
                s.append("-");
                s.setCharAt(0, '#');
            }
            System.out.println("\nStringBuilder Length: " + s.length());
            printTimePerWorkItem(s.length());

        }

        {
            StringBuilder s = new StringBuilder();
            s.append(">");
            for (long i = 0; i < NUM; i++) {
                s.append("-");
                s.setCharAt(0, '#');
            }
            System.out.println("\nStringbuffer length: " + s.length());
            printTimePerWorkItem(s.length());
        }
    }

    public static void main(String[] args) {

        stopWatchDifferentStrings();

    }
}
