# ARTU: 문화생활 공연 정보 및 예술 커뮤니티 플랫폼

> 자신만의 예술적 가치를 공유하고, 타 사용자들과 소통하며, 다양한 문화 공연 정보를 탐색하고 예매하는 커뮤니티 기반 플랫폼입니다.

---

### 💡 소개
ARTU는 문화생활 공연 정보 검색 및 등록, 티켓 판매를 위한 웹 서비스로 시작되었습니다. 여기에 개인의 예술 활동을 공유할 수 있는 SNS 기능을 추가하여 사용자 간 소통을 강화한 커뮤니티 기반 플랫폼으로 확장되었습니다.

이 프로젝트는 풀스택 개발 과정에서 학습한 기술을 실제로 적용하고, 사용 언어 및 프레임워크에 대한 경험과 숙련도를 향상시키는 것을 목표로 합니다. 
사용자들에게 예술적 가치를 공유하고 소통할 수 있는 공간을 제공하며, 편리한 공연 정보 탐색 및 예매 경험을 제공합니다.

--- 
### 관련 레퍼지토리
유저 서비스 : (현재) https://github.com/hby-kr/fullstack_team_project_application

관리자 서비스 : https://github.com/hby-kr/fullstack_team_project_administrator

개발용 프론트앤트 :   https://github.com/hby-kr/fullstack_team_project_app_view

---

### ✨ 주요 기능

* **회원 관리 및 개인 공간**: 사용자 맞춤형 페이지 제공 (위젯 커스터마이징, 게시물/팔로워/팔로잉 관리) 
* **예술 활동 개인 포스팅**: 이미지/텍스트 포스팅, 파일 업로드, 댓글, 신고 및 차단 기능 등
* **위젯 커스터마이징**: Drag & Drop 기능을 통한 위젯 배치 및 개인화된 페이지 구성 
* **공연 정보 검색 및 등록**: 다양한 문화 공연 정보 제공
* **리뷰**: 공연 평점과 소감을 기록
* **티켓 판매 및 결제**: 토스(Toss) Open API를 활용한 결제 시스템 연동
* **공연 장소 정보 제공**: 카카오맵 Open API 연동

---

### 🛠️ 기술 스택

#### Front-end

* **JavaScript (JS)** 
* **React** 
    * 비동기식 데이터 통신 (React + Fetch) 
    * `useEffect` 훅을 사용하여 컴포넌트 렌더링 시 API 호출 처리 
    * `i18n` 라이브러리를 통한 다국어 지원 (번역 파일 관리 및 `useTranslation` 훅 활용) 
    * Drag & Drop / React 기반 인터페이스 (위젯 추가 및 이동) 
    * 반응형 UI (모바일, 데스크톱 등 다양한 환경 대응) 
* **Vite**

#### Back-end

* **Java** 
* **Spring Boot** 
    * **Spring Security**: FilterChain, Authentication 객체, SecurityContext 등을 활용한 인증 구현. 인증에 필요한 최소 정보만 노출하여 정보 과다 노출 방지 및 유지보수 용이성 향상.
    * **JWT (JSON Web Token)**: 로컬 스토리지에 JWT 저장 및 요청 헤더에 포함시켜 Spring Security 필터에서 인증 정보 검증. 서버 자원 관리 효율화, 페이지 새로고침 시 로그인 상태 유지, 보안 제어 유연성 증대.
    * **OAuth (소셜 로그인)**: 회원가입 및 로그인 절차 간소화, 사용자 편의성 향상, 비밀번호 관리 불필요로 인한 보안 리스크 감소.
* **JPA (Java Persistence API) / Hibernate**:
    * `FetchType.LAZY`를 사용하여 관계된 데이터가 실제 사용될 때만 로딩되도록 설정하여 성능 최적화.
    * 기본 CRUD 메서드, 연관관계 매핑, LAZY 조인 등을 통해 사용자에게 필요한 데이터 최적화 전달.
    * 서비스 개발 초기 속도 향상 및 데이터 일관성 보장.
* **Maven**

#### Database

* **MySQL** 

#### Deployment & Infrastructure

* **AWS EC2**: 가상 서버 인프라 활용, 서버 부하 감소 및 서비스 안정성 확보.
* **AWS RDS**: 데이터베이스 관리.
* **AWS S3**: 파일 스토리지.
* **Docker**: 이미지/컨테이너 개념 및 명령어 숙지, 컨테이너 기반 배포.
* **GitHub Actions**: CI/CD 자동 배포 환경 구현.
* **HTTPS**: 비대칭 암호화 기반 HTTPS 인증 및 keystore 구성.
* **Kakao Map API**
* **Toss Payments Open API**

---

### 📈 프로젝트 결과

#### 데이터베이스 재설계 및 정규화

* 기존 서버 및 DB에 SNS 기능 통합 과정에서 데이터 모델 복잡성 증가로 DB를 재설계.
* 약 60여 개의 DB 테이블을 직접 재설계하며 DB 정규화 원칙 및 설계 기법에 대한 이해 심화.
* MySQL 기반 환경에서 ERD 설계, 쿼리 성능 고려, 관계 모델링까지 전체 흐름 경험.
* **수직 분할 (Vertical Partitioning)**: 회원 정보 세분화에 적용.
* **서브타입 분해 (Subtype Decomposition)**: 공연 유형에 따른 테이블 분리.
* **JPA 복합 키 매핑 및 연관 관계 설정**: 팔로잉 등 사용자 간 상호작용 기능 구현.

#### 서버 인스턴스 구현 및 배포

* AWS EC2, RDS, S3의 네트워크 및 보안 설정.
* Spring Boot 애플리케이션과 외부 리소스 연동 설정.
* GitHub Secrets를 통한 보안 정보 관리.
* Docker를 활용한 컨테이너 기반 배포.
* 비대칭 암호화 기반 HTTPS 인증 및 keystore 구성.
* GitHub Actions를 이용한 CI/CD 자동 배포 환경 구축.
* 실제 서비스 배포 및 운영을 통해 백엔드와 인프라 전반에 걸친 경험 축적.
