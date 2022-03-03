package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author afu
 */
@EnableEurekaClient
@EnableHystrix
@EnableTurbine
@EnableAutoConfiguration
public class TurbineApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(TurbineApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
