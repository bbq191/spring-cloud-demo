package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author afu
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerAdvanceApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(FeignConsumerAdvanceApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
