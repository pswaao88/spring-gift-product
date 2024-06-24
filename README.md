# spring-gift-product

# 진행 방식
- 미션은 과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항 세 가지로 구성되어 있다.

- 세 개의 요구 사항을 만족하기 위해 노력한다. 

- 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

------

# 과제 진행 요구 사항
- 미션은 선물하기 상품 관리 저장소를 포크하고 클론하는 것으로 시작한다.
- 온라인 코드 리뷰 요청 1단계 문서를 참고하여 실습 환경을 구축한다.

   1. 미션 시작 버튼을 클릭하여 미션을 시작한다.
   2. 저장소에 GitHub 사용자 이름으로 브랜치가 생성되었는지 확인한다.
   3. 저장소를 내 계정으로 포크한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.

-----

# 기능 요구 사항

상품을 조회, 추가, 수정, 삭제할 수 있는 간단한 HTTP API를 구현한다.

- HTTP 요청과 응답은 JSON 형식으로 주고받는다.
- 현재는 별도의 데이터베이스가 없으므로 적절한 자바 컬렉션 프레임워크를 사용하여 메모리에 저장한다.