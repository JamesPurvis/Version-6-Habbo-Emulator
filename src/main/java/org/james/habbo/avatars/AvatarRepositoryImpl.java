package org.james.habbo.avatars;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import java.util.List;

import java.util.HashMap;

public class AvatarRepositoryImpl implements AvatarRepository
{

    private EntityManager mManager = null;
    private static AvatarRepositoryImpl mInstance = null;

    public EntityManager EntityManager()
    {
        return mManager;
    }

    public void setEntityManager(EntityManager m)
    {
        mManager = m;
    }

    @Override
    public AvatarEntity getAvatarById(int id) {
        return null;
    }

    @Override
    public List<AvatarEntity> findByName(String userName) {

        CriteriaBuilder cb = mManager.getCriteriaBuilder();
        CriteriaQuery<AvatarEntity> criteria = cb.createQuery(AvatarEntity.class);
        Root<AvatarEntity> root = criteria.from(AvatarEntity.class);
        criteria.where(cb.equal(root.get("username"), userName));
        return mManager.createQuery(criteria).getResultList();
    }

    @Override
    public AvatarEntity createNewAvatar(HashMap<Integer, String> propertiesMap) {
        return null;
    }

    @Override
    public boolean avatarExists(String Name) {

        return !findByName(Name).isEmpty();
    }

    @Override
    public void deleteAvatar(int id) {

    }

    @Override
    public void deleteAvatar(String userName) {

    }

    public static AvatarRepositoryImpl getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new AvatarRepositoryImpl();
        }

        return mInstance;
    }
}
