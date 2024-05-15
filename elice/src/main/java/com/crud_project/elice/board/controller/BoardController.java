package com.crud_project.elice.board.controller;

import com.crud_project.elice.user.entity.User;
import com.crud_project.elice.board.entity.Board;
import com.crud_project.elice.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    // BoardService 주입
    @Autowired
    BoardService boardService;

    // 게시판 페이지에 게시물 목록 가져오기
    @GetMapping("/list")
    public String getList(Model model) {
        List<Board> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "/board/list";
    }

    // 게시글 작성하기 - 1
    @GetMapping("/write")
    public String showWriteForm(Model model) {
        Board board = new Board();
        User user = new User();
        user.setId(user.getId());
        board.setUser(user);

        model.addAttribute("board", board);
        return "/board/write";
    }
    // 게시글 작성하기 - 2
    @PostMapping("/write")
    public String write(Board board) {
        board.setBno(board.getBno());
        User user = new User();
        user.setId("운영자");
        board.setUser(user);
        board.setViewCnt((long)(Math.random()*20));
        board.setInDate(new Date());
        board.setUpDate(new Date());
        boardService.write(board);
        return "redirect:/board/list";
    }


    // 게시물 읽기 페이지
    @GetMapping("/read")
    public String read(Long bno, Model model) {
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "/board/read";
    }


    // 게시물 수정하기 - 1: 먼저 수정하기 전에 보여줘야 함
    @GetMapping("/modify")
    public String modify(Long bno, Model model) {
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "/board/edit";  // write 화면에서 수정해야 하므로 edit 로 board 의 정보들을 제공
    }
    // 게시물 수정하기 - 2: 수정한 내용이 객체로 넘어오면 반영하여 수정 처리
    @PostMapping("modify")
    public String modify(Board board) {
        boardService.modify(board);
        return "redirect:/board/list";  // 수정 완료 후 list 페이지로 redirect (write 와 동일한 상황)
    }



    // 게시물 삭제 기능
    @PostMapping("/remove")     // form 태그로 요청을 하기 때문에 PostMapping 사용
    public String remove(Long bno) {
        boardService.remove(bno);
        return "redirect:/board/list";  // 게시물 삭제 후에 게시물 목록으로 이동
    }
}
