package org.james.habbo.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.avatars.AvatarRepositoryImpl;

public class DatabaseManager
{

    private static DatabaseManager mInstance = null;
    private static Logger mLogger = LogManager.getLogger(DatabaseManager.class.getName());

    public void createRepositories()
    {
        AvatarRepositoryImpl.getInstance(returnEntityManager("AvatarEntity"));

        mLogger.info("Entity Repositories created successfully!");
    }

    public static DatabaseManager getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new DatabaseManager();
        }

        return mInstance;
    }

    private EntityManager returnEntityManager(String unit)
    {
        EntityManagerFactory mFactory = Persistence.createEntityManagerFactory(unit);
        return mFactory.createEntityManager();
    }
}
