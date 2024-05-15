package com.crud_project.elice.board.service;

import com.crud_project.elice.board.entity.Board;
import com.crud_project.elice.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepo;

    public List<Board> getBoardList() {
        return (List<Board>)boardRepo.findAll();
    }

    public Board write(Board board) {

        return boardRepo.save(board);
    }

    public Board read(Long bno) {

        return boardRepo.findById(bno).orElse(null);
    }

    public Board modify(Board newBoard) {
        Board board = boardRepo.findById(newBoard.getBno()).orElse(null);
        if(board==null) return null;
        // 작성자인지 확인하는 과정을 아래에 코드로 추가
        //
        //

        board.setTitle(newBoard.getTitle());
        board.setContent(newBoard.getContent());
        return boardRepo.save(board);
    }


    // 게시물을 삭제하는 메서드 D : Board 의 PK 속성인 bno 를 입력하여 삭제
    public void remove(Long bno) {
        Board board = boardRepo.findById(bno).orElse(null);

        // 만약 입력한 게시물 번호 bno 에 해당하는 데이터가 없어서 board = null 이 된 경우 처리할 코드 추가
        //
        //

        if(board != null)
            boardRepo.deleteById(bno);
    }
}
