package sample.fixed_point.testbench;

import sample.fixed_point.bench.IBenchmark;
import sample.fixed_point.bench.cpu.CPUFloatingPoint;

public class TestCPUFloatingPoint {
    public static void test(Character f) {

        IBenchmark bench = new CPUFloatingPoint();
        bench.warmUp();
        bench.initialize(5000.1234, 3456.7536345); //double a, b

        bench.run('f','+', '-', '*', '/');//choose the operation
    }
}
