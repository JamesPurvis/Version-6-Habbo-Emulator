package org.james.habbo.avatars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class AvatarServiceImpl implements  AvatarService
{
    private static AvatarServiceImpl mInstance = null;

    private static Logger mLogger = LogManager.getLogger(AvatarServiceImpl.class.getName());

    public AvatarServiceImpl()
    {
        mLogger.info("AvatarService has started successfully.");
    }
    @Override
    public Avatar returnAvatarByUserName(String userName) {
        return null;
    }

    @Override
    public Avatar returnAvatarById(int id) {
        return null;
    }

    @Override
    public Avatar createNewAvatar(HashMap<String, String> mPropertyBox) {
        return null;
    }

    public static AvatarServiceImpl getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new AvatarServiceImpl();
        }

        return mInstance;
    }
}
