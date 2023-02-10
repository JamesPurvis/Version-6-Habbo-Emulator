package org.james.habbo.navigator.repo;

import org.james.habbo.navigator.models.CategoryEntity;
import org.james.habbo.navigator.models.RoomEntity;

import java.util.List;

public interface NavigatorRepository {

    List<RoomEntity> findRoomsByCategory(int categoryID);
    List<CategoryEntity> findSubCategories(int categoryID);
    List<RoomEntity> findRoomsByOwner(String userName);
    RoomEntity findRoomById(Long roomID);
    int findRoomCountByCategory(int categoryID);
    Long createNewRoom(String roomName, String room_model, String door, boolean showOwne, String roomOwner);

    void SetFlatInfo(Long roomID, String desc, String pass, boolean allsuper);
}
