
package org.james.habbo;
import org.james.habbo.configuration.ConfigurationFile;
import org.james.habbo.util.DateUtil;

public class Emulator {


    private static long mStartUpTime = 0;
    private static ConfigurationFile mConfigFile = null;


    public static void main(String[] args)
    {
        mStartUpTime = System.nanoTime();

        printHeader();

        try
        {
            ConfigurationFile.getInstance("");
        }
        catch(Exception e)
        {
            System.out.println("The emulator failed to start!");
            return;
        }


        System.out.println("The emulator has finished starting in " + DateUtil.returnTimeElapsed(mStartUpTime) + "ms!");
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


