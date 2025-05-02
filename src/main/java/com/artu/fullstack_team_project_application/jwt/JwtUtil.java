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


    public String generateToken(String username) {
        //토큰은 로그인 인증을 하기위해 꼭 id를 포함해야한다.
        return Jwts.builder() // Jwts는 io.jsonwebtoken.Jwts 클래스임.
                // Jwts.builder() => JWT 생성기를 시작함. JWT 구조는 header, payload, signature 세 부분으로 구성됨.
                // Jwts.parser()는 JWT를 검증하고 해석할 때 사용하는 파서 객체를 반환함.
                .subject(username) // JWT의 payload에 들어갈 sub 값을 설정함. 여기서는 사용자 이름을 넣음.
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION)) // 토큰의 만료 시간을 설정함
                .signWith(secretKey, SignatureAlgorithm.HS512) // JWT를 서명함. 비밀키와 HS512 알고리즘을 사용함. 이 서명을 통해 위조를 막을 수 있음.
                .compact(); // JWT를 문자열로 완성함. 이 문자열이 최종 토큰임.
    }


    public String getUsername(String token) {
        String username = Jwts.parser()    // JWT 파서를 생성 (구식 방식, 권장되지 않음)
                .verifyWith(secretKey)     // JWT 서명을 검증할 키를 설정
                .build()                   // 설정을 마치고 JWT 파서 객체를 생성
                .parseSignedClaims(token)  // JWT를 파싱하고 서명을 검증하며, claims(본문)를 포함한 구조 반환
                .getPayload()              // 파싱된 결과에서 payload(본문)를 꺼냄 (claims 정보가 들어 있음)
                .getSubject();             // claims 안에서 subject 값을 꺼냄 (여기서는 사용자 이름)
    /*  payload의 대충 구조
    {
        "sub": "userName",   // <- 이게 getSubject()로 가져오는 부분
        "exp": 1714439999,   // 만료 시간 (UNIX timestamp)
        "role": "USER"
    }
     */
        return username;                   // 추출한 사용자 이름 반환
    }


    public boolean validateToken(String token) throws JwtException {

        try {
            // secretKey는 Key 타입이어야 함 (예: HMAC-SHA 키)
            Jwts.parser()
                    .verifyWith(secretKey) // secretKey는 Key 객체여야 함 (예: Keys.hmacShaKeyFor(...))
                    .build()
                    .parseClaimsJws(token); // JWT 토큰 파싱 및 서명 검증
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
