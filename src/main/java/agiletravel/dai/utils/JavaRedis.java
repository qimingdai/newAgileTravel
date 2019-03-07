package agiletravel.dai.utils;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component("javaRedis")
public class JavaRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public String getKeyValue (String key){
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    public void setKeyValue(String key, String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public void setAccessTokenKey(String key,String value,long time){
        stringRedisTemplate.opsForValue().set(key,value,MiniProgramConst.ACCESS_TOKEN_LAST_TIME, TimeUnit.SECONDS);
    }

    public boolean deleteKey(String key){
       return stringRedisTemplate.delete(key);
    }

}
