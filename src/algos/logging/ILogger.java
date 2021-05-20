package algos.logging;

public interface ILogger {
    void write(long param);
    void write(String param);
    void write(Object ... values);
    void writeTime(long value, TimeUnit unit);
    void writeTime(String string, long value, TimeUnit unit);
    void close();
}
