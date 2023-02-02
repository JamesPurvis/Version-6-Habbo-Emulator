package org.james.habbo.habbohotel;

import org.james.habbo.configuration.ConfigurationFile;

public class Hotel
{

    private static Hotel mInstance = null;
    private int mVersionNumber;

    public int VersionNumber()
    {
        return mVersionNumber;
    }
    public Hotel(int versionNumber)
    {
        this.mVersionNumber = versionNumber;
        System.out.println("A new HabboHotel instance has been created for version " + mVersionNumber);
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
