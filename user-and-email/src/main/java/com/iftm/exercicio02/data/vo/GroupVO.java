package com.iftm.exercicio02.data.vo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.iftm.exercicio02.models.User;

public class GroupVO implements Serializable {

    private Long id;
    private String name;
    private String code;
    private String link;

    private List<User> users = new ArrayList<>();

    public GroupVO() {
    }

    public GroupVO(String name, String code, String link, List<User> users) {
        this.name = name;
        this.code = code;
        this.link = link;
        this.users = users;
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
        GroupVO groupVO = (GroupVO) o;
        return Objects.equals(id, groupVO.id) && Objects.equals(name, groupVO.name) && Objects.equals(code, groupVO.code) && Objects.equals(link, groupVO.link) && Objects.equals(users, groupVO.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, link, users);
    }

    @Override
    public String toString() {
        return "GroupVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", link='" + link + '\'' +
                ", users=" + users +
                '}';
    }
}
