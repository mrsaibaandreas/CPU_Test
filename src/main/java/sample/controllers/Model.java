package sample.controllers;

public class Model {
    public String operator;
    public String time;
    public Model(String operator, String time)
    {
        this.time = time;
        this.operator = operator;
    }

    public String getOperator()
    {
        return this.operator;
    }
    public String getTime()
    {
        return this.time;
    }



}
