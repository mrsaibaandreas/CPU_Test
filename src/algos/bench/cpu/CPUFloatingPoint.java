package algos.bench.cpu;

import algos.bench.IBenchmark;
import algos.logging.ConsoleLogger;
import algos.logging.ILogger;
import algos.logging.TimeUnit;
import algos.timing.ITimer;

import java.util.ArrayList;

public class CPUFloatingPoint implements IBenchmark {

    ArrayList<Character> operators;
    ITimer timer = new algos.timing.Timer();
    TimeUnit timeUnit = TimeUnit.Micro;
    ILogger log = new ConsoleLogger();

    float aF, bF; //single precision
    float add, sub, mul, div;

    double aD, bD;//double precision
    double Add, Sub, Mul, Div;

    long endTime;

    @Override
    public void run() {

    }

    @Override
    public void run(Object... params) {
        operators = new ArrayList<Character>();

        for (int i = 0; i < params.length; i++){
            operators.add((Character) params[i]);
        }

        for (Character operator : operators) {
            timer.start();
            doOperation(operator, "float");
            endTime = timer.stop();
            log.writeTime("Time for operation " + "["+ operator + " & " + "float" +"]"
                    + " is" , endTime , timeUnit);
        }

        for (Character operator : operators) {
            timer.stop();
            doOperation(operator, "double");
            endTime = timer.stop();
            log.writeTime("Time for operation " + "["+ operator + " & " + "double" +"]"
                    + " is" , endTime , timeUnit);
        }
        log.close();
    }

    private void doOperation(Character operation, String type) {

        switch (type){
            case "float":
                switch (operation) {
                    case '+':
                        addNumbers('f');
                    case '-':
                        subtractNumbers('f');
                    case '*':
                        multiplyNumbers('f');
                    case '/':
                        divideNumbers('f');
                }
            case "double":
                switch (operation) {
                    case '+':
                        addNumbers('d');
                    case '-':
                        subtractNumbers('d');
                    case '*':
                        multiplyNumbers('d');
                    case '/':
                        divideNumbers('d');
                }
        }

    }

    private void divideNumbers(char type) {
        if (type == 'f')
            div = aF / bF;
        else
            Div = aD / bD;
    }

    private void multiplyNumbers(char type) {
        if (type == 'f')
            mul = aF * bF;
        else
            Mul = aD * bD;
    }

    private void subtractNumbers(char type) {
        if (type == 'f')
            sub = aF - bF;
        else
            Sub = aD - bD;
    }

    private void addNumbers(char type) {
        if (type == 'f')
            add = aF + bF;
        else
            Add = aD + bD;
    }

    @Override
    public void initialize(Object... params) {
        this.aF = Float.parseFloat(params[0].toString());
        this.bF = Float.parseFloat(params[1].toString());
        this.aD = Double.parseDouble(params[0].toString());
        this.bD = Double.parseDouble(params[1].toString());
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

        double x = 1234.234, y = 123443.22;
        aD = x; bD = y;
        doOperation('+',"double");
    }

    @Override
    public String getResult() {
        return null;
    }

}
