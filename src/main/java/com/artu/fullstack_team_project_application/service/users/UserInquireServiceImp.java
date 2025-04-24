package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.users.base.UserInquire;
import com.artu.fullstack_team_project_application.repository.users.UserInquireRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class UserInquireServiceImp implements UserInquireService{
    private final UserInquireRepository userInquireRepository;

    @Override
    public void save(UserInquire userInquire) {
        userInquireRepository.save(userInquire);
    }

    @Override
    public void delete(String userId, Integer inquireId) {
        Optional<UserInquire> optUserInquire = userInquireRepository.findOneByInquireIdAndUser_UserId(inquireId, userId);
        if(optUserInquire.isPresent()) {
            userInquireRepository.delete(optUserInquire.get());
        }
    }

    @Override
    public List<UserInquire> findAll() {
        return userInquireRepository.findAll();
    }

    @Override
    public Set<UserInquire> findInquireByUserId(String userId) {
        return userInquireRepository.findByUser_UserId(userId);

    }

    @Override
    public Set<UserInquire> findInquireByInquireCategory(UserInquire.InquireCategory inquireCategory) {
        return userInquireRepository.findByInquireCategory(inquireCategory);
    }

    @Override
    public Optional<UserInquire> findOneByInquireIdAndUser_UserId(Integer inquireId, String UserId){
        return userInquireRepository.findOneByInquireIdAndUser_UserId(inquireId, UserId);
    }



}
