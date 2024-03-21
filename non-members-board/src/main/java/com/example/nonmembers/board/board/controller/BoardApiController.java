package com.example.nonmembers.board.board.controller;

import com.example.nonmembers.board.board.db.BoardEntity;
import com.example.nonmembers.board.board.service.BoardService;
import com.example.nonmembers.board.board.model.BoardRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor// 해당 클래스의 모든 final 필드에 대한 생성자가 자동으로 생성
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    //@Valid 유효성 검사
    //@RequestBody 이 어노테이션은 HTTP 요청의 본문(body)을 자바 객체로 변환
    public BoardEntity create(@Valid @RequestBody BoardRequest boardRequest){
        return boardService.create(boardRequest);
    }
}
