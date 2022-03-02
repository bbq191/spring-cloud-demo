package com.imooc;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author afu
 */
@RestController
public class Controller {

  @Qualifier("com.imooc.MyService")
  @Autowired
  private MyService myService;

  @Autowired private RequestCacheService requestCacheService;

  @GetMapping("/fallback")
  public String fallback() {
    return myService.error();
  }

  @GetMapping("/timeout")
  public String timeout(Integer timeout) {
    return myService.retry(timeout);
  }

  @GetMapping("/cache")
  public Friend cache(String name) {
    @Cleanup HystrixRequestContext context = HystrixRequestContext.initializeContext();
    name += "!";
    return requestCacheService.requestCaches(name);
  }
}
