package com.social.media.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

  //  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    //@JoinColumn(name = "social_profile_id")

    private SocialProfile socialProfile;


    @OneToMany(mappedBy = "socialUser")
    private List<Post> post=new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="group_id")
    )
    private Set<SocialGroup> groups=new HashSet<>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    //establishing the Cascading works on both side of relationship.
    //bidirectional relation
    //setting user as well as associtated SocialProfile at same time
    //set() setting all socialProfile values to social profile entity.
    public void setSocialProfile(SocialProfile socialProfile) {
        socialProfile.setUser(this);
        this.socialProfile = socialProfile;
    }

}
