package com.test.admin.web.controller;

import com.test.admin.web.dto.PostsResponseDto;
import com.test.admin.web.dto.PostsSaveRequestDto;
import com.test.admin.web.dto.PostsUpdateRequestDto;
import com.test.admin.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //등록기능
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }
    ////
    //수정기능
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id , @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);
    }
    //조회기능
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    //삭제기능
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
