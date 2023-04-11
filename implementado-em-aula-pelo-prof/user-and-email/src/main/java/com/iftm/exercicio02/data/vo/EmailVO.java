package com.iftm.exercicio02.data.vo;

import com.iftm.exercicio02.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class EmailVO implements Serializable {

    private Long id;
    private String from;
    private String to;
    private String subject;
    private String body;
    private String attachment;

    private User user;

    public EmailVO() {
    }

    public EmailVO(String from, String to, String subject, String body, String attachment, User user) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        EmailVO emailVO = (EmailVO) o;
        return Objects.equals(id, emailVO.id) && Objects.equals(from, emailVO.from) && Objects.equals(to, emailVO.to) && Objects.equals(subject, emailVO.subject) && Objects.equals(body, emailVO.body) && Objects.equals(attachment, emailVO.attachment) && Objects.equals(user, emailVO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, subject, body, attachment, user);
    }

    @Override
    public String toString() {
        return "EmailVO{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                ", user=" + user +
                '}';
    }
}
