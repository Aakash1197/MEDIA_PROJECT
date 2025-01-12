package com.social.media.repository;

import com.social.media.entity.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository extends JpaRepository <SocialProfile, Long> {
}
