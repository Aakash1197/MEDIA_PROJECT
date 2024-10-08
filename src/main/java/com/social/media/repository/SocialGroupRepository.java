package com.social.media.repository;

import com.social.media.entity.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialGroupRepository extends JpaRepository <SocialGroup, Long> {
}
