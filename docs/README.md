# 일정 관리 앱 서버

![](https://img.shields.io/badge/내일배움캠프-Spring개인과제-white.svg)
  

---
+ 나만의 일정 관리 앱 서버 만들기
---  

# 📈 Use Case Diagram
![schedulemanagement](https://github.com/sonjh919/sonjh919.github.io/assets/109019081/4ded16cd-d891-4430-877c-bc6ce3c58d25)

---

# 📚 기능 목록
## 🔥 일정 작성 기능
- [x] `할일 제목`,`할일 내용`, `담당자`, `비밀번호`, `작성일`을 저장할 수 있다.
- [x] 저장된 게시글의 정보를 반환 받아 확인할 수 있다.
  - [x] 반환 받은 게시글의 정보에 `비밀번호`는 제외되어 있다.

## 🔥 선택한 일정 조회 기능
- [x] 선택한 일정의 정보를 조회할 수 있다.
  - [x] 반환 받은 일정 정보에 `비밀번호`는 제외되어 있다.

## 🔥 일정 목록 조회 기능
- [x] 등록된 일정 전체를 조회할 수 있다.
    - [x] 반환 받은 일정 정보에 `비밀번호`는 제외 되어있다.
- [x] 조회된 일정 목록은 `작성일` 기준 내림차순으로 정렬 되어있다.


## 🔥 선택한 일정 수정 기능
- [x] 선택한 일정의 `할일 제목`,`할일 내용`, `담당자`을 수정할 수 있다.
  - [x] 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달한다.
  - [x] 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 수정이 가능하다.
- [x] 수정된 일정의 정보를 반환 받아 확인할 수 있다.
  - [x] 반환 받은 일정의 정보에 `비밀번호`는 제외 되어있다.

### 🔥 선택한 일정 삭제 기능
- [x] 선택한 일정을 삭제할 수 있다.
  - [x] 서버에 일정 삭제를 요청할 때 `비밀번호`를 함께 전달한다.
  - [x] 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 삭제가 가능하다.


### ⛏ 예외 처리 사항
- [x] 요청받은 값에 NULL이 들어있는지 체크한다.
- [x] 요청받은 ID값이 유효한 값인지 유효성 검사를 진행한다.
- [x] 요청받은 값이 각 column의 자릿수에 맞는지 체크한다.
- [x] 선택 일정 수정 및 삭제 요청의 경우, 비밀번호가 일치하지 않을 경우 API 요청 실패(예외상황)에 대해 판단할 수 있는 Status Code, Error 메시지등의 정보를 반환한다.
---

# 📋 DataBase
![schedulemanagementDB](https://github.com/sonjh919/ScheduleManagement/assets/109019081/91a40f16-6922-4391-b5ca-bfbb1d41b112)


## 🧾 SQL
```mysql
DROP TABLE `TB_SCHEDULE`;

CREATE TABLE `TB_SCHEDULE`
(
    `SCHEDULE_ID`    BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '일정ID',
    `TITLE`    VARCHAR(64) NOT NULL COMMENT '할일 제목',
    `CONTENT`    VARCHAR(4096) NOT NULL COMMENT '할일 내용',
    `AUTHOR`    VARCHAR(32) NOT NULL COMMENT '담당자',
    `PASSWORD`    VARCHAR(128) NOT NULL COMMENT '비밀번호',
    `DATE_CREATED`    DATE NOT NULL COMMENT '작성일'
) COMMENT = '일정';

```
# 📪 API 설계
https://sepia-waterfall-6a4.notion.site/api-33903b32568b424dafd3bcbb2d128543?pvs=4