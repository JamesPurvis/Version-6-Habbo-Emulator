package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.navigator.models.CategoryEntity;
import org.james.habbo.navigator.models.RoomEntity;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;

import java.util.List;

public class NavNodeInfoMessageComposer implements MessageComposer {

    private long mCategoryID;
    private CategoryEntity mCategoryInstance;

    public NavNodeInfoMessageComposer(long categoryID)
    {
        this.mCategoryID = categoryID;
        mCategoryInstance = NavigatorRepositoryImpl.getInstance().findCategoryById(categoryID);
    }
    @Override
    public void compose(Response response) {
        response.writeInt(Math.toIntExact(mCategoryID));
        response.writeInt(mCategoryInstance.getType());
        response.writeString(mCategoryInstance.getName());
        response.writeInt(0);
        response.writeInt(Math.toIntExact(mCategoryInstance.getParent_id()));
        response.writeInt(0);

        if (mCategoryInstance.getType() == 2)
        {
            response.writeInt(mCategoryInstance.roomCount());
            compileChildrenRooms(response);
        }

        if (mCategoryInstance.getType() == 0)
        {
            compilePublicRooms(response);
        }


        compileChildrenNodes(response);
    }

    @Override
    public short returnID() {
        return 220;
    }

    public void compileChildrenNodes(Response response)
    {
        for(CategoryEntity entity : mCategoryInstance.subCategories())
        {
            response.writeInt(Math.toIntExact(entity.getId()));
            response.writeInt(0);
            response.writeString(entity.getName());
            response.writeInt(0);
            response.writeInt(Math.toIntExact(entity.getParent_id()));
            response.writeInt(0);
        }
    }

    public void compileChildrenRooms(Response response)
    {
        for(RoomEntity entity : mCategoryInstance.roomList())
        {
            response.writeInt(Math.toIntExact(entity.getFlat_id()));
            response.writeString(entity.getFlat_name());
            if (entity.getFlat_show_owner()== true) response.writeString(entity.getFlat_owner());
            if (entity.getFlat_show_owner()== false) response.writeString("-");
            response.writeString(entity.getFlat_door());
            response.writeInt(entity.getFlat_active_users());
            response.writeString(entity.getFlat_description());
        }
    }

    public void compilePublicRooms(Response response)
    {
        for(RoomEntity entity : mCategoryInstance.roomList())
        {
            response.writeInt(Math.toIntExact(entity.getFlat_id()));
            response.writeInt(1);
            response.writeString(entity.getFlat_name());
            response.writeInt(entity.getFlat_active_users());
            response.writeInt(entity.getFlat_category_id());
            response.writeInt(1);
            response.writeString(entity.getFlat_description());
            response.writeInt(Math.toIntExact(entity.getFlat_id()) + 1000);
            response.writeInt(0);
            response.writeString(entity.getFlat_cct());

        }
    }
}
