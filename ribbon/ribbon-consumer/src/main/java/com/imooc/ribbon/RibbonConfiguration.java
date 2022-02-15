package com.imooc.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ServerListSubsetFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author afu */
@Configuration
public class RibbonConfiguration {
  @Bean
  public IRule defaultLBStrategy() {
    return new RandomRule();
  }

  @Bean
  public ServerListSubsetFilter serverListFilter() {
    ServerListSubsetFilter filter = new ServerListSubsetFilter();
    return filter;
  }
}
