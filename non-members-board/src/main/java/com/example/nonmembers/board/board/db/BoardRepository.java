package com.example.nonmembers.board.board.db;

import com.example.nonmembers.board.post.db.PostEntity;
import com.example.nonmembers.board.post.db.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
