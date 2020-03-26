package com.bonree.zuul;

import java.lang.reflect.Method;

/**
 * 整合启动类
 * @author Bonree
 */
public class BonreeMain {
    
    public static void main(String[] args) throws Exception {
        // 引用nacos服务端jar包,启动nacos服务端主类
        
        // 启用nacos和zuul客户端
        Method zuulMain = Class.forName("com.bonree.zuul.ZuulApplication").getMethod("main",
                String[].class);
        zuulMain.invoke(null, (Object) new String[]{});
    }
}
