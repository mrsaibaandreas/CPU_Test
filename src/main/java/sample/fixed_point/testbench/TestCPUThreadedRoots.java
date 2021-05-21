package sample.fixed_point.testbench;

import sample.fixed_point.bench.IBenchmark;
import sample.fixed_point.bench.cpu.CPUThreadedRoots;

import sample.fixed_point.logging.ConsoleLogger;
import sample.fixed_point.logging.ILogger;
import sample.fixed_point.logging.TimeUnit;
import sample.fixed_point.timing.ITimer;
import sample.fixed_point.timing.Timer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestCPUThreadedRoots {
    public static ArrayList<String> output = new ArrayList<String>();

    public static void test(int nOfThreads, int workload) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Sec;

        IBenchmark bench = new CPUThreadedRoots();
        bench.initialize(workload); //workload
        for(int i = nOfThreads; i >= 1; i /= 2){
          bench.warmUp();
        }
        for(int i = nOfThreads; i >= 1; i /= 2){
            timer.start();
            bench.run(i);
            long time = timer.stop();
            log.writeTime("[t=" + i +"] Finished in ",time,timeUnit );
            output.add("[t=" + i +"] Done in " + time + "\n");
        }

        bench.clean();
        log.close();
    }

}
