package comm.mapper;

import comm.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email")
    })

    @Select("select * from user where name = #{name}")
    List<User> findByName(String name);

    @Insert("insert into user(name, email) values (#{name}, #{email})")
    void addUser(User user);

    @Update("update user set name = #{name}, email = #{email} where id = #{id}")
    void modUser(User user);

    @Delete("delete from user where id = #{id}")
    void delUser(int id);
}
