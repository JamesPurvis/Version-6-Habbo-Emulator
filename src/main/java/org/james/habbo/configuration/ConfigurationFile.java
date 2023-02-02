package org.james.habbo.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.io.FileNotFoundException;
import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigurationFile
{

    private static ConfigurationFile mInstance = null;
    private File mConfigFile = null;
    private HashMap<String, String> mProperties = null;

    private static Logger mLogger = LogManager.getLogger(ConfigurationFile.class.getName());

    private boolean mIsLoaded = false;

    public ConfigurationFile(String FilePath)
    {
        mConfigFile = new File(FilePath);

        try {
            loadConfigurationFile();
        } catch (FileNotFoundException e) {
            mLogger.error("server.configuration file is missing! Please check your setup and try again.");
        }
    }

    public static ConfigurationFile getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new ConfigurationFile("/Users/andypurvis/IdeaProjects/Version6Habbo/src/main/resources/server.configuration");
        }

        return mInstance;
    }


    private void loadConfigurationFile() throws FileNotFoundException {
        Scanner mScanner = new Scanner(mConfigFile);
        mProperties = new HashMap<String, String>();

        while(mScanner.hasNextLine())
        {
           String mLine = mScanner.nextLine();

           if (!mLine.isBlank())
           {
               String mPropertyHeader = mLine.split("=")[0];
               String mPropertyValue = mLine.split("=")[1];
               mProperties.put(mPropertyHeader, mPropertyValue);
           }
        }

        mScanner.close();

        mLogger.info("Configuration file has been loaded successfully!");
        mIsLoaded = true;


    }

    public HashMap<String, String> returnPropBox()
    {
        return mProperties;
    }

    public boolean isLoaded()
    {
        return mIsLoaded;
    }
}
