package com.example.nonmembers.board.post.controller;

import com.example.nonmembers.board.post.db.PostEntity;
import com.example.nonmembers.board.post.model.PostRequest;
import com.example.nonmembers.board.post.model.PostViewRequest;
import com.example.nonmembers.board.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;
    @PostMapping("")
    public PostEntity create(@Valid @RequestBody PostRequest postRequest){
        return postService.create(postRequest);
    }
    @PostMapping("/view")
    //게시글 자세히 보기
    public PostEntity view(@Valid @RequestBody PostViewRequest postViewRequest){
        return postService.view(postViewRequest);
    }

    //게시글 목록
    @GetMapping("/all")
    public List<PostEntity> list(){
        return postService.all();
    }

    @PostMapping("/delete")
    //게시글 삭제
    public void delete(@Valid @RequestBody PostViewRequest postViewRequest) {
        postService.delete(postViewRequest);
    }
}
