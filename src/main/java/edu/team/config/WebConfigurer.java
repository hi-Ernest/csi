package edu.team.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.team.config.interceptor.LoginInterceptor;

/**
 * 过滤器加载配置
 *
 * @author dailiwen
 * @date 2019/06/24
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // 在excludePathPatterns中除了要放行登录界面和登录接口外，还需要放行static文件夹下的静态资源
        InterceptorRegistration loginRegistry = interceptorRegistry.addInterceptor(loginInterceptor);
        loginRegistry.addPathPatterns("/**").excludePathPatterns("/loginForm.html", "/loginIn", "/js/**", "/css/**", "/default/**", "/images/**", "/login/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/localFile/**").addResourceLocations("file:D:/localFile/");
    }
}
