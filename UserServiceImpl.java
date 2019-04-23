package kr.hs.dgsw.web_0422_homework.Service;

import kr.hs.dgsw.web_0422_homework.Domain.User;
import kr.hs.dgsw.web_0422_homework.Repository.UserRepository;
import kr.hs.dgsw.web_0422_homework.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() {
        return this.userRepository.findAll();
    }

    @Override
    public User view(String userName) {
        return this.userRepository.findByuserName(userName);
    }

    @Override
    public User add(User user) {
        Optional<User> found = this.userRepository.findById(user.getId());
        if(found != null){
            return null;
        }
        return this.userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        try{
            this.userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public User update(Long id, User user){
        return this.userRepository.findById(id)
                .map(found -> {
                    if(user.getId() != null) found.setId(user.getId());
                    if(user.getUserName() != null) found.setUserName(user.getUserName());
                    this.userRepository.save(found);
                    return found;
                })
                .orElse(null);
    }
}
