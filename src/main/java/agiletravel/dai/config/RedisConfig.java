//package agiletravel.dai.config;
//
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//
//
//import java.time.Duration;
//
//
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//    @Bean
//    public RedisCacheConfiguration cachingConfigurerSupport(){
//        FastJsonSerializer<Object> fastJsonSerializer = new FastJsonSerializer<>(Object.class);
//        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
//        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonSerializer)).entryTtl(Duration.ofDays(30));
//        return configuration;
//    }
//}
//
