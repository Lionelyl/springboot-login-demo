package lionel.springbootlogindemo.service;

import lionel.springbootlogindemo.dao.UserDao;
//import lionel.springbootlogindemo.dao.UserDaoImpl;
import lionel.springbootlogindemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username,password);
        if(user == null) throw new RuntimeException();
        return user;
    }

    @Override
    public List<String> getUsernameList() {return new ArrayList<String>(userDao.getUsernameList());}


    @Override
    public int insertUser(User user) {
        int num = userDao.insertUser(user);
        return num;
    }
}
