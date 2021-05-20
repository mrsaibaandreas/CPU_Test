package fixed_point.testbench;

import fixed_point.bench.IBenchmark;
import fixed_point.bench.cpu.CPUThreadedRoots;
import fixed_point.logging.ConsoleLogger;
import fixed_point.logging.ILogger;
import fixed_point.logging.TimeUnit;
import fixed_point.timing.ITimer;
import fixed_point.timing.Timer;

public class TestCPUThreadedRoots {

    public static void main(String[] args) {
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
