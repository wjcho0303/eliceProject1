교육과정 첫 6주간 배운 Java, Git, Spring Boot 학습 내용을 바탕으로
단순 CRUD 기능을 구현하는 프로젝트입니다.</br>
</br>
개인프로젝트 이지만, 팀별로 협업하는 경험을 위해 팀으로 구성되었습니다.</br>
팀 내에서 스크럼을 함께 진행하고, 담당 코치로부터 피드백을 받는 오피스 아워도 함께 참여했습니다.</br>
스크럼과 오피스 아워를 통해 각 구성원의 프로젝트 작업물의 개발 현황을 서로 공유하고 피드백을 주는 시간을 가졌습니다.</br>
</br>
프로젝트 발표는 1명이 5명의 개인 프로젝트 작업물들을 요약하여 대신 발표해주는 방식이었기 때문에 </br>
첨부한 PPT(또는 PDF) 파일에는 저의 개인 작업물 외에도 다른 참여자의 작업물도 함께 있습니다.</br>
해당 자료에 저의 작업물과 관련한 내용은 본 Readme.md에 작성되어 있으며,</br>
PPT(또는 PDF) 파일은 단지 협업 경험을 보여드리기 위한 참고 자료용으로서 첨부해놓으니 가볍게 훑어보시면 되겠습니다.</br>
</br>

1. 프로젝트 기획 - 기능명세서 및 ERD 설계도 작성</br>
본 프로젝트는 먼저 기능명세서와 ERD 설계도를 작성하는 것으로 시작하였습니다.</br>

</br>
2. 디렉토리 구조 - 계층형</br>
프로젝트 규모가 작기 때문에 계층형 방식으로 했어도 무방했지만 개인적으로 도메인형 디렉토리 구조를 선호하기 때문에</br>
도메인형 디렉토리 구조로 프로젝트를 진행하였습니다.</br>
</br>
3. 프로젝트에 대한 자기 비판</br>
먼저 내세울 만한 프로젝트가 되지 못한 점을 굉장히 아쉽게 생각하지만 본 프로젝트를 통해 </br>
어떠한 시행착오를 겪었고, 그로 인해 어떤 점을 배우게 되었는지 말씀드리는 것도 의미가 있다고 판단하였습니다.</br>
본 프로젝트를 진행하는 동안 프로젝트의 구조에 대해 거시적인 이해도가 부족한 상태에서 진행하였고,</br>
그 결과 Dto와 Mapper를 사용하지 않았으며, Controller 레이어에서 setter를 통해 비즈니스 로직을 수행하는 등</br>
각 레이어의 역할과 책임을 분리시켜야 한다는 원리에 대한 이해가 결여된 채로 프로젝트를 진행했습니다.</br>
</br>
4. 개선할 점 및 아쉬운 점</br>
- enum 타입의 예외 클래스를 통해 예외 처리를 체계적으로 했었으면 하는 아쉬움이 있습니다.</br>
- 회원가입, 게시판 카테고리 분류, 댓글 CRUD 기능을 구현하지 못한 아쉬움이 있습니다.</br>
- 게시물 목록을 나타낼 때 Paging을 구현하지 못한 아쉬움이 있습니다.</br>
- 게시물 클릭 시 조회수 증가, 추천-비추천 기능 등 세부적인 로직에 미처 신경쓰지 못한 점이 아쉽습니다.</br>
- 단순한 기능명세서를 넘어, API 명세까지 미리 기획했더라면 하는 아쉬움이 있습니다.</br>
</br>
5. 프로젝트를 통해 배운 것들</br>
- 관심사 분리에 실패함으로써 프로젝트가 마무리 될 때쯤 뒤늦게나마 관심사 분리의 중요성을 몸소 깨달았습니다.</br>
- 이론과 짧은 실습만으로 이해하지 못했던 내용들을 테스트 및 프로젝트를 통해 직접 실천하여 구현하면서 체득할 수 있었습니다.</br>
- </br>
