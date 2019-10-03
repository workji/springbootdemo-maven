package com.ki.config;

import com.ki.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor testInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**", "/vendor/**");
    }

//    @Bean
//    public FilterRegistrationBean hogeFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean(new LoginFilter());
//        bean.addUrlPatterns("/*");
//        bean.setOrder(Integer.MIN_VALUE);
//        return bean;
//    }
}
