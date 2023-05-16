package com.iftm.exercicio02.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_table")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 120)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 120)
    private String lastName;
    @Column(name = "user_name", nullable = false, length = 120)
    private String userName;
    @Column(name = "pwd", nullable = false)
    private String password;
    @Column(nullable = false, length = 15)
    private String phone;
    @Column(name = "social_network", nullable = true)
    private String socialNetwork;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_groups",
              joinColumns = {@JoinColumn(name = "user_id")},
              inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<Group> groups = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName, String password, String phone, String socialNetwork) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.socialNetwork = socialNetwork;
    }



    public void addGroup(Group group) {
        this.groups.add(group);
        group.getUsers().add(this);
    }

    public void addEmail(Email email) {
        email.setUser(this);
        emails.add(email);
    }

    public void removeEmail(Email email) {
        email.setUser(null);
        emails.remove(email);
    }   

    
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, phone, socialNetwork);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && Objects.equals(socialNetwork, user.socialNetwork);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", socialNetwork='" + socialNetwork + '\'' +
                '}';
    }
}
