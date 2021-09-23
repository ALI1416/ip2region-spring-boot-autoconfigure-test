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
        resource();
        // local();
        // url();
        // priority();
        // none();
        // error();
        // init();
    }

    /**
     * 使用资源路径
     */
    static void resource() {
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // INFO 15744 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       :
        // 读取到配置文件，RESOURCE_PATH为/file/ip2region/data.db
        // INFO 15744 --- [           main] cn.z.ip2region.Ip2Region                 : 加载数据文件成功，总共8.93MB
        // INFO 15744 --- [           main] com.demo.App                             : Started App in 0.971 seconds
        // (JVM running for 2.101)
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 使用本地路径
     */
    static void local() {
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // INFO 13984 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       :
        // 读取到配置文件，LOCAL_PATH为/file/ip2region/data.db
        // INFO 13984 --- [           main] cn.z.ip2region.Ip2Region                 : 初始化，文件路径为/file/ip2region/data.db
        // INFO 13984 --- [           main] cn.z.ip2region.Ip2Region                 : 加载数据文件成功，总共8.93MB
        // INFO 13984 --- [           main] com.demo.App                             : Started App in 1.053 seconds
        // (JVM running for 2.208)
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 使用url路径
     */
    static void url() {
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // INFO 13900 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       : 读取到配置文件，URL_PATH为https://cdn.jsdelivr.net/gh/lionsoul2014/ip2region/data/ip2region.db
        // INFO 13900 --- [           main] cn.z.ip2region.Ip2Region                 : 初始化，URL路径为https://cdn.jsdelivr.net/gh/lionsoul2014/ip2region/data/ip2region.db
        // INFO 13900 --- [           main] cn.z.ip2region.Ip2Region                 : 加载数据文件成功，总共8.93MB
        // INFO 13900 --- [           main] com.demo.App                             : Started App in 2.704 seconds
        // (JVM running for 4.005)
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 优先级
     */
    static void priority() {
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // INFO 4364 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       :
        // 读取到配置文件，RESOURCE_PATH为/file/ip2region/data.db
        // INFO 4364 --- [           main] cn.z.ip2region.Ip2Region                 : 加载数据文件成功，总共8.93MB
        // INFO 4364 --- [           main] com.demo.App                             : Started App in 1.024 seconds
        // (JVM running for 2.208)
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

    /**
     * 没有配置
     */
    static void none() {
        System.out.print(Ip2Region.parse("202.108.22.5"));
        //  INFO 13960 --- [           main] com.demo.App                             : Started App in 0.972 seconds
        //  (JVM running for 2.132)
        // ERROR 13960 --- [           main] cn.z.ip2region.Ip2Region                 : memorySearch查询异常
        // java.lang.NullPointerException: null
        // Region{country='', province='', city='', area='', isp=''}
    }

    /**
     * 配置错误
     */
    static void error() {
        System.out.print(Ip2Region.parse("202.108.22.5"));
        //  INFO 15352 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       :
        //  读取到配置文件，RESOURCE_PATH为/file/ip2region/data
        // ERROR 15352 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       : 数据文件读取异常
        // java.io.FileNotFoundException: class path resource [file/ip2region/data] cannot be opened because it does
        // not exist
        //  INFO 15352 --- [           main] com.demo.App                             : Started App in 1.007 seconds
        //  (JVM running for 2.123)
        // ERROR 15352 --- [           main] cn.z.ip2region.Ip2Region                 : memorySearch查询异常
        // java.lang.NullPointerException: null
        // Region{country='', province='', city='', area='', isp=''}
    }

    /**
     * 配置属性后又手动初始化
     */
    static void init() {
        Ip2Region.initByFile("/file/ip2region/data.db");
        System.out.print(Ip2Region.parse("202.108.22.5"));
        // INFO 10676 --- [           main] c.z.i.a.Ip2RegionAutoConfiguration       :
        // 读取到配置文件，RESOURCE_PATH为/file/ip2region/data.db
        // INFO 10676 --- [           main] cn.z.ip2region.Ip2Region                 : 加载数据文件成功，总共8.93MB
        // INFO 10676 --- [           main] com.demo.App                             : Started App in 0.969 seconds
        // (JVM running for 2.106)
        // WARN 10676 --- [           main] cn.z.ip2region.Ip2Region                 : 已经初始化过了，不可重复初始化！
        // Region{country='中国', province='北京', city='北京', area='', isp='联通'}
    }

}
