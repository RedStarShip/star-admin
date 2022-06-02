package com.star.gateway.filter.factory;


import com.star.constant.RedisPrefix;
import com.star.exceptions.IllegalTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

//自定义token工厂
@Component//在工厂中创建对象
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    private static final Logger log = LoggerFactory.getLogger(TokenGatewayFilterFactory.class);

    private RedisTemplate redisTemplate;

    @Autowired
    public TokenGatewayFilterFactory(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    //config参数就是基于当前类的配置
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            //ServerWebExchange 交换机
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("config required token ", config.requiredToken);
                log.info("config required name ", config.name);
                if (config.requiredToken) {
                    //1.获取token信息
                    if (exchange.getRequest().getQueryParams().get("token").get(0) == null)
                        throw new IllegalTokenException("token为空");
                    String token = exchange.getRequest().getQueryParams().get("token").get(0);
                    //2.根据token信息从redis中获取用户信息
                    if (redisTemplate.hasKey(RedisPrefix.TOKEN_KEY + token)) throw new IllegalTokenException("不合法的token");
                }
                return chain.filter(exchange);
            }
        };
    }


    //用来配置将使用filter时指定值赋值给Config中哪个属性
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("requiredToken", "name");
    }

    //自定义配置类
    public static class Config {
        private boolean requiredToken; //默认为false
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isRequiredToken() {
            return requiredToken;
        }

        public void setRequiredToken(boolean requiredToken) {
            this.requiredToken = requiredToken;
        }
    }

}
