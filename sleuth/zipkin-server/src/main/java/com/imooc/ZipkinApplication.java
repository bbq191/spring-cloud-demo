package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ZipkinApplication.class).web(WebApplicationType.SERVLET).run(args);
  }
}
