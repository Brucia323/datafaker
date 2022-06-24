package zcy.gyj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Slf4j
public class UserDao {
    @Resource
    JdbcTemplate jdbcTemplate;
    
    int[][] addUser(List<User> users) {
        return jdbcTemplate.batchUpdate("insert into user(uname, uno, upwd, ucash, ustate, uphone, unum) VALUES (?,?,'123456',300,'使用中',?,?)", users, 1000, (ps, argument) -> {
            ps.setString(1, argument.getUname());
            ps.setString(2, argument.getUno());
            ps.setString(3, argument.getUphone());
            ps.setString(4, argument.getUnum());
        });
    }
}
