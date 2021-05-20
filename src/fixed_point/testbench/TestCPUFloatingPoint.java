package fixed_point.testbench;

import fixed_point.bench.IBenchmark;
import fixed_point.bench.cpu.CPUDigitsOfPi;
import fixed_point.bench.cpu.CPUFloatingPoint;
import fixed_point.logging.ConsoleLogger;
import fixed_point.logging.ILogger;
import fixed_point.logging.TimeUnit;
import fixed_point.timing.ITimer;
import fixed_point.timing.Timer;

public class TestCPUFloatingPoint {

    public static void main(String[] args) {

        IBenchmark bench = new CPUFloatingPoint();
        bench.warmUp();
        bench.initialize(5000.1234, 3456.7536345); //double a, b

        bench.run('+', '-', '*', '/');//choose the operation
    }

}
