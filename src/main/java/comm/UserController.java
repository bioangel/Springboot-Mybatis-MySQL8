package comm;

import comm.mapper.UserMapper;
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

    @PostMapping(path = "/new")
    public @ResponseBody
    User addUser(@RequestBody User user) {
        System.out.println("==============" + user.getName() + ", " + user.getEmail());
        return userMapper.addUser(user.getName(), user.getEmail());
    }
}