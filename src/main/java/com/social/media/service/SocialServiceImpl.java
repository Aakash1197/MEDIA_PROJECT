package com.social.media.service;

import com.social.media.entity.SocialUser;
import com.social.media.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServiceImpl {
    @Autowired
    private SocialUserRepository socialUserRepository;
    public List<SocialUser> getAllUsers() {
       return socialUserRepository.findAll().stream().toList();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public SocialUser deleteUser(Long id) {
         SocialUser socialUser=socialUserRepository.findById(id).orElseThrow( ()-> new RuntimeException("RESOURCE IS NOT FOUND!!"));
       socialUserRepository.delete(socialUser);
       return socialUser;

    }
}
