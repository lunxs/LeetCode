package com.lunx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author desong.xie
 * @version 1.0
 * @title SpringRedisConfig
 * @date 2019/09/25
 * @description
 */
@Configuration
public class SpringRedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(Environment environment, JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setHostName(environment.getProperty("spring.redis.host"));
        jedisConnectionFactory.setPassword(environment.getProperty("spring.redis.password"));
        jedisConnectionFactory.setPort(Integer.parseInt(environment.getProperty("")));
        jedisConnectionFactory.setTimeout(3600);
        jedisConnectionFactory.setDatabase(5);
        return jedisConnectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(2);
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestWhileIdle(true);
        return jedisPoolConfig;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

    /*@Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(Environment environment) {
        String host = environment.getProperty("spring.redis.host");
        String password = environment.getProperty("spring.redis.password");
        Config config = new Config();
        String address = "redis://" + host + ":6379";
        config.useSingleServer().setAddress(address)
                .setPassword(password)
                .setDatabase(9)
                .setTimeout(600)
                .setRetryAttempts(2)
                .setConnectionMinimumIdleSize(2)
                .setReconnectionTimeout(3000);
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

    @Bean
    public RedisLockerTemplate redisLockerTemplate(RedissonClient redissonClient) {
        return new RedisLockerTemplate(redissonClient);
    }*/

}
