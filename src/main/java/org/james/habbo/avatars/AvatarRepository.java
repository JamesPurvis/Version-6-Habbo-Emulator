package org.james.habbo.avatars;

import java.util.HashMap;

public interface AvatarRepository
{
    AvatarEntity getAvatarById(int id);
    AvatarEntity getAvatarByName(String userName);
    AvatarEntity createNewAvatar(HashMap<Integer, String> propertiesMap);
    void deleteAvatar(int id);
    void deleteAvatar(String userName);
}
