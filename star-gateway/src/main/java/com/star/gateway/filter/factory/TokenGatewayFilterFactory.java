package com.star.gateway.filter.factory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

//自定义token工厂
@Component//在工厂中创建对象
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    private static final Logger log = LoggerFactory.getLogger(TokenGatewayFilterFactory.class);

    public TokenGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            //ServerWebExchange 交换机
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                log.info("进入自定义token工厂");
                exchange.getRequest();
                exchange.getResponse();
                return chain.filter(exchange);
            }
        };
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return super.shortcutFieldOrder();
    }
    public static class Config{

    }

}
