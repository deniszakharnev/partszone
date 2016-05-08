package mapper;

import domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select customer_id, customer_login, customer_name, customer_type from customers where customer_login = #{login} and customer_password = #{password}")
    User getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);
    //User getUserByUsername(String username);
}
