package com.ezhik.instamine.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_image")
    private Image image;

    public Likes(){}
    public Likes(User user, Image image){
        this.user = user;
        this.image = image;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserLike() {
        return user;
    }

    public void setUserLike(User userLike) {
        this.user = userLike;
    }

    public Image getImageLike() {
        return image;
    }

    public void setImageLike(Image imageLike) {
        this.image = imageLike;
    }
}
