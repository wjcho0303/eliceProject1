package com.crud_project.elice.board.repository;
import com.crud_project.elice.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    Page<Board> findAllByBoardOrderByCreatedAtDesc(Board board, Pageable pageable);
//
//    Page<Board>  findAllByBoardAndTitleContaining(Board board, String keyword, Pageable pageable);
}
