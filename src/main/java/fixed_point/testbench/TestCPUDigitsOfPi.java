package fixed_point.testbench;

import fixed_point.bench.IBenchmark;
import fixed_point.bench.cpu.CPUDigitsOfPi;
import fixed_point.logging.ConsoleLogger;
import fixed_point.logging.ILogger;
import fixed_point.logging.TimeUnit;
import fixed_point.timing.ITimer;
import fixed_point.timing.Timer;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;

        IBenchmark testBench = new CPUDigitsOfPi();
        testBench.initialize(10000);
        testBench.warmUp();
        timer.start();
        testBench.run(1);//choose the option
        long endTime = timer.stop();

        log.writeTime("The test has been ended in", endTime, timeUnit);
        log.write(testBench.getResult());

        testBench.clean();
        log.close();
    }

}
