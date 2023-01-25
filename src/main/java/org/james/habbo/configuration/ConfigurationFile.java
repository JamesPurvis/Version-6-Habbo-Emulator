package org.james.habbo.configuration;

import java.io.FileNotFoundException;
import java.lang.module.Configuration;

public class ConfigurationFile
{

    private static ConfigurationFile mInstance = null;
    public ConfigurationFile(String FilePath)
    {
        try
        {

        }
        catch(Exception e)
        {
            System.out.println("Unable to find configuration, check your emulator setup and try again.");
        }
    }

    public static ConfigurationFile getInstance(String filePath)
    {
        if (mInstance == null)
        {
            mInstance = new ConfigurationFile(filePath);
        }

        return mInstance;
    }
}
