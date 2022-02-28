package com.imooc.ribbon;

import com.imooc.ribbon.rule.MyRule;
import com.netflix.loadbalancer.ServerListSubsetFilter;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author afu
 */
@Configuration
@RibbonClient(name = "eureka-client", configuration = MyRule.class)
public class RibbonConfiguration {
  //  @Bean
  //  public IRule defaultLBStrategy() {
  //    return new RandomRule();
  //  }

  @Bean
  public ServerListSubsetFilter serverListFilter() {
    ServerListSubsetFilter filter = new ServerListSubsetFilter();
    return filter;
  }
}
