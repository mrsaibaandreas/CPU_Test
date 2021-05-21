package algos.testbench;

import algos.bench.cpu.CPUFixedPoint;
import algos.logging.ConsoleLogger;
import algos.logging.ILogger;
import algos.logging.TimeUnit;
import algos.timing.ITimer;
import algos.timing.Timer;
import algos.bench.IBenchmark;
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
