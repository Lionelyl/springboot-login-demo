package lionel.springbootlogindemo.dao;


import lionel.springbootlogindemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    //插入用户
    @Insert("insert into  user(id,username,password) VALUES (#{id},#{username},#{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);


    //获取全用户列表
    @Results(
            id = "userlist",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    }
    )
    @Select("select * from user;")
    List<User> getUserList();

    //获取全用户名列表
    @Select("select username from user;")
    List<String> getUsernameList();

    //根据用户名搜索用户
    @ResultMap("userlist")
    @Select("select * from user where username = #{username};")
    User getUserByUsername(@Param("username") String username);


    //根据用户名密码搜索用户
    @ResultType(User.class)
    @Select("select * from user where username = #{username} and password = #{password};")
    User getUserByUsernameAndPassword(@Param("username") String username,
                                      @Param("password") String password);

}
