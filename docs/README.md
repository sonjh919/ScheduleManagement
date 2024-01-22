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
- [ ] `할일 제목`,`할일 내용`, `담당자`, `비밀번호`, `작성일`을 저장할 수 있다.
- [ ] 저장된 게시글의 정보를 반환 받아 확인할 수 있다.
  - [ ] 반환 받은 게시글의 정보에 `비밀번호`는 제외되어 있다.

## 🔥 선택한 일정 조회 기능
- [ ] 선택한 일정의 정보를 조회할 수 있다.
  - [ ] 반환 받은 일정 정보에 `비밀번호`는 제외되어 있다.

## 🔥 일정 목록 조회 기능
- [ ] 등록된 일정 전체를 조회할 수 있다.
    - [ ] 반환 받은 일정 정보에 `비밀번호`는 제외 되어있다.
- [ ] 조회된 일정 목록은 `작성일` 기준 내림차순으로 정렬 되어있다.


## 🔥 선택한 일정 수정 기능
- [ ] 선택한 일정의 `할일 제목`,`할일 내용`, `담당자`을 수정할 수 있다.
  - [ ] 서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달한다.
  - [ ] 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 수정이 가능하다.
- [ ] 수정된 일정의 정보를 반환 받아 확인할 수 있다.
  - [ ] 반환 받은 일정의 정보에 `비밀번호`는 제외 되어있다.

- [ ]  선택한 일정 삭제 기능
    - 선택한 일정을 삭제할 수 있습니다.
        - 서버에 일정 삭제를 요청할 때 `비밀번호`를 함께 전달합니다.
        - 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 삭제가 가능합니다.

### 🔥 선택한 일정 삭제 기능
- [ ] 선택한 일정을 삭제할 수 있다.
  - [ ] 서버에 일정 삭제를 요청할 때 `비밀번호`를 함께 전달한다.
  - [ ] 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 삭제가 가능하다.


### ⛏ 예외 처리 사항
- [ ] 요청받은 값에 NULL이 들어있는지 체크한다.
- [ ] 요청받은 ID값이 유효한 값인지 유효성 검사를 진행한다.
- [ ] 선택 일정 수정 및 삭제 요청의 경우, 비밀번호가 일치하지 않을 경우 API 요청 실패(예외상황)에 대해 판단할 수 있는 Status Code, Error 메시지등의 정보를 반환한다.
---

# 📋 DataBase
![schedulemanagementDB](https://github.com/sonjh919/sonjh919.github.io/assets/109019081/d51e9d5f-411c-4b06-ab5b-1d37d071315a)

## 🧾 SQL
```mysql
DROP TABLE `TB_SCHEDULE`;

CREATE TABLE `TB_SCHEDULE`
(
    `scheduleId`    INTEGER NOT NULL COMMENT '일정ID',
    `title`    VARCHAR(64) NOT NULL COMMENT '할일 제목',
    `content`    VARCHAR(4096) NOT NULL COMMENT '할일 내용',
    `author`    VARCHAR(32) NOT NULL COMMENT '담당자',
    `password`    VARCHAR(128) NOT NULL COMMENT '비밀번호',
    `dateCreated`    DATE NOT NULL COMMENT '작성일',
 PRIMARY KEY ( `scheduleId` )
) COMMENT = '일정';

ALTER TABLE `TB_SCHEDULE`
 ADD CONSTRAINT `TB_SCHEDULE_PK` PRIMARY KEY ( `scheduleId` );
```
# 📪 API 설계
https://sepia-waterfall-6a4.notion.site/api-33903b32568b424dafd3bcbb2d128543?pvs=4