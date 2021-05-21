package sample.fixed_point.testbench;

import sample.fixed_point.bench.IBenchmark;
import sample.fixed_point.bench.cpu.CPUThreadedRoots;

import sample.fixed_point.logging.ConsoleLogger;
import sample.fixed_point.logging.ILogger;
import sample.fixed_point.logging.TimeUnit;
import sample.fixed_point.timing.ITimer;
import sample.fixed_point.timing.Timer;

public class TestCPUThreadedRoots {

    public static void test() {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Sec;

        IBenchmark bench = new CPUThreadedRoots();
        bench.initialize(1000000);

        for(int i=32; i >= 1; i /= 2){
            timer.start();
            bench.run(i);
            long time = timer.stop();
            log.writeTime("[t=" + i +"] Finished in ",time,timeUnit );
        }

        bench.clean();
        log.close();
    }

}
