package org.james.habbo.navigator.models;

import jakarta.persistence.*;
import org.james.habbo.navigator.repo.NavigatorRepositoryImpl;

import java.util.List;


@Entity
@Table(name = "categories")

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private long parent_id;

    @Column(name = "type")
    private int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<CategoryEntity> subCategories()
    {
        return NavigatorRepositoryImpl.getInstance().findSubCategories(id);
    }

    public int roomCount()
    {
        return NavigatorRepositoryImpl.getInstance().findRoomCountByCategory(id);
    }

    public List<RoomEntity> roomList()
    {
        return NavigatorRepositoryImpl.getInstance().findRoomsByCategory(id);
    }
}
