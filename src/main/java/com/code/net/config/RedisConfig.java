package com.code.net.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootConfiguration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> kw = new RedisTemplate();
        FastJson2JsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
        kw.setValueSerializer(fastJsonRedisSerializer);
        kw.setHashValueSerializer(fastJsonRedisSerializer);
        kw.setKeySerializer(new StringRedisSerializer());
        kw.setHashKeySerializer(new StringRedisSerializer());
        kw.setConnectionFactory(redisConnectionFactory);
        return kw;
    }
}