package com.test.admin.web.controller;

import com.test.admin.web.config.auth.LoginUser;
import com.test.admin.web.config.auth.dto.SessionUser;
import com.test.admin.web.dto.PostsResponseDto;
import com.test.admin.web.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/") // (0) 추가부분 @LoginUser
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        // 삭제했음 SessionUser user 부분
        if (user != null) {
            model.addAttribute("userName", user.getName());
        } //(1)
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
