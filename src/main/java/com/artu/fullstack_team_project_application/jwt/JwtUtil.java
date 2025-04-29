package com.artu.fullstack_team_project_application.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "artu는 문화의 소비자가 곧 문화의 생산자일 수 있다고 생각에서 출발하였습니다"; // pw 34자 이상
    private final SecretKey secretKey; // JWT 토큰을 생성하거나 검증할 때 사용할 저장 필드
    private final long EXPIRATION = 1000 * 60 * 30; // JWT 유효시간 설정을 위한 만료 시간
    private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    //  이 생성자는 JwtUtil 객체가 만들어질 때, 비밀키 문자열을 -> 암호화 키 객체로 변환하여 저장하기 위한 코드
    public JwtUtil() {
        this.secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // String인 비밀키를 HMAC-SHA 알고리즘에 사용할 수 있는 SecretKey 객체로 변환함.
    }

    // 사용자의 이름(또는 ID)을 기반으로 로그인 인증용 JWT 토큰을 생성하는 메서드
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    // JWT 토큰을 파싱(디코딩)하고, 그 안에 포함된 사용자 이름(username)을 추출하는 메서드
    public String getUsername(String token) {
        return Jwts.parser()  // JWT 파서를 생성 (JJWT 0.12.x에서는 여전히 사용)
                .setSigningKey(secretKey)  // 서명 검증을 위한 비밀 키를 설정
                .parseClaimsJws(token)    // JWT 토큰을 파싱하고 서명을 검증하며 claims 반환
                .getBody()                 // claims 본문을 가져오기
                .getSubject();             // payload에서 사용자 이름 (subject) 추출
    }

    // JWT 토큰의 서명을 검증하고, 유효한지 확인하는 메서드
    public boolean validateToken(String token) throws JwtException {
        try {
            // 최신 방식으로 JWT 파서 설정
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;

        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            throw new JwtException("토큰 만료됨: " + e.getMessage());
        } catch (SignatureException e) {
            e.printStackTrace();
            throw new JwtException("서명 오류: " + e.getMessage());
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            throw new JwtException("잘못된 JWT 형식: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            throw new JwtException("지원하지 않는 JWT 타입: " + e.getMessage());
        } catch (MissingClaimException e) {
            e.printStackTrace();
            throw new JwtException("필수 클레임이 없음: " + e.getMessage());
        } catch (JwtException e) {
            e.printStackTrace();
            throw new JwtException("JWT 처리 중 오류 발생: " + e.getMessage());
        } catch (SecurityException e) {
            e.printStackTrace();
            throw new JwtException("보안 오류: 서명 검증 실패 - " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new JwtException("기타 예외 발생: " + e.getMessage());
        }
    }

}
