package com;

import com.Interceptor.CheckLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 public void addInterceptors(InterceptorRegistry registry){
     registry.addInterceptor(new CheckLoginInterceptor()).addPathPatterns("/**");

 }



}
