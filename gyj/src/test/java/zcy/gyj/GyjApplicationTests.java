package zcy.gyj;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootTest
@Slf4j
class GyjApplicationTests {
    @Resource
    UserDao userDao;
    
    @Test
    void contextLoads() {
        Faker faker = new Faker(Locale.CHINA);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            User user = new User();
            user.setUname(faker.name().fullName());
            user.setUno(GenerateID.getRandomID());
            user.setUphone(faker.phoneNumber().cellPhone());
            user.setUnum(faker.idNumber().validZhCNSsn());
            log.info(String.valueOf(user));
            users.add(user);
        }
        userDao.addUser(users);
    }
    
}
