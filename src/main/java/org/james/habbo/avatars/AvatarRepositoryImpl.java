package org.james.habbo.avatars;

import jakarta.persistence.EntityManager;

import java.util.HashMap;

public class AvatarRepositoryImpl implements AvatarRepository
{

    private EntityManager mManager = null;
    private static AvatarRepositoryImpl mInstance = null;
    public AvatarRepositoryImpl(EntityManager instance)
    {
        mManager = instance;
    }

    @Override
    public AvatarEntity getAvatarById(int id) {
        return null;
    }

    @Override
    public AvatarEntity getAvatarByName(String userName) {
        return null;
    }

    @Override
    public AvatarEntity createNewAvatar(HashMap<Integer, String> propertiesMap) {
        return null;
    }

    @Override
    public void deleteAvatar(int id) {

    }

    @Override
    public void deleteAvatar(String userName) {

    }

    public static AvatarRepositoryImpl getInstance(EntityManager m)
    {
        if (mInstance == null)
        {
            mInstance = new AvatarRepositoryImpl(m);
        }

        return mInstance;
    }
}
