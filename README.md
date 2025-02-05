# 게시판 시스템

해당 GitHub 리포지토리는 Spring을 사용하여 게시판 시스템을 구현한 프로젝트입니다. 리포지토리에는 기본적인 게시글 CRUD 기능과 관련된 코드가 포함되어 있으며, Gradle을 사용하여 빌드하고 실행할 수 있습니다. 데이터베이스로는 MySQL을 사용합니다.

## 기술 스택
- **백엔드**: Spring Framework
- **데이터베이스**: MySQL 
- **빌드 툴**: Gradle
- **언어**: Java

## ERD (엔터티 관계도)
![Image](https://github.com/user-attachments/assets/629eea12-bc03-49fa-b3bf-ac360715550d)

## API 엔드포인트

### POST /members/signup
- **설명**: 회원 생성 기능
- **요청 본문**: 
`{
  "username": "test",
  "password": "1234",
  "age": 20
}`
- **응답**: `{
  "id": 1,
  "username": "test",
  "age": 20
  }`

### GET /members/{id}
- **설명**: 특정 회원 조회 기능
- **응답**: `{
  "username": "test",
  "age": 20
  }`

### PATCH /members/{id}
- **설명**: 비밀번호 수정 기능
- **요청 본문**:`{
  "oldPassword": "1234",
  "newPassword": "1111"
  }`
- **응답**: `200 OK`

### POST /boards
- **설명**: 게시글 생성 기능
- **요청 본문**:`{
  "title": "title",
  "contents": "contents",
  "username": "test"
  }`
- **응답**: `{
  "id": 1,
  "title": "title",
  "contents": "contents"
  }`

### GET /boards
- **설명**: 게시글 전체 조회 기능
- **응답**: `[
  {
  "id": 1,
  "title": "title",
  "contents": "contents"
  }
  ]`

### GET /boards/{id}
- **설명**: 특정 게시글 조회 기능
- **응답**: `{
  "id": 1,
  "title": "title",
  "contents": "contents",
  "age": 20
  }`

### DELETE /members/{id}
- **설명**: 특정 게시글 삭제 기능
- **응답**: `200 OK`

## 실행 방법

1. 레포지토리 클론:
   ```bash
   git clone https://github.com/ijieun0123/board.git
   ```

2. 프로젝트 빌드:
   ```bash
   gradle build
   ```

3. 애플리케이션 실행:
   ```bash
   gradle bootRun
   ```

