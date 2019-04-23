package kr.hs.dgsw.web_0422_homework.Controller;

import kr.hs.dgsw.web_0422_homework.Domain.User;
import kr.hs.dgsw.web_0422_homework.Protocol.ResponseFormat;
import kr.hs.dgsw.web_0422_homework.Protocol.ResponseType;
import kr.hs.dgsw.web_0422_homework.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseFormat list(){
        return new ResponseFormat(
                ResponseType.POST_ADD,
                "Hello"
        );
    }

//    @GetMapping("/user")
//    @ResponseBody
//    public List<User> list(){
//        return this.userService.list();
//    }

    @GetMapping("/user/{userName}")
    @ResponseBody
    public User view(@PathVariable String userName) {
        return this.userService.view(userName);
    }

    @PostMapping("/user")
    @ResponseBody
    public User add(@RequestBody User user){
        return this.userService.add(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Long id) {
        return this.userService.delete(id);
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public User update(@PathVariable Long id, @RequestBody User user){
        return this.userService.update(id, user);
    }

}
