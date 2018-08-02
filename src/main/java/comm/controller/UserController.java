package comm.controller;

import comm.mapper.UserMapper;
import comm.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping(path = "/find")
    public @ResponseBody
    User findUserByName(@RequestBody User user) {
        return userMapper.findByName(user.getName());
    }

    @PostMapping(path = "/signin")
    public @ResponseBody
    String addUser(@RequestBody User user) {
        userMapper.addUser(user);
        return "Saved";
    }
}
