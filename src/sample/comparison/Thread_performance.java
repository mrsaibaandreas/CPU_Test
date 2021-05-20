package sample.comparison;

import static java.util.stream.IntStream.rangeClosed;

public class Thread_performance {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: benchmark [million iterations] [maxThreads]");
            return;
        }

        final int MILLION = 1_000_000;
        final int iterations = Integer.parseInt(args[0]);
        final int maxThreads = Integer.parseInt(args[1]);

        for (int threads = 1; threads < maxThreads; threads++) {
            long start = System.currentTimeMillis();
            int count = iterations * MILLION / threads;
            rangeClosed(1, threads).parallel()
                    .forEach(i -> rangeClosed(1, count).mapToDouble(Math::sqrt).sum());

            System.out.println(String.format("Benchmark of %d M iterations on %d thread(s): %d ms", iterations, threads, System.currentTimeMillis() - start));
        }

    }

}


