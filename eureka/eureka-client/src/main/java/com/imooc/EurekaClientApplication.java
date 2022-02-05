package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/** @author afu */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(EurekaClientApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
