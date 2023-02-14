package org.james.habbo.messages.outgoing.navigator;

import org.james.habbo.messages.types.MessageComposer;
import org.james.habbo.messages.types.Response;
import org.james.habbo.navigator.models.CategoryEntity;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;

import java.util.List;

public class HandleUserFlatCatsMessageComposer implements MessageComposer {
    @Override
    public void compose(Response response) {
        List<CategoryEntity> mCategories = NavigatorRepositoryImpl.getInstance().returnFlatCats();

        response.writeInt(mCategories.size());

        for(CategoryEntity c : mCategories)
        {
            response.writeInt(Math.toIntExact(c.getId()));
            response.writeString(c.getName());
        }
    }

    @Override
    public short returnID() {
        return 221;
    }
}
