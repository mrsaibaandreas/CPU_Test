package algos.testbench;

import algos.bench.IBenchmark;
import algos.bench.cpu.CPUDigitsOfPi;
import algos.logging.ConsoleLogger;
import algos.logging.ILogger;
import algos.logging.TimeUnit;
import algos.timing.ITimer;
import algos.timing.Timer;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;

        IBenchmark testBench = new CPUDigitsOfPi();
        testBench.initialize(10000);
        timer.start();
        testBench.run(0);//choose the option
        long endTime = timer.stop();

        log.writeTime("The test has been ended in", endTime, timeUnit);
        log.write(testBench.getResult());
        log.close();
    }

}
