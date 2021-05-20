package algos.logging;
import java.io.*;

public class FileLogger implements ILogger{

    FileWriter log_file;

    public FileLogger(String file_name) {
        try {
            log_file = new FileWriter(file_name);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void write(long param)
    {
        try {
        log_file.write(String.valueOf(param));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void write(String param)
    {
        try {
        log_file.write(param);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void write(Object ... value)
    {
        try {
        for (Object i: value) {
            log_file.write(i.toString());
            log_file.write(" ");
        }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeTime(long value, TimeUnit unit)
    {
        //System.out.println(String.valueOf(TimeUnit.toTimeUnit(value,unit)));
    }

    public void writeTime(String string, long value, TimeUnit unit)
    {
        //System.out.println(string + " " + String.valueOf(TimeUnit.toTimeUnit(value,unit)) + unit.toString());
    }


    public void close()
    {
        try {
        log_file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
