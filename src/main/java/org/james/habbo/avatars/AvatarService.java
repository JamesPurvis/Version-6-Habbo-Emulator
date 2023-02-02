package org.james.habbo.avatars;

import java.util.HashMap;

public interface AvatarService
{
    Avatar returnAvatarByUserName(String userName);
    Avatar returnAvatarById(int id);
    Avatar createNewAvatar(HashMap<String, String> mPropertyBox);
}
