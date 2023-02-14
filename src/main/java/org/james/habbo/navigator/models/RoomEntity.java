package org.james.habbo.navigator.models;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")

public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flat_id", nullable = false)
    private Long flat_id;

    @Column(name = "flat_super_rights")
    private boolean flat_super_rights;

    @Column(name = "flat_door")
    private String flat_door;

    @Column(name = "flat_owner")
    private String flat_owner;

    @Column(name = "flat_name")
    private String flat_name;

    @Column(name = "flat_description")
    private String flat_description;

    @Column(name = "flat_show_owner")
    private Boolean flat_show_owner;

    @Column(name = "flat_trading_enabled")
    private Boolean flat_trading_enabled;

    @Column(name = "flat_category_id")
    private int flat_category_id;

    @Column(name = "flat_active_users")
    private int flat_active_users;

    @Column(name = "flat_password")
    private String flat_password;

    @Column(name = "flat_cct")
    private String flat_cct;

    @Column(name = "flat_model")
    private String flat_model;


    public String getFlat_password() {
        return flat_password;
    }


    public void setFlat_password(String flat_password) {
        this.flat_password = flat_password;
    }

    public Long getFlat_id() {
        return flat_id;
    }

    public void setFlat_id(Long flat_id) {
        this.flat_id = flat_id;
    }

    public boolean isFlat_super_rights() {
        return flat_super_rights;
    }

    public void setFlat_super_rights(boolean flat_super_rights) {
        this.flat_super_rights = flat_super_rights;
    }

    public String getFlat_door() {
        return flat_door;
    }

    public void setFlat_door(String flat_door) {
        this.flat_door = flat_door;
    }

    public String getFlat_owner() {
        return flat_owner;
    }

    public void setFlat_owner(String flat_owner) {
        this.flat_owner = flat_owner;
    }

    public String getFlat_name() {
        return flat_name;
    }

    public void setFlat_name(String flat_name) {
        this.flat_name = flat_name;
    }

    public String getFlat_description() {
        return flat_description;
    }

    public void setFlat_description(String flat_description) {
        this.flat_description = flat_description;
    }

    public Boolean getFlat_show_owner() {
        return flat_show_owner;
    }

    public void setFlat_show_owner(Boolean flat_show_owner) {
        this.flat_show_owner = flat_show_owner;
    }

    public Boolean getFlat_trading_enabled() {
        return flat_trading_enabled;
    }

    public void setFlat_trading_enabled(Boolean flat_trading_enabled) {
        this.flat_trading_enabled = flat_trading_enabled;
    }

    public int getFlat_category_id() {
        return flat_category_id;
    }

    public void setFlat_category_id(int flat_category_id) {
        this.flat_category_id = flat_category_id;
    }

    public int getFlat_active_users() {

        return flat_active_users;
    }

    public void setFlat_active_users(int flat_active_users) {

        this.flat_active_users = flat_active_users;
    }

    public String getFlat_cct() {
        return flat_cct;
    }

    public void setFlat_cct(String flat_cct) {
        this.flat_cct = flat_cct;
    }

    public String getFlat_model() {
        return flat_model;
    }

    public void setFlat_model(String flat_model) {
        this.flat_model = flat_model;
    }
}
