package org.james.habbo.database;

import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseManager
{

    private static DatabaseManager mInstance = null;
    private static Logger mLogger = LogManager.getLogger(DatabaseManager.class.getName());

    public void createRepositories()
    {

    }

    public static DatabaseManager getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new DatabaseManager();
        }

        return mInstance;
    }
}
