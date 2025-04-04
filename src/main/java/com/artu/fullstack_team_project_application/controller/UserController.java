package com.artu.fullstack_team_project_application.controller;

import com.artu.fullstack_team_project_application.entity.users.user.User;
import com.artu.fullstack_team_project_application.entity.users.user.UserloginLogs;
import com.artu.fullstack_team_project_application.service.users.UserLoginLogService;
import com.artu.fullstack_team_project_application.service.users.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserLoginLogService userLoginLogService;

    @GetMapping("/signIn.do")
    public String signInForm(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) { // 세션에 사용자 정보가 있으면 마이페이지로 리다이렉트
            // return "redirect:/user/mypage";  // 마이페이지로 리다이렉트
            return "redirect:/posting/" + user.getUserId() +"/userpage.do";  // 마이페이지로 리다이렉트
        }
        // 세션에 사용자 정보가 없으면 로그인 페이지로 이동
        return "/user/signIn";  // 로그인 페이지
    }

    @PostMapping("/signIn.do")
    public String signIn(
            @RequestParam("userId") String username,
            @RequestParam("typedPw") String typedPw,
            HttpServletRequest request,
            HttpSession session) {

        Optional<User> userOptional = userService.readOne(username);
        String UserPw = userOptional.get().getPassword();

        if (userOptional.isPresent() && BCrypt.checkpw(typedPw, UserPw)) {
            session.setAttribute("user", userOptional.get()); // 로그인 성공 시 세션에 사용자 정보 저장

            String userAgent = request.getHeader("User-Agent");  // user-agent 가져오기
            String ipAddress = request.getRemoteAddr();  // 클라이언트 IP 주소 가져오기
            // 정보 가져와서 객체 생성
            UserloginLogs userloginLogs = new UserloginLogs();
            userloginLogs.setUserId(userOptional.get().getUserId());
            userloginLogs.setUserAgent(userAgent);
            userloginLogs.setIpAddress(ipAddress);
            userloginLogs.setLoginAt(LocalDateTime.now());
            userLoginLogService.save(userloginLogs); // 로그인 기록

            return "redirect:/";  // 로그인 후 홈 화면으로 리다이렉트
        } else {
            return "redirect:/user/signIn";
        }
    }

    @GetMapping("/signUp.do")
    public String signUpForm(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) { // 세션에 사용자 정보가 있으면 마이페이지로 리다이렉트
            return "redirect:/user/mypage";  // 마이페이지로 리다이렉트
        }
        // 세션에 사용자 정보가 없으면 로그인 페이지로 이동
        return "/user/signUp";  // 로그인 페이지
    }

    @PostMapping("/signUp.do") // Action페이지 = 리다이렉트 할거임.
    public String signUpAction(
            @ModelAttribute User user, // 폼에서 전송된 데이터를 자동으로 객체로 변환해주는 역할
            RedirectAttributes redirectAttributes
    ) throws Exception {
        System.out.println(user);
        String pwBcrypt = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pwBcrypt);
        user.setCreatedAt(LocalDate.now());
        User result = userService.save(user);
        // user가 null이 아니면 성공
        if (result != null) { // 성공하면, 리다이렉트 하고 user 아이디 같이 보내기
            // redirectAttributes.addFlashAttribute("userId", user.getUserId());
            return "redirect:/user/signIn.do";
        } else { // 실패시 등록페이지 머뭄. 적은 데이터 다 초기화 되니까, 리액트로 인풋값 검증해야함.
            return "redirect:/user/singUp.do";
        }
    }

    @GetMapping("/signOut.do")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/"; // 로그인 페이지로 리다이렉트
    }

    @GetMapping("/api/checkUserId.do")
    @ResponseBody // JSON 형식으로 반환
    public boolean checkUserId(@RequestParam String userId){
        return userService.checkUserExists(userId);
    }

    @GetMapping("/api/checkUserEmail.do")
    @ResponseBody // JSON 형식으로 반환
    public boolean checkUserEmail(@RequestParam String UserEmail){
        return userService.checkUserEmailExists(UserEmail);
    }


//    @PostMapping("pw/check")


}

