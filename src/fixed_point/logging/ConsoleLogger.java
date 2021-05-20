package fixed_point.logging;

public class ConsoleLogger implements ILogger{
    //public ConsoleLogger() {}
    public void write(long param)
    {
        System.out.println(param);
    }
    public void write(String param)
    {
        System.out.println(param);
    }

    public void write(Object ... values)
    {
        for (Object i: values)
            System.out.print(i + " ");
        System.out.println();
    }

    public void writeTime(long value, TimeUnit unit)
    {
        System.out.println(String.valueOf(TimeUnit.toTimeUnit(value,unit)));
    }

    public void writeTime(String string, long value, TimeUnit unit)
    {
        System.out.println(string + " " + String.valueOf(TimeUnit.toTimeUnit(value,unit)) + " " + unit.toString());
    }


    public void close()
    {}
}
