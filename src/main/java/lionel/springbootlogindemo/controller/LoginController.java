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

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{username}/{password}")
    public String login(@PathVariable(value = "username", required = true) String username,
                        @PathVariable(value = "password", required = true) String password,
                        HttpSession httpSession){

        //参数校验
        if(username.length() < 2 || username.length() > 20
                || password.length() < 2 || password.length() > 20){
            return "Login failed";
        }

        //请求转发，会话管理
        try{
            httpSession.setAttribute("user",userService.getUser(username,password));
        }catch (Exception e){
            return "login failed";
        }
        return "login successfully";
    }




    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "logout successfully";
    }


}
