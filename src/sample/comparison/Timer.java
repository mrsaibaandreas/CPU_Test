package sample.comparison;

public class    Timer {
    static long timeStart = 0L;

    public static void printTimePerWorkItem(long numItems) {
        long timeEnd = System.nanoTime();
        if (0L < timeStart) // Beim ersten Mal nicht drucken
        {
            double secs = (timeEnd - timeStart) / 1.e9;
            System.out.printf("Dauer: %fs; je St�ck: %es", secs, secs / numItems);
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
            System.out.println("L�nge String: " + s.length());
            printTimePerWorkItem(s.length());
        }

        {
            StringBuilder s = new StringBuilder();
            s.append(">");
            for (long i = 0; i < NUM; i++) {
                s.append("-");
                s.setCharAt(0, '#');
            }
            System.out.println("\nL�nge StringBuilder: " + s.length());
            printTimePerWorkItem(s.length());

        }

        {
            StringBuilder s = new StringBuilder();
            s.append(">");
            for (long i = 0; i < NUM; i++) {
                s.append("-");
                s.setCharAt(0, '#');
            }
            System.out.println("\nL�nge Stringbuffer: " + s.length());
            printTimePerWorkItem(s.length());
        }
    }

    public static void main(String[] args) {

        stopWatchDifferentStrings();

    }
}
