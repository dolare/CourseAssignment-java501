// Timer.java
/*
 * to calc the time
 */

package jiugong2;
import java.util.*;

/**
 *
 * @author yuankui
 */
public class Timer {
    private Date oldtime;
    private Date newtime;
    private long cost;
    public void begin() {
        oldtime = new Date();
    }

    public void end() {
        newtime = new Date();
    }

    public long getCost() {
        return newtime.getTime() - oldtime.getTime();
    }

}
