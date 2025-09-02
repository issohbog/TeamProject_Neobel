# Neobel (화장품 쇼핑몰 프로젝트)
<img width="1905" height="916" alt="메인화면" src="https://github.com/user-attachments/assets/9612d433-df65-49e1-ac19-784a1a1b8692" />



### [🔗발표 영상 풀 버전](https://youtu.be/c67rlVCR8Bs?si=8ZwD8d9Fv4izRmcR&t=3)
### [🔗프로젝트 시연부터 보기](https://youtu.be/c67rlVCR8Bs?si=cE7P3sf24_gRuOS7&t=181)



## 📑 목차 
- [📌 프로젝트 개요](#-프로젝트-개요)
  - [🎯 주제 및 선정배경](#-주제-및-선정-배경)
  - [⚡ 핵심 기능](#-핵심-기능)
  - [🏗️ 설계 (Design)](#️-설계-design)
  - [🛠️ 개발환경](#️-개발-환경)
- [👥 팀 구성 및 역할](#-팀-구성-roles)
- [📝 평가](#-평가)

---

## 📌 프로젝트 개요 

### 🎯 주제 및 선정 배경
본 프로젝트는 JSP/Servlet 기반 화장품 쇼핑몰 사이트(네오벨) 구축을 목표로 하였습니다.
전자상거래 서비스는 웹 개발의 전형적인 기능들을 종합적으로 다룰 수 있어, 학습 및 실무 역량 강화에 적합한 주제입니다.

특히 JSP/Servlet 구조는 MVC(Model–View–Controller) 패턴을 명확히 적용할 수 있어,

- Controller(Servlet): 요청/응답 처리 및 흐름 제어

- Model(Java Class/DAO): 비즈니스 로직과 DB 연동

- View(JSP): 사용자 화면 렌더링

을 분리하여 체계적인 웹 애플리케이션 아키텍처를 경험할 수 있습니다.

또한 화장품 쇼핑몰은 상품 조회, 장바구니, 주문/결제 등 다양한 기능을 포함하기 때문에,
실제 전자상거래 시스템의 데이터 흐름과 사용자 상호작용을 학습하기에 적합하다고 판단하여 주제로 선정하였습니다.

### ⚡ 핵심 기능 
- 회원: 회원가입, 로그인/로그아웃, 회원 정보 수정, 마이페이지

- 상품: 상품 목록, 상품 상세, 장바구니에 담기 

- 장바구니 기능: 수량 변경, 삭제 

- 주문 처리: 주문서 작성, 주문, 주문 내역 조회
<details>
  <summary>핵심 기능 화면 보기</summary>
<img width="1905" height="916" alt="메인화면" src="https://github.com/user-attachments/assets/cc695bef-1709-4de5-bbf8-aa8905b2f55c" />
<img width="1904" height="917" alt="상품목록" src="https://github.com/user-attachments/assets/6df7a736-8abc-406a-9989-056cf93e0e1a" />
<img width="1904" height="912" alt="상품상세" src="https://github.com/user-attachments/assets/084966dd-ec76-4a57-b54d-05a0b18d7637" />
<img width="1903" height="802" alt="장바구니" src="https://github.com/user-attachments/assets/6ddd52ce-0c59-4394-b886-b17f9aa95236" />
<img width="1758" height="921" alt="주문내역" src="https://github.com/user-attachments/assets/8a15cf73-b749-4d29-be08-fbfd7002c771" />
<img width="1855" height="918" alt="주문양식" src="https://github.com/user-attachments/assets/b2ce9ae9-0c77-46c1-b3e8-41f364f7f304" />

</details>
  

### 🏗️ 설계 (Design)

| 설계 자료 | 자료 링크 |
|------|------|
| 기능 정의서 | [🔗 기능 정의서](https://docs.google.com/spreadsheets/d/1LpjBPq6ytZsn2JEAyntCbLYUME8-tIbX/edit?usp=drive_link&ouid=116494253856014580670&rtpof=true&sd=true) |
| 요구사항 정의서 | [🔗 요구사항 정의서](https://docs.google.com/spreadsheets/d/1yNrk9gGDu1PewjA-lpgAB3aoPXKQx-yY/edit?usp=drive_link&ouid=116494253856014580670&rtpof=true&sd=true) |
| 테이블 정의서 | [🔗 테이블 정의서](https://docs.google.com/document/d/1EQTGhHOVUdI6Z1evQTDO3u5Ulg4fYUHQ1vSusSggfEg/edit?usp=drive_link) |
| 화면 설계 | [🔗 Figma 화면설계](https://www.figma.com/design/D7wTWnxeVavEeJ1cJsaPOp/%EB%AF%B8%EB%8B%88%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%9B%B9%EC%82%AC%EC%9D%B4%ED%8A%B8?node-id=0-1&t=6eVFJGn9NMXDpMNB-1) |

<details>
  <summary>📊 ERD</summary>
  <img width="1832" height="916" alt="shoppingmall_erd (1)" src="https://github.com/user-attachments/assets/42671240-a9c5-4fce-8a77-8131fa38c96e" />
</details>

### 🛠️ 개발 환경 
<img width="800" height="600" alt="image" src="https://github.com/user-attachments/assets/35f120b5-d5c4-4562-ba23-da64bcb6d16f" />


---

## 👥 팀 구성 (Roles)
<img width="800" height="600" alt="image" src="https://github.com/user-attachments/assets/bd0a2f79-e9ca-4173-b4cc-b68ff7905df7" />


---

## 📝 평가 
<img width="800" height="600" alt="image" src="https://github.com/user-attachments/assets/130bd2ef-15f8-4551-b123-89bf9a590c91" />

