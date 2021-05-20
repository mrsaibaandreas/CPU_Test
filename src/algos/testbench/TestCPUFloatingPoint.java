package algos.testbench;

import algos.bench.IBenchmark;
import algos.bench.cpu.CPUFloatingPoint;

public class TestCPUFloatingPoint {

    public static void main(String[] args) {

        IBenchmark bench = new CPUFloatingPoint();
        bench.warmUp();
        bench.initialize(5000.1234, 3456.7536345); //double a, b

        bench.run('+', '-', '*', '/');//choose the operation
    }

}
