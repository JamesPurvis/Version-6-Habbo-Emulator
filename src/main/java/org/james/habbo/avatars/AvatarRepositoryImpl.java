package org.james.habbo.avatars;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.mapping.Property;

import java.util.List;

import java.util.HashMap;

public class AvatarRepositoryImpl implements AvatarRepository
{

    private static Logger mLogger = LogManager.getLogger(AvatarRepositoryImpl.class.getName());

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
    public AvatarEntity findByName(String userName) {

        CriteriaBuilder cb = mManager.getCriteriaBuilder();
        CriteriaQuery<AvatarEntity> criteria = cb.createQuery(AvatarEntity.class);
        Root<AvatarEntity> root = criteria.from(AvatarEntity.class);
        criteria.where(cb.equal(root.get("username"), userName));
        return mManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public void createNewAvatar(HashMap<Integer, Object> PropertyBox) {

        AvatarEntity mNewAvatar = new AvatarEntity();

        mNewAvatar.setUsername((String) PropertyBox.get(2));
        mNewAvatar.setPassword((String) PropertyBox.get(3));
        mNewAvatar.setFigure((String) PropertyBox.get(4));
        mNewAvatar.setSex(PropertyBox.get(5).toString().charAt(0));
        mNewAvatar.setMission((String) PropertyBox.get(6));
        mNewAvatar.setEmail((String) PropertyBox.get(7));
        mNewAvatar.setPersistent_message("");
        mNewAvatar.setCredits(0);
        mNewAvatar.setFilm(0);
        mNewAvatar.setTickets(0);

        mManager.getTransaction().begin();
        mManager.persist(mNewAvatar);
        mManager.getTransaction().commit();

        mLogger.info(mNewAvatar.getUsername() + " " + "has registered on the client!");

    }

    @Override
    public boolean avatarExists(String Name) {

        return findByName(Name) == null;
    }

    @Override
    public void deleteAvatar(int id) {

    }

    @Override
    public void deleteAvatar(String userName) {

    }

    public boolean tryLogin(String username, String password)
    {
        username = username.toLowerCase();
        password = password.toLowerCase();

        return findByName(username).getPassword().toLowerCase().equals(password);
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
