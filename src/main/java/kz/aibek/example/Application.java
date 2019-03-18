package kz.aibek.example;


import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@SpringBootApplication
public class Application {

    private int maxUploadSizeInMb = 10*1024*1024;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
/*
    @Bean
    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory= new MultipartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("128KB");
        return factory.createMultipartConfig();
    }
*/
}
