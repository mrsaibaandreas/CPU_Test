package fixed_point.timing;

public class Timer implements ITimer{
    long start;
    //long end;
    long elapsed;
    long total;
    long resumed;


    public void start()
    {
        start=System.nanoTime();
        total=0;
        elapsed=0;
        resumed=0;
    }

    public long stop()
    {
        elapsed = System.nanoTime() - start;
        //System.out.println(elapsed);
        total = total + elapsed;
        return total;
    }


    public long pause()
    {
        elapsed = System.nanoTime() - start;
        //total=total+elapsed;
        return elapsed;
    }

    public void resume()
    {
        //start=elapsed;
        start = System.nanoTime();
        total=total+elapsed;
        //System.out.println(total);
    }

}
