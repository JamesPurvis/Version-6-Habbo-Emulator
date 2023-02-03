package org.james.habbo.avatars;

import jakarta.persistence.*;

@Entity
@Table(name = "avatars")
public class AvatarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "figure")
    private String figure;

    @Column(name = "mission")
    private String mission;

    @Column(name = "persistent_message")
    private String persistent_message;

    @Column(name = "tickets")
    private int tickets;

    @Column(name = "film")
    private int film;

    @Column(name = "sex")
    private char sex;

    @Column(name = "pool_figure")
    private String pool_figure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getPersistent_message() {
        return persistent_message;
    }

    public void setPersistent_message(String persistent_message) {
        this.persistent_message = persistent_message;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPool_figure() {
        return pool_figure;
    }

    public void setPool_figure(String pool_figure) {
        this.pool_figure = pool_figure;
    }
}