
package org.james.habbo;
import org.james.habbo.util.DateUtil;

public class Emulator {


    private static long mStartUpTime = 0;
    public static void main(String[] args)
    {
        mStartUpTime = System.currentTimeMillis();
        printHeader();

        try
        {

        }
        catch(Exception e)
        {
            System.out.println("The emulator failed to start: " + e.getMessage());
        }

        System.out.println("The emulator has finished starting in " + DateUtil.returnTimeElapsed(mStartUpTime));
    }

    public static void printHeader()
    {
        System.out.println("#########################################################################");
        System.out.println("                     Habbo Hotel Version 6 Emulator");
        System.out.println("                     by: James Purvis (GoldenShox)");
        System.out.println("##########################################################################");
        System.out.println(" ");
        System.out.println("The emulator is starting...");
    }




}


