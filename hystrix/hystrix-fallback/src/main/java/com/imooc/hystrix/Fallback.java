package com.imooc.hystrix;

import com.imooc.Friend;
import com.imooc.MyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author afu
 */
@Slf4j
@Component
public class Fallback implements MyService {

  @Override
  public String sayHi() {
    return null;
  }

  @Override
  public Friend sayHiPost(Friend friend) {
    return null;
  }

  @Override
  public String retry(int timeout) {
    return "You are late!";
  }

  @Override
  @HystrixCommand(fallbackMethod = "fallback2")
  public String error() {
    log.info("Fallback");
    throw new RuntimeException("fallback first");
  }

  @HystrixCommand(fallbackMethod = "fallback3")
  private String fallback2() {
    log.info("Fallback2");
    throw new RuntimeException("fallback again");
  }

  private String fallback3() {
    log.info("Fallback3");
    return "success";
  }
}
