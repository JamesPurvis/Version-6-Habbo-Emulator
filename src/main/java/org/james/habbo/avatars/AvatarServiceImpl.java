package org.james.habbo.avatars;

import java.util.HashMap;

public class AvatarServiceImpl implements  AvatarService
{
    private static AvatarServiceImpl mInstance = null;

    public AvatarServiceImpl()
    {
        System.out.println("AvatarService has started successfully.");
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
