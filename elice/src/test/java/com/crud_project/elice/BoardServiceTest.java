package com.crud_project.elice;
import com.crud_project.elice.board.entity.Board;
import com.crud_project.elice.board.service.BoardService;
import com.crud_project.elice.user.entity.User;
import com.crud_project.elice.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoardServiceTest {
    @Autowired      // BoardService 를 주입 받아야 CRUD 메서드를 사용할 수 있다.
    BoardService boardService;

    @Autowired      // UserRepository 를 주입 받아야 User Entity 를 가져올 수 있다.
    UserRepository userRepo;


    @BeforeEach     // Test 마다 초기화 데이터가 들어가게 해주는 애너테이션. 테스트 메서드들은 각각 별도로 돌아가기 때문에,
    // Test 메서드가 실행될 때마다 @BeforeEach 가 실행되면서 데이터를 초기화 해준다.
    public void init() {
        // 게시물을 10개 정도 넣어보자
        for(Long i = 1L; i <= 50; i++) {
            // 10명의 user 생성
            User user = new User();
            user.setId("아이디"+Long.toString(i));
            userRepo.save(user);

            // 한 명의 user 당 한 개의 게시물 생성(총 50개)
            Board b = new Board();
            b.setBno(i);
            b.setTitle("글제목 " + i);
            b.setContent("글 내용 " + i);
            b.setUser(user);
            b.setViewCnt((long)(Math.random()*400));
            b.setInDate(new Date());
            b.setUpDate(new Date());
            boardService.write(b); // public Board writeBoard(Board board) { return boardRepo.save(board); }
            // Repository 에서는 save() 메서드를 쓰지만 Board 는 CRUD 이기 때문에 Service 에 정의해 놓은 메서드를 쓰는 것일 뿐이다.
            // Service 단에서는 좀 더 비즈니스 로직을 처리하기 때문에 DB적인 용어보다는 업무적인 용어를 준 것이다.
        }
    }



    // 1. 게시물 전체 가져오기 테스트
    @Test
    @Order(1)
    public void getListTest() {
        List<Board> list = boardService.getBoardList();

        // List Collection 을 가져오는 테스트이므로 size 확인이 좋다.
        assertTrue(list.size() == 50);
        // 통과

        System.out.println("list = " + list);
    }


    // 2. 게시물 읽기 & 쓰기 테스트
    @Test
    @Order(2)
    public void writeAndReadTest() {
        User user = new User();
        user.setId("운영자");
        userRepo.save(user);

        // 쓰기 테스트 (write 메서드 정상 작동여부 확인)
        Board b = new Board();
        b.setBno(51L);
        b.setTitle("원룸 화장실 바닥 배수구 냄새...");
        b.setContent("전문업체 불러 싸구려 트랩 아닌 전문업체가 해주는 트랩으로 하려 하는데 어떤 업체는 14만원,"
                + "\n" +"어떤 업체는 9만원 부르네요... 혹시 더 저렴히 해주는 업체 아시는 분 계시면 공유 부탁드려도 될까요?"
                + "\n" +"가스 악취가 오늘 아침까지도 나서... 계속 이냄새 맡다가 코가 마비될 것 같아요 살려주세요 ㅠㅠ");

        b.setUser(user);
        b.setViewCnt((long)(Math.random()*400));
        b.setInDate(new Date());
        b.setUpDate(new Date());
        boardService.write(b);

        // 읽기 테스트 (read 메서드 정상 작동여부 확인)
        Board b2 = boardService.read(51L);
        assertTrue(b2 != null);
        // 통과

        assertEquals(b.getTitle(), b2.getTitle());
        // 통과
        assertEquals(b.getContent(), b2.getContent());
        // 통과


        // * 참고: assertEquals(A, B) A와 B가 같은지 여부 확인
    }


    // 3. 게시물 수정 테스트
//    @Test
//    @Order(3)
//    public void modifyTest() {
//        Board board = boardService.read(1L);
//        // 1번 게시물의 User 가 맞는지 검증하는 코드: 해당 user 가 아닐 경우 안내메시지 출력 및 메서드 탈출
//        //
//        //
//
//        // 1번 게시물의 User 가 게시물을 아래와 같이 수정했다고 가정
//        board.setTitle("1번 게시물 제목 수정했어요. modifyTest()");
//        board.setContent("1번 게시물 내용 수정했음 modifyTest()");
//
//        // 1번 게시물의 수정 내용을 modify 메서드에 투입하여 DB 에 저장
//        boardService.modify(board);
//
//        // 1번 게시물을 board2 라는 참조변수에 복붙
//        Board board2 = boardService.read(1L);
//
//        // board 와 복붙한 board2 가 Title 과 Content 가 일치하는지 여부 확인
//        assertEquals(board.getTitle(), board2.getTitle());
//        assertEquals(board.getContent(), board2.getContent());
//    }



    // 4. 게시물 삭제 테스트
//    @Test
//    @Order(4)
//    public void removeTest() {
//        // 게시물 번호 지정
//        Long deleteBno = 10L;
//
//        // 입력한 게시물 번호의 게시물이 존재하는지 여부 확인
//        assertTrue(boardService.read(deleteBno) != null);
//
//        // 게시물이 존재한 것을 확인했으므로 삭제
//        boardService.remove(deleteBno);
//
//        // 삭제 처리 후 삭제가 제대로 되었느지 확인
//        assertTrue(boardService.read(deleteBno) == null);
//    }

    // 이상 BoardService 의 메서드 테스트 완료
}