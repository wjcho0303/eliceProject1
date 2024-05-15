package com.crud_project.elice.user.entity;

import com.crud_project.elice.board.entity.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(name="user_id")
    private String id;
    private String password;
    private String name;
    private String email;
    private Date inDate;
    private Date upDate;

    @OneToMany(mappedBy = "user")
    List<Board> boardList = new ArrayList<>();
}