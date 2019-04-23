package kr.hs.dgsw.web_0422_homework.Service;

import kr.hs.dgsw.web_0422_homework.Domain.Post;
import kr.hs.dgsw.web_0422_homework.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postrepository;

    @Override
    public Post get(Long userId){
        return this.postrepository
                .findTopByUserIdOrderByIdDesec(userId)
                .orElse(null);
    }

    @Override
    public boolean delete(Long postId){
        this.postrepository.deleteById(postId);
        return false;
    }
}
