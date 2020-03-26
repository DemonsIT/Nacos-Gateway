package com.bonree.zuul;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 整合启动类
 * @author Bonree
 */
public class BonreeMain {
    
    public static void main(String[] args) throws Exception {
        // 引用nacos服务端jar包,启动nacos服务端主类
        // File file = new File("D:\\bonree\\桌面文件\\ncov.jar");
        File file = new File("D:\\bonree\\CodeProject\\Nacos-Gateway\\Zuul\\nacos\\target\\nacos" +
                "-server.jar");
        URL url = file.toURI().toURL();
        System.out.println("show file's url:" + url);
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        Method main = Class.forName("org.springframework.boot.loader.JarLauncher", true, loader).getMethod("main",
                String[].class);
        main.invoke(null, (Object) new String[]{});
        
        // 启用nacos和zuul客户端
        Method zuulMain = Class.forName("com.bonree.zuul.ZuulApplication").getMethod("main",
                String[].class);
        zuulMain.invoke(null, (Object) new String[]{});
    }
}
