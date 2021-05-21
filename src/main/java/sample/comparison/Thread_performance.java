package sample.comparison;

import java.util.ArrayList;

import static java.util.stream.IntStream.rangeClosed;

public class Thread_performance {
    public static ArrayList<String> s = new ArrayList<String>();

    public static void test(String ...params) {
        if (params.length < 2) {
            System.out.println("Usage: benchmark [million iterations] [maxThreads]");
            return;
        }

        final int MILLION = 1_000_000;
        final int iterations = Integer.parseInt(params[0]);
        final int maxThreads = Integer.parseInt(params[1]);

        for (int threads = 1; threads < maxThreads; threads++) {
            long start = System.currentTimeMillis();
            int count = iterations * MILLION / threads;
            rangeClosed(1, threads).parallel()
                    .forEach(i -> rangeClosed(1, count).mapToDouble(Math::sqrt).sum());

            String x = String.format("Benchmark of %d M iterations on %d thread(s): %d ms", iterations, threads, System.currentTimeMillis() - start);
            s.add(x);
            System.out.println(x);
        }

    }

}


