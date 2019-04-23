package kr.hs.dgsw.web_0422_homework.Service;

import kr.hs.dgsw.web_0422_homework.Domain.User;

import java.util.List;

public interface UserService {

    List<User> list();
    User view(String userName);
    User add(User user);
    boolean delete(Long id);
    User update(Long id, User user);
}
