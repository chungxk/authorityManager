package chung.manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class AuthorityManagerApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
    }

}
