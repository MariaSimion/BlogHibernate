package com.maria.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by msimion on 8/25/2015.
 */
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "commentator")
    private String commentator;

    @Column(name = "date")
    private Date date;

    @Column(name = "commentContent")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article commentedArticle;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Article getCommentedArticle() {
        return commentedArticle;
    }

    public void setCommentedArticle(Article commentedArticle) {
        this.commentedArticle = commentedArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return commentContent.equals(comment.commentContent);

    }

    @Override
    public int hashCode() {
        return commentContent.hashCode();
    }
}
