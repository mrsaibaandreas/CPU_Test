package algos.bench.cpu;

import algos.bench.IBenchmark;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class CPUThreadedRoots implements IBenchmark {

    private double result;
    private int size;
    private boolean running;

    @Override
    public void initialize(Object... params) {
        this.size = (int) params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void warmUp() {
        int proc = Runtime.getRuntime().availableProcessors();
        run(proc);
        // call run method: call run() once
        // detect number of cores: Runtime.....availableProcessors();

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Objects...) instead");
    }

    @Override
    public void run(Object... options) {

        int nThreads = (int)options[0];
        Thread[] threads = new Thread[nThreads];

        // e.g. 1 to 10,000 on 4 threads = 2500 jobs per thread
        final int jobPerThread = size/nThreads; /**/


        running = true; // flag used to stop all started threads

        try {
            for(int i = nThreads; i > 0; i--) {
                // Let the thread sleep for a while.
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // create a thread for each runnable (SquareRootTask) and start it
        for (int i = 0; i < nThreads; ++i) {
            threads[i] = new Thread(new SquareRootTask(i * jobPerThread + 1, (i+1) * jobPerThread));
            start(threads[i]);
        }

        // join threads
        for (int i = 0; i < nThreads; ++i) {
            try{
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void start (Thread t) {
        if (t == null) {
            t.start();
        }
    }

    @Override
    public String getResult() {
        return String.valueOf(result);
    }

    class SquareRootTask implements Runnable {

        private final int from, to;
        private final double precision = 1e-4; // fixed
        private double result = 0.0;


        public SquareRootTask(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {

            for(double i = from; i < to; ++i){
                result += getNewtonian(i);
                updateValue(result);
            }
        }

        private double getNewtonian(double x) {
            double res = 0.0;
            while(abs(pow(res,2) - x) > precision){
                res = (x/res + res)/2;
            }

            return res;
        }

        public synchronized void updateValue (double k) {
            CPUThreadedRoots.this.result +=k;
        }

        // extra: compute sum, pass it back to wrapper class. Use synchronized
    }


}
