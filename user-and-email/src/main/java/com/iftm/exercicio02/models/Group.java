package com.iftm.exercicio02.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "group_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 5)
    private String code;
    @Column(nullable = false)
    private String link;

    @ManyToMany( mappedBy = "groups", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    public Group() {
    }

    public Group(String name, String code, String link, List<User> users) {
        this.name = name;
        this.code = code;
        this.link = link;
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
        user.getGroups().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && Objects.equals(name, group.name) && Objects.equals(code, group.code) && Objects.equals(link, group.link) && Objects.equals(users, group.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, link, users);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", link='" + link + '\'' +
                ", users=" + users +
                '}';
    }
}