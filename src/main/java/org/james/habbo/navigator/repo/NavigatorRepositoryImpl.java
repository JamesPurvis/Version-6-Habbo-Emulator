package org.james.habbo.navigator.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.james.habbo.avatars.AvatarEntity;
import org.james.habbo.navigator.models.CategoryEntity;
import org.james.habbo.navigator.models.RoomEntity;

import java.util.List;

public class NavigatorRepositoryImpl implements NavigatorRepository{

    private static NavigatorRepositoryImpl mInstance;
    private static Logger mLogger = LogManager.getLogger(NavigatorRepositoryImpl.class.getName());
    private EntityManager mNavigatorEntityManager;
    private EntityManager mRoomEntityManager;


    @Override
    public List<RoomEntity> findRoomsByCategory(int categoryID) {
        return null;
    }

    @Override
    public List<CategoryEntity> findSubCategories(int categoryID) {
        return null;
    }

    @Override

    public List<RoomEntity> findRoomsByOwner(String userName) {
        CriteriaBuilder cb = mRoomEntityManager.getCriteriaBuilder();
        CriteriaQuery<RoomEntity> criteria = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> root = criteria.from(RoomEntity.class);
        criteria.where(cb.equal(root.get("flat_owner"), userName));
        return mRoomEntityManager.createQuery(criteria).getResultList();
    }

    @Override
    public RoomEntity findRoomById(Long roomID) {

        CriteriaBuilder cb = mRoomEntityManager.getCriteriaBuilder();
        CriteriaQuery<RoomEntity> criteria = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> root = criteria.from(RoomEntity.class);
        criteria.where(cb.equal(root.get("flat_id"), roomID));
        return mRoomEntityManager.createQuery(criteria).getSingleResult();
    }

    @Override
    public int findRoomCountByCategory(int categoryID) {
        return 0;
    }

    @Override
    public Long createNewRoom(String roomName, String room_model, String door, boolean showOwner, String mRoomOwner) {

        RoomEntity mRoom = new RoomEntity();
        mRoom.setFlat_name(roomName);
        mRoom.setFlat_show_owner(showOwner);
        mRoom.setFlat_door(door);
        mRoom.setFlat_model(room_model);
        mRoom.setFlat_owner(mRoomOwner);

        mRoomEntityManager.getTransaction().begin();
        mRoomEntityManager.persist(mRoom);
        mRoomEntityManager.getTransaction().commit();

        mLogger.info("A new room has been created called " + mRoom.getFlat_name() + " " + "by " + mRoomOwner + " " + "with id: " + mRoom.getFlat_id());

        return mRoom.getFlat_id();
    }

    @Override
    public void SetFlatInfo(Long roomID, String desc, String pass, boolean allsuper)
    {
        RoomEntity mRoom = findRoomById(roomID);
        mRoom.setFlat_description(desc);
        mRoom.setFlat_super_rights(allsuper);
        mRoom.setFlat_password(pass);

        mRoomEntityManager.getTransaction().begin();
        mRoomEntityManager.persist(mRoom);
        mRoomEntityManager.getTransaction().commit();
    }

    public static NavigatorRepositoryImpl getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new NavigatorRepositoryImpl();
        }

        return mInstance;
    }

    public void setNavigatorEntityManager(EntityManager instance)
    {
        mNavigatorEntityManager = instance;
    }

    public void setRoomEntityManager(EntityManager instance)
    {
        mRoomEntityManager = instance;
    }

}
