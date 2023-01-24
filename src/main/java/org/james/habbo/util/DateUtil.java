package org.james.habbo.util;

public class DateUtil {

    public static long returnTimeElapsed(long timeStart)
    {
        return System.currentTimeMillis() - timeStart;
    }
}
