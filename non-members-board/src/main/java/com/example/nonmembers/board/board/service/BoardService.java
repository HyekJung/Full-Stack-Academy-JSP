package com.example.nonmembers.board.board.service;

import com.example.nonmembers.board.board.db.BoardEntity;
import com.example.nonmembers.board.board.db.BoardRepository;
import com.example.nonmembers.board.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardEntity create(BoardRequest boardRequest){
        var entity = BoardEntity.builder().boardName(boardRequest.getBoardName()).status("REGISTERED").build();

        return boardRepository.save(entity);
    }
}
