package comm.controller;

import comm.mapper.UserMapper;
import comm.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping(path = "/find")
    public @ResponseBody
    List<User> findUserByName(@RequestBody User user) {
        return userMapper.findByName(user.getName());
    }

    @PostMapping(path = "/signin")
    public @ResponseBody
    String addUser(@RequestBody User user) {
        userMapper.addUser(user);
        return "User Added!";
    }

    @PostMapping(path = "/moduser")
    public @ResponseBody
    String modUser(@RequestBody User user) {
        userMapper.modUser(user);
        return "User Changed!";
    }

    @PostMapping(path = "/deluser")
    public @ResponseBody
    String delUser(@RequestBody User user) {
        userMapper.delUser(user.getId());
        return "User Deleted!";
    }
}
