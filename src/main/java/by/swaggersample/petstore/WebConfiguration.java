package by.swaggersample.petstore;

import by.swaggersample.petstore.interceptor.AccessTokenInterceptor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.SqlResultSetMapping;
import java.util.logging.Level;

@Configuration
@EnableWebMvc
@Slf4j
public class WebConfiguration extends WebMvcConfigurerAdapter {

//    Logger logger = Logger.getLogger(WebConfiguration.class.getName());

//     Logger logger = LoggerFactory.getLogger(WebConfiguration.class);


    //info
    //warning
    //error
    //debug
    //trace

    @Autowired
    private AccessTokenInterceptor accessTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        logger.log(Level.INFO, "Hello World!");
        log.trace("Hello World!");
        registry.addInterceptor(accessTokenInterceptor)
                .addPathPatterns("/pet", "/pet/**")
                .addPathPatterns("/store/inventory")
                .addPathPatterns("/tag", "/tag/**")
                .addPathPatterns("/category", "category/**");
    }
}
