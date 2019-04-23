package kr.hs.dgsw.web_0422_homework.Controller;

import kr.hs.dgsw.web_0422_homework.Domain.Post;
import kr.hs.dgsw.web_0422_homework.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public Post add(@RequestBody Post post){
        return this.postService.add(post);
    }

    @DeleteMapping("/post/${id}")
    public boolean delete(@PathVariable Long id){
        return this.postService.delete(id);
    }
}
