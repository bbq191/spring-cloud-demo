package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author afu
 */
@RestController
@Slf4j
public class Controller implements IService {
  @Value("${server.port}")
  private String port;

  @Override
  public String sayHi() {
    return "This is " + port;
  }

  @Override
  public Friend sayHiPost(Friend friend) {
    log.info("You are " + friend.getName());
    friend.setPort(port);
    return friend;
  }
}
