package com.lth.pojos;

import javax.persistence.*;

@Entity
@Table(name = "reaction")
public class Reaction {
    @EmbeddedId
    private ReactionId id;
    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReactionId getId() {
        return id;
    }

    public void setId(ReactionId id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}