package com.demo;

import cn.z.ip2region.Ip2Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>启动类</h1>
 *
 * <p>
 * createDate 2021/09/22 16:24:01
 * </p>
 *
 * @author ALI[ali-k@foxmail.com]
 * @since 1.0.0
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.print(Ip2Region.parse("202.108.22.5"));
    }

}
