package com.iftm.exercicio02.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "email_table")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_mail", nullable = false)
    private String from;
    @Column(name = "to_mail", nullable = false)
    private String to;
    @Column(name = "subject_mail", nullable = false)
    private String subject;
    @Column(name = "body_mail", nullable = false)
    private String body;
    @Column(name = "attachment_mail", nullable = false)
    private String attachment;

    @ManyToOne
    //@JsonBackReference
    @JsonIgnore
    private User user;

    public Email() {
    }

    public Email(String from, String to, String subject, String body, String attachment) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(from, email.from) && Objects.equals(to, email.to) && Objects.equals(subject, email.subject) && Objects.equals(body, email.body) && Objects.equals(attachment, email.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, subject, body, attachment);
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
