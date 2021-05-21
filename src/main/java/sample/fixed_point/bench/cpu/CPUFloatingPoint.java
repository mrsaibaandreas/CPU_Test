package sample.fixed_point.bench.cpu;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controllers.Model;
import sample.fixed_point.bench.IBenchmark;
import sample.fixed_point.logging.ConsoleLogger;
import sample.fixed_point.logging.ILogger;
import sample.fixed_point.logging.TimeUnit;
import sample.fixed_point.timing.ITimer;
import sample.fixed_point.timing.Timer;

import java.util.ArrayList;

public class CPUFloatingPoint implements IBenchmark {

    public static ObservableList<Model> data_float = FXCollections.observableArrayList(
            new Model("Demo", "Demo")
    );
    public static ObservableList<Model> data_double = FXCollections.observableArrayList(
            new Model("Demo", "Demo")
    );
    public static ArrayList<Character> operators;
    ITimer timer = new Timer();
    TimeUnit timeUnit = TimeUnit.Micro;
    ILogger log = new ConsoleLogger();

    float aF, bF; //single precision
    float add, sub, mul, div;

    double aD, bD;//double precision
    double Add, Sub, Mul, Div;

    double endTime;

    @Override
    public void run() {

    }

    @Override
    public void run(Object... params) {
        operators = new ArrayList<Character>();

        for (int i = 1; i < params.length; i++) {
            operators.add((Character) params[i]);
        }
        switch ((Character)params[0]) {
            case 'f':
                data_float.add(new Model("Demo", "Demo"));
                for (Character operator : operators) {
                    timer.start();
                    doOperation(operator, "float");
                    endTime = timer.stop();
                    log.writeTime("Time for operation " + "[" + operator + " & " + "float" + "]"
                            + " is", (long) endTime, timeUnit);
                    data_float.add(new Model(operator.toString(), Double.toString(endTime)));
                }
                break;

            case 'd':
                data_float.add(new Model("Demo", "Demo"));

                for (Character operator : operators) {
                    timer.stop();
                    doOperation(operator, "double");
                    endTime = timer.stop();
                    log.writeTime("Time for operation " + "[" + operator + " & " + "double" + "]"
                            + " is", (long) endTime, timeUnit);
                    System.out.println(endTime);
                    data_float.add(new Model(operator.toString(), Double.toString(endTime)));

                }
                log.close();
        }
    }

        private void doOperation (Character operation, String type){

            switch (type) {
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

        private void divideNumbers ( char type){
            if (type == 'f')
                div = aF / bF;
            else
                Div = aD / bD;
        }

        private void multiplyNumbers ( char type){
            if (type == 'f')
                mul = aF * bF;
            else
                Mul = aD * bD;
        }

        private void subtractNumbers ( char type){
            if (type == 'f')
                sub = aF - bF;
            else
                Sub = aD - bD;
        }

        private void addNumbers ( char type){
            if (type == 'f')
                add = aF + bF;
            else
                Add = aD + bD;
        }

        @Override
        public void initialize (Object...params){
            this.aF = Float.parseFloat(params[0].toString());
            this.bF = Float.parseFloat(params[1].toString());
            this.aD = Double.parseDouble(params[0].toString());
            this.bD = Double.parseDouble(params[1].toString());
        }

        @Override
        public void clean () {

        }

        @Override
        public void cancel () {

        }

        @Override
        public void warmUp () {

            double x = 1234.234, y = 123443.22;
            aD = x;
            bD = y;
            doOperation('+', "double");
        }

        @Override
        public String getResult () {
            return null;
        }

    }
