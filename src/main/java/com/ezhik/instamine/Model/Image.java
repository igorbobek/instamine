package com.ezhik.instamine.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String src;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
    private User user;

    private Date date;

    @OneToMany(mappedBy = "image",fetch = FetchType.EAGER )
    private Set<UserImageLikeComment> commentUserBook = new HashSet<>();


    @OneToMany(mappedBy = "image",fetch = FetchType.EAGER )
    private Set<Likes> likes = new HashSet<>();

    public Image(){}
    public Image(String src){
        this.src = src;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Set<UserImageLikeComment> getCommentUserBook() {
        return commentUserBook;
    }

    public void setCommentUserBook(Set<UserImageLikeComment> commentUserBook) {
        this.commentUserBook = commentUserBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Likes> getLikes() {
        return likes;
    }

    public void setLikes(Set<Likes> likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
