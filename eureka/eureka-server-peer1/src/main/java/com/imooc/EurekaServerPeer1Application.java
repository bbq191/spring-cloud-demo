package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author afu
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPeer1Application {
  public static void main(String[] args) {
    new SpringApplicationBuilder(EurekaServerPeer1Application.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
