//package com.yocy.youngfriend.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000") // 允许访问的域
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
//                .allowCredentials(true) // 是否允许发送Cookie信息
//                .maxAge(3600); // 预检请求的有效期，单位为秒
//    }
//}
