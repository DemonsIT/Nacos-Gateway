package com.bonree.gateway.author;

import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bonree
 * 网关入口鉴权
 * TODO:待实现
 */
// @Component
public class IndexFilter implements WebFilter, Ordered {
    
    private static Map<String, String> methodPathMap = new HashMap<>(16);
    
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        // 获取请求参数
        Map<String, String> query =
                serverWebExchange.getRequest().getQueryParams().toSingleValueMap();
        // 鉴权
        check(query);
        String method = query.get("method");
        String path = methodPathMap.get(method);
        if (path != null) {
            // 复制一个新的request
            ServerHttpRequest newRequest = serverWebExchange.getRequest()
                    .mutate()
                    // 关键:重新定义转发的path
                    .path(path)
                    .build();
            // 复制一个新的exchange,request用新的
            ServerWebExchange newExchange = serverWebExchange.mutate().request(newRequest).build();
            // 向后转发新的exchange
            return webFilterChain.filter(newExchange);
        }
        return webFilterChain.filter(serverWebExchange);
    }
    
    private void check(Map<String, String> query) {
        
    }
    
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
