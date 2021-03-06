package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigBusConsumerApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ConfigBusConsumerApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
