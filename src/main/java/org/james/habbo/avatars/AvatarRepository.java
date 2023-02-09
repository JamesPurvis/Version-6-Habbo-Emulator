package org.james.habbo.avatars;


import java.util.HashMap;
import java.util.List;

public interface AvatarRepository
{
    AvatarEntity getAvatarById(int id);
    List<AvatarEntity> findByName(String userName);
    AvatarEntity createNewAvatar(HashMap<Integer, Object> propertiesMap);
    boolean avatarExists(String Name);
    void deleteAvatar(int id);
    void deleteAvatar(String userName);
}
