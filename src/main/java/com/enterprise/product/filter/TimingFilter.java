package com.enterprise.product.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TimingFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        var startMillis = System.currentTimeMillis();
        return chain.filter(exchange)
                .doOnSuccess(aVoid ->

                        //TODO: Send endpoints timings to a file appender
                        log.info("Elapsed Time: {}ms", System.currentTimeMillis() - startMillis)
                );
    }
}