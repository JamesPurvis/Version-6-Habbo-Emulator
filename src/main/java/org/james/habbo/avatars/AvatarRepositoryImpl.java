package org.james.habbo.avatars;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.mapping.Property;

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
    public AvatarEntity createNewAvatar(HashMap<Integer, Object> PropertyBox) {

        /*  pRegMsgStruct["parentagree"] = [#id: 1, "type": #boolean]
        pRegMsgStruct["name"] = [#id: 2, "type": #string]
        pRegMsgStruct["password"] = [#id: 3, "type": #string]
        pRegMsgStruct["figure"] = [#id: 4, "type": #string]
        pRegMsgStruct["sex"] = [#id: 5, "type": #string]
        pRegMsgStruct["customData"] = [#id: 6, "type": #string]
        pRegMsgStruct["email"] = [#id: 7, "type": #string]
        pRegMsgStruct["birthday"] = [#id: 8, "type": #string]
        pRegMsgStruct["directMail"] = [#id: 9, "type": #boolean]
        pRegMsgStruct["has_read_agreement"] = [#id: 10, "type": #boolean]
        pRegMsgStruct["isp_id"] = [#id: 11, "type": #string]
        pRegMsgStruct["partnersite"] = [#id: 12, "type": #string]
        pRegMsgStruct["oldpassword"] = [#id: 13, "type": #string]
        registerMessage(#enterRoom, me.getID(), #closeFigureCreator)
        registerMessage(#changeRoom, me.getID(), #closeFigureCreator)
        registerMessage(#leaveRoom, me.getID(), #closeFigureCreator)
        registerMessage(#show_registration, me.getID(), #openFigureCreator)
        registerMessage(#hide_registration, me.getID(), #closeFigureCreator)
        registerMessage(#figure_ready, me.getID(), #figureSystemReady) */

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

        return mNewAvatar;

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
