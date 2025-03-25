package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.entity.postings.UserFollow;
import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserInterest;
import com.artu.fullstack_team_project_application.repository.postings.UserFollowRepository;
import com.artu.fullstack_team_project_application.repository.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserFollowRepository userFollowRepository;

    @Override
    public Page<User> readAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> readOne(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String userId) {
    }

    @Override
    public List<UserInterest> readInterests(String userId) {
        return List.of();
    }

    @Override
    public List<UserInterest> saveInterests(UserInterest userInterest) {
        return List.of();
    }

    @Override
    public boolean checkUserExists(String userId) {
        return userRepository.existsByUserId(userId);
    }

    @Override
    public boolean checkUserEmailExists(String email) {
        return userRepository.existsByUserEmail(email);
    }

    @Override
    public List<UserFollow> findByFolloweeId(String userId) {
        return userFollowRepository.findByFolloweeId(userId);
    }

    @Override
    public List<UserFollow> findByFollowerId(String userId) {
        return userFollowRepository.findByFollowerId(userId);
    }

    //
    @Override
    public Map<String, Long> getCountFollower(String followeeId) {
        Long countFollower = userFollowRepository.countFolloweeByUserId(followeeId);
        Map<String, Long> countFollowerMap = new HashMap<>();
        countFollowerMap.put("countFollower", countFollower);
        return countFollowerMap;
    }

    @Override
    public Map<String, Long> getCountFollowee(String followerId) {
        Long countFollowee = userFollowRepository.countFollowerByUserId(followerId);
        Map<String, Long> countFolloweeMap = new HashMap<>();
        countFolloweeMap.put("countFollowee", countFollowee);
        return countFolloweeMap;
    }



//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(String userId) {
//        return userRepository.findById(userId);
//    }
//
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(String userId) {
//        userRepository.deleteById(userId);
//    }
}
