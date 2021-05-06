package fixed_point.testbench;

import fixed_point.bench.cpu.CPUFixedPoint;
import fixed_point.logging.ConsoleLogger;
import fixed_point.logging.ILogger;
import fixed_point.logging.TimeUnit;
import fixed_point.timing.ITimer;
import fixed_point.timing.Timer;
import fixed_point.bench.IBenchmark;
//import fixed_point.bench.cpu.CPUFixedPoint;
//import fixed_point.bench.cpu.CPUNumberRepresentation;


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
