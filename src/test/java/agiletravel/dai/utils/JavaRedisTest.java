package agiletravel.dai.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaRedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void getKeyValue() {
        String value = stringRedisTemplate.opsForValue().get("mykey");
        System.out.println(value);
    }
}