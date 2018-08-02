package comm.mapper;

import comm.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user(name, email) values (#{name}, #{email})")
    User addUser(@Param("name") String name, @Param("email") String email);

}