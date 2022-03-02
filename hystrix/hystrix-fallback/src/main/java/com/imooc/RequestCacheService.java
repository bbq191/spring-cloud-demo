package com.imooc;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author afu
 */
@Slf4j
@Service
public class RequestCacheService {

  @Qualifier("com.imooc.MyService")
  @Autowired
  private MyService myService;

  @CacheResult
  @HystrixCommand(commandKey = "cacheKey")
  public Friend requestCaches(@CacheKey String name) {
    log.info("requesting cache {}", name);
    Friend friend = new Friend();
    friend.setName(name);
    friend = myService.sayHiPost(friend);
    log.info("after resquesting chahe {}", name);
    return friend;
  }
}
