
package org.james.habbo;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.james.habbo.configuration.ConfigurationFile;
import org.james.habbo.database.DatabaseManager;
import org.james.habbo.habbohotel.Hotel;
import org.james.habbo.messages.ReactorService;
import org.james.habbo.net.session.GameSessionFactory;
import org.james.habbo.util.DateUtil;
import org.apache.logging.log4j.*;
import org.james.habbo.net.*;

public class Emulator {


    private static long mStartUpTime = 0;
    private static Logger mLogger = LogManager.getLogger(Emulator.class.getName());

    public static void main(String[] args)
    {
        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);

        mStartUpTime = System.nanoTime();

        printHeader();

        ConfigurationFile.getInstance();

        try
        {
            if (ConfigurationFile.getInstance().isLoaded())
            {
                Hotel.getInstance();
                GameSessionFactory.getInstance();
                DatabaseManager.getInstance().createRepositories();
                Server.getInstance().createSocket();
                Server.getInstance().bind();
                ReactorService.getInstance().loadIntialReactors();

            }
        }
        catch(Exception e)
        {
            mLogger.error("The emulator failed to start: " + e.getMessage());
            return;
        }


        mLogger.info("The emulator has finished starting in " + DateUtil.returnTimeElapsed(mStartUpTime) + "ms!");
    }

    public static void printHeader()
    {
        System.out.println("#########################################################################");
        System.out.println("                     Habbo Hotel Version 6 Emulator");
        System.out.println("                     by: James Purvis (GoldenShox)");
        System.out.println("##########################################################################");
        System.out.println(" ");
        System.out.println("The emulator is starting...");
        System.out.println(" ");
    }




}


