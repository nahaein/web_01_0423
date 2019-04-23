package kr.hs.dgsw.web_0422_homework.Service;

import kr.hs.dgsw.web_0422_homework.Domain.Post;

public interface PostService {
//    List<Post> list();
//    Post view(String title);
//    Post add(Post post);
//    Post update(Long id, Post post);
// void delete(Long postId))

    Post get(Long postId);
    Post add(Post post);
    boolean delete(Long postId);
}
