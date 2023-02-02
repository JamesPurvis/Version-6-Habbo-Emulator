package org.james.habbo.avatars;

import org.james.habbo.avatars.details.AvatarDetails;

public class Avatar
{
    private AvatarDetails mDetails;

    public Avatar()
    {
        mDetails = new AvatarDetails();
    }
    public AvatarDetails getDetails()
    {
        return mDetails;
    }
}
