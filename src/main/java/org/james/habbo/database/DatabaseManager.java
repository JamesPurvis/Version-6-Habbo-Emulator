package org.james.habbo.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.avatars.AvatarRepositoryImpl;

public class DatabaseManager
{

    private static DatabaseManager mInstance = null;
    private static Logger mLogger = LogManager.getLogger(DatabaseManager.class.getName());

    public void createRepositories()
    {
       EntityManagerFactory mAvatarFactory = Persistence.createEntityManagerFactory("AvatarEntity");
       AvatarRepositoryImpl.getInstance(mAvatarFactory.createEntityManager());

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
}
