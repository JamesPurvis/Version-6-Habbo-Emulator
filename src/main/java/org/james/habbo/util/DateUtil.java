package org.james.habbo.util;

import java.text.DecimalFormat;

public class DateUtil {

    public static String returnTimeElapsed(long timeStart)
    {
        DecimalFormat mFormat = new DecimalFormat("#.#");
        return mFormat.format((System.nanoTime() - timeStart) / 1e6);
    }
}
