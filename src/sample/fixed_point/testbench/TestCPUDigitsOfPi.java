package sample.fixed_point.testbench;

import sample.fixed_point.bench.IBenchmark;
import sample.fixed_point.bench.cpu.CPUDigitsOfPi;
import sample.fixed_point.logging.ConsoleLogger;
import sample.fixed_point.logging.ILogger;
import sample.fixed_point.logging.TimeUnit;
import sample.fixed_point.timing.ITimer;
import sample.fixed_point.timing.Timer;

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
