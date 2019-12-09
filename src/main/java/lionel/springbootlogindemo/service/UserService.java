package lionel.springbootlogindemo.service;

import lionel.springbootlogindemo.entity.User;

import java.util.List;

public interface UserService {

    //根据用户密码获取用户
    User getUser(String username, String password);

    //获取用户列表
    List<String> getUsernameList();

    //插入用户
    int insertUser(User user);
}
