package lionel.springbootlogindemo.controller;

import lionel.springbootlogindemo.entity.User;
import lionel.springbootlogindemo.service.UserService;
import lionel.springbootlogindemo.service.UserServiceImp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getusernames")
    public List<String> getUsernames(HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return userService.getUsernameList();
        }
        return null;
    }

    @GetMapping("/insertuser/{username}/{password}")
    public int insertUser(@PathVariable(value = "username", required = true) String username,
                          @PathVariable(value = "password", required = true) String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        int count = userService.insertUser(user);
        return count;
    }

}
