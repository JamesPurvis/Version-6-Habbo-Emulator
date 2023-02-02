package org.james.habbo.habbohotel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.configuration.ConfigurationFile;

public class Hotel
{

    private static Hotel mInstance = null;
    private int mVersionNumber;

    private static Logger mLogger = LogManager.getLogger(Hotel.class.getName());

    public int VersionNumber()
    {

        return mVersionNumber;
    }

    public Hotel(int versionNumber)
    {
        this.mVersionNumber = versionNumber;
        mLogger.info("A new HabboHotel instance has been created for version " + mVersionNumber);
    }
    public static Hotel getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new Hotel(Integer.parseInt(ConfigurationFile.getInstance().returnPropBox().get("hotel.version")));
        }

        return mInstance;
    }

}
