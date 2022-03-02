package com.imooc.hystrix;

import com.imooc.Friend;
import com.imooc.MyService;
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
  public String error() {
    log.info("Fallback");
    return "Fallback";
  }
}
