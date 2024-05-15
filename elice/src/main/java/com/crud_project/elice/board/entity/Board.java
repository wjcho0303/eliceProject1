package com.crud_project.elice.board.entity;

import com.crud_project.elice.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String writer;

    private String content;

    private Long viewCnt;

    private Date inDate;        // 입력날짜

    private Date upDate;        // 수정날짜

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

//    @OneToMany(mappedBy = "board")
//    List<Comment> commentList = new ArrayList<>();
}
