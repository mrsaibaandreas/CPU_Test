package sample.fixed_point.testbench;

import sample.fixed_point.bench.cpu.CPUFixedPoint;
import sample.fixed_point.logging.ConsoleLogger;
import sample.fixed_point.logging.ILogger;
import sample.fixed_point.logging.TimeUnit;
import sample.fixed_point.timing.ITimer;
import sample.fixed_point.timing.Timer;
import sample.fixed_point.bench.IBenchmark;
//import sample.fixed_point.bench.cpu.CPUFixedPoint;
//import sample.fixed_point.bench.cpu.CPUNumberRepresentation;


public class TestCPUFixedPoint {

    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Milli;

        IBenchmark bench = new CPUFixedPoint();
        bench.initialize((long) 1e7);
        bench.warmUp();

        timer.start();

        bench.run(0);
        bench.run(1);
        bench.run(2);
        long time = timer.stop();
        log.writeTime("Finished in", time, timeUnit);
        log.write("Result is : ", bench.getResult());
        double mops = Double.parseDouble(bench.getResult()) / (time / 1e9) ;
        log.write("MOPS: ",mops);


        bench.clean();
        log.close();
    }



}
