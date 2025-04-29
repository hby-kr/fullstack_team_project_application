package com.artu.fullstack_team_project_application.service.users;

import com.artu.fullstack_team_project_application.dto.users.CustomUserDetails;
import com.artu.fullstack_team_project_application.repository.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    // 스프링 시큐리티에게 DB 어디서 찾아오는지 알려주는 클래스

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 필드와 생성자
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 사용자 정보 조회 및 UserDetails 반환
        logger.info("로그인 시도 : " + username);

        return userRepository.findById(username)
                .map(CustomUserDetails::new) // 만약 사용자 정보가 존재한다면, 그 값을 CustomUserDetails로 변환함.
                .orElseThrow(() -> new UsernameNotFoundException(username)); // Optional에 값이 없을 경우 예외를 던짐.
    }
}