#RestFul API Server

### 스펙
- Java 11
- SpringBoot 2.5.3
- gradle


### 기능 
- 수식(mathematical expression)
  - 조회
  - 등록
  - 수정
  - 삭제

### 데이터 속성
- 문자열 
- 수식은 + , - 만 존재한다.
- 괄호는 중괄호를 포함 할 수 있다.
- 영문 대/소문자를 구분한다.

### 제약사항
- DB로 저장하지 않고 파일 혹은 변수에 저장
- 수식 출력시 괄호를 제거하고 출력

