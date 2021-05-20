package algos.testbench;

import algos.bench.IBenchmark;
import algos.bench.cpu.CPUThreadedRoots;
import algos.logging.ConsoleLogger;
import algos.logging.ILogger;
import algos.logging.TimeUnit;
import algos.timing.ITimer;
import algos.timing.Timer;

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
