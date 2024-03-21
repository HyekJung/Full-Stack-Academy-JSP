package com.example.nonmembers.board.post.service;

import com.example.nonmembers.board.post.db.PostEntity;
import com.example.nonmembers.board.post.db.PostRepository;
import com.example.nonmembers.board.post.model.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    
    public PostEntity create(PostRequest postRequest){
        var entity = PostEntity.builder().boardId(1L)// 1번
                .userName(postRequest.getUserName()).password(postRequest.getPassword()).email(postRequest.getEmail()).
                status("REGISTERED").title(postRequest.getTitle()).content(postRequest.getContent())
                .postedSt(LocalDateTime.now()).build();

        return postRepository.save(entity);
    }
}
