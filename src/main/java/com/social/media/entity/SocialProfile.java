package com.social.media.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "social_user")
    @JsonIgnore
    private SocialUser user;

    private String description;

    //establishing the Cascading works on both side of relationship.
    //bidirectional relation
    //setting SocialProfile as well as associtated Social User at same time
    //set() setting all Social User values to  Social User entity.
    public void setSocialUser(SocialUser user) {
        this.user = user;
        if(user.getSocialProfile()!=this){
            user.setSocialProfile(this);
        }
    }
}
