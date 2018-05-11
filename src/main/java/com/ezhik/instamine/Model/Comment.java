package com.ezhik.instamine.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Date date;

    @OneToMany(mappedBy = "comment",fetch = FetchType.EAGER )
    private Set<UserImageLikeComment> commentUserBook = new HashSet<>();

    public Comment(){}
    public Comment(String content){
        this.content = content;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<UserImageLikeComment> getCommentUserBook() {
        return commentUserBook;
    }

    public void setCommentUserBook(Set<UserImageLikeComment> commentUserBook) {
        this.commentUserBook = commentUserBook;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
